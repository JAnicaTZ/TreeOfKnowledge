# TREE — Preliminary Viability and Success-Probability Assessment

**Project:** Tree of Knowledge (TREE)  
**Website:** [TreeOfKnowledge.eu](https://TreeOfKnowledge.eu)  
**Repository:** [github.com/JAnicaTZ/TreeOfKnowledge](https://github.com/JAnicaTZ/TreeOfKnowledge)  
**Document status:** Public working draft v0.1 — under construction  
**Assessment date:** 27 September 2026  
**Document type:** Preliminary project-continuity, IP-readiness and business-readiness assessment

> **A routine good-governance practice for every serious software project — not an emergency measure.**

---

## 1. Executive summary

Tree of Knowledge (TREE) is a logic-based software project designed to make reasoning explicit and traceable: not merely to state **what** follows, but to preserve a reviewable account of **why** it follows.

The project already has several assets that distinguish it from a concept-only initiative:

- working Java software with roots in an original 2002 academic project;
- public source code, runnable distributions and technical documentation;
- propositional reasoning and minimization functionality;
- explicit intermediate representations and reasoning traces;
- at least one documented external execution of the current software;
- an independent verification exercise using a separate trust/provenance layer;
- early experimental applications and proposed interfaces with complementary systems;
- a small international group of active or prospective collaborators.

TREE is therefore assessed as **technically real and worthy of continued development**, but **not yet commercially validated**. Its principal risks are no longer whether any software exists. They are now:

1. formal clarification of intellectual-property ownership and contributor rights;
2. reduction of founder dependency;
3. conversion of demonstrations into repeatable, bounded use cases;
4. assignment of clear responsibility for deliverables;
5. identification of a customer problem important enough to fund a pilot.

### Preliminary conclusion

**Technical-development viability:** high  
**Continuity viability:** moderate and improving  
**IP/legal readiness:** incomplete; professional review recommended  
**Commercial readiness:** early  
**Suitability for a bounded pilot:** plausible after completion of the minimum documentation and interface contract

This document does **not** claim that commercial success is mathematically proved. It provides a transparent, revisable estimate based on currently available evidence, explicitly stated assumptions and identifiable milestones.

---

## 2. Purpose of this document

This assessment has five purposes:

1. establish what TREE demonstrably is today;
2. distinguish evidence from aspiration;
3. estimate the probability of defined future outcomes;
4. identify the smallest actions that would materially improve those probabilities;
5. invite focused assistance from IP lawyers, technical reviewers, pilot partners and sponsors.

The intended readers are:

- pro bono or success-linked IP/software lawyers;
- prospective technical collaborators;
- research and institutional partners;
- sponsors and early pilot customers;
- anyone evaluating whether TREE can survive and develop independently of its original author.

---

## 3. What counts as “success”?

“Success” is not treated as one vague all-or-nothing event. The following outcomes are assessed separately:

| Level | Defined outcome | Evidence required |
|---|---|---|
| **S1 — Continuity** | TREE remains accessible, attributable, buildable and understandable without relying exclusively on its founder. | Repository, releases, documentation, authorship record, backup/continuity plan and at least one independent operator. |
| **S2 — Reproducible demonstration** | An external person can execute a defined scenario and reproduce the expected logical result. | Environment record, inputs, outputs, expected result and repeatable instructions. |
| **S3 — Integrated bounded prototype** | TREE exchanges a minimum agreed information contract with one complementary component. | Frozen schema, outcome semantics, synthetic test and explicit component boundaries. |
| **S4 — External pilot** | A real organization agrees to test a bounded, non-critical use case. | Named problem owner, scope, success criteria, responsibilities and evidence policy. |
| **S5 — First revenue** | TREE generates a paid pilot, licence, professional service or sponsored development contribution. | Written commercial terms and received payment. |
| **S6 — Sustainable operation** | Recurring income or committed funding supports maintenance, legal protection and continued development. | Repeatable revenue/funding and assigned operational responsibility. |

This separation prevents a common error: confusing technical correctness with permission to act, market demand or commercial success.

> **A logically valid conclusion is not automatically permission to act.**

---

## 4. Current evidence base

### 4.1 Existing technical assets

The public project presently includes or describes:

- a First-Order Logic calculator;
- a Simple Propositional Tree tool;
- a Propositional Minimization tool producing normal forms and reduced expressions;
- Java source packages for first-order, propositional and minimization functionality;
- AST parsing, conversion toward negation normal form and explicit intermediate results;
- runnable JAR distributions and a developer/source package;
- a handbook summary and use-case documentation.

Current Java guidance specifies Java 21 LTS or later.

### 4.2 Baseline external execution

A current baseline exercise used the formula:

`(A ∧ B ∧ C) → D`

TREE transformed it to:

`¬A ∨ ¬B ∨ ¬C ∨ D`

The execution was documented by an external collaborator using Debian 12 and Temurin OpenJDK 21.0.6. This is evidence that the distributed software can be executed outside the founder’s original environment.

### 4.3 Independent verification exercise

A separate SignalLink demonstration independently evaluated the reduced expression as contingent:

- true in 15 of 16 valuations (93.75%);
- false only when `A`, `B` and `C` are true and `D` is false;
- accompanied by a timestamped SHA-256-style integrity receipt in the demonstration layer.

This supports logical consistency and traceability for the selected baseline. It does **not** by itself establish production integration, external causation, legal admissibility or market demand.

### 4.4 Emerging complementary architecture

The present collaboration model separates responsibilities:

| Component | Intended responsibility | Core question |
|---|---|---|
| **TREE** | Explicit logical reasoning | Does the conclusion follow from the supplied facts and rules? |
| **OMNIX** | Admissibility determination | Is this specific proposed action admissible now? |
| **Fidacy** | Bounded execution grant | What precisely may execute, under which grant and limits? |
| **SignalLink** | Provenance and integrity | Can the relevant evidence and state transitions be verified? |

The proposed flow is:

`Propose → Reason → Determine Admissibility → Authorize or Deny → Execute or Remain Closed → Anchor → Verify`

This remains an architectural direction until a minimum contract and synthetic end-to-end test are frozen and reproduced.

### 4.5 Experimental third-party application

An independent experimental job-application example has also been developed around TREE-related material. It is useful evidence of external interest and practical experimentation, but its exact technical dependency, reuse boundaries, attribution and verification method should be documented before it is treated as a validated TREE integration.

---

## 5. Assessment method

Two different measures are used and must not be confused.

### 5.1 Readiness index

The readiness index scores the project’s present condition. It is **not a probability of commercial success**.

Each category is scored from 0 to 10 and multiplied by its weight. Scores are preliminary and should be revised when new evidence appears.

| Dimension | Weight | Current score | Weighted contribution | Current interpretation |
|---|---:|---:|---:|---|
| Working technical core | 20% | 9/10 | 18.0 | Existing and executable software, not merely a proposal. |
| External reproducibility | 15% | 7/10 | 10.5 | Baseline execution and independent logical checking exist; broader test coverage is needed. |
| Documentation | 10% | 7/10 | 7.0 | Considerable public material exists, but navigation, terminology and status labels still require consolidation. |
| Integration readiness | 10% | 4/10 | 4.0 | Responsibilities are conceptually separated; the minimum machine-readable contract is not yet frozen. |
| IP and legal clarity | 15% | 3/10 | 4.5 | Original authorship is asserted and historically grounded, but formal chain-of-title and contributor terms require legal review. |
| Team and continuity | 10% | 5/10 | 5.0 | Multiple collaborators exist, but roles, commitments and replacement coverage are not yet formalized. |
| Commercial validation | 15% | 2/10 | 3.0 | Potential applications are visible; no paid pilot or validated buyer commitment exists. |
| Governance and risk controls | 5% | 4/10 | 2.0 | Strong principles exist; operating rules and decision rights remain incomplete. |
| **Total preliminary readiness** | **100%** |  | **54/100** | **Promising technical project; pre-pilot and legally under-structured.** |

### 5.2 Event-probability estimates

Probability ranges below are structured judgments, not actuarial or statistically trained forecasts. They are derived from:

- the current evidence inventory;
- the project’s demonstrated technical maturity;
- dependency on voluntary contributors;
- unresolved legal and commercial questions;
- the number and difficulty of milestones still required;
- explicit assumptions listed below.

The ranges are intentionally broad to avoid false precision.

---

## 6. Preliminary probability forecast

### 6.1 Near-term outcomes: next 30–60 days

| Outcome | Estimated probability | Main dependency |
|---|---:|---|
| A second documented, independently repeatable use case | **65–75%** | One named owner completes and publishes the full evidence package. |
| Frozen minimum TREE-to-OMNIX information contract | **55–70%** | Agreement on fields, outcome semantics and responsibility boundaries. |
| One further concrete collaborator deliverable | **60–75%** | Work is divided into small owned tasks rather than open discussion. |
| Useful preliminary IP/legal review | **35–50%** | A suitable lawyer accepts a tightly bounded initial assignment. |
| Synthetic multi-component prototype | **25–40%** | Interface first; transport and large architecture deferred. |
| First revenue | **10–20%** | A buyer problem and small paid offer are defined immediately. |

### 6.2 Medium-term outcomes: next 6–12 months

Assuming regular small deliverables, documented contributor terms and active outreach:

| Outcome | Estimated probability |
|---|---:|
| S1 — Founder-independent continuity package | **70–85%** |
| S2 — Multiple reproducible demonstrations | **65–80%** |
| S3 — Integrated bounded prototype | **50–65%** |
| S4 — Serious external pilot discussion | **35–50%** |
| S5 — First paid pilot, licence or sponsored development | **25–40%** |
| Material institutional or commercial agreement | **10–20%** |

If coordination, documentation, legal clarification and outreach continue to depend almost entirely on the founder, the estimated probability of first revenue within 12 months falls to approximately **10–20%**.

### 6.3 Overall viability judgment

- **Probability that TREE has sufficient technical and intellectual substance to justify continued development:** **80–90%**
- **Probability of a measurable first commercial result within 12 months under disciplined role separation and milestone ownership:** **35–45%**
- **Probability of commercial success without legal clarification, owned deliverables and direct market testing:** **below 20%**

These estimates should be updated after every material milestone. A successful external pilot, completed IP review or first payment would substantially change the forecast.

---

## 7. Assumptions behind the forecast

The positive scenario assumes that:

1. the repository and distributions remain publicly accessible;
2. original development records can support the authorship history;
3. no unknown agreement has already transferred or encumbered relevant rights;
4. contributors disclose what they created and under which terms;
5. at least two people besides the founder can run or explain a bounded TREE scenario;
6. the team prioritizes propositional logic and one practical use case before expanding into FOL or premature optimization;
7. no production safety claim is made from synthetic demonstrations;
8. the project tests willingness to pay before undertaking a large rebuild;
9. public claims continue to distinguish verified facts, interpretations and aspirations.

If any of these assumptions proves false, the forecast must be revised.

---

## 8. Intellectual-property and legal-readiness questions

This section identifies questions for qualified counsel. It is not legal advice.

### 8.1 Priority questions

1. What evidence best documents Ana Kovačević’s original authorship and the development timeline beginning with the 2002 academic work?
2. Did any university, employer, client or prior contract obtain rights relevant to the original or later code?
3. Which repository files and releases are covered by which licence terms?
4. Have third-party libraries, generated materials or copied fragments introduced incompatible obligations?
5. How should later contributions be accepted: assignment, contributor licence agreement, inbound licence or another arrangement?
6. How should independent applications refer to TREE without implying authorship, endorsement or production integration?
7. Which names, logos or phrases should be protected as trademarks, and in which jurisdictions would that be proportionate?
8. What structure can permit broad experimentation while preserving non-exclusive commercial licensing opportunities?
9. How should revenue shares, success-linked legal work and collaborator compensation be documented without creating ambiguous ownership?
10. What continuity instrument would protect the project and the founder’s child if the founder became unavailable?

### 8.2 Minimum legal deliverable requested

A highly useful first contribution from an IP/software lawyer would be a short written memorandum containing:

- a preliminary chain-of-title map;
- a list of missing evidence or agreements;
- the three most urgent legal risks;
- recommended contributor terms;
- recommended public licence/commercial-licence boundary;
- a practical 30-day legal action list.

This bounded assignment is designed to make pro bono or deferred-fee participation realistic. It does not ask counsel to solve every future legal question at once.

---

## 9. Founder-independent continuity plan

The project should remain understandable and usable even if its founder is temporarily or permanently unavailable.

Minimum continuity requirements:

- canonical repository and release locations;
- build and execution instructions tested by another person;
- inventory of source code, binaries, documentation, domains and credentials;
- authorship and contribution ledger;
- licence and agreement register;
- named maintainers or custodians with bounded permissions;
- backup and recovery procedure;
- succession instructions that protect both project continuity and the founder’s beneficiary interests;
- explicit prohibition on treating logical output as automatic authority to act.

This is normal project governance, not a prediction of emergency.

---

## 10. Principal risks and mitigations

| Risk | Likelihood | Impact | Immediate mitigation |
|---|---|---|---|
| Founder becomes the sole organizer and delivery bottleneck | High | High | Assign every active collaborator one small deliverable with an owner and evidence requirement. |
| Informal contributions create IP ambiguity | Medium–high | High | Start a contributor ledger and adopt written inbound-contribution terms. |
| Discussion expands faster than implementation | High | Medium–high | Freeze one bounded scenario and defer nonessential architecture. |
| Synthetic demonstration is mistaken for production integration | Medium | High | Preserve “SYNTHETIC / DEMO ONLY” labels and publish verification limits. |
| Technically correct output is mistaken for authorization | Medium | High | Maintain separation between TREE reasoning and admissibility/authority layers. |
| FOL or minimization work distracts from a sellable propositional pilot | Medium | Medium | Keep the first commercial demonstration propositionally bounded. |
| No validated buyer problem | High | High | Conduct written problem interviews and offer one small paid pilot. |
| Public claims outrun evidence | Medium | High | Link each material claim to a reproducible artifact or label it as a hypothesis. |
| Volunteer attrition | High | Medium | Keep tasks short, visible, attributable and independently useful. |

---

## 11. Milestones that would most improve the forecast

### Within 30 days

1. Publish the second reproducible use case.
2. Create an authorship and contribution ledger.
3. Freeze the minimum TREE-to-OMNIX information contract.
4. Obtain one written preliminary IP review.
5. Define one customer problem and one bounded paid-pilot offer.

### Within 60–90 days

1. Run a synthetic end-to-end test across clearly separated components.
2. Have a third party reproduce the test from public instructions.
3. Publish a one-page architecture and responsibility boundary.
4. Complete contributor and independent-application attribution language.
5. Approach a small set of relevant organizations with the same measurable pilot proposition.

### Evidence that would materially raise the 12-month revenue probability

- a signed pilot letter or paid discovery engagement;
- a legal memorandum resolving the principal ownership uncertainties;
- two independent reproductions of the same documented scenario;
- one maintainer capable of operating without founder intervention;
- a customer statement confirming that the addressed problem is valuable and budgeted.

---

## 12. Invitation to IP lawyers

TREE welcomes contact from IP, software and technology-transfer lawyers interested in making a **small, concrete and independently valuable contribution**.

The initial request is deliberately limited: review the public materials, identify the most important ownership/licensing gaps and recommend the smallest defensible legal structure for continued collaboration and future licensing.

Possible participation models may include:

- pro bono preliminary review;
- deferred-fee work;
- a capped initial assignment;
- a separately negotiated success-linked arrangement where lawful and professionally appropriate.

No lawyer is asked to endorse the project’s commercial prospects merely by reviewing it.

---

## 13. Invitation to sponsors and pilot partners

TREE is not presently seeking funding for an undefined large rebuild.

The preferred next engagement is a **small, measurable and falsifiable pilot** in which:

- the input facts and rules are bounded;
- TREE’s expected output is specified in advance;
- the reasoning trace is reviewable;
- authority to act remains separate;
- success and failure criteria are agreed before execution;
- all claims remain proportionate to the evidence.

Suitable support could fund:

- legal and IP clarification;
- reproducibility testing;
- documentation and accessibility;
- a minimum API/interface layer;
- one domain-specific pilot;
- independent evaluation.

---

## 14. Evidence register — current and requested

| Evidence item | Current status | Next action |
|---|---|---|
| Original academic work and authorship history | Partly documented | Consolidate dated records and third-party confirmations. |
| Current source and releases | Publicly available | Record licences and hashes by release. |
| Baseline external execution | Documented | Standardize as a reproducibility package. |
| Independent logical verification | Demonstrated | Preserve exact artifact, method and limitation statement. |
| TREE–OMNIX boundary | Conceptually defined | Freeze minimum schema and decision semantics. |
| Contributor rights | Incomplete | Create ledger and written terms. |
| Independent experimental application | Available | Clarify dependency, attribution and validation status. |
| Customer demand | Unverified | Conduct written interviews and seek a bounded pilot commitment. |
| Revenue | None reported | Define a small paid offer and record any transaction. |
| Continuity beyond founder | Partial | Name custodians and test independent operation. |

---

## 15. Update policy

This assessment should be updated whenever one of the following occurs:

- a new reproducible use case is published;
- a contributor joins, leaves or delivers material work;
- IP ownership or licensing is clarified;
- an integration test succeeds or fails;
- a pilot partner expresses documented interest;
- funding or revenue is received;
- a material risk or conflicting claim is discovered.

Each revision should preserve:

- the assessment date;
- changed evidence;
- changed scores or probabilities;
- the reason for every material change;
- previous versions for traceability.

---

## 16. Final assessment

TREE has crossed the threshold from a private historical project into a publicly inspectable technical initiative with early external execution, verification and collaboration signals.

It has **not yet crossed the threshold into a legally structured, commercially validated or sustainably operated product**.

That distinction is not a weakness to conceal. It is the central reason for publishing this document.

The rational next step is neither a grand rewrite nor an unsupported valuation. It is a sequence of small proofs:

1. prove authorship and clarify rights;
2. prove that others can reproduce the software’s results;
3. prove a minimum safe interface;
4. prove that one external problem owner values the result;
5. only then scale the technology, organization and commercial claim.

### Current forecast

> **Technically promising. Legally under-structured. Commercially unvalidated. Increasingly reproducible. Worthy of one carefully bounded next test.**

---

## 17. Important notice

This is a preliminary internal/public planning assessment, not legal, financial, investment or safety advice. Probability ranges are transparent judgment estimates based on incomplete information; they are not guarantees, valuations or statistically validated predictions. References to proposed collaborations or components do not imply signed partnerships, production integrations or endorsements unless separately documented.

---

## Contact and project materials

- Website: [https://TreeOfKnowledge.eu](https://TreeOfKnowledge.eu)
- Repository: [https://github.com/JAnicaTZ/TreeOfKnowledge](https://github.com/JAnicaTZ/TreeOfKnowledge)
- AI-friendly project summary: [TREE-HANDBOOK-SUMMARY.md](https://raw.githubusercontent.com/JAnicaTZ/TreeOfKnowledge/main/TREE-HANDBOOK-SUMMARY.md)

**Project originator:** Ana Kovačević (JAnicaTZ)  
**Preferred communication:** written communication

