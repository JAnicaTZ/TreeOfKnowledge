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

import java.util.List;
import java.util.ArrayList;

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class Konjunkcija extends BinarnaFormula{
  public String toString(){
    return (new Character(Calc.AND_CHAR)).toString();
  }

  public Konjunkcija( Formula lijevoPodStablo, Formula desnoPodStablo){
    super( lijevoPodStablo, desnoPodStablo);
  }

  public List disjunktivnojFormi(){
    List disjunktivnaForma = new ArrayList();
    List lDisjunktivnaForma = ((FormulaUNormalnoj) lPodStablo).disjunktivnojFormi();
    List dDisjunktivnaForma = ((FormulaUNormalnoj) dPodStablo).disjunktivnojFormi();
		for ( int i = 0; i < lDisjunktivnaForma.size(); i++){
			for ( int j = 0; j < dDisjunktivnaForma.size(); j++){
				List pKonjunkt = new ArrayList((List) lDisjunktivnaForma.get(i)); //ovdje bila GRESKA!!
				List dKonjunkt = new ArrayList((List) dDisjunktivnaForma.get(j));
				if (neKontradiktorni( pKonjunkt, dKonjunkt)){
					pKonjunkt.addAll(dKonjunkt);
					disjunktivnaForma.add(pKonjunkt);
				}
			}
		}
    return disjunktivnaForma;
  }
  public static boolean neKontradiktorni( List pKonjunkt, List dKonjunkt){
    int i = 0;
    while (i < pKonjunkt.size())
      if (dKonjunkt.contains(((AtomarnaFormula) pKonjunkt.get(i++)).suprotnaFormula())) return false;
    return true;
  }
	
  public List konjunktivnojFormi(){
    List konjunktivnaForma = ((FormulaUNormalnoj) lPodStablo).konjunktivnojFormi();
    konjunktivnaForma.addAll(((FormulaUNormalnoj) dPodStablo).konjunktivnojFormi());
    return konjunktivnaForma;
  }
}
