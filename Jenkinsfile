pipeline {
    agent any

    parameters {
        booleanParam(name: 'RUN_SELENIUM', defaultValue: false, description: 'Run browser UI tests (requires Chrome/Chromium or Selenium Grid on this agent)')
        booleanParam(name: 'DEPLOY_DOCKER', defaultValue: false, description: 'Build and deploy the Docker image (requires this Jenkins agent to access a Docker daemon)')
        string(name: 'DEPLOY_PORT', defaultValue: '8087', description: 'Host port for the Jenkins-managed demo container')
    }

    tools {
        maven 'Maven 3.9'
        jdk 'JDK 21'
    }

    environment {
        APP_NAME = 'smart-irrigation-dashboard'
        VERSION = '1.0.0'
        DOCKER_IMAGE = "smart-irrigation:${BUILD_NUMBER}"
        DEPLOY_CONTAINER = 'smart-irrigation-jenkins'
    }

    stages {
        stage('Checkout SCM') {
            steps {
                echo 'Checking out source code from GitHub repository...'
                checkout scm
            }
        }

        stage('Build & Compile') {
            steps {
                echo 'Compiling source code with Maven...'
                sh 'mvn clean compile'
            }
        }

        stage('Automated Tests') {
            steps {
                echo 'Executing unit and integration tests...'
                sh 'mvn test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Selenium UI Tests') {
            when {
                expression { params.RUN_SELENIUM }
            }
            steps {
                sh 'mvn --batch-mode -Pselenium test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package Artifact') {
            steps {
                echo 'Packaging executable Spring Boot JAR file...'
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Docker Build and Deploy') {
            when {
                expression { params.DEPLOY_DOCKER }
            }
            steps {
                sh '''
                    set -eu
                    case "$DEPLOY_PORT" in
                        ''|*[!0-9]*) echo "DEPLOY_PORT must be a number" >&2; exit 2 ;;
                    esac
                    if [ "$DEPLOY_PORT" -lt 1 ] || [ "$DEPLOY_PORT" -gt 65535 ]; then
                        echo "DEPLOY_PORT must be between 1 and 65535" >&2
                        exit 2
                    fi

                    docker info >/dev/null
                    docker build --tag "$DOCKER_IMAGE" .

                    previous_image="$(docker inspect --format '{{.Image}}' "$DEPLOY_CONTAINER" 2>/dev/null || true)"
                    docker rm --force "$DEPLOY_CONTAINER" >/dev/null 2>&1 || true
                    docker run --detach --name "$DEPLOY_CONTAINER" --restart unless-stopped \\
                        --publish "${DEPLOY_PORT}:8085" "$DOCKER_IMAGE"

                    healthy=0
                    attempt=1
                    while [ "$attempt" -le 10 ]; do
                        if curl --fail --silent --show-error "http://127.0.0.1:${DEPLOY_PORT}/api/summary" >/dev/null; then
                            healthy=1
                            break
                        fi
                        sleep 3
                        attempt=$((attempt + 1))
                    done

                    if [ "$healthy" -ne 1 ]; then
                        docker logs --tail 100 "$DEPLOY_CONTAINER" || true
                        docker rm --force "$DEPLOY_CONTAINER" >/dev/null 2>&1 || true
                        if [ -n "$previous_image" ]; then
                            docker run --detach --name "$DEPLOY_CONTAINER" --restart unless-stopped \\
                                --publish "${DEPLOY_PORT}:8085" "$previous_image" || true
                        fi
                        echo "Deployment health check failed; attempted to restore the previous container image." >&2
                        exit 1
                    fi

                    echo "Container is healthy at http://localhost:${DEPLOY_PORT}"
                '''
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully for ${env.JOB_NAME} Build #${env.BUILD_NUMBER}!"
        }
        failure {
            echo "Pipeline failed! Please check the console log for errors."
        }
    }
}
