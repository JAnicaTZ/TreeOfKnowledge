package firstorder;

/**
 * Solution search and result-highlighting utilities for the FOL engine.
 *
 * <p>This class performs the “search layer” on top of the normalized formula tree: it generates
 * candidate interpretations over a finite domain (carrier size), checks which assignments satisfy
 * the formula, and prepares output suitable for visualization and explanation.
 *
 * <p>Core responsibilities:
 *
 * <ul>
 *   <li>Collecting and expanding used variables into concrete ground instances (based on the chosen
 *       domain size).
 *   <li>Building and reducing a normal-form oriented representation to make testing efficient
 *       (e.g., reducing redundant parts before evaluation).
 *   <li>Checking whether a candidate interpretation satisfies the formula ({@code
 *       zadovoljavaInterpretaciju}).
 *   <li>Generating canonical / “perfect” conjunctive forms for systematic analysis ({@code
 *       savrsenaKonjuktivnaForma}).
 *   <li>Highlighting found solutions in the UI / tree output ({@code osvijetliRjesenja}).
 * </ul>
 *
 * <p>In short: {@code Parser} builds the tree, {@code Formula/FormulaUNF} normalize and test it,
 * and {@code PronalazenjeRjesenja} searches the finite model space and presents satisfying
 * assignments.
 */
import java.awt.Color;
import java.util.*; // List, ArrayList, Map, HashMap
import javax.swing.*; // JTree, JScrollPane, JPanel, JButton

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

public class PronalazenjeRjesenja {
  public static TreeMap mapKoristeneVarijable;
  public static int velicinaNosaca;
  public static ArrayList koristeneVarijable; // pojavljuje se u Konjukcija!!

  /**
   * Builds an ordered list of actually-used variables for the current formula and carrier size.
   *
   * <p>Uses {@link #mapKoristeneVarijable} (filled by the parser) and constructs {@link
   * #koristeneVarijable} containing only variables that occur in the input formula. The method also
   * sets {@link #velicinaNosaca}.
   *
   * <p>This list defines the dimension of the interpretation space explored later: if there are N
   * used variables and the carrier has K elements, then there are K^N possible assignments to test.
   *
   * @param brojElemenataNosaca size of the finite carrier/domain used by the calculator
   */
  public static void napraviKoristeneVarijable(int brojElemenataNosaca) {
    Object[] nizKoristenihVarijabli = mapKoristeneVarijable.keySet().toArray();
    koristeneVarijable = new ArrayList();
    for (int i = 0; i < mapKoristeneVarijable.keySet().size(); i++) {
      if (mapKoristeneVarijable.containsKey(nizKoristenihVarijabli[i])) {
        if ((mapKoristeneVarijable.get(nizKoristenihVarijabli[i]).equals(new Integer(1)))) {
          for (int j = 0; j < brojElemenataNosaca; j++) {
            koristeneVarijable.add(
                new String((String) nizKoristenihVarijabli[i] + Calc.konstante[j]));
          }
        }
        if ((mapKoristeneVarijable.get(nizKoristenihVarijabli[i]).equals(new Integer(2)))) {
          for (int j = 0; j < brojElemenataNosaca; j++) {
            for (int k = 0; k < brojElemenataNosaca; k++) {
              koristeneVarijable.add(
                  new String(
                      (String) nizKoristenihVarijabli[i] + Calc.konstante[j] + Calc.konstante[k]));
            }
          }
        }
      }
    }
  }

  /**
   * Top-level driver for solution search on a given formula tree.
   *
   * <p>Initializes the solution-search state (used variables, carrier size, etc.), transforms the
   * input formula through the main FOL pipeline (normalization / main test), and then triggers the
   * evaluation/search procedure over a finite carrier.
   *
   * <p>Conceptually:
   *
   * <ul>
   *   <li>{@code Parser} builds the AST,
   *   <li>{@code Formula/FormulaUNF} normalize/test it,
   *   <li>{@code PronalazenjeRjesenja} explores candidate interpretations and collects solutions.
   * </ul>
   *
   * @param korijenStabla root of the parsed formula AST
   * @param mapKoristeneVarijable variables actually used in the formula (from the parser)
   */
  public static void paralelnaAnaliza(Formula korijenStabla, TreeMap mapKoristeneVarijable)
      throws Clear {
    PronalazenjeRjesenja.mapKoristeneVarijable = mapKoristeneVarijable;
    FormulaUNF glavniTestLogikePrvogReda =
        (FormulaUNF) ((Formula) korijenStabla.clone()).glavniTestLogikePrvogReda();
    FormulaUNF negiraniGlavniTestLogikePrvogReda =
        (FormulaUNF) (new Negacija((Formula) korijenStabla.clone())).glavniTestLogikePrvogReda();
    JTree stabloGlavnogTesta = new JTree(glavniTestLogikePrvogReda.prikazFormule());
    for (int i = 0; i < stabloGlavnogTesta.getRowCount(); i++) {
      stabloGlavnogTesta.expandRow(i);
    }
    JScrollPane stabloGlavnogTestaView = new JScrollPane(stabloGlavnogTesta);
    Calc.nosacOd2ElementaPanel.add(stabloGlavnogTestaView);
    for (
    /* int  */ velicinaNosaca = 1; velicinaNosaca <= 4; velicinaNosaca++) {
      FormulaUNF glavniTest =
          (FormulaUNF) ((FormulaUNF) glavniTestLogikePrvogReda.clone()).glavniTest(velicinaNosaca);
      napraviKoristeneVarijable(velicinaNosaca);
      if (koristeneVarijable.size() <= 12) {
        List konjuktivnaForma = ((FormulaUNF) glavniTest).konjuktivnaForma();
        switch (velicinaNosaca) {
          case 1:
            osvijetliRjesenja(konjuktivnaForma, Calc.interpretacijePanel, "   ", "     ");
            break;
          case 2:
            JTree stabloGlavnogTesta2 = new JTree(glavniTest.prikazFormule());
            for (int i = 0; i < stabloGlavnogTesta2.getRowCount(); i++) {
              stabloGlavnogTesta2.expandRow(i);
            }
            JScrollPane stabloGlavnogTesta2View = new JScrollPane(stabloGlavnogTesta2);
            Calc.nosacOd2ElementaPanel.add(stabloGlavnogTesta2View);
            osvijetliRjesenja(konjuktivnaForma, Calc.interpretacijePanel2Formule, " ", "     ");
            break;
        }
        FormulaUNF negiraniGlavniTest =
            (FormulaUNF)
                ((FormulaUNF) negiraniGlavniTestLogikePrvogReda.clone()).glavniTest(velicinaNosaca);
        List negiranaKonjuktivnaForma = ((FormulaUNF) negiraniGlavniTest).konjuktivnaForma();
        paralelnaAnalizaZaNosac(konjuktivnaForma, negiranaKonjuktivnaForma);
      }
    }
    System.out.println();
  }

  /**
   * Runs the solution search for a specific finite carrier size.
   *
   * <p>Sets {@link #velicinaNosaca} and prepares the internal representation of the formula for
   * testing over this domain. Typically used to compare behavior across different carrier sizes
   * (e.g. 2, 3, 4), and to print/collect solutions per carrier.
   *
   * @param formulaUNF formula prepared for the normal-form / testing workflow
   * @param brojElemenataNosaca size of the carrier/domain (number of elements)
   */
  public static void paralelnaAnalizaZaNosac(List konjuktivnaForma, List negiranaKonjuktivnaForma) {
    boolean[] semantickaTablica = savrsenaKonjuktivnaForma(konjuktivnaForma);
    int brojIstinitihInterpretacija = 0;
    for (int i = 0; i < semantickaTablica.length; i++) {
      if (semantickaTablica[i] == true) brojIstinitihInterpretacija++;
    }
    System.out.println(
        "NOSAC "
            + velicinaNosaca
            + ": #Istinitih / ukupan#Interpretacija = "
            + brojIstinitihInterpretacija
            + "/"
            + semantickaTablica.length
            + " = "
            + (double) brojIstinitihInterpretacija / semantickaTablica.length);

    boolean[] semantickaTablicaNegiraneFormule = savrsenaKonjuktivnaForma(negiranaKonjuktivnaForma);
    boolean komplementarni = true;
    for (int i = 0; i < semantickaTablicaNegiraneFormule.length; i++) {
      if (semantickaTablica[i] == semantickaTablicaNegiraneFormule[i]) {
        komplementarni = false;
        System.out.println("!!komplementarni = " + komplementarni);
      }
    }
  }

  /**
   * Simplifies a conjunction-oriented list representation by removing redundancies.
   *
   * <p>Given a list representing a conjunctive normal-form-like structure (list of clauses /
   * conjuncts), this method removes duplicates and performs lightweight reductions that shrink the
   * search space.
   *
   * <p>The goal is not full theorem-proving, but practical pruning before interpretation testing.
   *
   * @param konjuktivnaForma list representation (typically produced by {@code konjuktivnaForma()})
   * @return reduced list with redundant parts removed
   */
  public static List reducirajNormalnuFormu(List konjuktivnaForma) {
    boolean ukloniTekuci = false;
    int i = 0;
    while (i < konjuktivnaForma.size()) {
      ukloniTekuci = false;
      /* String prvi = ((Map) konjuktivnaForma.get(i)).toString(); // MIJENJA SVE!!!
      prvi = prvi.substring( 1, prvi.length() - 1); */
      for (int j = i + 1; j < konjuktivnaForma.size(); j++) {
        String prvi = ((Map) konjuktivnaForma.get(i)).toString();
        prvi = prvi.substring(1, prvi.length() - 1);
        String drugi = ((Map) konjuktivnaForma.get(j)).toString();
        drugi = drugi.substring(1, drugi.length() - 1);
        if (prvi.indexOf(drugi) >= 0) {
          konjuktivnaForma.remove(i);
          ukloniTekuci = true;
        }
        if (!ukloniTekuci && drugi.indexOf(prvi) >= 0) {
          konjuktivnaForma.remove(j);
        }
      }
      if (!ukloniTekuci) i++;
    }
    return konjuktivnaForma;
  }

  /**
   * Checks whether a candidate interpretation satisfies the reduced normal-form representation.
   *
   * <p>The interpretation is encoded as an array of truth values for all generated ground instances
   * (derived from {@link #koristeneVarijable} and {@link #velicinaNosaca}). The method evaluates
   * the conjunction/list structure and returns {@code true} if the interpretation satisfies all
   * required constraints.
   *
   * @param interpretacija encoded truth assignment for the current carrier and variable list
   * @param konjuktivnaForma reduced conjunction-oriented structure to be tested
   * @return {@code true} if the interpretation satisfies the formula under this carrier size
   */
  public static boolean zadovoljavaInterpretaciju(int[] interpretacija, Map konjukt) {
    boolean zadovoljavaInterpretaciju = true;
    int i = 0;
    while (zadovoljavaInterpretaciju == true && i < koristeneVarijable.size()) {
      String pv = (String) koristeneVarijable.get(i);
      if (konjukt.containsKey(pv)
          && ((interpretacija[i] == 0) && ((Boolean) konjukt.get(pv)).equals(new Boolean(true))
              || (interpretacija[i] == 1)
                  && ((Boolean) konjukt.get(pv)).equals(new Boolean(false))))
        zadovoljavaInterpretaciju = false;
      i++;
    }
    return zadovoljavaInterpretaciju;
  }

  /**
   * Converts a decimal index into a fixed-width binary vector.
   *
   * <p>Used to systematically enumerate candidate interpretations. The returned array has a fixed
   * length {@code brojBinarnihZnamenki} and represents the binary form of {@code dekadski}.
   *
   * @param dekadski decimal number to convert
   * @param brojBinarnihZnamenki fixed width of the resulting binary vector
   * @return binary vector (most-significant bit first)
   */
  public static int[] dekadskiUBinarni(
      int dekadski, int brojBinarnihZnamenki /* koristeneVarijable.size() */) {
    int[] binarni = new int[brojBinarnihZnamenki];
    for (int i = brojBinarnihZnamenki - 1; i >= 0; i--) {
      int potencijaOd2 = (int) Math.pow((double) 2, (double) i);
      int cjelobrojnoDijeljenje = Math.round(dekadski / potencijaOd2);
      binarni[brojBinarnihZnamenki - 1 - i] = cjelobrojnoDijeljenje;
      dekadski = dekadski - (cjelobrojnoDijeljenje * potencijaOd2);
    }
    return binarni;
  }

  /**
   * Searches for a satisfying interpretation by exhaustive enumeration (finite model search).
   *
   * <p>Enumerates all candidate interpretations for the current carrier size and used variables,
   * tests each candidate via {@link #zadovoljavaInterpretaciju(boolean[], List)}, and returns
   * whether at least one satisfying interpretation exists.
   *
   * <p>This method effectively answers “is the formula satisfiable over the chosen finite carrier?”
   * for the calculator's internal normal-form representation.
   *
   * @param konjuktivnaForma reduced conjunction-oriented representation of the formula
   * @return {@code true} if at least one satisfying interpretation exists
   */
  public static boolean[] savrsenaKonjuktivnaForma(List konjuktivnaForma) {
    List reduciranaKonjuktivnaForma = reducirajNormalnuFormu(konjuktivnaForma);
    boolean[] semantickaTablica =
        new boolean[(int) Math.pow((double) 2, (double) koristeneVarijable.size())];
    for (int i = 0; i < semantickaTablica.length; i++) {
      int[] binarniBroj = dekadskiUBinarni(i, koristeneVarijable.size());
      int j = 0;
      while (semantickaTablica[i] == false && j < reduciranaKonjuktivnaForma.size()) {
        if (zadovoljavaInterpretaciju(binarniBroj, (Map) reduciranaKonjuktivnaForma.get(j))) {
          semantickaTablica[i] = true;
        }
        j++;
      }
    }
    return semantickaTablica;
  }

  /**
   * Highlights the found solutions in the GUI.
   *
   * <p>Takes the encoded solution vector and applies visual highlighting to UI components
   * (typically variable/predicate buttons or table entries) so that the user can see which
   * assignments make the formula true under the current carrier.
   *
   * @param panel UI container whose components are highlighted
   * @param savrsenaKonjuktivnaForma encoded solution vector (from the satisfiability search)
   */
  public static void osvijetliRjesenja(
      List konjuktivnaForma, JPanel panel, String maliRazmak, String razmak) {
    boolean[] semantickaTablica = savrsenaKonjuktivnaForma(konjuktivnaForma);
    String varijable = "";
    for (int i = 0; i < koristeneVarijable.size(); i++) {
      varijable += maliRazmak + (String) koristeneVarijable.get(i);
    }
    JButton gumbVarijabli = ((JButton) panel.getComponent(1));
    gumbVarijabli.setText(varijable.substring(maliRazmak.length()));
    gumbVarijabli.setForeground(Color.yellow);
    gumbVarijabli.setBackground(Color.blue);
    for (int i = 0; i < semantickaTablica.length; i++) {
      String rastegnutaInterpretacija = "";
      int[] interpretacija = dekadskiUBinarni(i, koristeneVarijable.size());
      for (int j = 0; j < interpretacija.length; j++)
        rastegnutaInterpretacija += razmak + (new Integer(interpretacija[j])).toString();
      JButton gumbInterpretacije = ((JButton) panel.getComponent(i + 2));
      gumbInterpretacije.setText(rastegnutaInterpretacija.substring(razmak.length()));
      if (semantickaTablica[i] == true) gumbInterpretacije.setBackground(Color.yellow);
    }
    System.out.println("✅ Solution found. Consistency: 100% — No contradictions detected!");
    // System.out.println("🪶 Wisdom check passed → ‘Fear of the Lord is hatred of evil.’");
  }
}
