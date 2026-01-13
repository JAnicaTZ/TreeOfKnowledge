package firstorder;

/**
 * Common base class for binary FOL connectives (two-child AST nodes).
 *
 * <p>Stores left and right subtrees and provides shared recursive behavior:
 * <ul>
 *   <li>Visualization: {@link #prikazFormule()} creates a binary node in the output tree,</li>
 *   <li>Normalization/testing pipeline: {@link #glavniTestLogikePrvogReda()} applies the same process
 *       recursively to both children,</li>
 *   <li>Domain evaluation: {@link #glavniTest(int)} delegates the domain-bounded test to both children.</li>
 * </ul>
 *
 * <p>Concrete subclasses (e.g. conjunction/disjunction) define only the operator semantics and how
 * list-based normal-form structures are combined.
 */

import javax.swing.tree.DefaultMutableTreeNode;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

public abstract class BinarnaFormula extends FormulaUNF{
  Formula lijevoPodStablo;
  Formula desnoPodStablo;

  public DefaultMutableTreeNode prikazFormule(){
    DefaultMutableTreeNode cvorStabla = new DefaultMutableTreeNode(this);
    cvorStabla.add(lijevoPodStablo.prikazFormule());
    cvorStabla.add( desnoPodStablo.prikazFormule());
    return cvorStabla;
  }

  public BinarnaFormula( Formula lijevoPodStablo, Formula desnoPodStablo){
		prefix = "";
    this.lijevoPodStablo = lijevoPodStablo;
    this.desnoPodStablo  = desnoPodStablo;
  }

  public Object clone(){
    Object klon = super.clone();
    ((BinarnaFormula) klon).lijevoPodStablo = (Formula) lijevoPodStablo.clone();
    ((BinarnaFormula) klon).desnoPodStablo  = (Formula)  desnoPodStablo.clone();
    return klon;
  }
  public Formula glavniTestLogikePrvogReda() throws Clear{
    lijevoPodStablo = lijevoPodStablo.glavniTestLogikePrvogReda();
    desnoPodStablo  =  desnoPodStablo.glavniTestLogikePrvogReda();
		return this;
  }
  public Formula glavniTest(int brojElemenataNosaca){
    lijevoPodStablo = ((FormulaUNF) lijevoPodStablo).glavniTest(brojElemenataNosaca);
    desnoPodStablo  =  ((FormulaUNF) desnoPodStablo).glavniTest(brojElemenataNosaca);
		return this;
  }
}
