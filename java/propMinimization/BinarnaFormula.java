package propMinimization;
/**
 * PROPOSITIONAL LOGIC – MINIMIZATION CALCULATOR
 * Minimal Normal Forms & Prime Implicants
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
