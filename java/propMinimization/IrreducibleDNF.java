package propMinimization;

/**
 * Represents and computes irreducible Disjunctive Normal Forms (DNF).
 *
 * <p>An irreducible DNF is a disjunction of conjunctions where no term can be removed without
 * changing the logical meaning of the formula.
 *
 * <p>This class filters and processes candidate conjunctions (often derived from prime implicants)
 * to obtain such irreducible forms.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import propCommon.AtomicFormula;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public class IrreducibleDNF {
  public static List primeImplicants;
  public static List ireducibilneDNF; // = new ArrayList(); //VELIKI PROBLEM s varijablom!!

  public static List ireducibilneDNF(List primeImplicants) {
    IrreducibleDNF.primeImplicants = primeImplicants;
    ireducibilneDNF = new ArrayList(); // !!
    pruneBySubsumption(primeImplicants);
    return ireducibilneDNF;
  }

  /**
   * Eliminates redundant disjunctive terms from the solution space by
   * subsumption.
   * <p>
   * A disjunct D1 makes a disjunct D2 redundant if every valuation satisfying D2
   * also satisfies D1, i.e. if the set of literals of D1 is a subset of the set
   * of
   * literals of D2.
   *
   * This method applies the absorption principle to the set of candidate
   * solutions
   * in order to keep only irreducible disjunctive normal forms.
   *
   * @param solutions a list of candidate disjuncts (implicants or prime
   *                  implicants)
   * @return a pruned list in which no element is subsumed by another
   */
  // public static List<Set<Literal>> pruneBySubsumption(List<Set<Literal>>
  // solutions)

  public static void pruneBySubsumption(List primeImplicants) {
    boolean iReducibilna = true;
    for (int i = 0; i < primeImplicants.size(); i++) {
      List bezDisjunkta = kopirajListuListi(primeImplicants);
      List parcijalnaInterpretacija = (List) bezDisjunkta.get(i);
      bezDisjunkta.remove(i);
      int j = 0;
      while (j < bezDisjunkta.size()) {
        List disjunkt = new ArrayList();
        disjunkt.addAll((List) bezDisjunkta.get(j));
        int k = 0;
        boolean ukloniTekuci = false;
        while (!bezDisjunkta.isEmpty() && k < parcijalnaInterpretacija.size()) {
          AtomicFormula literal = (AtomicFormula) parcijalnaInterpretacija.get(k);
          if (disjunkt.contains(literal))
            ((List) bezDisjunkta.get(j)).remove(literal);
          if (disjunkt.contains(literal.suprotnaFormula()))
            ukloniTekuci = true;
          k++;
        }
        if (ukloniTekuci)
          bezDisjunkta.remove(j);
        else
          j++;
      }
      if (!bezDisjunkta.isEmpty())
        bezDisjunkta = PrimeImplicants.primeImplicants(bezDisjunkta);
      if (bezDisjunkta.contains(new String("tautologija;)!)"))) {
        iReducibilna = false;
        List rekurzivno = kopirajListuListi(primeImplicants);
        rekurzivno.remove(i);
        pruneBySubsumption(rekurzivno);
      }
    } // for i
    if (iReducibilna) {
      if (!ireducibilneDNF.contains(primeImplicants))
        ireducibilneDNF.add(primeImplicants);
      // else System.out.println("dupla IReducibilna");
    }
  }

  public static List kopirajListuListi(List listaPodListi) {
    List glavnaLista = new ArrayList();
    for (int i = 0; i < listaPodListi.size(); i++) {
      List podLista = new ArrayList();
      podLista.addAll((List) listaPodListi.get(i));
      glavnaLista.add(podLista);
    }
    return glavnaLista;
  }
}
