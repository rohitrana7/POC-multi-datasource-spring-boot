
# Git Commands for Linking a Local Repository to GitHub

This document records the sequence of Git commands executed to initialize and link a **local Git repository** to a newly created **GitHub repository**, while resolving a merge conflict caused by unrelated histories.

---

## 🧭 1. Verify Existing Git Remotes

Before adding a new remote, we check whether any remotes are already configured.

```bash
git remote -v
```

---

## 🔗 2. Add Remote Repository (HTTPS URL)

Initially, the remote GitHub repository was added using the HTTPS method:

```bash
git remote add origin https://github.com/rohitrana7/POC-multi-datasource-spring-boot.git
git remote -v
```

**Output:**

```
origin  https://github.com/rohitrana7/POC-multi-datasource-spring-boot.git (fetch)
origin  https://github.com/rohitrana7/POC-multi-datasource-spring-boot.git (push)
```

---

## 🧱 3. Check Repository Status

To ensure there are no uncommitted changes:

```bash
git status
```

**Output:**

```
On branch master
nothing to commit, working tree clean
```

---

## 🔐 4. Verify SSH Authentication with GitHub

Before switching to SSH, ensure authentication works correctly:

```bash
ssh -T git@github.com
```

**Output:**

```
Hi rohitrana7! You've successfully authenticated, but GitHub does not provide shell access.
```

---

## ⚙️ 5. Switch Remote URL to SSH

This allows pushing and pulling without entering credentials every time.

```bash
git remote set-url origin git@github.com:rohitrana7/POC-multi-datasource-spring-boot.git
git remote -v
```

**Output:**

```
origin  git@github.com:rohitrana7/POC-multi-datasource-spring-boot.git (fetch)
origin  git@github.com:rohitrana7/POC-multi-datasource-spring-boot.git (push)
```

---

## 🚀 6. Attempt to Push to GitHub

```bash
git push --set-upstream origin master
```

**Error:**

```
! [rejected] master -> master (fetch first)
error: failed to push some refs to 'github.com:rohitrana7/POC-multi-datasource-spring-boot.git'
hint: Updates were rejected because the remote contains work that you do not have locally.
```

This means the remote repository already has some files (like a README.md).

---

## 🔄 7. Fetch and Merge Remote Changes

### Fetch remote data:

```bash
git fetch
```

**Output:**
```
From github.com:rohitrana7/POC-multi-datasource-spring-boot
 * [new branch]      master     -> origin/master
```

### Pull and Merge with Local Repo (Unrelated Histories)

Since both repositories were initialized independently, Git refused to merge them until explicitly allowed.

```bash
git pull origin master
```

**Error:**

```
fatal: refusing to merge unrelated histories
```

Use the flag to override this restriction:

```bash
git pull origin master --allow-unrelated-histories
```

**Output:**
```
Merge made by the 'ort' strategy.
 README.md | 2 ++
 1 file changed, 2 insertions(+)
 create mode 100644 README.md
```

---

## 📤 8. Push Merged Code to GitHub

The current branch had no upstream set, so we specify it:

```bash
git push
```

**Output:**
```
fatal: The current branch master has no upstream branch.
```

Then set the upstream and push:

```bash
git push --set-upstream origin master
```

**Output:**

```
Enumerating objects: 55, done.
Counting objects: 100% (55/55), done.
...
branch 'master' set up to track 'origin/master'.
```

---

## ✅ Summary

This workflow connected a **local Git repository** (initialized earlier) to a **new GitHub repository** that already contained a small commit (like `README.md`). To resolve conflicts between two unrelated repositories, the `--allow-unrelated-histories` flag was used.

---

**Date:** 2025-10-25 11:55:38  
**Author:** Rohit Rana  
**Repository:** [POC-multi-datasource-spring-boot](https://github.com/rohitrana7/POC-multi-datasource-spring-boot)

