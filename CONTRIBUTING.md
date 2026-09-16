# Contributing to Tree of Knowledge

Thank you for your interest in Tree of Knowledge. 🌳

This repository welcomes careful, evidence-based contributions to the logic engine, documentation, testing, demonstrations and proposed interoperability interfaces.

Before contributing, please read:

* [Where We Are Now](PROJECT-STATUS.md)
* [What Already Exists](EXISTING-ASSETS.md)
* [3 + 1 Design Principles for Collaborators](COLLABORATION-PRINCIPLES.md)

---

## 1. Preferred Communication

Project communication should remain primarily written and inspectable.

Preferred contribution channels are:

* GitHub Issues;
* Pull Requests;
* reproducible test vectors;
* documented architecture corrections;
* written technical proposals.

Please do not require telephone calls or meetings as a condition of participation.

---

## 2. Before Opening a Pull Request

Please:

1. explain the problem being addressed;
2. identify the affected component;
3. distinguish existing behavior from proposed behavior;
4. describe the smallest useful change;
5. state how the change was tested;
6. preserve existing project history and attribution;
7. avoid unrelated rewrites.

If an Issue already exists, reference it in the Pull Request.

---

## 3. Keep Changes Bounded

A good contribution should answer:

* What goes in?
* What comes out?
* What changed?
* Why was the change necessary?
* How can another person reproduce the result?
* What happens when the operation fails?

Avoid adding architectural layers unless they remove more uncertainty than they create.

---

## 4. Preserve Responsibility Boundaries

Current discussions distinguish four independent functions:

```text
TREE       = reasoning
OMNIX      = governed admissibility
Fidacy     = bounded execution enforcement
SignalLink = provenance and integrity continuity
```

A TREE contribution must not silently convert a logical conclusion into authorization or execution permission.

External collaboration documents may describe proposed interfaces, but they must not be presented as completed native integration without reproducible evidence.

---

## 5. Claim-State Vocabulary

When documenting work, use precise language:

* **VERIFIED** — independently reproducible or supported by retained evidence;
* **DEMONSTRATED** — shown in a bounded test;
* **SYNTHETIC** — simulated or based on non-production data;
* **EXPERIMENTAL** — implemented but not production-ready;
* **PROPOSED** — awaiting implementation, confirmation or testing;
* **NOT CLAIMED** — explicitly outside the current evidence boundary.

Public claims must not exceed retained evidence.

---

## 6. Code Contributions

For code changes:

* preserve compatibility with the documented Java version unless the change explicitly updates that requirement;
* keep parsing, transformation and presentation responsibilities understandable;
* prefer small, reviewable commits;
* document new public classes and interfaces;
* include repeatable tests where practical;
* do not silently change logical semantics;
* identify unsupported syntax and failure states;
* avoid committing generated build output unless intentionally required.

Changes to normalization, minimization or logical evaluation should include representative inputs and expected outputs.

---

## 7. Documentation Contributions

Documentation corrections are welcome.

Please distinguish clearly between:

* historical implementation;
* current verified behavior;
* intended behavior;
* proposed interfaces;
* synthetic demonstrations;
* external independent systems.

Do not list a person or organization publicly as a collaborator, partner, employee, agent or endorser without explicit consent.

---

## 8. Security and Privacy

Never commit:

* passwords;
* authentication codes;
* API keys;
* access tokens;
* private cryptographic keys;
* private personal information;
* confidential documents;
* credentials embedded in screenshots or configuration files.

If you discover a potentially serious security issue, do not publish exploitable details in a public Issue. Contact the repository owner privately with the minimum information needed to understand the concern.

Disclose only as much personal information as you are comfortable making permanently public.

---

## 9. How to Propose a Change

You may:

1. open an Issue;
2. fork the repository;
3. create a focused branch;
4. implement and test the proposed change;
5. submit a Pull Request;
6. respond to written review comments.

Submitting a contribution does not guarantee acceptance.

The repository owner retains responsibility for deciding what is merged into the main branch.

---

## 10. Collaboration Boundary

A message, Issue, Pull Request, repository view or informal discussion does not by itself establish:

* formal partnership;
* employment;
* agency;
* endorsement;
* shared ownership;
* exclusivity;
* completed integration;
* authority to represent another participant.

Any broader relationship requires separate written agreement.

---

## Guiding Principles

🕶️ **MATRIX**
🧠 **SIMPLE**
🎮 **INTERESTING**
🔐 **SAFE**

Make trouble for bad logic—not for repository security. 🌳⚔️
