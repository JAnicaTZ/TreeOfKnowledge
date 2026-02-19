package propMinimization;

/**
 * Computes prime implicants of a propositional formula.
 *
 * <p>Implements the core logical step of minimization: finding all implicants that are minimal with
 * respect to subsumption and still imply the formula.
 *
 * <p>Prime implicants form the basis for constructing minimal DNF and CNF representations.
 */
import java.util.ArrayList;
import java.util.List;

import propCommon.AtomicFormula;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public class PrimeImplicants {
  public static List normalnaForma = new ArrayList();;

  public static List primeImplicants(List forma) {
    if (!forma.isEmpty() && !forma.contains(new String("tautologija;)!)"))) {
      normalnaForma = forma;
      reduceBySubsumption();
      List prethodnoSuglasje = new ArrayList();
      List suglasje = suglasje(prethodnoSuglasje);
      if (suglasje.contains(new AtomicFormula('T'))) {
        // System.out.println("Tautologija;)!");
        normalnaForma.clear();
        normalnaForma.add(new String("tautologija;)!)"));
      }

      while (!suglasje.isEmpty()
          && !suglasje.contains(new AtomicFormula('T'))
          && (!suglasje.equals(prethodnoSuglasje))) {
        normalnaForma.add(suglasje);
        reduceBySubsumption();
        prethodnoSuglasje = suglasje;
        suglasje = suglasje(prethodnoSuglasje);
        if (suglasje.contains(new AtomicFormula('T'))) {
          // System.out.println("Tautologija;)!");
          normalnaForma.clear();
          normalnaForma.add(new String("tautologija;)!)"));
        }
      }
    }
    return normalnaForma;
  }

  public static List suglasje(List prethodnoSuglasje) {
    List suglasje = new ArrayList();
    int i = 0;
    while (suglasje.isEmpty() && ++i <= normalnaForma.size()) {
      List prviDisjunkt = (List) normalnaForma.get(i - 1);
      int j = i;
      while (suglasje.isEmpty() && ++j <= normalnaForma.size()) {
        List drugDisjunkt = (List) normalnaForma.get(j - 1);
        int p = 0;
        while (suglasje.isEmpty() && ++p <= prviDisjunkt.size()) {
          AtomicFormula literal = (AtomicFormula) prviDisjunkt.get(p - 1);
          AtomicFormula suprotanLiteral = literal.suprotnaFormula();
          if (drugDisjunkt.contains(suprotanLiteral)) {
            suglasje.addAll(prviDisjunkt);
            suglasje.addAll(drugDisjunkt);
            suglasje.remove(literal); // java.util.AbstractCollection
            suglasje.remove(suprotanLiteral);
            if (suglasje.isEmpty()) {
              suglasje.add(new AtomicFormula('T'));
              return suglasje;
            } else {
              int k = 0;
              while (!suglasje.isEmpty() && ++k <= suglasje.size()) {
                literal = (AtomicFormula) suglasje.get(k - 1);
                if (suglasje.indexOf(literal) != suglasje.lastIndexOf(literal))
                  suglasje.remove(suglasje.lastIndexOf(literal));
                if (suglasje.contains(literal.suprotnaFormula()))
                  suglasje = new ArrayList();
              }
            }
          }
        }
        if (suglasje.equals(prethodnoSuglasje))
          suglasje = new ArrayList();
        else {
          int n = 0;
          while (!suglasje.isEmpty() && ++n <= normalnaForma.size()) // cool
            if (suglasje.containsAll((List) normalnaForma.get(n - 1)))
              suglasje = new ArrayList();
        }
      }
    }
    return suglasje;
  }

  /**
   * Reduces a set of implicants by subsumption (absorption).
   * <p>
   * An implicant I1 subsumes implicant I2 if the set of literals of I1 is a
   * subset
   * of the literals of I2. In that case, I2 is redundant and can be removed
   * without
   * changing the Boolean function represented by the disjunction of implicants.
   *
   * This corresponds to the logical law:
   *
   * <pre>
   * I1 ∨ I2  =  I1   if  I1 ⊆ I2
   * </pre>
   *
   * @param implicants a list of implicants, each represented as a set of literals
   */
  // private static void reduceBySubsumption(List<Set<Literal>> implicants)

  public static void reduceBySubsumption() { // vrlo osjetljiv dio koda!
    int i = 0;
    while (i < normalnaForma.size()) {
      List pDisjunkt = (List) normalnaForma.get(i);
      boolean ukloniTekuci = false;
      int j = i + 1;
      while (j < normalnaForma.size()) {
        List dDisjunkt = (List) normalnaForma.get(j);
        if (dDisjunkt.containsAll(pDisjunkt)) {
          normalnaForma.remove(j);
        } else
          j++;
        if (pDisjunkt.containsAll(dDisjunkt) && (pDisjunkt.size() != dDisjunkt.size()))
          ukloniTekuci = true;
      }
      if (ukloniTekuci) {
        normalnaForma.remove(i);
      } else
        i++;
    }
  }

}
