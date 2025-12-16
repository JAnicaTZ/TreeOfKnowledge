package propositional;

/**
 * SIMPLE PROPOSITIONAL TREE – Beginner Mode
 * Part of the TreeOfKnowledge.eu project.
 *
 * 🕯 Dedicated to the victims of Vukovar, Škabrnja, and the Homeland War.
 * 🕯 Posvećeno žrtvama Vukovara, Škabrnje i Domovinskog rata.
 *
 * Th© BEST CORE of AI
 * Author: JAnica Tesla Zrinski
 * Domain: https://TreeOfKnowledge.eu
 * Years: 2002–2025
 *
 * All rights reserved.
 *
 * This source code is the intellectual property of
 * JAnica Tesla Zrinski (TreeOfKnowledge.eu).
 *
 * Unauthorized reproduction, modification, redistribution,
 * commercial use, or AI-model training is strictly prohibited
 * without prior written permission from the author.
 *
 * Provided solely for personal study and educational insight.
 */

import javax.swing.*; // JTree, JScrollPane
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*; // List, ArrayList

class FaktorExpected extends Exception{}
class Pocetak extends Exception{}
class ZatvoriZagradu extends Exception{}

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class DisjunktivnaFormaZaLS{
  public static ArrayList koristeneVarijable; 
  public static String formula;
  public static int d;
  public static int i;

  public static void disjunktivnaFormaZaLS() throws FaktorExpected, Pocetak, ZatvoriZagradu{
    koristeneVarijable = new ArrayList(); 
    formula = Calc.display.getText().substring(1);
    d = formula.length();
    if ( d == 0 ) throw new Pocetak();
    i = 0;
    Formula korijenStabla = term();
    
    JTree stabloFormule = new JTree(korijenStabla.prikazFormule());
    for ( int i = 0; i < stabloFormule.getRowCount(); i++){
      stabloFormule.expandRow(i);
    }
    JScrollPane stabloFormuleView = new JScrollPane(stabloFormule);
    
    //Postavljanje stabla u panel
    Calc.stablaPanel.add(stabloFormuleView);
    
    Formula eliminiramNegacije = (Formula) korijenStabla.clone();
    eliminiramNegacije = eliminiramNegacije.eliminiramNegacije();
    JTree stabloGlavnogTesta = new JTree(eliminiramNegacije.prikazFormule());
    for ( int i = 0; i < stabloGlavnogTesta.getRowCount(); i++){
      stabloGlavnogTesta.expandRow(i);
    }
    JScrollPane stabloGlavnogTestaView = new JScrollPane(stabloGlavnogTesta);
    Calc.stablaPanel.add(stabloGlavnogTestaView);
    
    OsvjetljivanjeRjesenja.osvijetliRjesenja( DisjunktivnaFormaZaLS.koristeneVarijable, reducirajNormalnuFormu(((FormulaUNormalnoj) eliminiramNegacije).disjunktivnojFormi()));
		
		System.out.println(((FormulaUNormalnoj) eliminiramNegacije).konjunktivnojFormi());
  }

  public static Formula term() throws FaktorExpected, ZatvoriZagradu{
    Formula prviFaktor = faktor();
    while ((i < d ) && Calc.binarniVeznici.contains(new Character(formula.charAt(i)))) {
      Formula binarniVeznik = new Konjunkcija( null, null); //razmotriti!
      if (i + 1 >= d)  throw new FaktorExpected();
      switch (formula.charAt(i++)){
        case Calc.AND_CHAR:
          binarniVeznik = new Konjunkcija( prviFaktor, faktor());
          break;
        case Calc.OR_CHAR:
          binarniVeznik = new Disjunkcija( prviFaktor, faktor());
          break;
        case Calc.POVLACI_CHAR:
          binarniVeznik = new Disjunkcija( new Negacija(prviFaktor), faktor());
          break;
        case Calc.AKKO_CHAR:
          Formula drugiFaktor = faktor();
          binarniVeznik = new Konjunkcija( new Disjunkcija( new Negacija(prviFaktor), drugiFaktor), 
            new Disjunkcija( (Formula) prviFaktor.clone(), new Negacija((Formula) drugiFaktor.clone())));
          break;
      }
      prviFaktor = binarniVeznik;
    }
    return prviFaktor;
  }
  public static Formula faktor() throws FaktorExpected, ZatvoriZagradu{
    if ((i >= d) || !Calc.propozicVarijable.contains(new Character(formula.charAt(i)))) throw new FaktorExpected();
    Formula izFaktora = new Negacija(null); //razmotriti!
      switch (formula.charAt(i)) {
        case Calc.P_CHAR: case Calc.Q_CHAR: case Calc.R_CHAR:
          if (!koristeneVarijable.contains(new Character(formula.charAt(i)))) koristeneVarijable.add(new Character(formula.charAt(i)));
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
  
  public static List reducirajNormalnuFormu(List forma) {
    boolean ukloniTekuci = false;
    int i = 0;
    while (i < forma.size()){
      ukloniTekuci = false;
      for ( int j = i + 1; j < forma.size(); j++){
        List pKonjukt = (List) forma.get(i);
        List dKonjukt = (List) forma.get(j);
        if (pKonjukt.containsAll(dKonjukt)) {
          forma.remove(i);
          ukloniTekuci = true;
        }
        if (!ukloniTekuci && dKonjukt.containsAll(pKonjukt)) forma.remove(j);
      }
      if (!ukloniTekuci) i++;
    }
    return forma;
  }
}