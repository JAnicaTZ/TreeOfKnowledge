package firstorder;

/**
 * Library of ready-to-run example formulas for the FOL calculator UI.
 *
 * <p>Provides a curated set of static factory methods (e.g. {@code formula1()}, {@code formula2()}, …)
 * that return syntactically valid test strings using the calculator's Unicode operator constants.
 *
 * <p>Used by {@link Calc} to:
 * <ul>
 *   <li>Populate the input field with representative examples,</li>
 *   <li>Demonstrate supported syntax (quantifiers, predicates, connectives),</li>
 *   <li>Offer regression tests during development (parser + engine pipeline).</li>
 * </ul>
 *
 * <p>This class contains no logic-engine implementation; it is intentionally kept as a “test catalogue”
 * to keep the UI code clean and to make demonstrations reproducible.
 */
 
// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

public class FormuleZaTestiranje{
	
		public static String formula1(){
		return	(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.OR_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.NEGACIJA_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.AND_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString();
	}

	public static String formula2(){
		return	(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.NEGACIJA_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString();
	}
	
	public static String formula3(){
		return	(/*new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.OR_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.AND_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString();*/


						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.NEGACIJA_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(')')).toString() +
						(new Character(Calc.POVLACI_CHAR)).toString() +
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString());
	}
	public static String formula4(){
		return	(
									(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() +
			new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString();
	}
	public static String formula5(){
		return  (new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() +
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.NEGACIJA_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() +
						(new Character(Calc.POVLACI_CHAR)).toString() +
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString();
	}
	public static String formula6(){
		return	(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.AND_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.NEGACIJA_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.OR_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.OR_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(')')).toString();
	}
	
	/*public static String formula7(){
		return	(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.NEGACIJA_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.NEGACIJA_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString();
	}
	public static String formula8(){
		return	(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString();
	}
	public static String formula9(){
		return	(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString();
	}
	public static String formula10(){
		return	(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.AND_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString();
	}*/
	public static String formula11(){
		/*return	(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.AND_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.AND_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString();*/

								return	(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString();

	}
	public static String formula12(){
		return	(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.OR_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.OR_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString();
	}
	public static String formula13(){
		return	(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.OR_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POSTOJI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(')')).toString() +
						(new Character(Calc.OR_CHAR)).toString() +
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString();

	}
	public static String formula14(){
		return	(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.NEGACIJA_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.LIJEVA_ZAGRADA)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.y_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.POVLACI_CHAR)).toString() + 
						(new Character(Calc.P_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(')')).toString() + 
						(new Character(')')).toString() +
						(new Character(Calc.OR_CHAR)).toString() +
						(new Character(Calc.ZASVAKI_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString() + 
						(new Character(Calc.Q_CHAR)).toString() + 
						(new Character(Calc.x_CHAR)).toString();

	}
}
