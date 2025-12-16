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

  public List disjunktivnojFormi(){
    List disjunktivnaForma = ((FormulaUNormalnoj) lPodStablo).disjunktivnojFormi();
    disjunktivnaForma.addAll(((FormulaUNormalnoj) dPodStablo).disjunktivnojFormi());
    return disjunktivnaForma;
  }
	
  public List konjunktivnojFormi(){
    List konjunktivnaForma = new ArrayList();
    List lKonjunktivnaForma = ((FormulaUNormalnoj) lPodStablo).konjunktivnojFormi();
    List dKonjunktivnaForma = ((FormulaUNormalnoj) dPodStablo).konjunktivnojFormi();
		for ( int i = 0; i < lKonjunktivnaForma.size(); i++){
			for ( int j = 0; j < dKonjunktivnaForma.size(); j++){
				List pDisjunkt = new ArrayList((List) lKonjunktivnaForma.get(i)); //ovdje bila GRESKA!!
				List dDisjunkt = new ArrayList((List) dKonjunktivnaForma.get(j));
				if (neKontradiktorni( pDisjunkt, dDisjunkt)){
					pDisjunkt.addAll(dDisjunkt);
					konjunktivnaForma.add(pDisjunkt);
				}
			}
		}
    return konjunktivnaForma;
  }
  public static boolean neKontradiktorni( List pKonjunkt, List dKonjunkt){
    int i = 0;
    while (i < pKonjunkt.size())
      if (dKonjunkt.contains(((AtomarnaFormula) pKonjunkt.get(i++)).suprotnaFormula())) return false;
    return true;
  }
}
