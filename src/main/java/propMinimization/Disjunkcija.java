package propMinimization;

/**
 * Disjunction (OR, ∨) node.
 *
 * <p>Dual to {@link Konjunkcija}:
 *
 * <ul>
 *   <li>DNF: concatenates DNF clause lists (OR of clauses)
 *   <li>CNF: performs a Cartesian product of CNF clauses (OR distributes over AND)
 * </ul>
 *
 * <p>Also filters tautological/contradictory clauses during CNF product merging using complement
 * checks.
 */
import java.util.ArrayList;
import java.util.List;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public class Disjunkcija extends BinarnaFormula {
  public String toString() {
    return (new Character(Calc.OR_CHAR)).toString();
  }

  public Disjunkcija(Formula lijevoPodStablo, Formula desnoPodStablo) {
    super(lijevoPodStablo, desnoPodStablo);
  }

  public List disjunktivnojFormi() {
    List disjunktivnaForma = ((FormulaUNormalnoj) lPodStablo).disjunktivnojFormi();
    disjunktivnaForma.addAll(((FormulaUNormalnoj) dPodStablo).disjunktivnojFormi());
    return disjunktivnaForma;
  }

  public List konjunktivnojFormi() {
    List konjunktivnaForma = new ArrayList();
    List lKonjunktivnaForma = ((FormulaUNormalnoj) lPodStablo).konjunktivnojFormi();
    List dKonjunktivnaForma = ((FormulaUNormalnoj) dPodStablo).konjunktivnojFormi();
    for (int i = 0; i < lKonjunktivnaForma.size(); i++) {
      for (int j = 0; j < dKonjunktivnaForma.size(); j++) {
        List pDisjunkt = new ArrayList((List) lKonjunktivnaForma.get(i)); // ovdje bila GRESKA!!
        List dDisjunkt = new ArrayList((List) dKonjunktivnaForma.get(j));
        if (neKontradiktorni(pDisjunkt, dDisjunkt)) {
          pDisjunkt.addAll(dDisjunkt);
          konjunktivnaForma.add(pDisjunkt);
        }
      }
    }
    return konjunktivnaForma;
  }

  public static boolean neKontradiktorni(List pKonjunkt, List dKonjunkt) {
    int i = 0;
    while (i < pKonjunkt.size())
      if (dKonjunkt.contains(((AtomarnaFormula) pKonjunkt.get(i++)).suprotnaFormula()))
        return false;
    return true;
  }
}
