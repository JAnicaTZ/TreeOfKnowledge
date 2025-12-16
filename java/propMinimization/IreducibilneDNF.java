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
public class IreducibilneDNF{
	public static List primeImplicants;
	public static List ireducibilneDNF;// = new ArrayList(); //VELIKI PROBLEM s varijablom!!
	
	public static List ireducibilneDNF(List primeImplicants){
		IreducibilneDNF.primeImplicants = primeImplicants;
		ireducibilneDNF = new ArrayList(); // !!
		eliminirajSuvisneDisjunkte(primeImplicants);
		return ireducibilneDNF;
	}
	
	public static void eliminirajSuvisneDisjunkte(List primeImplicants){
		boolean iReducibilna = true;
		for ( int i = 0; i < primeImplicants.size(); i++){
			List bezDisjunkta = kopirajListuListi(primeImplicants);
			List parcijalnaInterpretacija = (List) bezDisjunkta.get(i);
			bezDisjunkta.remove(i);
			int j = 0;
			while (j < bezDisjunkta.size()){
				List disjunkt = new ArrayList();
				disjunkt.addAll((List) bezDisjunkta.get(j));
				int k = 0;
				boolean ukloniTekuci = false;
				while ( !bezDisjunkta.isEmpty() && k < parcijalnaInterpretacija.size()){
					AtomarnaFormula literal = (AtomarnaFormula) parcijalnaInterpretacija.get(k);
					if (disjunkt.contains(literal)) ((List) bezDisjunkta.get(j)).remove(literal);
					if (disjunkt.contains(literal.suprotnaFormula())) ukloniTekuci = true;
					k++;
				}
				if (ukloniTekuci) bezDisjunkta.remove(j);
				else j++;
			}
			if (!bezDisjunkta.isEmpty()) bezDisjunkta = PrimeImplicants.primeImplicants(bezDisjunkta);
			if (bezDisjunkta.contains(new String("tautologija;)!)"))){
				iReducibilna = false;
				List rekurzivno = kopirajListuListi(primeImplicants);
				rekurzivno.remove(i);
				eliminirajSuvisneDisjunkte(rekurzivno);
			}
		}//for i
		if (iReducibilna){
			if (!ireducibilneDNF.contains(primeImplicants)) ireducibilneDNF.add(primeImplicants);
			//else System.out.println("dupla IReducibilna");
		}
	}
	public static List kopirajListuListi(List listaPodListi){
		List glavnaLista = new ArrayList();
		for ( int i = 0; i < listaPodListi.size(); i++){
			List podLista = new ArrayList();
			podLista.addAll((List) listaPodListi.get(i));
			glavnaLista.add(podLista);
		}
		return glavnaLista;
	}
}

