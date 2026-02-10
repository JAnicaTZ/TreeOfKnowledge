# TreeOfKnowledge – Propositional & First-Order Logic Tree Engine

**Author:** JAnica Tesla Zrinski  
Original Java symbolic logic tree engine (2002–2004)  
Originally developed as a university diploma project (PMF, Zagreb)

It is designed for education, formal logic exploration, and explainable symbolic reasoning experiments.

This repository contains the **core Java source code** of a symbolic logic
reasoning engine that builds and transforms explicit logic trees (ASTs) for:

- propositional logic  
- first-order logic  
- normal-form transformations  

The focus is on **transparent, inspectable symbolic reasoning — not black-box evaluation.**

---

**Status:** Stable legacy academic engine, preserved and modernized for educational and explainable-AI use.

**Current packaged release:** 1.0.0



## 🌳 Official website

Interactive calculators, runnable demos, and explanations:

**https://TreeOfKnowledge.eu**

This repository contains the core Java engine behind the calculators.  
The website itself is maintained separately as a static project.

---

## 🔬 How it works (technical overview)

TreeOfKnowledge constructs an explicit **Abstract Syntax Tree (AST)** for each formula.

Formulas are recursively decomposed into primitive connectives:

- ¬ NOT  
- ∧ AND  
- ∨ OR  

Using recursive transformations and **De Morgan’s laws**, formulas are converted into:

- Negation Normal Form (NNF)  
- Disjunctive Normal Form (DNF)  
- Conjunctive Normal Form (CNF)  
- minimal normal forms (where applicable)

Parsing, evaluation, and visualization follow the same recursive structure —  
so every step of reasoning remains **traceable and auditable**.

---

## 🎯 Core idea

The goal is not only to compute logical truth values —  
but to expose **step-by-step reasoning through explicit tree transformations.**

Each formula becomes a concrete tree structure that can be:

- inspected  
- evaluated  
- transformed  
- visualized  

---

## 🎓 Educational relevance

Designed as a pedagogical tool for logic and discrete mathematics.

The explicit AST representation helps learners understand:

- hierarchical formula structure  
- connective precedence  
- quantifier scope and nesting  
- normalization procedures  
- recursive evaluation  

Logical reasoning becomes a **visible structure**, not an abstract procedure.

Suitable for:

- logic courses  
- CS foundations  
- recursion teaching  
- symbolic reasoning demos  

---

## 🤖 Explainable AI relevance (XAI)

By exposing structure and transformation steps explicitly,  
the engine illustrates principles of **symbolic and explainable AI**:

- visible reasoning paths  
- rule-based transformations  
- auditable inference structure  

It serves as a minimal, fully inspectable symbolic reasoning core  
that can complement modern AI systems.

---

## 📦 Included in this repository

### Core features

- formula parsing  
- AST construction  
- propositional logic engine  
- first-order logic engine  
- normalization transformations  
- semantic table evaluation  
- Swing GUI demo calculators  

### Technical properties

- pure Java  
- no external frameworks  
- recursive algorithms  
- source-level transparency  

### Documentation

- LICENSE  
- ORIGIN-2002.txt  
- README.md  

---

## ⚙️ Requirements

- Java 8 or newer  

Tested with:

- Java 21 (Temurin)  
- IntelliJ IDEA  
- VS Code  
- standard Java CLI tools  

---

## ▶ Running

### Quick start (CLI)

```bash
javac propositional/*.java
java propositional.Calc
```

Compile sources and run a calculator launcher class.

Or run directly from an IDE by launching the desired `Calc` class.

---

## 🏫 Origin note

The core algorithms originate from academic work developed  
during a university diploma project at **PMF Zagreb (2002–2004)**.

This repository preserves and modernizes that original logic tree engine.

---

## 📬 Contact

For academic collaboration, educational use, or licensing inquiries —  
please contact the author.
