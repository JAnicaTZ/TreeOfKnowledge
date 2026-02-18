package propositional;

/**
 * UI/driver pipeline for building and using the Disjunctive Normal Form (DNF).
 *
 * <p>This class orchestrates a typical workflow:
 *
 * <ol>
 *   <li>Parse the input string into an AST ({@link Formula})
 *   <li>Visualize the AST in a Swing {@code JTree}
 *   <li>Clone and rewrite the AST by eliminating negations (De Morgan + double negation)
 *   <li>Compute DNF as a list-of-lists of literals
 *   <li>Reduce the normal form (remove redundant clauses)
 *   <li>Highlight satisfying valuations in the truth-table style panel
 * </ol>
 *
 * <p>The intention is "explainable logic": the same input is shown simultaneously as text, a
 * transformation tree, and a semantic table of valuations.
 */
import java.util.*; // List, ArrayList
import javax.swing.*; // JTree, JScrollPane

import propCommon.AtomicFormula;
import propCommon.Disjunction;
import propCommon.Formula;
import propCommon.NormalFormFormula;
import propCommon.PropAnalysisResult;
import propCommon.Negation;
// import propCommon.SemanticTableHighlighter;
import propCommon.UIStrings;
import propCommon.Conjunction;

class FaktorExpected extends Exception {
}

class Pocetak extends Exception {
}

class ZatvoriZagradu extends Exception {
}

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu

public class DisjunktivnaFormaZaLS {
  public static ArrayList koristeneVarijable;
  public static String formula;
  public static int d;
  public static int i;

  // public static void disjunktivnaFormaZaLS() throws FaktorExpected, Pocetak,
  // ZatvoriZagradu {
  // koristeneVarijable = new ArrayList();
  // // formula = Calc.display.getText().substring(1);
  // formula = Calc.getCanonicalFormula();

  // d = formula.length();
  // if (d == 0)
  // throw new Pocetak();
  // i = 0;
  // Formula korijenStabla = term();

  // // @SIMPLE SHOW Tree
  // JTree stabloFormule = new JTree(korijenStabla.prikazFormule());
  // for (int i = 0; i < stabloFormule.getRowCount(); i++) {
  // stabloFormule.expandRow(i);
  // }
  // JScrollPane stabloFormuleView = new JScrollPane(stabloFormule);

  // // Postavljanje stabla u panel
  // Calc.stablaPanel.add(stabloFormuleView);

  // Formula eliminiramNegacije = (Formula) korijenStabla.clone();
  // eliminiramNegacije = eliminiramNegacije.eliminiramNegacije();
  // JTree stabloGlavnogTesta = new JTree(eliminiramNegacije.prikazFormule());
  // for (int i = 0; i < stabloGlavnogTesta.getRowCount(); i++) {
  // stabloGlavnogTesta.expandRow(i);
  // }
  // JScrollPane stabloGlavnogTestaView = new JScrollPane(stabloGlavnogTesta);
  // Calc.stablaPanel.add(stabloGlavnogTestaView);

  // // eliminiramNegacije = reduceBySubsumption(((NormalFormFormula)
  // // eliminiramNegacije).disjunktivnojFormi());

  // SemanticTableHighlighter.osvijetliRjesenja(
  // DisjunktivnaFormaZaLS.koristeneVarijable,
  // ((NormalFormFormula) eliminiramNegacije).disjunktivnojFormi(),
  // Calc.interpretacijePanel);

  // System.out.println(((NormalFormFormula)
  // eliminiramNegacije).konjunktivnojFormi());
  // }
  public static PropAnalysisResult disjunktivnaFormaZaLS() throws FaktorExpected, Pocetak, ZatvoriZagradu {
    koristeneVarijable = new ArrayList();
    // formula = Calc.display.getText().substring(1);
    formula = Calc.getCanonicalFormula();

    d = formula.length();
    if (d == 0)
      throw new Pocetak();
    i = 0;
    Formula korijenStabla = term();

    // @SIMPLE SHOW Tree: EXPAND ALL NODES
    JTree stabloFormule = new JTree(korijenStabla.prikazFormule());
    for (int i = 0; i < stabloFormule.getRowCount(); i++) {
      stabloFormule.expandRow(i);
    }
    JScrollPane stabloFormuleView = new JScrollPane(stabloFormule);

    // Postavljanje stabla u panel
    Calc.stablaPanel.add(stabloFormuleView);

    Formula eliminiramNegacije = (Formula) korijenStabla.clone();
    eliminiramNegacije = eliminiramNegacije.eliminiramNegacije();
    JTree stabloGlavnogTesta = new JTree(eliminiramNegacije.prikazFormule());
    for (int i = 0; i < stabloGlavnogTesta.getRowCount(); i++) {
      stabloGlavnogTesta.expandRow(i);
    }
    JScrollPane stabloGlavnogTestaView = new JScrollPane(stabloGlavnogTesta);
    Calc.stablaPanel.add(stabloGlavnogTestaView);

    // eliminiramNegacije = reduceBySubsumption(((NormalFormFormula)
    // eliminiramNegacije).disjunktivnojFormi());

    // SemanticTableHighlighter.osvijetliRjesenja(
    // DisjunktivnaFormaZaLS.koristeneVarijable,
    // ((NormalFormFormula) eliminiramNegacije).disjunktivnojFormi(),
    // Calc.interpretacijePanel);

    System.out.println(((NormalFormFormula) eliminiramNegacije).konjunktivnojFormi());

    return new PropAnalysisResult(
        formula,
        korijenStabla,
        koristeneVarijable,
        eliminiramNegacije,
        null, // normalForm
        ((NormalFormFormula) eliminiramNegacije).disjunktivnojFormi(),
        null // cnf
    );
  }

  public static Formula term() throws FaktorExpected, ZatvoriZagradu {
    Formula prviFaktor = faktor();
    while ((i < d) && Calc.binarniVeznici.contains(new Character(formula.charAt(i)))) {
      Formula binarniVeznik = new Conjunction(null, null); // razmotriti!
      if (i + 1 >= d)
        throw new FaktorExpected();
      switch (formula.charAt(i++)) {
        case UIStrings.AND_CHAR:
          binarniVeznik = new Conjunction(prviFaktor, faktor());
          break;
        case UIStrings.OR_CHAR:
          binarniVeznik = new Disjunction(prviFaktor, faktor());
          break;
        case UIStrings.IMPLIES_CHAR:
          binarniVeznik = new Disjunction(new Negation(prviFaktor), faktor());
          break;
        case UIStrings.EQUIV_CHAR:
          Formula drugiFaktor = faktor();
          binarniVeznik = new Conjunction(
              new Disjunction(new Negation(prviFaktor), drugiFaktor),
              new Disjunction(
                  (Formula) prviFaktor.clone(), new Negation((Formula) drugiFaktor.clone())));
          break;
      }
      prviFaktor = binarniVeznik;
    }
    return prviFaktor;
  }

  public static Formula faktor() throws FaktorExpected, ZatvoriZagradu {
    if ((i >= d) || !Calc.propozicVarijable.contains(new Character(formula.charAt(i))))
      throw new FaktorExpected();
    Formula izFaktora = new Negation(null); // razmotriti!
    switch (formula.charAt(i)) {
      case Calc.P_CHAR:
      case Calc.Q_CHAR:
      case Calc.R_CHAR:
        if (!koristeneVarijable.contains(new Character(formula.charAt(i))))
          koristeneVarijable.add(new Character(formula.charAt(i)));
        return new AtomicFormula(formula.charAt(i++));
      case UIStrings.NEGACIJA_CHAR:
        i++;
        if (i >= d)
          throw new FaktorExpected();
        return new Negation(faktor());
      case Calc.LIJEVA_ZAGRADA:
        i++;
        if (i >= d)
          throw new FaktorExpected();
        izFaktora = term();
        if ((i >= d) || (formula.charAt(i) != ')'))
          throw new ZatvoriZagradu();
        i++;
        break;
    }
    return izFaktora;
  }

  /**
   * Reduces a Disjunctive Normal Form (DNF) by subsumption (absorption law).
   * <p>
   * A conjunction C1 is said to subsume C2 if the set of its literals is a subset
   * of
   * the literals of C2. In that case, C2 is redundant and can be removed:
   *
   * <pre>
   * (A ∧ B) ∨ A  ≡  A
   * </pre>
   *
   * This method removes all conjunctions that are supersets of another
   * conjunction,
   * thus producing a logically equivalent but smaller DNF.
   *
   * @param dnf a list of conjunctions, each represented as a list of literals
   * @return a reduced DNF in which no conjunction is subsumed by another
   */
  // @GPT
  // public static List<List<AtomarnaFormula>>
  // reduceBySubsumption(List<List<AtomarnaFormula>> dnf) {
  // public static List<List<AtomicFormula>>
  // reduceBySubsumption(List<List<AtomicFormula>> forma) {
  // // 1) Normalizacija: makni duplikate unutar konjunkta + makni kontradikcije
  // List<List<AtomicFormula>> norm = new ArrayList<>();

  // for (List<AtomicFormula> conj : forma) {
  // // ukloni duplikate, zadrži redoslijed
  // LinkedHashSet<AtomicFormula> set = new LinkedHashSet<>(conj);

  // // kontradikcija? (A i ¬A zajedno)
  // boolean kontradikcija = false;
  // for (AtomicFormula lit : set) {
  // if (set.contains(lit.suprotnaFormula())) {
  // kontradikcija = true;
  // break;
  // }
  // }
  // if (kontradikcija)
  // continue; // ovaj konjunkt je uvijek false → izbaci ga

  // norm.add(new ArrayList<>(set));
  // }

  // // 2) Makni duplikate cijelih konjunkata (kanoniziraj ključ)
  // Map<String, List<AtomicFormula>> unique = new LinkedHashMap<>();
  // for (List<AtomicFormula> conj : norm) {
  // // ključ: sortirana reprezentacija
  // List<String> parts = new ArrayList<>();
  // for (AtomicFormula lit : conj)
  // parts.add(lit.toString());
  // Collections.sort(parts);
  // String key = String.join("&", parts);

  // unique.putIfAbsent(key, conj);
  // }

  // List<List<AtomicFormula>> list = new ArrayList<>(unique.values());

  // // 3) Subsumption/apsorpcija: sortiraj po duljini (kraći prvi)
  // list.sort(Comparator.comparingInt(List::size));

  // List<List<AtomicFormula>> reduced = new ArrayList<>();
  // outer: for (List<AtomicFormula> candidate : list) {
  // for (List<AtomicFormula> kept : reduced) {
  // // ako kept ⊆ candidate → candidate je redundant
  // if (candidate.containsAll(kept))
  // continue outer;
  // }
  // reduced.add(candidate);
  // }

  // return reduced;
  // }

}
