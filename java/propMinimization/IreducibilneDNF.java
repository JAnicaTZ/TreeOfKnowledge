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

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public class IreducibilneDNF {
  public static List primeImplicants;
  public static List ireducibilneDNF; // = new ArrayList(); //VELIKI PROBLEM s varijablom!!

  public static List ireducibilneDNF(List primeImplicants) {
    IreducibilneDNF.primeImplicants = primeImplicants;
    ireducibilneDNF = new ArrayList(); // !!
    eliminirajSuvisneDisjunkte(primeImplicants);
    return ireducibilneDNF;
  }

  public static void eliminirajSuvisneDisjunkte(List primeImplicants) {
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
          AtomarnaFormula literal = (AtomarnaFormula) parcijalnaInterpretacija.get(k);
          if (disjunkt.contains(literal)) ((List) bezDisjunkta.get(j)).remove(literal);
          if (disjunkt.contains(literal.suprotnaFormula())) ukloniTekuci = true;
          k++;
        }
        if (ukloniTekuci) bezDisjunkta.remove(j);
        else j++;
      }
      if (!bezDisjunkta.isEmpty()) bezDisjunkta = PrimeImplicants.primeImplicants(bezDisjunkta);
      if (bezDisjunkta.contains(new String("tautologija;)!)"))) {
        iReducibilna = false;
        List rekurzivno = kopirajListuListi(primeImplicants);
        rekurzivno.remove(i);
        eliminirajSuvisneDisjunkte(rekurzivno);
      }
    } // for i
    if (iReducibilna) {
      if (!ireducibilneDNF.contains(primeImplicants)) ireducibilneDNF.add(primeImplicants);
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
