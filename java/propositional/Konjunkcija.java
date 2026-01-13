package propositional;

/**
 * Conjunction (AND, ∧) node.
 *
 * <p>Provides conversion to DNF/CNF using a list-of-lists representation:
 * <ul>
 *   <li>DNF: performs a Cartesian product of left and right DNF clauses (AND distributes over OR)</li>
 *   <li>CNF: concatenates CNF clause lists (AND of clauses)</li>
 * </ul>
 *
 * <p>Includes a contradiction filter: while merging two conjunctive clauses, it rejects
 * clauses that contain both a literal and its complement.
 */

import java.util.List;
import java.util.ArrayList;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — PROPOSITIONAL logic calculator (Beginner Mode)

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

      /**
     * Checks whether two conjunctive clauses can be merged without contradiction.
     * A contradiction occurs if the merged list contains both X and ¬X.
     */
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
