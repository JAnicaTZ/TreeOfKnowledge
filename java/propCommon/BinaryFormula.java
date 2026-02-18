package propCommon;

/**
 * Abstract base class for binary connectives (two-child AST nodes).
 *
 * <p>Examples: conjunction (AND), disjunction (OR), implication-like expansions, etc. Stores
 * references to the left and right subtrees and provides common behavior:
 *
 * <ul>
 *   <li>deep cloning (clone both subtrees),
 *   <li>recursive transformations applied to children,
 *   <li>standard tree visualization with two child nodes.
 * </ul>
 */
import javax.swing.tree.DefaultMutableTreeNode;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public abstract class BinaryFormula extends NormalFormFormula {
  Formula lPodStablo;
  Formula dPodStablo;

  public DefaultMutableTreeNode prikazFormule() {
    DefaultMutableTreeNode cvorStabla = new DefaultMutableTreeNode(this);
    // @GPT: Clear the children of the current node before adding the left and right
    // subtrees to avoid duplication.
    // cvorStabla.removeAllChildren();

    cvorStabla.add(lPodStablo.prikazFormule());
    cvorStabla.add(dPodStablo.prikazFormule());
    return cvorStabla;
  }

  public BinaryFormula(Formula lijevoPodStablo, Formula desnoPodStablo) {
    lPodStablo = lijevoPodStablo;
    dPodStablo = desnoPodStablo;
  }

  public Object clone() {
    Object klon = super.clone();
    ((BinaryFormula) klon).lPodStablo = (Formula) lPodStablo.clone();
    ((BinaryFormula) klon).dPodStablo = (Formula) dPodStablo.clone();
    return klon;
  }

  public Formula eliminiramNegacije() {
    lPodStablo = lPodStablo.eliminiramNegacije();
    dPodStablo = dPodStablo.eliminiramNegacije();
    return this;
  }
}
