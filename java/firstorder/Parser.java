package firstorder;

/**
 * Parser for the TreeOfKnowledge First-Order Logic input syntax.
 *
 * <p>Converts a compact user input string into an Abstract Syntax Tree (AST) of {@link Formula}
 * objects (atomic predicates, negation, conjunction/disjunction and other supported connectives).
 *
 * <p>Key features of this parser:
 * <ul>
 *   <li>Supports a compact prefix notation for quantifiers (e.g., ∀x∃y...) used by the engine.</li>
 *   <li>Tracks variables that actually occur in the formula (stored in {@code mapKoristeneVarijable}).</li>
 *   <li>Implements a recursive-descent style grammar: factors, unary negation, binary operators.</li>
 *   <li>Builds the internal tree structure used by the normalization and testing pipeline.</li>
 * </ul>
 *
 * <p>The parser is intentionally strict and throws small, domain-specific exceptions
 * (e.g. wrong input / missing bracket / backspace / clear) to keep the UI responsive
 * and to allow immediate error handling without crashing the application.
 */

import java.util.Map;
import java.util.TreeMap;

class PogresanUnos extends Exception{}
class ZatvoriZagradu extends Exception{}
class BackSpace extends Exception{}
class Clear extends Exception{}

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

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