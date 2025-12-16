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

import java.util.*; // List, ArrayList, Map, HashMap
import javax.swing.*; // JButton, JPanel, BorderFactory
import java.awt.Font;
import java.awt.Color;

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class OsvjetljivanjeRjesenja {
  public static List koristeneVarijable;
  public static String[] semantickaTablica;
  public static String razmak = "    ";
  
  public static void osvijetliRjesenja( List koristeneVarijable, List disjunktivnaForma){
    OsvjetljivanjeRjesenja.koristeneVarijable = koristeneVarijable;
    String varijable = "";
    for ( int i = 0; i < koristeneVarijable.size(); i++){
      varijable += razmak + ((Character) koristeneVarijable.get(i)).charValue();
    }
    JButton gumbVarijabli = ((JButton) Calc.interpretacijePanel.getComponent(1));
    gumbVarijabli.setText(varijable.substring(razmak.length()));
    gumbVarijabli.setFont(new Font("Times Roman", Font.BOLD, 15));
    gumbVarijabli.setForeground(Color.yellow);
    gumbVarijabli.setBackground(Color.blue);
		
    crtanjeSemantickeTablice(koristeneVarijable.size());
    for ( int i = 0; i < semantickaTablica.length; i++){
      String rastegnutaInterpretacija = "";
      for ( int j = 0; j < semantickaTablica[i].length(); j++) rastegnutaInterpretacija += razmak + semantickaTablica[i].charAt(j);
      JButton gumbInterpretacije = ((JButton) Calc.interpretacijePanel.getComponent(i + 2));
      gumbInterpretacije.setText(rastegnutaInterpretacija.substring(razmak.length()));
      gumbInterpretacije.setFont(new Font("Times Roman", Font.ITALIC, 15));
      int j = 0;
      while (j < disjunktivnaForma.size()){
        if ( OsvjetljivanjeRjesenja.zadovoljavaInterpretaciju( semantickaTablica[i], (List) disjunktivnaForma.get(j++))) {
          ((JButton) Calc.interpretacijePanel.getComponent(i + 2)).setBackground(Color.yellow);
					break;
        }
      }
    }
  }
  
  public static void crtanjeSemantickeTablice(int brojBinarnihZnamenki){
    semantickaTablica = new String[(int) Math.pow( (double)2, (double) brojBinarnihZnamenki)];
    for ( int i = 0; i < semantickaTablica.length; i++) {
      semantickaTablica[i] = "";
      int k = i;
      for ( int j = brojBinarnihZnamenki - 1; j >= 0; j--) {
        int potencijaOd2 = (int) Math.pow( (double)2, (double) j);
        int cjelobrojnoDijeljenje = Math.round(k / potencijaOd2);
        semantickaTablica[i] += new Integer(cjelobrojnoDijeljenje).toString();
        k = k - ( cjelobrojnoDijeljenje * potencijaOd2 );
      }
    }
  }
  public static boolean zadovoljavaInterpretaciju( String nuleJedinice, List konjukt){
    int i = 0;
    while (i < koristeneVarijable.size()) {
			AtomarnaFormula a = new AtomarnaFormula(((Character) koristeneVarijable.get(i)).charValue());
      if ((nuleJedinice.charAt(i) == '0') && konjukt.contains(a) ||
        (nuleJedinice.charAt(i++) == '1') && konjukt.contains(a.suprotnaFormula())) return false;
    }
    return true;
  }
}
