package firstorder;

/**
 * Negation node (NOT, ¬) in the FOL formula tree.
 *
 * <p>This class is a key transformation step in the engine:
 * it pushes negation inward and normalizes the formula structure. In particular, it supports:
 * <ul>
 *   <li>Double-negation elimination (¬¬A → A),</li>
 *   <li>De Morgan transformations (¬(A ∧ B) → (¬A ∨ ¬B), ¬(A ∨ B) → (¬A ∧ ¬B)),</li>
 *   <li>Quantifier flipping under negation by transforming the quantifier prefix
 *       (∀ ↔ ∃) via {@link #suprotanPrefix(String)}.</li>
 * </ul>
 *
 * <p>The engine encodes quantifiers in a compact “prefix” string (e.g., ∀x∃y...), and negation
 * updates this prefix so that the normalized formula remains semantically equivalent.
 */

import javax.swing.tree.DefaultMutableTreeNode;

import java.util.List;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

public class Negacija extends Formula{
  Formula podStablo;
    
  public String toString(){
    return prefix + " " + (new Character(Calc.NEGACIJA_CHAR)).toString();
  }
  public DefaultMutableTreeNode prikazFormule(){
    DefaultMutableTreeNode cvorStabla = new DefaultMutableTreeNode(this);
    cvorStabla.add(podStablo.prikazFormule());
    return cvorStabla;
  }

  public Negacija(Formula podStablo){
		this.prefix = new String();
    this.podStablo = podStablo;
  } 
  public Negacija(String prefix, Formula podStablo){
		this.prefix = prefix;
    this.podStablo = podStablo;
  } 

  public Object clone(){
    Object klon = super.clone();
    ((Negacija) klon).podStablo = (Formula) podStablo.clone();
    return klon;
  }
	public Formula glavniTestLogikePrvogReda() throws Clear{
		if (podStablo instanceof AtomarnaFormula){
			podStablo.prefix = prefix + suprotanPrefix(podStablo.prefix);
			((AtomarnaFormula) podStablo).istinitost = !((AtomarnaFormula) podStablo).istinitost;
		}
		if (podStablo instanceof Negacija){
			((Negacija) podStablo).podStablo.prefix += prefix + suprotanPrefix(((Negacija) podStablo).prefix);
			return ((Negacija) podStablo).podStablo.glavniTestLogikePrvogReda();
		}
		if (podStablo instanceof Konjukcija){ //de Morgan() - !! Konjukcija & Disjunkcija imaju prefix?!
			BinarnaFormula podStablo = (BinarnaFormula) this.podStablo;
			podStablo = new Disjunkcija( new Negacija( prefix + suprotanPrefix(podStablo.prefix), podStablo.lijevoPodStablo), 
																	 new Negacija( prefix + suprotanPrefix(podStablo.prefix), podStablo.desnoPodStablo));
			return podStablo.glavniTestLogikePrvogReda();
		}
		if (podStablo instanceof Disjunkcija){ //de Morgan()
			BinarnaFormula podStablo = (BinarnaFormula) this.podStablo;
			podStablo = new Konjukcija(	new Negacija( prefix + suprotanPrefix(podStablo.prefix), podStablo.lijevoPodStablo), 
																	new Negacija( prefix + suprotanPrefix(podStablo.prefix), podStablo.desnoPodStablo));
			return podStablo.glavniTestLogikePrvogReda();
		}
		return podStablo.glavniTestLogikePrvogReda();
	}
	public static String suprotanPrefix(String prefix){
		String suprotanPrefix = new String();
		for ( int i = 0; i < prefix.length(); i++) {
			suprotanPrefix += ( prefix.charAt(i) == Calc.ZASVAKI_CHAR) ? Calc.POSTOJI_CHAR : Calc.ZASVAKI_CHAR;
			suprotanPrefix +=  prefix.charAt(++i);
		}
		return suprotanPrefix;
	}
}
