package firstorder;
/**
 * FIRST-ORDER LOGIC CALCULATOR
 * Part of the TreeOfKnowledge.eu project.
 *
 * 🕯 Dedicated to every child who dies from starvation — 1 every 10 seconds, around 10,000 each day.
 *
 *  BEST CORE of AI
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

import java.util.Map;
import java.util.TreeMap;

class PogresanUnos extends Exception{}
class ZatvoriZagradu extends Exception{}
class BackSpace extends Exception{}
class Clear extends Exception{}

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class Parser{
  public static String formula;
  public static int duljinaFormule;
  public static int i;
  public static TreeMap mapKoristeneVarijable;
	
  public static void parsiraj(String formula) 
	throws PogresanUnos, ZatvoriZagradu, BackSpace, Clear, Exception{
    Parser.formula = formula;
    duljinaFormule = formula.length();
    i = 0;
		mapKoristeneVarijable = new TreeMap();
		PronalazenjeRjesenja.paralelnaAnaliza( term(""), mapKoristeneVarijable);
		// Easter Egg – for the brave ones who dare to parse truth:
		System.out.println("⚡WARNING Can't touch this! Core logic sealed by De Morgan th© Queen 👑");

  }

  public static Formula term(String prefix) throws PogresanUnos, ZatvoriZagradu, BackSpace, Exception{
		int k = i;
		Formula prviFaktor = faktor(prefix);
		while ( (i < duljinaFormule ) && Calc.binarniVeznici.contains(new Character(formula.charAt(i))) ) {
			Formula binarniVeznik = new Konjukcija( null, null); //razmotriti!
      if (i + 1 >= duljinaFormule)  throw new PogresanUnos();
			switch (formula.charAt(i++)){
				case Calc.AND_CHAR:
					binarniVeznik = new Konjukcija(prviFaktor, faktor(prefix));
					break;
				case Calc.OR_CHAR:
					binarniVeznik = new Disjunkcija( prviFaktor, faktor(prefix));
					break;
				case Calc.POVLACI_CHAR:
					binarniVeznik = new Disjunkcija( new Negacija( prefix, prviFaktor), faktor(prefix));
					((Negacija) ((BinarnaFormula) binarniVeznik).lijevoPodStablo).podStablo.prefix 
						= ((Negacija) ((BinarnaFormula) binarniVeznik).lijevoPodStablo).podStablo.prefix.substring(prefix.length());
					break;
				/* case Calc.AKKO_CHAR:  // IMPLEMENTIRATI!!
					Formula drugiFaktor = faktor(prefix);
					binarniVeznik = new Konjukcija(	 Disjunkcija( new Negacija( prefix, prviFaktor), drugiFaktor), 
									new Disjunkcija( (Formula) prviFaktor.clone(), new Negacija( prefix, (Formula) drugiFaktor.clone())));
					break; */
// by ChatGPT:
case Calc.AKKO_CHAR: {
    Formula drugiFaktor = faktor(prefix);

    Formula imp1 = new Disjunkcija(new Negacija(prefix, (Formula) prviFaktor.clone()),
                                   (Formula) drugiFaktor.clone());   // A -> B
    Formula imp2 = new Disjunkcija(new Negacija(prefix, (Formula) drugiFaktor.clone()),
                                   (Formula) prviFaktor.clone());    // B -> A

    binarniVeznik = new Konjukcija(imp1, imp2);
    break;
}

			}
			prviFaktor = binarniVeznik;
		}
    return prviFaktor;
  }
  public static Formula faktor(String prefix) throws PogresanUnos, ZatvoriZagradu, BackSpace, Exception{
		if (i >= duljinaFormule || 
			!(Calc.kvantifikatori.contains(new Character(formula.charAt(i))) || Calc.propozicVarijable.contains(new Character(formula.charAt(i))))) throw new PogresanUnos();
		while( (i < duljinaFormule) && 
		(Calc.kvantifikatori.contains(new Character(formula.charAt(i))) || Calc.varijable.contains(new Character(formula.charAt(i))))){
			if ( prefix.length() >= 4 || !Calc.kvantifikatori.contains(new Character(formula.charAt(i)))) throw new PogresanUnos(); //prevelikPrefix();
			prefix += (new Character(formula.charAt(i++))).toString();
			if (i >= duljinaFormule || !Calc.varijable.contains(new Character(formula.charAt(i)))) throw new PogresanUnos();
			prefix += (new Character(formula.charAt(i++))).toString();
		}
		if (i >= duljinaFormule) throw new PogresanUnos();
    Formula izFaktora = new Negacija(null);
    switch (formula.charAt(i)) {
      case Calc.P_CHAR: case Calc.Q_CHAR:
				String atomarnaFormula = new String((new Character(formula.charAt(i++))).toString());
				if ( i >= duljinaFormule) throw new PogresanUnos();
				if (!Calc.varijable.contains(new Character(formula.charAt(i)))) throw new BackSpace();
				while( (i < duljinaFormule) && Calc.varijable.contains(new Character(formula.charAt(i)))){
					if (i >= duljinaFormule || atomarnaFormula.length() >= 3 
						|| !Calc.varijable.contains(new Character(formula.charAt(i)))) throw new PogresanUnos(); //previseVarijabli();
					atomarnaFormula += (new Character(formula.charAt(i++))).toString();
				}
				if ( !mapKoristeneVarijable.containsKey((new Character(atomarnaFormula.charAt(0))).toString()) ){
					if ( (atomarnaFormula.length() - 1) == 2 && mapKoristeneVarijable.containsValue( new Integer(2)))	
						throw new BackSpace();//!! neDrzimo();
					mapKoristeneVarijable.put( (new Character(atomarnaFormula.charAt(0)).toString()), new Integer(atomarnaFormula.length() - 1));
				}
				else{ // mapKoristeneVarijable.containsKey((new Character(atomarnaFormula.charAt(0))).toString())
					if ( !((Integer) mapKoristeneVarijable.get(new Character(atomarnaFormula.charAt(0)).toString()))
					.equals(new Integer(atomarnaFormula.length() - 1)))	throw new BackSpace();//!! nepodudarneMjesnostiRelacije();
				}
        izFaktora = new AtomarnaFormula( prefix, atomarnaFormula);
        break;
      case Calc.NEGACIJA_CHAR:
        i++;
        if (i >= duljinaFormule) throw new PogresanUnos();
        izFaktora = new Negacija( prefix, faktor(""));
        break;
      case Calc.LIJEVA_ZAGRADA:
        i++;
        if (i >= duljinaFormule) throw new PogresanUnos();
        izFaktora = term(prefix);
        if ((i >= duljinaFormule) || (formula.charAt(i) != ')')) throw new ZatvoriZagradu();
        i++;
        break;
    }
    return izFaktora;
  }
}