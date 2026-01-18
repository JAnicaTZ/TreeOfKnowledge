package firstorder;

/**
 * Conjunction node (AND, ∧) in the FOL formula tree.
 *
 * <p>Represents {@code left ∧ right}. In the normal-form workflow, conjunction acts as a structural
 * “collector”: it merges conjunctive contributions produced by its subtrees into a single list
 * representation returned by {@link #konjuktivnaForma()}.
 *
 * <p>This class also provides a utility predicate {@link #neKontradiktorni(java.util.Map,
 * java.util.Map)} used during solution search: it checks whether two partial assignments (maps) are
 * compatible (i.e., do not assign different values to the same variable).
 */
import java.util.*; // List, ArrayList, Map, HashMap

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

public class Konjukcija extends BinarnaFormula {
  public String toString() {
    return (new Character(Calc.AND_CHAR)).toString();
  }

  public Konjukcija(Formula lijevoPodStablo, Formula desnoPodStablo) {
    super(lijevoPodStablo, desnoPodStablo);
  }

  public List konjuktivnaForma() {
    List konjuktivnaForma = new ArrayList();
    List prviList = ((FormulaUNF) lijevoPodStablo).konjuktivnaForma();
    List drugiList = ((FormulaUNF) desnoPodStablo).konjuktivnaForma();
    for (int i = 0; i < prviList.size(); i++) {
      for (int j = 0; j < drugiList.size(); j++) {
        Map prviMap = new HashMap((Map) prviList.get(i));
        Map drugiMap = new HashMap((Map) drugiList.get(j));
        if (neKontradiktorni(prviMap, drugiMap)) {
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
    while (neKontradiktorni == true && i < PronalazenjeRjesenja.koristeneVarijable.size()) {
      String pv = (String) PronalazenjeRjesenja.koristeneVarijable.get(i);
      if (prviMap.containsKey(pv)
          && drugiMap.containsKey(pv)
          && !(prviMap.get(pv)).equals(drugiMap.get(pv))) neKontradiktorni = false;
      i++;
    }
    return neKontradiktorni;
  }
}
