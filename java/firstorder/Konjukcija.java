package firstorder;
/**
 * FIRST-ORDER LOGIC CALCULATOR
 * Part of the TreeOfKnowledge.eu project.
 *
 * 🕯 Dedicated to every child who dies from starvation — 1 every 10 seconds, around 10,000 each day.
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

import java.util.*; // List, ArrayList, Map, HashMap

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class Konjukcija extends BinarnaFormula{
  public String toString(){
    return (new Character(Calc.AND_CHAR)).toString();
  }

	public Konjukcija( Formula lijevoPodStablo, Formula desnoPodStablo){
		super( lijevoPodStablo, desnoPodStablo);
	}

  public List konjuktivnaForma(){
    List konjuktivnaForma = new ArrayList();
    List prviList = ((FormulaUNF) lijevoPodStablo).konjuktivnaForma();
    List drugiList = ((FormulaUNF) desnoPodStablo).konjuktivnaForma();
        for ( int i = 0; i < prviList.size(); i++){
          for ( int j = 0; j < drugiList.size(); j++){
            Map prviMap  = new HashMap((Map) prviList.get(i));
            Map drugiMap = new HashMap((Map) drugiList.get(j));
            if (neKontradiktorni( prviMap, drugiMap)) {
              prviMap.putAll(drugiMap);
              konjuktivnaForma.add(prviMap);
            }
          }
        }               
    return konjuktivnaForma;
  }
  public static boolean neKontradiktorni(Map prviMap, Map drugiMap) {
    boolean neKontradiktorni = true;
    int i = 0;
    while ( neKontradiktorni == true && i < PronalazenjeRjesenja.koristeneVarijable.size() ) {
      String pv =  (String) PronalazenjeRjesenja.koristeneVarijable.get(i);
      if (  prviMap.containsKey(pv) && drugiMap.containsKey(pv)
        && !(prviMap.get(pv)).equals(drugiMap.get(pv))) neKontradiktorni = false;
      i++;
    }
    return neKontradiktorni;
  }
 }
