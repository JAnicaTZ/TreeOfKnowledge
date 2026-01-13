package propositional;

/**
 * Abstract base class for binary connectives (two-child AST nodes).
 *
 * <p>Examples: conjunction (AND), disjunction (OR), implication-like expansions, etc.
 * Stores references to the left and right subtrees and provides common behavior:
 * <ul>
 *   <li>deep cloning (clone both subtrees),</li>
 *   <li>recursive transformations applied to children,</li>
 *   <li>standard tree visualization with two child nodes.</li>
 * </ul>
 */

import javax.swing.tree.DefaultMutableTreeNode;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — PROPOSITIONAL logic calculator (Beginner Mode)

public abstract class BinarnaFormula extends FormulaUNormalnoj{
  Formula lPodStablo;
  Formula dPodStablo;

  public DefaultMutableTreeNode prikazFormule(){
    DefaultMutableTreeNode cvorStabla = new DefaultMutableTreeNode(this);
    cvorStabla.add(lPodStablo.prikazFormule());
    cvorStabla.add(dPodStablo.prikazFormule());
    return cvorStabla;
  }

  public BinarnaFormula( Formula lijevoPodStablo, Formula desnoPodStablo){
    lPodStablo = lijevoPodStablo;
    dPodStablo = desnoPodStablo;
  }

  public Object clone(){
    Object klon = super.clone();
    ((BinarnaFormula) klon).lPodStablo = (Formula) lPodStablo.clone();
    ((BinarnaFormula) klon).dPodStablo = (Formula) dPodStablo.clone();
    return klon;
  }
  public Formula eliminiramNegacije(){
    lPodStablo = lPodStablo.eliminiramNegacije();
    dPodStablo = dPodStablo.eliminiramNegacije();
    return this;
  }
}
