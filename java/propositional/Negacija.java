package propositional;

/**
 * SIMPLE PROPOSITIONAL TREE – Beginner Mode
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
public class Negacija extends Formula{
  Formula podStablo;
    
  public String toString(){
    return (new Character(Calc.NEGACIJA_CHAR)).toString();
  }
  public DefaultMutableTreeNode prikazFormule(){
    DefaultMutableTreeNode cvorStabla = new DefaultMutableTreeNode(this);
    cvorStabla.add(podStablo.prikazFormule());
    return cvorStabla;
  }

  public Negacija(Formula podStablo){
    this.podStablo = podStablo;
  } 

  public Object clone(){
    Object klon = super.clone();
    ((Negacija) klon).podStablo = (Formula) podStablo.clone();
    return klon;
  }
  public Formula eliminiramNegacije(){
    if (podStablo instanceof AtomarnaFormula){
      ((AtomarnaFormula) podStablo).istinitost = !((AtomarnaFormula) podStablo).istinitost;
    }
    else if (podStablo instanceof Negacija){// eliminacijaNegacije();
			podStablo = ((Negacija) podStablo).podStablo;
    }
    else if (podStablo instanceof Konjunkcija){// deMorgan()!!
      podStablo = new Disjunkcija( new Negacija(((BinarnaFormula) podStablo).lPodStablo), new Negacija(((BinarnaFormula) podStablo).dPodStablo));
    }
    else if (podStablo instanceof Disjunkcija){// deMorgan()!!
      podStablo = new Konjunkcija( new Negacija(((BinarnaFormula) podStablo).lPodStablo), new Negacija(((BinarnaFormula) podStablo).dPodStablo));
    }
    return podStablo.eliminiramNegacije();
  }
}
