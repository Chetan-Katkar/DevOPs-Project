# Automated Provisioning & Idempotency Validation (Task 14)

**Project:** Smart Irrigation Alert Dashboard  
**Student:** Chetan Katkar | **Roll No:** 23102A0024 | **Class:** BE CMPN-A  

---

## 🔁 1. Demonstration of Ansible Idempotency

**What is Idempotency?**  
Idempotency is the property of an operation whereby it can be applied multiple times without changing the result beyond the initial application. In Ansible, running a playbook on an already configured node produces `changed=0` (all tasks report `ok`).

### Run 1: Initial Provisioning
```bash
ansible-playbook -i inventory.ini setup.yml
```
**Output:**
```text
PLAY [Provision and Deploy Smart Irrigation Alert Dashboard] *******************
TASK [Ensure required deployment directories exist] ****************************
changed: [localhost]
TASK [Verify Docker service is running] ****************************************
ok: [localhost]
TASK [Run Smart Irrigation Docker Container] ***********************************
changed: [localhost]
TASK [Wait for application HTTP endpoint to become healthy] ********************
ok: [localhost]

PLAY RECAP *********************************************************************
localhost                  : ok=5    changed=2    unreachable=0    failed=0
```

### Run 2: Idempotent Verification Run (Second Run)
```bash
ansible-playbook -i inventory.ini setup.yml
```
**Output:**
```text
PLAY [Provision and Deploy Smart Irrigation Alert Dashboard] *******************
TASK [Ensure required deployment directories exist] ****************************
ok: [localhost]
TASK [Verify Docker service is running] ****************************************
ok: [localhost]
TASK [Run Smart Irrigation Docker Container] ***********************************
ok: [localhost]
TASK [Wait for application HTTP endpoint to become healthy] ********************
ok: [localhost]

PLAY RECAP *********************************************************************
localhost                  : ok=5    changed=0    unreachable=0    failed=0
```
Notice: **`changed=0`**! The system recognizes the desired state already exists and makes zero unnecessary modifications.

---

## ⏪ 2. Rollback & Disaster Recovery Demonstration

If a defect is detected in a new release (`v2.0`):
1. **Automated Rollback Command:**
   ```bash
   docker stop irrigation-app
   docker rm irrigation-app
   docker run -d -p 8085:8085 --name irrigation-app smart-irrigation:v1.0
   ```
2. **Verification:** Running `curl http://localhost:8085/api/sensors` confirms the service is immediately restored to the stable `v1.0` state with zero data loss.
