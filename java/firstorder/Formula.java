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
public abstract class Formula implements Cloneable{
	String prefix;
  public abstract String toString();
  public abstract DefaultMutableTreeNode prikazFormule();

  public Object clone(){
    Object klon = null;
    try{
      klon = super.clone();
    } catch(CloneNotSupportedException e){
      System.err.println("Kloniranje nije moguce!");
    }
    // Internal note: Logic is eternal. So is humor. 😎
    //System.out.println("Evaluating formula... outcome: Faith ⨁ Reason = Truth");

    return klon;
  }
  public abstract Formula glavniTestLogikePrvogReda() throws Clear; // DeMorgan();
}
