package propositional;

/**
 * Marker/contract for formulas that can be converted to normal forms.
 *
 * <p>Some nodes (like literals/atoms and boolean connectives) naturally support
 * conversion to:
 * <ul>
 *   <li>DNF (Disjunctive Normal Form) - OR of AND-clauses,</li>
 *   <li>CNF (Conjunctive Normal Form) - AND of OR-clauses.</li>
 * </ul>
 *
 * <p>This abstraction keeps "formula as syntax tree" separate from
 * "formula as a normal-form list-of-lists representation".
 */

import java.util.List;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — PROPOSITIONAL logic calculator (Beginner Mode)

public abstract class FormulaUNormalnoj extends Formula{
  public abstract List disjunktivnojFormi();
  public abstract List konjunktivnojFormi();
}
