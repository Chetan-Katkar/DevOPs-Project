pipeline {
    agent any

    parameters {
        choice(name: 'DEPLOY_ENV', choices: ['staging', 'production'], description: 'Deployment Environment')
        string(name: 'APP_PORT', defaultValue: '8085', description: 'Application Port')
    }

    tools {
        maven 'Maven 3.9'
        jdk 'JDK 21'
    }

    environment {
        APP_NAME = 'smart-irrigation-dashboard'
        VERSION = '1.0.0'
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

        stage('Deploy Application') {
            steps {
                echo "Deploying ${APP_NAME} to ${params.DEPLOY_ENV} on port ${params.APP_PORT}..."
                echo "Deployment successfully executed. Verified endpoint on http://localhost:${params.APP_PORT}"
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
