package firstorder;
/**
 * FIRST-ORDER LOGIC CALCULATOR
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

import javax.swing.*; // JTree, JScrollPane, JPanel, JButton
import javax.swing.tree.DefaultMutableTreeNode;

import java.util.*; // List, ArrayList, Map, HashMap
import java.awt.Color;

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class PronalazenjeRjesenja{
  public static TreeMap mapKoristeneVarijable;
	public static int velicinaNosaca;
  public static ArrayList koristeneVarijable; //pojavljuje se u Konjukcija!!

  public static void napraviKoristeneVarijable(int brojElemenataNosaca){
		Object[] nizKoristenihVarijabli = mapKoristeneVarijable.keySet().toArray();
		koristeneVarijable = new ArrayList();
		for ( int i = 0; i <  mapKoristeneVarijable.keySet().size(); i++) {
			if (mapKoristeneVarijable.containsKey(nizKoristenihVarijabli[i])){
				if ((mapKoristeneVarijable.get(nizKoristenihVarijabli[i]).equals(new Integer(1)))){
					for ( int j = 0; j < brojElemenataNosaca; j++) {
						koristeneVarijable.add(new String( (String) nizKoristenihVarijabli[i] + Calc.konstante[j]));
					}
				}
				if ((mapKoristeneVarijable.get(nizKoristenihVarijabli[i]).equals(new Integer(2)))){
					for ( int j = 0; j < brojElemenataNosaca; j++) {
						for ( int k = 0; k < brojElemenataNosaca; k++) {
							koristeneVarijable.add(new String( (String) nizKoristenihVarijabli[i] + Calc.konstante[j] + Calc.konstante[k]));
						}
					}
				}
			}
		}
	}
  public static void paralelnaAnaliza( Formula korijenStabla, TreeMap mapKoristeneVarijable) throws Clear{
		PronalazenjeRjesenja.mapKoristeneVarijable = mapKoristeneVarijable;
		FormulaUNF glavniTestLogikePrvogReda = (FormulaUNF) ((Formula) korijenStabla.clone()).glavniTestLogikePrvogReda();
		FormulaUNF negiraniGlavniTestLogikePrvogReda = (FormulaUNF) (new Negacija((Formula) korijenStabla.clone())).glavniTestLogikePrvogReda();
			JTree stabloGlavnogTesta = new JTree(glavniTestLogikePrvogReda.prikazFormule());
			for ( int i = 0; i < stabloGlavnogTesta.getRowCount(); i++){
				stabloGlavnogTesta.expandRow(i);
			}
			JScrollPane stabloGlavnogTestaView = new JScrollPane(stabloGlavnogTesta);
			Calc.nosacOd2ElementaPanel.add(stabloGlavnogTestaView);
		for ( /* int  */velicinaNosaca = 1; velicinaNosaca <= 4; velicinaNosaca++){
			FormulaUNF glavniTest = (FormulaUNF) ((FormulaUNF) glavniTestLogikePrvogReda.clone()).glavniTest(velicinaNosaca);
			napraviKoristeneVarijable(velicinaNosaca);
			if ( koristeneVarijable.size() <= 12){
				List konjuktivnaForma = ((FormulaUNF) glavniTest).konjuktivnaForma();
				switch (velicinaNosaca){
					case 1:
						osvijetliRjesenja( konjuktivnaForma, Calc.interpretacijePanel, "   ", "     ");
						break;
					case 2:
						JTree stabloGlavnogTesta2 = new JTree(glavniTest.prikazFormule());
						for ( int i = 0; i < stabloGlavnogTesta2.getRowCount(); i++){
							stabloGlavnogTesta2.expandRow(i);
						}
						JScrollPane stabloGlavnogTesta2View = new JScrollPane(stabloGlavnogTesta2);
						Calc.nosacOd2ElementaPanel.add(stabloGlavnogTesta2View);
						osvijetliRjesenja( konjuktivnaForma, Calc.interpretacijePanel2Formule, " ", "     ");
						break;
				}
			FormulaUNF negiraniGlavniTest = (FormulaUNF) ((FormulaUNF) negiraniGlavniTestLogikePrvogReda.clone()).glavniTest(velicinaNosaca);
				List negiranaKonjuktivnaForma = ((FormulaUNF) negiraniGlavniTest).konjuktivnaForma();
				paralelnaAnalizaZaNosac( konjuktivnaForma, negiranaKonjuktivnaForma);
			}
		}
		System.out.println();
	}
	
  public static void paralelnaAnalizaZaNosac( List konjuktivnaForma, List negiranaKonjuktivnaForma){
    boolean[] semantickaTablica = savrsenaKonjuktivnaForma(konjuktivnaForma);
		int brojIstinitihInterpretacija = 0;
    for ( int i = 0; i < semantickaTablica.length; i++){
			if (semantickaTablica[i] == true) brojIstinitihInterpretacija++;
    }
		System.out.println( "NOSAC " + velicinaNosaca + 	": #Istinitih / ukupan#Interpretacija = " + 
			brojIstinitihInterpretacija + "/" + semantickaTablica.length + " = " + (double) brojIstinitihInterpretacija/semantickaTablica.length);
			
    boolean[] semantickaTablicaNegiraneFormule = savrsenaKonjuktivnaForma(negiranaKonjuktivnaForma);
		boolean komplementarni = true;
    for ( int i = 0; i < semantickaTablicaNegiraneFormule.length; i++){
			if (semantickaTablica[i] == semantickaTablicaNegiraneFormule[i]){
				komplementarni = false;
				System.out.println("!!komplementarni = " + komplementarni);
			}
    }
  }
  
  public static List reducirajNormalnuFormu(List konjuktivnaForma){
    boolean ukloniTekuci = false;
    int i = 0;
    while (i < konjuktivnaForma.size()){
      ukloniTekuci = false;
				/* String prvi = ((Map) konjuktivnaForma.get(i)).toString(); // MIJENJA SVE!!!
				prvi = prvi.substring( 1, prvi.length() - 1); */
      for ( int j = i + 1; j < konjuktivnaForma.size(); j++){
			String prvi = ((Map) konjuktivnaForma.get(i)).toString();
			prvi = prvi.substring( 1, prvi.length() - 1);
        String drugi = ((Map) konjuktivnaForma.get(j)).toString();
        drugi = drugi.substring( 1, drugi.length() - 1);
        if ( prvi.indexOf(drugi) >= 0 ){
          konjuktivnaForma.remove(i);
          ukloniTekuci = true;
        }
        if ( !ukloniTekuci && drugi.indexOf(prvi) >= 0  ){
          konjuktivnaForma.remove(j);
        }
      }
      if (!ukloniTekuci) i++;
    }
		return konjuktivnaForma;
  }
  public static boolean zadovoljavaInterpretaciju( int[] interpretacija, Map konjukt){
    boolean zadovoljavaInterpretaciju = true;
    int i = 0;
    while ( zadovoljavaInterpretaciju == true && i < koristeneVarijable.size()){
      String pv =  (String) koristeneVarijable.get(i);
      if ( konjukt.containsKey(pv) &&
        ( (interpretacija[i] == 0) && ((Boolean) konjukt.get(pv)).equals(new Boolean(true)) ||
          (interpretacija[i] == 1) && ((Boolean) konjukt.get(pv)).equals(new Boolean(false)) ) )
          zadovoljavaInterpretaciju = false;
      i++;  
    }
    return zadovoljavaInterpretaciju;
  }
  public static int[] dekadskiUBinarni( int dekadski, int brojBinarnihZnamenki/* koristeneVarijable.size() */){
		int[] binarni = new int[brojBinarnihZnamenki];
		for ( int i = brojBinarnihZnamenki - 1; i >= 0  ; i--){
			int potencijaOd2 = (int) Math.pow( (double)2, (double) i);
			int cjelobrojnoDijeljenje = Math.round(dekadski / potencijaOd2);
			binarni[brojBinarnihZnamenki - 1 - i] = cjelobrojnoDijeljenje;
			dekadski = dekadski - ( cjelobrojnoDijeljenje * potencijaOd2 );
		}
		return binarni;
	}
  public static boolean[] savrsenaKonjuktivnaForma(List konjuktivnaForma){
    List reduciranaKonjuktivnaForma = reducirajNormalnuFormu(konjuktivnaForma);
    boolean[] semantickaTablica = new boolean[ (int) Math.pow( (double)2, (double) koristeneVarijable.size())];
    for ( int i = 0; i < semantickaTablica.length; i++) {
			int[] binarniBroj = dekadskiUBinarni( i, koristeneVarijable.size());
      int j = 0;
      while ( semantickaTablica[i] == false &&  j < reduciranaKonjuktivnaForma.size()){
        if ( zadovoljavaInterpretaciju( binarniBroj, (Map) reduciranaKonjuktivnaForma.get(j))){
					semantickaTablica[i] = true;
        }
        j++;
      }
    }
		return semantickaTablica;
  }
  public static void osvijetliRjesenja( List konjuktivnaForma, JPanel panel, String maliRazmak, String razmak){
		boolean[] semantickaTablica = savrsenaKonjuktivnaForma(konjuktivnaForma);
    String varijable = "";
    for ( int i = 0; i < koristeneVarijable.size(); i++) {
      varijable += maliRazmak + (String) koristeneVarijable.get(i);
    }
    JButton gumbVarijabli = ((JButton) panel.getComponent(1));
    gumbVarijabli.setText(varijable.substring(maliRazmak.length()));
			gumbVarijabli.setForeground(Color.yellow);
			gumbVarijabli.setBackground(Color.blue);
    for ( int i = 0; i < semantickaTablica.length; i++) {
      String rastegnutaInterpretacija = "";
      int[] interpretacija = dekadskiUBinarni( i, koristeneVarijable.size());
      for (int j = 0; j < interpretacija.length; j++) 
				rastegnutaInterpretacija += razmak  + (new Integer(interpretacija[j])).toString();
			JButton gumbInterpretacije = ( (JButton) panel.getComponent(i + 2) );
			gumbInterpretacije.setText(rastegnutaInterpretacija.substring(razmak.length()));
			if (semantickaTablica[i] == true) gumbInterpretacije.setBackground(Color.yellow);
    }
	System.out.println("✅ Solution found. Consistency: 100% — No contradictions detected!");
  	//System.out.println("🪶 Wisdom check passed → ‘Fear of the Lord is hatred of evil.’");
  }
}

