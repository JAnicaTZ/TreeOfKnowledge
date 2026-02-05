# TreeOfKnowledge – Propositional & First-Order Logic Tree Calculator

**Author:** JAnica Tesla Zrinski  
Original Java logic tree engine (2002–2004).  
Originally developed as a university diploma project (PMF, Zagreb).

This repository contains the **core Java source code** of a symbolic logic
calculator originally developed around 2002 (source preserved from the 2004 version).


## How it works (technical)

TreeOfKnowledge is a symbolic reasoning engine that constructs an explicit  
**Abstract Syntax Tree (AST)** for propositional and first-order logic formulas.

Formulas are recursively decomposed into primitive connectives  
{¬ (NOT), ∧ (AND), ∨ (OR)} and transformed via **De Morgan’s laws** into a  
**Negation Normal Form (NNF)** AST, with negations pushed down to the atomic level.

Parsing, evaluation, and visualization follow the same recursive structure —  
making the reasoning **transparent, inspectable, and auditable** rather than a black box.


## Official website

Interactive calculators, runnable demos, and user-oriented explanations:

🌳 **https://TreeOfKnowledge.eu**

This repository contains the **core Java logic engine** behind the website.  
The website itself is maintained as a separate static project.


## Core idea

The goal is not only to compute logical results, but to expose  
**step-by-step reasoning through explicit tree transformations.**


## Educational relevance

Designed as a **pedagogical tool** for propositional and first-order logic.

The explicit AST representation helps learners understand:

- hierarchical formula structure  
- quantifier scope and nesting  
- logical connective roles  
- normalization steps (e.g. NNF)

Logical reasoning becomes a **concrete, visual, inspectable structure**, useful in  
logic, discrete mathematics, and computer science education.


## Explainable AI relevance (XAI)

By exposing structure and transformation steps through ASTs,  
the engine demonstrates principles aligned with **symbolic and explainable AI** —  
where reasoning paths are visible and verifiable.

TreeOfKnowledge illustrates how symbolic logic trees can serve as a minimal,  
fully inspectable model of explainable reasoning.


---

## Included in this repository

- Formula parsing and AST construction  
- Propositional & first-order logic support  
- Tree-based transformations  
- Simple Swing GUI demo  
- Pure Java engine (no external frameworks)

Documentation files:

- `LICENSE.txt`  
- `ORIGIN-2002.txt`  
- `README.md`


---

## Requirements

- Java 8+ (the core engine was originally developed on much earlier Java versions)

Tested with:

- Java 21 (Temurin)
- VS Code
- IntelliJ IDEA


## Running

Compile all sources and run the GUI launcher class from the desired package.

Example: java propositional.Calc

You can also run the project directly from any Java IDE by launching the  
corresponding `Calc` class.


---

## Contact

For academic collaboration or licensing inquiries — please contact the author.
