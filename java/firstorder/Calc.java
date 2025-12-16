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

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//java.lang.* se automatski dodaje

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
public class Calc extends JFrame implements ActionListener {
  public static String razmak = "                      ";
  public static final char ZASVAKI_CHAR = '\u2200';
  static JButton zaSvaki;
  public static final char POSTOJI_CHAR = '\u2203';
  static JButton postoji;
  static ArrayList kvantifikatori = new ArrayList();
  static {
    kvantifikatori.add(new Character(ZASVAKI_CHAR));
    kvantifikatori.add(new Character(POSTOJI_CHAR));
  }
  public static final char x_CHAR = 'x';
  static JButton xButton;
  public static final char y_CHAR = 'y';
  static JButton yButton;
  static ArrayList varijable = new ArrayList();
  static {
    varijable.add(new Character(x_CHAR));
    varijable.add(new Character(y_CHAR));
  }
  static String[] konstante = new String[] { "a", "b", "c", "d"};
	
  public static final char NEGACIJA_CHAR  = '\u00AC';
  static JButton negacija;
  public static final char LIJEVA_ZAGRADA = '(';
  static JButton lijevaZagrada;
  public static final char P_CHAR = 'P';
  static JButton PButton;
  public static final char Q_CHAR = 'Q';
  static JButton QButton;
  static ArrayList propozicVarijable = new ArrayList();
  static {
    propozicVarijable.add(new Character(NEGACIJA_CHAR)); // ostatak od osvijetliKorakUnosa()
    propozicVarijable.add(new Character(LIJEVA_ZAGRADA)); // & za slucaj greske FaktorExpected
    propozicVarijable.add(new Character(P_CHAR));
    propozicVarijable.add(new Character(Q_CHAR));
  }   
  public static final char AND_CHAR     = '\u22C0';
  static JButton and;
  public static final char OR_CHAR      = '\u22C1';
  static JButton or;
  public static final char POVLACI_CHAR = '\u21D2';
  static JButton povlaci;
  public static final char AKKO_CHAR    = '\u21D4';
  static JButton akko;
  static ArrayList binarniVeznici = new ArrayList();
  static {
    binarniVeznici.add(new Character(AND_CHAR));
    binarniVeznici.add(new Character(OR_CHAR));
    binarniVeznici.add(new Character(POVLACI_CHAR));
    binarniVeznici.add(new Character(AKKO_CHAR));
  }
  static JLabel display;
  static JButton backSpace;
  static JButton clear;
  static JButton desnaZagrada;
  static JButton enter;
	
  static JButton negirajFormulu;
  static JButton formula1;
  static JButton formula2;
  static JButton formula3;
  static JButton formula4;
  static JButton formula5;
  static JButton formula6;
  static JButton formula7;
  static JButton formula8;
  static JButton formula9;
  static JButton formula10;
  static JButton formula11;
  static JButton formula12;
  static JButton formula13;
  static JButton formula14;
  static JButton formula15;

	static JPanel glavniPanel; // lijeviPanel
	static JPanel calculatorPanel;
	static JPanel keysPanel;
	static JPanel testFormulePanel;
  static JPanel interpretacijePanel;
  static JPanel nosacOd2ElementaPanel;// desniPanel
  static JPanel interpretacijePanel2Formule;
  static JPanel interpretacijePanel2NegiraneFormule;
    
  public Calc(){
    super( "Kalkulator za LOGIKU Prvog Reda" );
		getContentPane().setLayout(new GridLayout( 1, 2));
    glavniPanel = new JPanel(new GridLayout( 2, 1));
			calculatorPanel = new JPanel(new BorderLayout());
        calculatorPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
				JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
					displayPanel.setFont(new Font( "Bold", Font.BOLD, 10));
					displayPanel.setBackground(Color.yellow);
					displayPanel.setBorder(BorderFactory.createLoweredBevelBorder());
						display = new JLabel(" ");
						display.setFont(new Font( "Times Roman", Font.BOLD, 16));
					displayPanel.add(display);
			calculatorPanel.add( displayPanel, BorderLayout.NORTH);
				
				JPanel keysPanel = new JPanel(new GridLayout( 6, 3));
					negacija = new JButton( new Character(NEGACIJA_CHAR).toString() );
						negacija.addActionListener(this);
				keysPanel.add(negacija);
					lijevaZagrada = new JButton(new Character(LIJEVA_ZAGRADA).toString());
						lijevaZagrada.addActionListener(this);
				keysPanel.add(lijevaZagrada);
					desnaZagrada = new JButton(")");
						desnaZagrada.addActionListener(this);
				keysPanel.add(desnaZagrada);
					zaSvaki = new JButton( new Character(ZASVAKI_CHAR).toString() );
						zaSvaki.addActionListener(this);
				keysPanel.add(zaSvaki);
					postoji = new JButton( new Character(POSTOJI_CHAR).toString() );
						postoji.addActionListener(this);
				keysPanel.add(postoji);
					JLabel keys = new JLabel("KEYs", JLabel.CENTER);
						keys.setFont(new Font("Times Roman", Font.BOLD, 30));
						keys.setForeground(Color.yellow);
				keysPanel.add(keys);
					xButton = new JButton( new Character(x_CHAR).toString() );
						xButton.addActionListener(this);
				keysPanel.add(xButton);
					yButton = new JButton( new Character(y_CHAR).toString() );
						yButton.addActionListener(this);
				keysPanel.add(yButton);
					clear = new JButton("CLEAR");
						clear.setFont(new Font("Times Roman", Font.BOLD, 18));
						clear.setForeground(Color.blue);
						clear.addActionListener(this);
				keysPanel.add(clear);
					PButton = new JButton(new Character(P_CHAR).toString());
						PButton.addActionListener(this);
				keysPanel.add(PButton);
					QButton = new JButton(new Character(Q_CHAR).toString());
						QButton.addActionListener(this);
				keysPanel.add(QButton);
					backSpace = new JButton("backSpace");
						backSpace.setFont(new Font("Times Roman", Font.BOLD, 12));
						backSpace.setForeground(Color.blue);
						backSpace.addActionListener(this);
				keysPanel.add(backSpace);
					and = new JButton( new Character(AND_CHAR).toString() );
						and.addActionListener(this);
				keysPanel.add(and);
					or = new JButton( new Character(OR_CHAR).toString() );
						or.addActionListener(this);
				keysPanel.add(or);
					negirajFormulu = new JButton(new Character(NEGACIJA_CHAR).toString() + "(formula)");
						negirajFormulu.setFont(new Font("Times Roman", Font.BOLD, 12));
						negirajFormulu.setForeground(Color.blue);
						negirajFormulu.addActionListener(this);
				keysPanel.add(negirajFormulu);
					povlaci = new JButton( new Character(POVLACI_CHAR).toString() );
						povlaci.addActionListener(this);
				keysPanel.add(povlaci);
					akko = new JButton( " "/* new Character(AKKO_CHAR).toString() */ );
						//akko.addActionListener( this );
				keysPanel.add(akko);
					enter = new JButton( "ENTER" );
					//enter.setBorder(BorderFactory.createLineBorder( Color.blue, 5));
						enter.setFont(new Font( "Times Roman", Font.BOLD, 27));
						enter.setForeground(Color.blue);
						enter.setBackground(Color.yellow);
						enter.addActionListener(this);
				keysPanel.add(enter);
			calculatorPanel.add( keysPanel, BorderLayout.CENTER);
		glavniPanel.add(calculatorPanel);
		
			GridBagLayout testFormulePanelGBLayout = new GridBagLayout();
      testFormulePanel = new JPanel();
      testFormulePanel.setLayout(testFormulePanelGBLayout);
			
				GridBagConstraints gbcTestFormule = new GridBagConstraints();
					gbcTestFormule.gridx = 0;
					gbcTestFormule.gridy = 0;
					gbcTestFormule.gridwidth = 3;
					gbcTestFormule.gridheight = 1;
					gbcTestFormule.fill = GridBagConstraints.BOTH;
					gbcTestFormule.weightx = 0.1;
					gbcTestFormule.weighty = 0.5;
				JLabel testFormule = new JLabel( "PRIMJERI  formula  logike  Prvog  Reda :  ", JLabel.CENTER);
					testFormule.setFont(new Font("Times Roman", Font.BOLD, 18));
				testFormulePanelGBLayout.setConstraints( testFormule, gbcTestFormule);
			testFormulePanel.add(testFormule);
			
				GridBagConstraints gbcOboriveFormule = new GridBagConstraints();
					gbcOboriveFormule.gridx = 0;
					gbcOboriveFormule.gridy = 1;
					gbcOboriveFormule.gridwidth = 3;
					gbcOboriveFormule.gridheight = 1;
					gbcOboriveFormule.fill = GridBagConstraints.BOTH;
					gbcOboriveFormule.weightx = 0.1;
					gbcOboriveFormule.weighty = 0.1;
				JLabel oboriveFormule = new JLabel( " ISPUNJIVE / OBORIVE  formule :    ", JLabel.CENTER);
					oboriveFormule.setFont(new Font("Times Roman", Font.BOLD, 15));
				testFormulePanelGBLayout.setConstraints( oboriveFormule, gbcOboriveFormule);
			testFormulePanel.add(oboriveFormule);
			
				GridBagConstraints gbcFormula1 = new GridBagConstraints();
					gbcFormula1.gridx = 0;
					gbcFormula1.gridy = 2;
					gbcFormula1.gridwidth = 1;
					gbcFormula1.gridheight = 1;
					gbcFormula1.fill = GridBagConstraints.BOTH;
					gbcFormula1.weightx = 0.1;
					gbcFormula1.weighty = 0.1;
				formula1 = new JButton("1 - oboriva form.");
					formula1.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula1, gbcFormula1);
			testFormulePanel.add(formula1);
			
				GridBagConstraints gbcFormula2 = new GridBagConstraints();
					gbcFormula2.gridx = 1;
					gbcFormula2.gridy = 2;
					gbcFormula2.gridwidth = 1;
					gbcFormula2.gridheight = 1;
					gbcFormula2.fill = GridBagConstraints.BOTH;
					gbcFormula2.weightx = 0.1;
				formula2 = new JButton("2 - oboriva form.");
					formula2.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula2, gbcFormula2);
			testFormulePanel.add(formula2);
			
				GridBagConstraints gbcFormula3 = new GridBagConstraints();
					gbcFormula3.gridx = 2;
					gbcFormula3.gridy = 2;
					gbcFormula3.gridwidth = 1;
					gbcFormula3.gridheight = 1;
					gbcFormula3.fill = GridBagConstraints.BOTH;
					gbcFormula3.weightx = 0.1;
				formula3 = new JButton("3 - oboriva form.");
					formula3.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula3, gbcFormula3);
			testFormulePanel.add(formula3);
			
				GridBagConstraints gbcFormula4 = new GridBagConstraints();
					gbcFormula4.gridx = 0;
					gbcFormula4.gridy = 3;
					gbcFormula4.gridwidth = 1;
					gbcFormula4.gridheight = 1;
					gbcFormula4.fill = GridBagConstraints.BOTH;
					gbcFormula4.weighty = 0.1;
				formula4 = new JButton("4 - oboriva form.");
					formula4.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula4, gbcFormula4);
			testFormulePanel.add(formula4);
			
				GridBagConstraints gbcFormula5 = new GridBagConstraints();
					gbcFormula5.gridx = 1;
					gbcFormula5.gridy = 3;
					gbcFormula5.gridwidth = 1;
					gbcFormula5.gridheight = 1;
					gbcFormula5.fill = GridBagConstraints.BOTH;
				formula5 = new JButton("5 - oboriva form.");
					formula5.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula5, gbcFormula5);
			testFormulePanel.add(formula5);
			
				GridBagConstraints gbcFormula6 = new GridBagConstraints();
					gbcFormula6.gridx = 2;
					gbcFormula6.gridy = 3;
					gbcFormula6.gridwidth = 1;
					gbcFormula6.gridheight = 1;
					gbcFormula6.fill = GridBagConstraints.BOTH;
				formula6 = new JButton("6 - oboriva form.");
					formula6.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula6, gbcFormula6);
			testFormulePanel.add(formula6);
			
				GridBagConstraints gbcTautologije = new GridBagConstraints();
					gbcTautologije.gridx = 0;
					gbcTautologije.gridy = 4;
					gbcTautologije.gridwidth = 3;
					gbcTautologije.gridheight = 1;
					gbcTautologije.fill = GridBagConstraints.BOTH;
					gbcTautologije.weightx = 0.1;
					gbcTautologije.weighty = 0.1;
				JLabel tautologije = new JLabel( " TAUTOLOGIJE / VALJANE  formule :    ", JLabel.CENTER);
					tautologije.setFont(new Font("Times Roman", Font.BOLD, 15));
				testFormulePanelGBLayout.setConstraints( tautologije, gbcTautologije);
			testFormulePanel.add(tautologije);
			
				GridBagConstraints gbcFormula7 = new GridBagConstraints();
					gbcFormula7.gridx = 0;
					gbcFormula7.gridy = 5;
					gbcFormula7.gridwidth = 1;
					gbcFormula7.gridheight = 1;
					gbcFormula7.fill = GridBagConstraints.BOTH;
					gbcFormula7.weighty = 0.1;
				formula7 = new JButton("7 - tautologija");
					formula7.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula7, gbcFormula7);
			testFormulePanel.add(formula7);
			
				GridBagConstraints gbcFormula8 = new GridBagConstraints();
					gbcFormula8.gridx = 1;
					gbcFormula8.gridy = 5;
					gbcFormula8.gridwidth = 1;
					gbcFormula8.gridheight = 1;
					gbcFormula8.fill = GridBagConstraints.BOTH;
				formula8 = new JButton("8 - tautologija");
					formula8.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula8, gbcFormula8);
			testFormulePanel.add(formula8);
			
				GridBagConstraints gbcFormula9 = new GridBagConstraints();
					gbcFormula9.gridx = 2;
					gbcFormula9.gridy = 5;
					gbcFormula9.gridwidth = 1;
					gbcFormula9.gridheight = 1;
					gbcFormula9.fill = GridBagConstraints.BOTH;
				formula9 = new JButton("9 - tautologija");
					formula9.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula9, gbcFormula9);
			testFormulePanel.add(formula9);
			
				GridBagConstraints gbcFormula10 = new GridBagConstraints();
					gbcFormula10.gridx = 3;
					gbcFormula10.gridy = 5;
					gbcFormula10.gridwidth = 1;
					gbcFormula10.gridheight = 1;
					gbcFormula10.fill = GridBagConstraints.BOTH;
				formula10 = new JButton("10 - tautologija");
					formula10.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula10, gbcFormula10);
			testFormulePanel.add(formula10);
			
				GridBagConstraints gbcFormula11 = new GridBagConstraints();
					gbcFormula11.gridx = 0;
					gbcFormula11.gridy = 6;
					gbcFormula11.gridwidth = 1;
					gbcFormula11.gridheight = 1;
					gbcFormula11.fill = GridBagConstraints.BOTH;
					gbcFormula11.weighty = 0.1;
				formula11 = new JButton("11 - tautologija");
					formula11.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula11, gbcFormula11);
			testFormulePanel.add(formula11);
			
				GridBagConstraints gbcFormula12 = new GridBagConstraints();
					gbcFormula12.gridx = 1;
					gbcFormula12.gridy = 6;
					gbcFormula12.gridwidth = 1;
					gbcFormula12.gridheight = 1;
					gbcFormula12.fill = GridBagConstraints.BOTH;
				formula12 = new JButton("12 - tautologija");
					formula12.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula12, gbcFormula12);
			testFormulePanel.add(formula12);
			
				GridBagConstraints gbcFormula13 = new GridBagConstraints();
					gbcFormula13.gridx = 2;
					gbcFormula13.gridy = 6;
					gbcFormula13.gridwidth = 1;
					gbcFormula13.gridheight = 1;
					gbcFormula13.fill = GridBagConstraints.BOTH;
				formula13 = new JButton("13 - tautologija");
					formula13.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula13, gbcFormula13);
			testFormulePanel.add(formula13);
			
				GridBagConstraints gbcFormula14 = new GridBagConstraints();
					gbcFormula14.gridx = 3;
					gbcFormula14.gridy = 6;
					gbcFormula14.gridwidth = 1;
					gbcFormula14.gridheight = 1;
					gbcFormula14.fill = GridBagConstraints.BOTH;
				formula14 = new JButton("14 - tautologija");
					formula14.addActionListener(this);
				testFormulePanelGBLayout.setConstraints( formula14, gbcFormula14);
			testFormulePanel.add(formula14);
			
				GridBagConstraints gbcInterpretacijePanel = new GridBagConstraints();
					gbcInterpretacijePanel.gridx = 3;
					gbcInterpretacijePanel.gridy = 1;
					gbcInterpretacijePanel.gridwidth = 1;
					gbcInterpretacijePanel.gridheight = 3;
					gbcInterpretacijePanel.fill = GridBagConstraints.BOTH;
					gbcInterpretacijePanel.weightx = 0.2;
					gbcInterpretacijePanel.weighty = 0.1;
        interpretacijePanel = new JPanel(new GridLayout(6,1));
        interpretacijePanel.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
          JButton result = new JButton("RESULT : ");
          result.setFont(new Font( "Italic", Font.BOLD, 15));
        interpretacijePanel.add(result);
        for( int i = 0; i < 5; i++) {
					JButton gumb = new JButton("");
          	gumb.setFont(new Font( "Italic", Font.BOLD, 15));
        interpretacijePanel.add(gumb);
        }
				testFormulePanelGBLayout.setConstraints( interpretacijePanel, gbcInterpretacijePanel);
      testFormulePanel.add(interpretacijePanel);
    glavniPanel.add(testFormulePanel);
		
    getContentPane().add(glavniPanel);
		
    	nosacOd2ElementaPanel = new JPanel(new GridLayout( 1, 4));
        interpretacijePanel2Formule = new JPanel(new GridLayout(66,1));
        	interpretacijePanel2Formule.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
          JButton x = new JButton("REZULTAT za NOSAC OD 2 elem.");
          	x.setFont(new Font( "Italic", Font.BOLD, 8));
        interpretacijePanel2Formule.add(x);
        for( int i = 0; i < 65; i++) {
					JButton gumb = new JButton("");
          	gumb.setFont(new Font( "Italic", Font.BOLD, 9));
        interpretacijePanel2Formule.add(gumb);
        }
			nosacOd2ElementaPanel.add(interpretacijePanel2Formule);
			nosacOd2ElementaPanel.add(new JButton("glavni test"));
			nosacOd2ElementaPanel.add(new JButton("za  NOSAC OD 2 elem."));
			
    getContentPane().add( nosacOd2ElementaPanel);
		
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    pack();
		setSize( 1020, 690);
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameDim = getSize();
		setLocation( ( (int)screenDim.getWidth() - (int)frameDim.getWidth() ) / 2,
									 ( (int)screenDim.getHeight() - (int)frameDim.getHeight() ) / 2 );
    show();
  }//Calc()

  public void actionPerformed(ActionEvent event) {
		Object action = event.getSource();
		desnaZagrada.setBackground(new Color( 204, 204, 204));
		if ( action.equals(clear)){
			for( int i = 0; i < 5; i++){
				JButton gumb = (JButton) interpretacijePanel.getComponent(i + 1);
				gumb.setText("");
				gumb.setBackground(new Color( 204, 204, 204));
			}
			for( int i = 0; i < 65; i++){
				JButton gumb = (JButton) interpretacijePanel2Formule.getComponent(i + 1);
				gumb.setText(razmak);
				gumb.setBackground(new Color( 204, 204, 204));
			}
			if (nosacOd2ElementaPanel.getComponentCount() > 2) nosacOd2ElementaPanel.remove(2);
			if (nosacOd2ElementaPanel.getComponentCount() > 1) nosacOd2ElementaPanel.remove(1);
			nosacOd2ElementaPanel.add(new JButton("glavni test"));
			nosacOd2ElementaPanel.add(new JButton("za  NOSAC OD 2 elem."));
			display.setText(" ");
		}
		if ( action.equals(backSpace)){
			int duljina = display.getText().length();
			if (duljina >= 2){ // display pocinje sa " "
				display.setText( display.getText().substring( 0, duljina - 1));
			}
		}
			if ( action.equals(negacija)){
				display.setText( display.getText() + negacija.getText() );
			}
			if ( action.equals(zaSvaki)){
				display.setText( display.getText() + zaSvaki.getText() ); // ovo se moze rijesiti bez getText()!
			}
			if ( action.equals(postoji)){
				display.setText( display.getText() + postoji.getText() );
			}
			if ( action.equals(xButton)){
				display.setText( display.getText() + xButton.getText() );
			}
			if ( action.equals(yButton)){
				display.setText( display.getText() + yButton.getText() );
			}
			if ( action.equals(lijevaZagrada)){
				display.setText( display.getText() + lijevaZagrada.getText() );
			}
			if ( action.equals(desnaZagrada)){
				display.setText( display.getText() + desnaZagrada.getText() );
			}
			if ( action.equals(PButton)){
				display.setText( display.getText() + PButton.getText() );
			}
			if ( action.equals(QButton)){
				display.setText( display.getText() + QButton .getText());
			}
			if ( action.equals(and)){
				display.setText( display.getText() + and .getText());
			}
			if ( action.equals(or)){
				display.setText( display.getText() + or.getText() );
			}
			if ( action.equals(povlaci)){
				display.setText( display.getText() + povlaci.getText() );
			}
			if ( action.equals(akko)){
				display.setText( display.getText() + akko.getText() );
			}
			if ( action.equals(negirajFormulu)){
				display.setText( " " + new Character(NEGACIJA_CHAR).toString() + new Character(LIJEVA_ZAGRADA).toString()
					+ display.getText().substring(1) + new Character(')').toString() );			
			}
		if ( action.equals(enter)){
			for( int i = 0; i < 5; i++){
				JButton gumb = (JButton) interpretacijePanel.getComponent(i + 1);
				gumb.setText("");
				gumb.setBackground(new Color( 204, 204, 204));
			}
			for( int i = 0; i < 65; i++){
				JButton gumb = (JButton) interpretacijePanel2Formule.getComponent(i + 1);
				gumb.setText(razmak);
				gumb.setBackground(new Color( 204, 204, 204));
			}
			if ( display.getText().length() > 1){
				if (Calc.nosacOd2ElementaPanel.getComponentCount() > 2) Calc.nosacOd2ElementaPanel.remove(2);
				if (Calc.nosacOd2ElementaPanel.getComponentCount() > 1) Calc.nosacOd2ElementaPanel.remove(1);
				try{
					//GlavniTest.glavniTest( display.getText().substring(1));
					Parser.parsiraj(display.getText().substring(1));
				}
				catch(PogresanUnos exception){
					//exception.printStackTrace();
				}
				catch(ZatvoriZagradu exception){
					desnaZagrada.setBackground(Color.yellow);         
					//exception.printStackTrace();
				}
				catch(BackSpace exception){
					Parser.i--;
					//exception.printStackTrace();
				}
				catch(Clear exception){
					display.setText(" ");
					//exception.printStackTrace();
				}
				catch(Exception exception){
					//System.err.println("Greska pri pozivanju GlavniTest.glavniTest(): ");
					//exception.printStackTrace();
				}
				finally{
					if (Calc.nosacOd2ElementaPanel.getComponentCount() <= 1){
						nosacOd2ElementaPanel.add(new JButton("glavni test"));
						nosacOd2ElementaPanel.add(new JButton("za  NOSAC OD 2 elem."));
					}
					// prouci ovo dole da naucis nesto o prioritetu operatora!!
					if ( display.getText().length() > 1 && Parser.i < Parser.duljinaFormule) display.setText(" " + Parser.formula.substring(0, Parser.i));
				}
			}
		}
    if ( action.equals(formula1)){
      display.setText( " " + FormuleZaTestiranje.formula1());
    }
    if ( action.equals(formula2)){
      display.setText( " " + FormuleZaTestiranje.formula2());
    }
    if ( action.equals(formula3)){
      display.setText( " " + FormuleZaTestiranje.formula3());
    }
    if ( action.equals(formula4)){
      display.setText( " " + FormuleZaTestiranje.formula4());
    }
    if ( action.equals(formula5)){
      display.setText( " " + FormuleZaTestiranje.formula5());
    }
    if ( action.equals(formula6)){
      display.setText( " " + FormuleZaTestiranje.formula6());
    }
    if ( action.equals(formula7)){
      display.setText( " " + FormuleZaTestiranje.formula7());
    }
    if ( action.equals(formula8)){
      display.setText( " " + FormuleZaTestiranje.formula8());
    }
    if ( action.equals(formula9)){
      display.setText( " " + FormuleZaTestiranje.formula9());
    }
    if ( action.equals(formula10)){
      display.setText( " " + FormuleZaTestiranje.formula10());
    }
    if ( action.equals(formula11)){
      display.setText( " " + FormuleZaTestiranje.formula11());
    }
    if ( action.equals(formula12)){
      display.setText( " " + FormuleZaTestiranje.formula12());
    }
    if ( action.equals(formula13)){
      display.setText( " " + FormuleZaTestiranje.formula13());
    }
    if ( action.equals(formula14)){
      display.setText( " " + FormuleZaTestiranje.formula14());
    }
  }//actionPerformed  

  public static void main(String args[]) throws Exception{
    System.out.println("TreeOfKnowledge.eu → Th© BEST CORE of AI © 2002–2025");
    System.out.println("Initializing pure logic... please stand by 🧠💫");
   //--------------------------------------------------------------
// 1. Opening line — TEST ALL THINGS
//--------------------------------------------------------------
System.out.println("⚖️TEST ALL THINGS AND KEEP WHAT IS GOOD.🏆 ~1. Thessalonians 5:21");

new Calc();

//--------------------------------------------------------------
// 2. Closing line — HUMILITY WARNING
//--------------------------------------------------------------
System.out.println("⚠️WARNING: Do NOT be wise in your OWN eyes: fear the Lord and shun evil. ~Proverbs 3:7"); 
// -------------------------------------------------------------------
// HOMEWORK (for reflection only)
// Is there any logical contradiction between:
// 1. the concept of (∞)ETERNAL(+∞) damnation, and
// 2. the belief that God is the purest possible Love?
// Hint: Think in terms of consistency, not theology.
// -------------------------------------------------------------------
  }
}
