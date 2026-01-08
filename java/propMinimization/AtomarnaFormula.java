package propMinimization;
/**
 * PROPOSITIONAL LOGIC – MINIMIZATION CALCULATOR
 * Minimal Normal Forms & Prime Implicants
 * Part of the TreeOfKnowledge.eu project.
 *
 * 🕯 Dedicated to every unborn child lost to abortion — an estimated ~200 000 each day worldwide. (Based on WHO global estimates of ~73 million abortions per year.)
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
import java.util.*; // List, ArrayList

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class AtomarnaFormula extends FormulaUNormalnoj{
  boolean istinitost;
  char propozicionalnaVarijabla;
  
  public String toString(){
		if (istinitost == false) return "" + Calc.NEGACIJA_CHAR + propozicionalnaVarijabla;
		return "" + propozicionalnaVarijabla;
  }
  public DefaultMutableTreeNode prikazFormule(){
    return new DefaultMutableTreeNode(this);
  }

  public AtomarnaFormula(char propozicionalnaVarijabla){
    istinitost = true;
    this.propozicionalnaVarijabla = propozicionalnaVarijabla;
  }

  public Formula eliminiramNegacije(){
    return this;
  }
	public boolean equals(Object o){
		if (o instanceof AtomarnaFormula){
			AtomarnaFormula a = (AtomarnaFormula) o;
			if ( (this.propozicionalnaVarijabla == a.propozicionalnaVarijabla) && (this.istinitost == a.istinitost)) return true;
		}
		return false;
	}
  public AtomarnaFormula suprotnaFormula(){
		AtomarnaFormula a = (AtomarnaFormula) this.clone();
		a.istinitost = !a.istinitost;
		return a;
	}
  public List disjunktivnojFormi(){
    List atom = new ArrayList();
		atom.add(this);
    List disjunktivnaForma = new ArrayList();
		disjunktivnaForma.add(atom);
    return disjunktivnaForma;
  }
  public List konjunktivnojFormi(){
		return this.disjunktivnojFormi();
    /* List atom = new ArrayList();
		atom.add(this);
    List konjunktivnaForma = new ArrayList();
		konjunktivnaForma.add(atom);
    return konjunktivnaForma; */
  }
}
