SIMPLE Propositional TREE — Quick Start

Position on the Project Website

The SIMPLE Propositional TREE is the second calculator displayed on the project website:

https://TreeOfKnowledge.eu

The more advanced First-Order Logic calculator is intentionally positioned first.

This ordering does not indicate that new contributors should begin with First-Order Logic. The FOL calculator received the leading position because it represents the project’s original and academically more ambitious core—and because I still hope that, one fine day, it may attract the attention of a distinguished professor of mathematical logic. ☀️😅

In other words:

FOL is positioned first for academic visibility; SIMPLE is the proper first step for understanding the system. 🌳
---
For learning, inspection and technical orientation, the recommended order is:

1. SIMPLE Propositional TREE
   Begin with the smallest and clearest representation of TREE’s recursive reasoning mechanism.

2. First-Order Logic
   Continue here for a more complete conceptual understanding—and, hopefully, for your total knowledge satisfaction. 🌳🧠

3. Propositional Minimization
   Examine this stage when we are ready to investigate whether logically equivalent formulas can be represented more economically by reducing unnecessary complexity.

In our slightly less formal MacroHARD™ terminology:

MINIMIZATION = the search for the best EKO algorithms—saving logical steps, representation space and potentially computational effort without changing the meaning of the formula. ♻️😎

This ordering reflects the learning path rather than the visual order of calculators on the website:

SIMPLE → FOL → MINIMIZATION

In short:

First understand the TREE. Then explore its full logical reach. Finally, investigate how much of it can be safely reduced.


Purpose

The SIMPLE Propositional TREE is the most accessible starting point for understanding the basic reasoning mechanism behind the Tree of Knowledge.

It was designed to make the internal structure of a propositional formula visible instead of returning only a final result.

The process can be summarized as:

REDUCE → TRANSFORM RECURSIVELY → ILLUMINATE THE SOLUTION

Position on the Project Website

The SIMPLE Propositional TREE is the second calculator displayed on the project website:

https://TreeOfKnowledge.eu

The more advanced First-Order Logic calculator is intentionally positioned first.

This ordering does not indicate that new contributors should begin with First-Order Logic. The FOL calculator received the leading position because it represents the project’s original and academically more ambitious core—and because I still hope that, one fine day, it may attract the attention of a distinguished professor of mathematical logic. ☀️😅

For learning, initial inspection and technical orientation, however, the recommended order is:

1. SIMPLE Propositional TREE
2. Propositional Minimization
3. First-Order Logic

In other words:

FOL is positioned first for academic visibility; SIMPLE is the proper first step for understanding the system. 🌳

---

1. Basic Logical Language

All formulas are internally reduced to the logical basis used throughout the code and GUI:

{¬ (NOT), ∧ (AND), ∨ (OR)}

Other logical connectives can be rewritten using this basis.

For example:

A → B ≡ ¬A ∨ B

A ↔ B ≡ (A ∧ B) ∨ (¬A ∧ ¬B)

This gives the reasoning engine a small and consistent set of operations.

---

2. Recursive Transformation

The formula is processed recursively.

Negations are pushed inward by applying De Morgan’s laws:

¬(A ∧ B) ≡ ¬A ∨ ¬B

¬(A ∨ B) ≡ ¬A ∧ ¬B

Double negations are eliminated:

¬¬A ≡ A

The objective is to reach a transparent structure in which every negation applies directly to an atomic proposition.

---

3. Explicit Logical Tree

The transformed formula is represented as an explicit logical tree.

The tree makes it possible to inspect:

- how the original formula was decomposed;
- which rule was applied at each stage;
- which logical alternatives arise;
- which branches remain possible;
- which branches are eliminated; and
- how the displayed solution follows from the original formula.

The purpose is not merely to provide a result, but to expose the reasoning path that produced it.

---

4. Illuminating the Solution

The GUI visually guides the user through the tree and highlights the relevant parts of the solution.

This makes the calculator useful as:

- an introductory mathematical-logic tool;
- a visual learning environment;
- a debugging aid for propositional formulas; and
- a simple demonstration of explicit and inspectable reasoning.

---

5. Small Example

Input:

¬(A ∧ B)

Recursive transformation:

¬(A ∧ B)
      ↓
¬A ∨ ¬B

The resulting tree exposes the alternatives explicitly instead of hiding the transformation behind a single final output.

---

6. Repository Structure

Propositional-specific functionality

The "propositional" package contains the functionality specific to the SIMPLE Propositional TREE:

https://github.com/JAnicaTZ/TreeOfKnowledge/tree/main/java%2Fpropositional

The class currently located there is intentionally the only remaining class in this package.

This does not mean that other propositional components are missing.

Shared functionality

During a recent and deliberate refactoring, all components shared by the propositional-tree and propositional-minimization tools were moved into the "propCommon" package:

https://github.com/JAnicaTZ/TreeOfKnowledge/tree/main/java%2FpropCommon

Therefore:

- "propositional" contains functionality specific to the SIMPLE Propositional TREE;
- "minimization" contains functionality specific to propositional minimization; and
- "propCommon" contains their shared parsing, formula-processing and logical infrastructure.

This separation avoids duplicated logic and keeps the shared implementation of {¬ (NOT), ∧ (AND), ∨ (OR)} consistent across both tools.

---

7. Useful Starting Links

Project website and working calculators

https://TreeOfKnowledge.eu

Main GitHub repository

https://github.com/JAnicaTZ/TreeOfKnowledge

Complete source-code bundle

https://raw.githubusercontent.com/JAnicaTZ/TreeOfKnowledge/main/AllSourceCode4UPloadToAI-TreeOfKnowledge-1.0.0.zip

---

Initial Review Boundary

For the first inspection, contributors are invited to examine only:

1. the accepted propositional notation;
2. reduction to {¬ (NOT), ∧ (AND), ∨ (OR)};
3. recursive application of De Morgan’s laws;
4. elimination of double negations;
5. construction of the explicit logical tree; and
6. visual illumination of the resulting solution.

Minimization, first-order logic and possible external integrations should be treated as separate later stages.

For now, this should be quite enough to begin inspecting TREE—one small, explicit and verifiable step at a time. 🌳