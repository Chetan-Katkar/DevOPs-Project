# Provisioning and Reliability Validation (Task 14)

**Project:** Smart Irrigation Alert Dashboard  
**Student:** Chetan Katkar | **Roll No:** 23102A0024 | **Class:** BE CMPN-A

## What the playbook is designed to verify

The Ansible playbook under `Task-13_Config-Management/ansible/setup.yml` creates writable application directories, checks Docker and the requested local image, and compares the current container with the desired image, running state, host port, and restart policy. It leaves a matching container running on later runs. If a deployment health check fails, it attempts to restore the previously running image.

The playbook has not yet been executed on this Ubuntu installation because `ansible-playbook` is not installed in the current environment. Record the real command output before presenting first-run/second-run counts or claiming rollback was demonstrated.

## Run the validation on Ubuntu

From the repository root, install Ansible if needed and build the local image:

```bash
sudo apt update
sudo apt install -y ansible
docker info
docker build -t smart-irrigation:v1.0 .
```

Check the playbook syntax, then run it twice:

```bash
cd Task-13_Config-Management/ansible
ansible-playbook -i inventory.ini --syntax-check setup.yml
ansible-playbook -i inventory.ini setup.yml
ansible-playbook -i inventory.ini setup.yml
```

Save the terminal output or use `script -a task14-validation.txt` before running the commands. On the second run, confirm the recap reports no changes to the already-correct container. Existing writable directories may make the first-run `changed` total lower than a fresh machine.

## Verify service and container state

```bash
docker ps --filter name=smart-irrigation
curl -fsS http://localhost:8087/api/summary
```

The endpoint should return JSON with five zones. Keep the actual terminal output or screenshots as evidence.

## Rollback demonstration

To validate rollback safely, keep an earlier working image locally, build/tag a test image with a different version, and use a disposable port/host. Do not stop the manually demonstrated `irrigation-demo` container. Capture the failed health check, the play recap, `docker ps`, and the restored endpoint. The playbook only attempts automatic rollback when the prior named container was running; this behavior still requires a live run to demonstrate.
