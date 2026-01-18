package propMinimization;

/**
 * Syntax tree representation of a propositional formula used in the minimization process.
 *
 * <p>Provides a tree-based (AST) view of the formula that supports:
 *
 * <ul>
 *   <li>recursive traversal,
 *   <li>normal-form transformations,
 *   <li>and structural analysis needed for prime implicant computation.
 * </ul>
 *
 * <p>This class is the structural backbone on which CNF/DNF conversion and minimization algorithms
 * operate.
 */
import java.util.*; // List, ArrayList
import javax.swing.*; // JTree, JScrollPane

class FaktorExpected extends Exception {}

class Pocetak extends Exception {}

class ZatvoriZagradu extends Exception {}

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public class StabloFormule {
  public static ArrayList koristeneVarijable;
  public static String formula;
  public static int d;
  public static int i;

  public static Formula parsiraj() throws FaktorExpected, Pocetak, ZatvoriZagradu {
    koristeneVarijable = new ArrayList();
    formula = Calc.formulaLS.substring(1);
    // System.out.println(formula);
    d = formula.length();
    if (d == 0) throw new Pocetak();
    i = 0;
    return term();
  }

  public static Formula term() throws FaktorExpected, ZatvoriZagradu {
    Formula prviFaktor = faktor();
    while ((i < d) && Calc.binarniVeznici.contains(new Character(formula.charAt(i)))) {
      Formula binarniVeznik = new Konjunkcija(null, null); // razmotriti!
      if (i + 1 >= d) throw new FaktorExpected();
      switch (formula.charAt(i++)) {
        case Calc.AND_CHAR:
          binarniVeznik = new Konjunkcija(prviFaktor, faktor());
          break;
        case Calc.OR_CHAR:
          binarniVeznik = new Disjunkcija(prviFaktor, faktor());
          break;
        case Calc.POVLACI_CHAR:
          binarniVeznik = new Disjunkcija(new Negacija(prviFaktor), faktor());
          break;
        case Calc.AKKO_CHAR:
          Formula drugiFaktor = faktor();
          binarniVeznik =
              new Konjunkcija(
                  new Disjunkcija(new Negacija(prviFaktor), drugiFaktor),
                  new Disjunkcija(
                      (Formula) prviFaktor.clone(), new Negacija((Formula) drugiFaktor.clone())));
          break;
      }
      prviFaktor = binarniVeznik;
    }
    return prviFaktor;
  }

  public static Formula faktor() throws FaktorExpected, ZatvoriZagradu {
    if ((i >= d) || !Calc.propozicVarijable.contains(new Character(formula.charAt(i))))
      throw new FaktorExpected();
    Formula izFaktora = new Negacija(null); // razmotriti!
    switch (formula.charAt(i)) {
      case Calc.P_CHAR:
      case Calc.Q_CHAR:
      case Calc.R_CHAR:
      case Calc.S_CHAR:
        if (!koristeneVarijable.contains(new Character(formula.charAt(i))))
          koristeneVarijable.add(new Character(formula.charAt(i)));
        return new AtomarnaFormula(formula.charAt(i++));
      case Calc.NEGACIJA_CHAR:
        i++;
        if (i >= d) throw new FaktorExpected();
        return new Negacija(faktor());
      case Calc.LIJEVA_ZAGRADA:
        i++;
        if (i >= d) throw new FaktorExpected();
        izFaktora = term();
        if ((i >= d) || (formula.charAt(i) != ')')) throw new ZatvoriZagradu();
        i++;
        break;
    }
    return izFaktora;
  }
}
