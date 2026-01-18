package propMinimization;

/**
 * Computes minimal normal forms (CNF and DNF) of a propositional formula.
 *
 * <p>Uses prime implicants and irreducible representations to construct logically equivalent normal
 * forms with a minimal number of clauses/terms.
 *
 * <p>This class encapsulates the final optimization step of the minimization pipeline.
 */
import java.util.*; // List, ArrayList
import javax.swing.*; // JTree, JScrollPane

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public class MinimalneNormalneForme {

  public static void minimalneNormalneForme(Formula korijenStabla) {
    Formula eliminiramNegacije = (Formula) korijenStabla.clone();
    eliminiramNegacije = eliminiramNegacije.eliminiramNegacije();

    List disjunktivnaNF = ((FormulaUNormalnoj) eliminiramNegacije).disjunktivnojFormi();
    // System.out.println(disjunktivnaNF);
    OsvjetljivanjeRjesenja.osvijetliRjesenja(
        StabloFormule.koristeneVarijable, disjunktivnaNF, Calc.interpretacijePanel);
    if (!disjunktivnaNF.isEmpty()) {
      List primeImplicants = PrimeImplicants.primeImplicants(disjunktivnaNF);
      System.out.println(
          "--------------------------------------------------------------------------------------\n\n"
              + "PRIME IMPLICANTS:\n\n"
              + primeImplicants);

      if (!primeImplicants.contains(new String("tautology;)!)"))) {
        List ireducibilneDNF = IreducibilneDNF.ireducibilneDNF(primeImplicants);
        // System.out.println("\n\nIRREDUCIBLE  DISJUNCTIVE  NORMAL FORMS (DNF):\n\n" +
        // ispisDNFormi( true, ireducibilneDNF));
        List konjunktivnaNF =
            ((FormulaUNormalnoj) new Negacija((Formula) korijenStabla.clone()).eliminiramNegacije())
                .disjunktivnojFormi();
        List ireducibilneKNF =
            IreducibilneDNF.ireducibilneDNF(PrimeImplicants.primeImplicants(konjunktivnaNF));
        // System.out.println("\nIReducibilne KONJUNKTIVNE normalne forme:\n" + ispisDNFormi( false,
        // ireducibilneKNF));
        int minimalanBrojLiterala = minimalnaSlozenost(false, ireducibilneDNF);
        int minimalanBrojLiteralaKNF = minimalnaSlozenost(false, ireducibilneKNF);
        if (minimalanBrojLiterala > minimalanBrojLiteralaKNF)
          minimalanBrojLiterala = minimalanBrojLiteralaKNF;
        String minimalneNormalneForme =
            "DISJUNCTIVE  Normal Forms (DNFs) with " + minimalanBrojLiterala + " literals:\n";
        for (int i = 0; i < ireducibilneDNF.size(); i++) {
          int brojLiterala = slozenostDNForme(false, (List) ireducibilneDNF.get(i));
          if (brojLiterala == minimalanBrojLiterala)
            minimalneNormalneForme += ispisDNForme(true, (List) ireducibilneDNF.get(i));
        }
        if (minimalneNormalneForme.equals(
            "DISJUNCTIVE  Normal Forms (DNFs) with " + minimalanBrojLiterala + " literals:\n"))
          minimalneNormalneForme = "";
        else {
          minimalneNormalneForme +=
              "\nCONJUCTIVE Normal Forms (CNFs) with " + minimalanBrojLiterala + " literals:\n";
          for (int i = 0; i < ireducibilneKNF.size(); i++) {
            int brojLiterala = slozenostDNForme(false, (List) ireducibilneKNF.get(i));
            if (brojLiterala == minimalanBrojLiterala)
              minimalneNormalneForme += ispisDNForme(false, (List) ireducibilneKNF.get(i));
          }
          if (minimalneNormalneForme.charAt(minimalneNormalneForme.length() - 2) == ':')
            minimalneNormalneForme = "";
        }
        if (minimalneNormalneForme.length() > 0) minimalneNormalneForme += "\n\n";
        int minimalnaSlozenost = minimalnaSlozenost(true, ireducibilneDNF);
        int minimalnaSlozenostKNF = minimalnaSlozenost(true, ireducibilneKNF);
        if (minimalnaSlozenost > minimalnaSlozenostKNF) minimalnaSlozenost = minimalnaSlozenostKNF;

        minimalneNormalneForme += "MINIMAL NORMAL FORMS :\n\n";
        for (int i = 0; i < ireducibilneDNF.size(); i++) {
          int slozenostDNForme = slozenostDNForme(true, (List) ireducibilneDNF.get(i));
          if (slozenostDNForme == minimalnaSlozenost)
            minimalneNormalneForme += ispisDNForme(true, (List) ireducibilneDNF.get(i));
        }
        for (int i = 0; i < ireducibilneKNF.size(); i++) {
          int slozenostDNForme = slozenostDNForme(true, (List) ireducibilneKNF.get(i));
          if (slozenostDNForme == minimalnaSlozenost) {
            if (minimalneNormalneForme.charAt(minimalneNormalneForme.length() - 2) == ':')
              minimalneNormalneForme += "\n";
            String minimalnaKonjunktivnaNormalnaForma =
                ispisDNForme(false, (List) ireducibilneKNF.get(i));
            if (minimalneNormalneForme
                    .substring(minimalneNormalneForme.lastIndexOf("MINIMAL NORMAL FORMS"))
                    .indexOf(minimalnaKonjunktivnaNormalnaForma)
                < 0) minimalneNormalneForme += minimalnaKonjunktivnaNormalnaForma;
          }
        }
        // minimalneNormalneForme +=
        // "--------------------------------------------------------------------------------------\n";
        Calc.minimalneNormalneForme.append(minimalneNormalneForme);
      } else Calc.minimalneNormalneForme.append("\t              TAUTOLOGY\n");
    } else Calc.minimalneNormalneForme.append("\t          ANTItautology\n");
    Calc.minimalneNormalneForme.append(
        "--------------------------------------------------------------------------------------\n");
    // System.out.println();
  }

  public static String ispisDNFormi(boolean disjunktivna, List listaDNFormi) {
    String izlaz = ispisDNForme(disjunktivna, (List) listaDNFormi.get(0)) + "\n";
    for (int i = 1; i < listaDNFormi.size(); i++) {
      izlaz += ispisDNForme(disjunktivna, (List) listaDNFormi.get(i)) + "\n";
    }
    return izlaz;
  }

  public static String ispisDNForme(boolean disjunktivna, List disjunktivnaNF) {
    String izlaz = ispisDisjunkta(disjunktivna, (List) disjunktivnaNF.get(0));
    for (int i = 1; i < disjunktivnaNF.size(); i++) {
      if (disjunktivna) izlaz += " " + (new Character(Calc.OR_CHAR)).toString() + " ";
      else izlaz += " " + (new Character(Calc.AND_CHAR)).toString() + " ";
      izlaz += ispisDisjunkta(disjunktivna, (List) disjunktivnaNF.get(i));
    }
    return izlaz + "\n";
  }

  public static String ispisDisjunkta(
      boolean disjunktivna, List disjunkt) { // ubaceno!!  SORTIRANJE
    String izlaz = "( ";
    int i = 0;
    AtomarnaFormula propozicionalnaVarijabla;
    while (izlaz.equals("( ")) {
      propozicionalnaVarijabla =
          new AtomarnaFormula(((Character) StabloFormule.koristeneVarijable.get(i++)).charValue());
      if (disjunkt.contains(propozicionalnaVarijabla)) {
        if (disjunktivna) izlaz += propozicionalnaVarijabla.toString();
        else izlaz += propozicionalnaVarijabla.suprotnaFormula().toString();
      }
      propozicionalnaVarijabla = propozicionalnaVarijabla.suprotnaFormula();
      if (disjunkt.contains(propozicionalnaVarijabla)) {
        if (disjunktivna) izlaz += propozicionalnaVarijabla.toString();
        else izlaz += propozicionalnaVarijabla.suprotnaFormula().toString();
      }
    }
    for (int j = i; j < StabloFormule.koristeneVarijable.size(); j++) {
      propozicionalnaVarijabla =
          new AtomarnaFormula(((Character) StabloFormule.koristeneVarijable.get(j)).charValue());
      if (disjunkt.contains(propozicionalnaVarijabla)) {
        if (disjunktivna)
          izlaz += (new Character(Calc.AND_CHAR)).toString() + propozicionalnaVarijabla.toString();
        else
          izlaz +=
              (new Character(Calc.OR_CHAR)).toString()
                  + propozicionalnaVarijabla.suprotnaFormula().toString();
      }
      propozicionalnaVarijabla = propozicionalnaVarijabla.suprotnaFormula();
      if (disjunkt.contains(propozicionalnaVarijabla)) {
        if (disjunktivna)
          izlaz += (new Character(Calc.AND_CHAR)).toString() + propozicionalnaVarijabla.toString();
        else
          izlaz +=
              (new Character(Calc.OR_CHAR)).toString()
                  + propozicionalnaVarijabla.suprotnaFormula().toString();
      }
    }
    return izlaz + ")";
  }

  public static int minimalnaSlozenost(boolean brojiDisjunkte, List listaDNFormi) {
    int minimalnaSlozenost = slozenostDNForme(brojiDisjunkte, (List) listaDNFormi.get(0));
    for (int i = 1; i < listaDNFormi.size(); i++) {
      int slozenost = slozenostDNForme(true, (List) listaDNFormi.get(i));
      if (slozenost < minimalnaSlozenost) minimalnaSlozenost = slozenost;
    }
    return minimalnaSlozenost;
  }

  public static int slozenostDNForme(boolean brojiDisjunkte, List disjunktivnaNF) {
    int slozenostDNForme = 0;
    if (brojiDisjunkte) slozenostDNForme = disjunktivnaNF.size();
    for (int i = 0; i < disjunktivnaNF.size(); i++) {
      slozenostDNForme += ((List) disjunktivnaNF.get(i)).size();
    }
    return slozenostDNForme;
  }
}
