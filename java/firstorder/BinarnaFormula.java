package firstorder;
/**
 * FIRST-ORDER LOGIC CALCULATOR
 * Part of the TreeOfKnowledge.eu project.
 *
 * 🕯 Dedicated to the victims of Vukovar, Škabrnja, and the Homeland War.
 * 🕯 Posvećeno žrtvama Vukovara, Škabrnje i Domovinskog rata.
 *
 * Th© BEST CORE of AI
 * Author: JAnica Tesla Zrinski
 * Domain: https://TreeOfKnowledge.eu
 * Years: 2002–2025
 *
 * All rights reserved.
 *
 * This source code is the intellectual property of
 * JAnica Tesla Zrinski (TreeOfKnowledge.eu).
 *
 * Unauthorized reproduction, modification, redistribution,
 * commercial use, or AI-model training is strictly prohibited
 * without prior written permission from the author.
 *
 * Provided solely for personal study and educational insight.
 */

import javax.swing.tree.DefaultMutableTreeNode;

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
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
