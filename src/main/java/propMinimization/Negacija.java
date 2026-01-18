package propMinimization;

/**
 * Negation (NOT) node: a unary AST connective.
 *
 * <p>This node is responsible for "pushing negations down" using classic rewrite rules:
 *
 * <ul>
 *   <li>¬(¬A) → A (double negation elimination)
 *   <li>¬(A ∧ B) → (¬A ∨ ¬B) (De Morgan)
 *   <li>¬(A ∨ B) → (¬A ∧ ¬B) (De Morgan)
 *   <li>¬P → (flip literal sign)
 * </ul>
 *
 * <p>This transformation is a key preprocessing step before normal-form conversion and evaluation.
 */
import javax.swing.tree.DefaultMutableTreeNode;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public class Negacija extends Formula {
  Formula podStablo;

  public String toString() {
    return (new Character(Calc.NEGACIJA_CHAR)).toString();
  }

  public DefaultMutableTreeNode prikazFormule() {
    DefaultMutableTreeNode cvorStabla = new DefaultMutableTreeNode(this);
    cvorStabla.add(podStablo.prikazFormule());
    return cvorStabla;
  }

  public Negacija(Formula podStablo) {
    this.podStablo = podStablo;
  }

  public Object clone() {
    Object klon = super.clone();
    ((Negacija) klon).podStablo = (Formula) podStablo.clone();
    return klon;
  }

  public Formula eliminiramNegacije() {
    if (podStablo instanceof AtomarnaFormula) {
      ((AtomarnaFormula) podStablo).istinitost = !((AtomarnaFormula) podStablo).istinitost;
    } else if (podStablo instanceof Negacija) { // eliminacijaNegacije();
      podStablo = ((Negacija) podStablo).podStablo;
    } else if (podStablo instanceof Konjunkcija) { // deMorgan()!!
      podStablo =
          new Disjunkcija(
              new Negacija(((BinarnaFormula) podStablo).lPodStablo),
              new Negacija(((BinarnaFormula) podStablo).dPodStablo));
    } else if (podStablo instanceof Disjunkcija) { // deMorgan()!!
      podStablo =
          new Konjunkcija(
              new Negacija(((BinarnaFormula) podStablo).lPodStablo),
              new Negacija(((BinarnaFormula) podStablo).dPodStablo));
    }
    return podStablo.eliminiramNegacije();
  }
}
