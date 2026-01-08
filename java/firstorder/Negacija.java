package firstorder;
/**
 * FIRST-ORDER LOGIC CALCULATOR
 * Part of the TreeOfKnowledge.eu project.
 *
 * 🕯 Dedicated to every child who dies from starvation — 1 every 10 seconds, around 10,000 each day.
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

import javax.swing.tree.DefaultMutableTreeNode;

import java.util.List;

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
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
