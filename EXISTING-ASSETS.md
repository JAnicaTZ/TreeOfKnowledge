# What Already Exists

**Project:** Tree of Knowledge — Core of XAI
**Origin:** University diploma work in mathematical logic, PMF Zagreb, 2002–2004
**Current public repository:** [JAnicaTZ/TreeOfKnowledge](https://github.com/JAnicaTZ/TreeOfKnowledge)

---

## 1. Project Origin

Tree of Knowledge is based on original Java work developed as a university diploma project in mathematical logic.

The project explores explicit symbolic reasoning through visible logical structures rather than opaque output alone.

Its historical origin, current documentation and modern development status should remain distinguishable.

---

## 2. Existing Logic Tools

The repository contains source material and release artifacts related to three desktop Java tools.

### First-Order Logic Calculator

Intended capabilities include:

* parsing first-order logical formulas;
* constructing explicit formula structures;
* working with declared predicates, variables and domains;
* transforming formulas toward normalized representations;
* supporting inspectable logical evaluation.

### SIMPLE Propositional Tree

Intended capabilities include:

* parsing propositional formulas;
* producing explicit abstract syntax trees;
* visualizing recursive formula structure;
* supporting step-by-step logical inspection.

### Propositional Minimization

Intended capabilities include:

* propositional analysis;
* Negation Normal Form;
* Disjunctive Normal Form;
* Conjunctive Normal Form;
* reduced logical forms;
* subsumption-based reduction.

---

## 3. Existing Technical Material

Publicly available material includes:

* original and modernized Java source code;
* Maven project configuration;
* executable Java application artifacts;
* project documentation;
* screenshots;
* origin and licensing information;
* a complete source bundle intended for independent AI-assisted or human inspection.

Complete source bundle:

[AllSourceCode4UPloadToAI-TreeOfKnowledge-1.0.0.zip](https://raw.githubusercontent.com/JAnicaTZ/TreeOfKnowledge/main/AllSourceCode4UPloadToAI-TreeOfKnowledge-1.0.0.zip)

Website:

[TreeOfKnowledge.eu](https://TreeOfKnowledge.eu)

---

## 4. Existing Reasoning Concepts

The implementation and documentation explore concepts including:

* explicit abstract syntax trees;
* recursive formula representation;
* inspectable normalization steps;
* Negation Normal Form;
* CNF and DNF;
* reduced propositional forms;
* explicit facts, rules and conclusions;
* reasoning traces that can be inspected instead of merely trusted.

The project’s intended contribution is not that every possible logical problem has already been solved.

Its core value is the attempt to keep reasoning structures visible.

---

## 5. What Does Not Yet Exist as a Verified Native Interface

The existing applications should not automatically be described as currently producing:

* a stable `reasoning_record_id`;
* a canonical deterministic export format;
* a SHA-256 digest for every reasoning record;
* standardized `SUPPORTED`, `REFUTED` and `UNDETERMINED` states;
* a timestamped machine-verifiable reasoning receipt;
* a production API;
* a completed native integration with OMNIX, Fidacy or SignalLink.

These are proposed interface or adapter capabilities until implementation and testing demonstrate otherwise.

Every proposed output should therefore be classified as:

| Classification          | Meaning                                                     |
| ----------------------- | ----------------------------------------------------------- |
| **EXISTS NATIVELY**     | Already emitted directly by the current TREE implementation |
| **DERIVABLE**           | Can be reliably computed from existing output               |
| **REQUIRES ADAPTER**    | Requires an additional export or interface component        |
| **NOT YET IMPLEMENTED** | Does not currently exist                                    |

---

## 6. Current Verification Boundary

Public source availability permits inspection.

It does not automatically prove:

* production readiness;
* absence of defects;
* security certification;
* regulatory compliance;
* fitness for a consequential decision;
* correctness of externally supplied facts;
* completed integration with any third-party system.

Independent review, testing and documented correction are welcome.

---

## 7. Recommended Next Technical Task

The next TREE-specific technical task is to map the proposed reasoning-record contract to the existing implementation.

For each required field:

1. identify the responsible class or component;
2. determine whether the information already exists;
3. define a deterministic export representation;
4. record unsupported or ambiguous cases;
5. specify safe failure behavior;
6. test the same input repeatedly for stable output;
7. preserve the distinction between logical reasoning and downstream authorization.

One bounded and verifiable improvement at a time. 🌳
