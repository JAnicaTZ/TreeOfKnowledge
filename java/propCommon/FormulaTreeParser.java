package propCommon;

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

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu

public class FormulaTreeParser {
  public static ArrayList<Character> koristeneVarijable;
  public static String formula;
  public static int duljina;
  public static int i;

  public static PropAnalysisResult parsiraj(String input) throws PropParseException {

    FormulaTreeParser.formula = input; // <-- KRITIČNO: napuni statičko polje koje koristi term()

    koristeneVarijable = new ArrayList<>();
    // formula = Calc.formulaLS.substring(1);
    // formula = Calc.getCanonicalFormula();
    // System.out.println(formula);
    duljina = formula.length();
    if (duljina == 0)
      throw new PropParseException.Pocetak();
    i = 0;
    // return term();

    // System.out.println("Parsing formula: " + formula);

    Formula korijenStabla = term();
    // System.out.println("Parsed AST: " + korijenStabla);

    // @MIN SHOW Tree: EXPAND ALL NODES
    JTree stabloFormule = new JTree(korijenStabla.prikazFormule());
    for (int i = 0; i < stabloFormule.getRowCount(); i++) {
      stabloFormule.expandRow(i);
    }
    // JScrollPane stabloFormuleView = new JScrollPane(stabloFormule);

    // Postavljanje stabla u panel
    // Calc.stablaPanel.add(stabloFormuleView);

    Formula eliminiramNegacije = (Formula) korijenStabla.clone();
    eliminiramNegacije = eliminiramNegacije.eliminiramNegacije();
    JTree stabloGlavnogTesta = new JTree(eliminiramNegacije.prikazFormule());
    for (int i = 0; i < stabloGlavnogTesta.getRowCount(); i++) {
      stabloGlavnogTesta.expandRow(i);
    }
    // System.out.println("BEFORE return: " + eliminiramNegacije);

    return new PropAnalysisResult(
        formula, // input
        korijenStabla, // ast
        koristeneVarijable, // vars
        eliminiramNegacije, // nnfAst
        null, // normalForm (nije obrađeno u ovom kodu)
        ((NormalFormFormula) eliminiramNegacije).disjunktivnojFormi(), // dnf
        ((NormalFormFormula) eliminiramNegacije).konjunktivnojFormi() // cnf
    );
  }

  public static Formula term() throws PropParseException.FaktorExpected, PropParseException.ZatvoriZagradu {
    // System.out.println("Parsing term starting at index " + i + ": " +
    // formula.substring(i));
    Formula prviFaktor = faktor();

    while ((i < duljina) && UIStrings.isBinaryOp(formula.charAt(i))) {
      Formula binarniVeznik = new Conjunction(null, null); // razmotriti!
      if (i + 1 >= duljina)
        throw new PropParseException.FaktorExpected();
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

  public static Formula faktor() throws PropParseException.FaktorExpected, PropParseException.ZatvoriZagradu {
    // System.out.println("Parsing factor starting at index " + i + ": " +
    // formula.substring(i));
    // System.out.println("duljina: " + duljina);
    if ((i >= duljina) /* || !MINIMIZATION_CHARACTERS.contains(new Character(formula.charAt(i))) */)
      throw new PropParseException.FaktorExpected();
    Formula izFaktora = new Negation(null); // razmotriti!

    char ch = formula.charAt(i);
    switch (ch) {
      // case UIStrings.NEGACIJA_CHAR:
      // i++;
      // if (i >= duljina)
      // throw new PropParseException.FaktorExpected();
      // return new Negation(faktor());

      default:
        if (UIStrings.PROP_VARS.contains(ch)) {

          if (!koristeneVarijable.contains(ch))
            koristeneVarijable.add(ch);
          i++;
          return new AtomicFormula(ch);
        }
        throw new PropParseException.FaktorExpected();

      case UIStrings.NEGACIJA_CHAR:
        i++;
        if (i >= duljina)
          throw new PropParseException.FaktorExpected();
        return new Negation(faktor());

      // TODO: NE dolazimo ovdje
      case UIStrings.LIJEVA_ZAGRADA:
        // System.out.println("UIStrings.LIJEVA_ZAGRADA -Parsing parenthesized
        // expression starting at index " + i);
        i++;
        if (i >= duljina)
          throw new PropParseException.FaktorExpected();
        izFaktora = term();
        if ((i >= duljina) || (formula.charAt(i) != UIStrings.DESNA_ZAGRADA))
          throw new PropParseException.ZatvoriZagradu();
        i++;
        break;
    }
    // System.out.println("Parsed factor: " + izFaktora);
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
  public static List<List<AtomicFormula>> reduceBySubsumption(List<List<AtomicFormula>> forma) {
    // 1) Normalizacija: makni duplikate unutar konjunkta + makni kontradikcije
    List<List<AtomicFormula>> norm = new ArrayList<>();

    for (List<AtomicFormula> conj : forma) {
      // ukloni duplikate, zadrži redoslijed
      LinkedHashSet<AtomicFormula> set = new LinkedHashSet<>(conj);

      // kontradikcija? (A i ¬A zajedno)
      boolean kontradikcija = false;
      for (AtomicFormula lit : set) {
        if (set.contains(lit.suprotnaFormula())) {
          kontradikcija = true;
          break;
        }
      }
      if (kontradikcija)
        continue; // ovaj konjunkt je uvijek false → izbaci ga

      norm.add(new ArrayList<>(set));
    }

    // 2) Makni duplikate cijelih konjunkata (kanoniziraj ključ)
    Map<String, List<AtomicFormula>> unique = new LinkedHashMap<>();
    for (List<AtomicFormula> conj : norm) {
      // ključ: sortirana reprezentacija
      List<String> parts = new ArrayList<>();
      for (AtomicFormula lit : conj)
        parts.add(lit.toString());
      Collections.sort(parts);
      String key = String.join("&", parts);

      unique.putIfAbsent(key, conj);
    }

    List<List<AtomicFormula>> list = new ArrayList<>(unique.values());

    // 3) Subsumption/apsorpcija: sortiraj po duljini (kraći prvi)
    list.sort(Comparator.comparingInt(List::size));

    List<List<AtomicFormula>> reduced = new ArrayList<>();
    outer: for (List<AtomicFormula> candidate : list) {
      for (List<AtomicFormula> kept : reduced) {
        // ako kept ⊆ candidate → candidate je redundant
        if (candidate.containsAll(kept))
          continue outer;
      }
      reduced.add(candidate);
    }

    return reduced;
  }

}
