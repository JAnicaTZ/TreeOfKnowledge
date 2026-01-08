# TreeOfKnowledge – Propositional & First-Order Logic (FOL) Tree Calculator

**Author:** JAnica Tesla Zrinski  
**Project:** “Tree of Knowledge” — original Java logic tree calculator (2002–2025).

This repository contains the **core Java source code** of a logic
calculator first developed around 2002 (source preserved as originally written, 2004).
Packaging/build scripts may evolve over time.


## How it works (technical)

TreeOfKnowledge is a symbolic reasoning engine that constructs an explicit
**Abstract Syntax Tree (AST)** for propositional and first-order logic formulas
and applies **De Morgan–based transformations** to normalize them.

Parsing, evaluation, and visualization follow the same recursive structure,
making the reasoning **transparent and auditable** — not a black box.


## Official website

The website presents the same core logic through interactive calculators
and beginner-friendly visualizations.

The public-facing version of the project, including ready-to-run calculators,
examples, and usage information, is available at:

🌳 **https://TreeOfKnowledge.eu**

This repository contains the **core Java logic engine** behind the website.


## Core idea

The goal is not just to produce results, but to expose
**auditable, step-by-step reasoning traces** through explicit tree transformations.


## Relevance to education

TreeOfKnowledge is designed primarily as a **pedagogical tool** for teaching
propositional and first-order logic.

By exposing the **Abstract Syntax Tree (AST)** explicitly, the system helps
students move beyond linear symbolic notation and understand:
- the hierarchical structure of formulas  
- the scope and nesting of quantifiers  
- the role of logical connectives  
- step-by-step transformations such as normalization to NNF  

The tree representation turns logical reasoning into a **concrete and inspectable object**, which can be especially helpful in introductory logic, discrete mathematics, and computer science courses.

The same explicit AST representation that supports learning and teaching also illustrates core ideas behind transparent and explainable reasoning systems.


## Relevance to explainable AI (XAI)

By making logical structure explicit through Abstract Syntax Trees (ASTs) and step-by-step transformations, TreeOfKnowledge exposes
**transparent and auditable reasoning traces**.

This naturally aligns with symbolic approaches to **explainable AI (XAI)**,
where understanding *how* a conclusion is reached is as important as the
conclusion itself.



---

The project includes:

- Parsing propositional & first-order logic formulas  
- Building a **tree representation**  
- Simple Swing GUI  
- Pure Java logic engine (no frameworks)

---

## 1. Contents

- Core algorithm for formula parsing & tree construction  
- Java source files of the logic engine  
- GUI launcher  
- Documentation:
  - `LICENSE.txt`  
  - `ORIGIN-2002.txt`  
  - `README.md`

---

## 2. Not included

- No HTML/CSS/JS  
- No website code  
- No server/backend (Javalin, Nginx, etc.)  
- No frontend from TreeOfKnowledge.eu  

For the public-facing calculators and downloads, see the official website:
https://TreeOfKnowledge.eu


---

## Distribution note

This DevKit is distributed as a ZIP for simplicity; a public repository may follow.

---

## 3. Requirements

- Java **21+**  
- Any IDE

---

## 4. Running the program

Compile all sources and run:
