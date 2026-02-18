package propCommon;

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

public class Negation extends Formula {
  Formula podStablo;

  public String toString() {
    return (new Character(UIStrings.NEGACIJA_CHAR)).toString();
  }

  public DefaultMutableTreeNode prikazFormule() {
    DefaultMutableTreeNode cvorStabla = new DefaultMutableTreeNode(this);
    cvorStabla.add(podStablo.prikazFormule());
    return cvorStabla;
  }

  public Negation(Formula podStablo) {
    this.podStablo = podStablo;
  }

  public Object clone() {
    Object klon = super.clone();
    ((Negation) klon).podStablo = (Formula) podStablo.clone();
    return klon;
  }

  /**
   * Eliminates negations by rewriting the subtree so that negations apply only to
   * atoms.
   *
   * @return transformed formula (may return a different node type than
   *         {@code Negacija}).
   */
  @Override
  public Formula eliminiramNegacije() {
    if (podStablo instanceof AtomicFormula) {
      ((AtomicFormula) podStablo).istinitost = !((AtomicFormula) podStablo).istinitost;
    } else if (podStablo instanceof Negation) { // eliminacijaNegacije();
      podStablo = ((Negation) podStablo).podStablo;
    } else if (podStablo instanceof Conjunction) { // deMorgan()!!
      podStablo = new Disjunction(
          new Negation(((BinaryFormula) podStablo).lPodStablo),
          new Negation(((BinaryFormula) podStablo).dPodStablo));
    } else if (podStablo instanceof Disjunction) { // deMorgan()!!
      podStablo = new Conjunction(
          new Negation(((BinaryFormula) podStablo).lPodStablo),
          new Negation(((BinaryFormula) podStablo).dPodStablo));
    }
    return podStablo.eliminiramNegacije();
  }
}
