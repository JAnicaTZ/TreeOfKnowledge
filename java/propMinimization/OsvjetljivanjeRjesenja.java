package propMinimization;

/**
 * Visualization and highlighting of minimal solutions in the GUI.
 *
 * <p>Marks clauses, literals, or tree nodes that participate in the selected minimal CNF/DNF
 * representation, allowing the user to visually inspect the result of the minimization process.
 */
import java.awt.Color;
import java.util.*; // List, ArrayList, Map, HashMap
import javax.swing.*; // JButton, JPanel, BorderFactory

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public class OsvjetljivanjeRjesenja {
  public static List koristeneVarijable;
  public static String[] semantickaTablica;
  public static String razmak = "       ";

  public static void osvijetliRjesenja(
      List koristeneVarijable, List disjunktivnaForma, JPanel panel) {
    OsvjetljivanjeRjesenja.koristeneVarijable = koristeneVarijable;
    String varijable = "";
    for (int i = 0; i < koristeneVarijable.size(); i++) {
      varijable += razmak + ((Character) koristeneVarijable.get(i)).charValue();
    }
    JButton gumbVarijabli = ((JButton) panel.getComponent(1));
    gumbVarijabli.setText(varijable.substring(razmak.length()));
    // gumbVarijabli.setFont(new Font("Times Roman", Font.BOLD, 15));
    gumbVarijabli.setForeground(Color.yellow);
    gumbVarijabli.setBackground(Color.blue);

    crtanjeSemantickeTablice(koristeneVarijable.size());
    for (int i = 0; i < semantickaTablica.length; i++) {
      String rastegnutaInterpretacija = "";
      for (int j = 0; j < semantickaTablica[i].length(); j++)
        rastegnutaInterpretacija += razmak + semantickaTablica[i].charAt(j);
      JButton gumbInterpretacije = ((JButton) panel.getComponent(i + 2));
      gumbInterpretacije.setText(rastegnutaInterpretacija.substring(razmak.length()));
      gumbInterpretacije.setForeground(Color.blue);
      int k = 0;
      while (++k <= disjunktivnaForma.size())
        if (OsvjetljivanjeRjesenja.zadovoljavaInterpretaciju(
            semantickaTablica[i], (List) disjunktivnaForma.get(k - 1))) {
          ((JButton) panel.getComponent(i + 2)).setBackground(Color.yellow);
          break;
        }
    }
  }

  public static void crtanjeSemantickeTablice(int brojBinarnihZnamenki) {
    semantickaTablica = new String[(int) Math.pow((double) 2, (double) brojBinarnihZnamenki)];
    for (int i = 0; i < semantickaTablica.length; i++) {
      semantickaTablica[i] = "";
      int k = i;
      for (int j = brojBinarnihZnamenki - 1; j >= 0; j--) {
        int potencijaOd2 = (int) Math.pow((double) 2, (double) j);
        int cjelobrojnoDijeljenje = Math.round(k / potencijaOd2);
        semantickaTablica[i] += new Integer(cjelobrojnoDijeljenje).toString();
        k = k - (cjelobrojnoDijeljenje * potencijaOd2);
      }
    }
  }

  public static boolean zadovoljavaInterpretaciju(String nuleJedinice, List konjukt) {
    int i = 0;
    while (i < koristeneVarijable.size()) {
      AtomarnaFormula a = new AtomarnaFormula(((Character) koristeneVarijable.get(i)).charValue());
      if ((nuleJedinice.charAt(i) == '0') && konjukt.contains(a)
          || (nuleJedinice.charAt(i++) == '1') && konjukt.contains(a.suprotnaFormula()))
        return false;
    }
    return true;
  }
}
