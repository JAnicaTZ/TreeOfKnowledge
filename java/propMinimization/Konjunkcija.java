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

public class Konjunkcija extends BinarnaFormula{
  public String toString(){
    return (new Character(Calc.AND_CHAR)).toString();
  }

  public Konjunkcija( Formula lijevoPodStablo, Formula desnoPodStablo){
    super( lijevoPodStablo, desnoPodStablo);
  }

  public List disjunktivnojFormi(){
    List disjunktivnaNF = new ArrayList();
    List lijevDNF = ((FormulaUNormalnoj) lPodStablo).disjunktivnojFormi();
    List desnaDNF = ((FormulaUNormalnoj) dPodStablo).disjunktivnojFormi();
		for ( int i = 0; i < lijevDNF.size(); i++){
			for ( int j = 0; j < desnaDNF.size(); j++){
				List prviDisjunkt = new ArrayList((List) lijevDNF.get(i)); //ovdje bila GRESKA!!
				List drugDisjunkt = new ArrayList((List) desnaDNF.get(j));
				List disjunkt = elementarnaKonjunkcija( prviDisjunkt, drugDisjunkt);
				if (!disjunkt.isEmpty()) disjunktivnaNF.add(disjunkt);
			}
		}
    return disjunktivnaNF;
  }
  public static List elementarnaKonjunkcija( List prviDisjunkt, List drugDisjunkt){
    int j = 0;
    while ( ++j <= drugDisjunkt.size()){
			AtomarnaFormula literal = (AtomarnaFormula) drugDisjunkt.get(j - 1);
      if (prviDisjunkt.contains(literal.suprotnaFormula())) return new ArrayList();
			if (!prviDisjunkt.contains(literal)) prviDisjunkt.add(literal);
		}
    return prviDisjunkt;
  }
	
  public List konjunktivnojFormi(){
    List konjunktivnaForma = ((FormulaUNormalnoj) lPodStablo).konjunktivnojFormi();
    konjunktivnaForma.addAll(((FormulaUNormalnoj) dPodStablo).konjunktivnojFormi());
    return konjunktivnaForma;
  }
}
