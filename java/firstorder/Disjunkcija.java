package firstorder;
/**
 * SIMPLE PROPOSITIONAL TREE – Beginner Mode
 * Part of the TreeOfKnowledge.eu project.
 *
 * 🕯 Dedicated to every child who dies from starvation — 1 every 10 seconds, around 10,000 each day.
 *
 *  BEST CORE of AI
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

import java.util.List;
import java.util.ArrayList;

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class Disjunkcija extends BinarnaFormula{
  public String toString(){
    return (new Character(Calc.OR_CHAR)).toString();
  }

	public Disjunkcija( Formula lijevoPodStablo, Formula desnoPodStablo){
		super( lijevoPodStablo, desnoPodStablo);
	}

  public List konjuktivnaForma(){
    List konjuktivnaForma = ((FormulaUNF) lijevoPodStablo).konjuktivnaForma();
    konjuktivnaForma.addAll( ((FormulaUNF) desnoPodStablo).konjuktivnaForma() );
    return konjuktivnaForma;
  }
}
