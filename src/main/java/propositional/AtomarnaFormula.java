package propositional;

/**
 * Atomic formula (literal) in propositional logic.
 *
 * <p>Represents a propositional variable (e.g. {@code P}, {@code Q}, {@code R}) with an optional
 * negation. This implementation stores the polarity as a boolean:
 *
 * <ul>
 *   <li>{@code istinitost == true} → positive literal (P)
 *   <li>{@code istinitost == false} → negated literal (¬P)
 * </ul>
 *
 * <p>Atoms are leaves of the syntax tree (AST) and the basic building blocks for normal forms
 * (CNF/DNF) used by the calculator.
 */
import java.util.*; // List, ArrayList
import javax.swing.tree.DefaultMutableTreeNode;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — PROPOSITIONAL logic calculator (Beginner Mode)

public class AtomarnaFormula extends FormulaUNormalnoj {
  boolean istinitost;
  char propozicionalnaVarijabla;

  public String toString() {
    if (istinitost == false) return "" + Calc.NEGACIJA_CHAR + propozicionalnaVarijabla;
    return "  " + propozicionalnaVarijabla;
  }

  public DefaultMutableTreeNode prikazFormule() {
    return new DefaultMutableTreeNode(this);
  }

  public AtomarnaFormula(char propozicionalnaVarijabla) {
    istinitost = true;
    this.propozicionalnaVarijabla = propozicionalnaVarijabla;
  }

  public Formula eliminiramNegacije() {
    return this;
  }

  public boolean equals(Object o) {
    if (o instanceof AtomarnaFormula) {
      AtomarnaFormula a = (AtomarnaFormula) o;
      if ((this.propozicionalnaVarijabla == a.propozicionalnaVarijabla)
          && (this.istinitost == a.istinitost)) return true;
    }
    return false;
  }

  /**
   * @return the complementary literal (P ↔ ¬P). Useful for contradiction checks.
   */
  public AtomarnaFormula suprotnaFormula() {
    AtomarnaFormula a = (AtomarnaFormula) this.clone();
    a.istinitost = !a.istinitost;
    return a;
  }

  public List disjunktivnojFormi() {
    List atom = new ArrayList();
    atom.add(this);
    List disjunktivnaForma = new ArrayList();
    disjunktivnaForma.add(atom);
    return disjunktivnaForma;
  }

  public List konjunktivnojFormi() {
    return this.disjunktivnojFormi();
  }
}
