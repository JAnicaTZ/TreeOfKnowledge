package propCommon;

/**
 * Conjunction (AND, ∧) node.
 *
 * <p>Provides conversion to DNF/CNF using a list-of-lists representation:
 *
 * <ul>
 *   <li>DNF: performs a Cartesian product of left and right DNF clauses (AND distributes over OR)
 *   <li>CNF: concatenates CNF clause lists (AND of clauses)
 * </ul>
 *
 * <p>Includes a contradiction filter: while merging two conjunctive clauses, it rejects clauses
 * that contain both a literal and its complement.
 */
import java.util.ArrayList;
import java.util.List;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public class Conjunction extends BinaryFormula {
  public String toString() {
    return (new Character(UIStrings.AND_CHAR)).toString();
  }

  public Conjunction(Formula lijevoPodStablo, Formula desnoPodStablo) {
    super(lijevoPodStablo, desnoPodStablo);
  }

  public List disjunktivnojFormi() {
    List disjunktivnaNF = new ArrayList();
    List lijevDNF = ((NormalFormFormula) lPodStablo).disjunktivnojFormi();
    List desnaDNF = ((NormalFormFormula) dPodStablo).disjunktivnojFormi();
    for (int i = 0; i < lijevDNF.size(); i++) {
      for (int j = 0; j < desnaDNF.size(); j++) {
        List prviDisjunkt = new ArrayList((List) lijevDNF.get(i)); // ovdje bila GRESKA!!
        List drugDisjunkt = new ArrayList((List) desnaDNF.get(j));
        List disjunkt = elementarnaKonjunkcija(prviDisjunkt, drugDisjunkt);
        if (!disjunkt.isEmpty())
          disjunktivnaNF.add(disjunkt);
      }
    }
    return disjunktivnaNF;
  }

  public static List elementarnaKonjunkcija(List prviDisjunkt, List drugDisjunkt) {
    int j = 0;
    while (++j <= drugDisjunkt.size()) {
      AtomicFormula literal = (AtomicFormula) drugDisjunkt.get(j - 1);
      if (prviDisjunkt.contains(literal.suprotnaFormula()))
        return new ArrayList();
      if (!prviDisjunkt.contains(literal))
        prviDisjunkt.add(literal);
    }
    return prviDisjunkt;
  }

  public List konjunktivnojFormi() {
    List konjunktivnaForma = ((NormalFormFormula) lPodStablo).konjunktivnojFormi();
    konjunktivnaForma.addAll(((NormalFormFormula) dPodStablo).konjunktivnojFormi());
    return konjunktivnaForma;
  }
}
