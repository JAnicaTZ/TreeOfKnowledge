# TreeOfKnowledge — Propositional & First-Order Logic Tree Engine

**Author:** JAnica Tesla Zrinski
**Origin:** Java symbolic logic tree engine developed during 2002–2004
**Academic origin:** University diploma project, PMF Zagreb
**Current public version:** 1.0.0

Tree of Knowledge is designed for education, formal-logic exploration and explainable symbolic-reasoning experiments.

This repository contains the core Java source code of a symbolic logic engine that builds and transforms explicit logical structures and abstract syntax trees for:

* propositional logic;
* first-order logic;
* normal-form transformations;
* inspectable symbolic reasoning.

The focus is on **transparent and inspectable symbolic reasoning—not black-box evaluation**.

---

## Current Status

**Preserved legacy academic engine under modernization, documentation and independent review.**

For the current technical, evidence and collaboration boundaries, see:

* **[Where We Are Now](PROJECT-STATUS.md)**
* **[What Already Exists](EXISTING-ASSETS.md)**
* **[3 + 1 Design Principles for Collaborators](COLLABORATION-PRINCIPLES.md)**
* **[Contributing to Tree of Knowledge](CONTRIBUTING.md)**

Current architectural direction:

> **Reasoning → Admissibility → Bounded Enforcement → Provenance**

The documented multi-layer workflow is presently a **synthetic reference architecture**.

No completed runtime integration, production deployment or formal multi-party partnership is claimed.

---

## 🌳 Official Website

Interactive calculators, runnable demonstrations and explanations:

**[TreeOfKnowledge.eu](https://TreeOfKnowledge.eu)**

This repository contains the Java logic-engine source behind the project.

The website is maintained separately as a static web project.

---

## 🔬 How It Works

Tree of Knowledge constructs an explicit **Abstract Syntax Tree (AST)** for a logical formula.

Formulas are recursively decomposed through logical connectives such as:

* `¬` NOT
* `∧` AND
* `∨` OR

Using recursive transformations and De Morgan’s laws, supported formulas can be converted into representations including:

* Negation Normal Form (NNF);
* Disjunctive Normal Form (DNF);
* Conjunctive Normal Form (CNF);
* reduced or minimal normal forms where applicable.

Parsing, transformation, evaluation and visualization use related recursive structures so that important reasoning steps can remain visible and inspectable.

---

## 🎯 Core Idea

The goal is not only to compute a result.

The goal is to expose the logical structure behind that result through explicit tree transformations.

A formula can become a concrete structure that may be:

* inspected;
* evaluated;
* transformed;
* visualized;
* compared with another representation.

The intended reasoning pattern is:

> **FACTS → RULES → REASONING → CONCLUSION**

And the most important question remains:

> **WHY?**

---

## 🎓 Educational Relevance

Tree of Knowledge originated as a pedagogical project for mathematical logic and computer science.

Its explicit formula and tree representations may help learners explore:

* hierarchical formula structure;
* connective precedence;
* quantifier scope and nesting;
* normalization procedures;
* recursive parsing and evaluation;
* relationships among formulas and normal forms.

Logical reasoning becomes a **visible structure**, not merely an abstract or hidden procedure.

Potential educational contexts include:

* mathematical-logic courses;
* computer-science foundations;
* recursion teaching;
* symbolic-reasoning demonstrations;
* explainable-AI discussions.

---

## 🤖 Explainable-AI Relevance

By exposing logical structures and transformation steps, TREE illustrates principles relevant to symbolic and explainable AI:

* visible reasoning paths;
* declared facts and rules;
* inspectable transformations;
* explicit conclusions;
* source-level transparency.

TREE may serve as an inspectable symbolic-reasoning component or research foundation.

However, logical reasoning alone does not establish that a consequential action is authorized or executable.

The current synthetic architectural discussion therefore preserves separate responsibilities for:

| Layer         | Responsibility                      |
| ------------- | ----------------------------------- |
| 🌳 TREE       | Reasoning                           |
| ⚖️ OMNIX      | Decision admissibility              |
| 🛡️ Fidacy    | Bounded execution enforcement       |
| 🔗 SignalLink | Provenance and integrity continuity |

These systems are not claimed to be natively integrated.

---

## 📦 Repository Contents

### Java packages

* `java/firstorder` — first-order logic calculator and related classes;
* `java/propositional` — SIMPLE propositional-tree calculator;
* `java/propCommon` — shared propositional parsing and formula classes;
* `java/propMinimization` — propositional minimization and normal forms.

### Additional material

* `docs/ORIGIN-2002.txt` — project-origin information;
* `docs/LICENCE.txt` — licensing information;
* `docs/README.md` — supporting documentation;
* `screenshots/` — application screenshots;
* `pom.xml` — Maven project configuration;
* `AllSourceCode4UPloadToAI-TreeOfKnowledge-1.0.0.zip` — complete source bundle for independent inspection.

### Core capabilities represented in the source

* formula parsing;
* abstract syntax tree construction;
* propositional logic;
* first-order logic;
* normalization transformations;
* semantic-table-related evaluation and presentation;
* Swing GUI calculator applications;
* recursive symbolic algorithms.

### Technical characteristics

* Java source code;
* no application-framework dependency;
* recursive algorithms;
* desktop Swing interfaces;
* source-level inspectability.

---

## ⚙️ Requirements

The current Maven configuration targets:

* **Java 21**

Recommended environment:

* Java 21 LTS, such as Eclipse Temurin;
* IntelliJ IDEA, VS Code or standard Java command-line tools.

Older Java versions should not be claimed as supported unless the current source and build are tested successfully with those versions.

---

## ▶ Running from the Command Line

The repository keeps Java source packages under the `java/` directory.

### Linux or macOS

From the repository root:

```bash
rm -rf out
mkdir out
find java -name "*.java" > sources.txt
javac -d out @sources.txt
```

Then launch one of the calculators:

```bash
java -cp out firstorder.Calc
```

```bash
java -cp out propositional.Calc
```

```bash
java -cp out propMinimization.Calc
```

### Windows PowerShell

From the repository root:

```powershell
Remove-Item out -Recurse -Force -ErrorAction SilentlyContinue
New-Item -ItemType Directory out
Get-ChildItem java -Recurse -Filter *.java |
    ForEach-Object { $_.FullName } |
    Set-Content sources.txt
javac -d out '@sources.txt'
```

Then launch one of the calculators:

```powershell
java -cp out firstorder.Calc
```

```powershell
java -cp out propositional.Calc
```

```powershell
java -cp out propMinimization.Calc
```

The desired `Calc` class may also be launched directly from a Java IDE after configuring `java/` as the source directory.

---

## 🧪 Verification Boundary

The public source code is available for inspection.

That does not automatically prove:

* production readiness;
* absence of defects;
* security certification;
* regulatory compliance;
* fitness for consequential decision-making;
* correctness of externally supplied facts;
* completed integration with another system.

Corrections, reproducible tests and carefully bounded improvements are welcome.

---

## 🏫 Origin Note

The core algorithms originated in academic work developed during a university diploma project at **PMF Zagreb between 2002 and 2004**.

This repository preserves and modernizes that original logic-tree work for education, technical inspection and explainable symbolic-reasoning experiments.

See:

* **[Project origin](docs/ORIGIN-2002.txt)**
* **[Licence](docs/LICENCE.txt)**

---

## 🤝 Collaboration

Before proposing a new interface, demonstration or architecture, please read:

* **[3 + 1 Design Principles for Collaborators](COLLABORATION-PRINCIPLES.md)**
* **[Contribution Guidelines](CONTRIBUTING.md)**

Constructive participation is welcome through:

* GitHub Issues;
* forks;
* Pull Requests;
* reproducible test vectors;
* documentation corrections;
* architecture critiques;
* implementation mapping.

Guiding principles:

🕶️ **MATRIX**
🧠 **SIMPLE**
🎮 **INTERESTING**
🔐 **SAFE**

---

## 📬 Contact

For academic evaluation, educational use, technical collaboration or licensing inquiries, please contact the project author through an appropriate written channel.

---

# FEED Th© TREE. 🌳

**πJAnica🏂 Tesla⚡ Zrinski⚔️**
[TreeOfKnowledge.eu](https://TreeOfKnowledge.eu) by **MacroHARD™**
