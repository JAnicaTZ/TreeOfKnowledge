package firstorder;

/**
 * Disjunction node (OR, ∨) in the FOL formula tree.
 *
 * <p>Represents {@code left ∨ right}. In this engine's list-based workflow, disjunction combines
 * the list representations coming from both subtrees (see {@link #konjuktivnaForma()}), effectively
 * concatenating/merging their contributions into a single list used by subsequent processing.
 *
 * <p>Operator-specific behavior (printing/operator label) is provided by {@link #toString()}.
 */
import java.util.List;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

public class Disjunkcija extends BinarnaFormula {
  public String toString() {
    return (new Character(Calc.OR_CHAR)).toString();
  }

  public Disjunkcija(Formula lijevoPodStablo, Formula desnoPodStablo) {
    super(lijevoPodStablo, desnoPodStablo);
  }

  public List konjuktivnaForma() {
    List konjuktivnaForma = ((FormulaUNF) lijevoPodStablo).konjuktivnaForma();
    konjuktivnaForma.addAll(((FormulaUNF) desnoPodStablo).konjuktivnaForma());
    return konjuktivnaForma;
  }
}
