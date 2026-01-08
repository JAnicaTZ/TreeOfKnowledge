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

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//java.lang.* se automatski dodaje

// © JAnica Tesla Zrinski – Original Source of Th© CORE of AI
class Calc extends JFrame implements ActionListener {
  public static final char NEGACIJA_CHAR  = '\u00AC';
  public static final char LIJEVA_ZAGRADA = '(';
  public static final char P_CHAR = 'P';
  public static final char Q_CHAR = 'Q';
  public static final char R_CHAR = 'R';
  static ArrayList propozicVarijable = new ArrayList();
  static {
    propozicVarijable.add(new Character(NEGACIJA_CHAR));
    propozicVarijable.add(new Character(LIJEVA_ZAGRADA));
    propozicVarijable.add(new Character(P_CHAR));
    propozicVarijable.add(new Character(Q_CHAR));
    propozicVarijable.add(new Character(R_CHAR));
  }   
  public static final char AND_CHAR     = '\u22C0';
  public static final char OR_CHAR    = '\u22C1';
  public static final char POVLACI_CHAR   = '\u21D2';
  public static final char AKKO_CHAR    = '\u21D4';
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
  static JButton negacija;
  static JButton lijevaZagrada;
  static JButton desnaZagrada;
  static JButton PButton;
  static JButton QButton;
  static JButton RButton;
  static JButton and;
  static JButton or;
  static JButton povlaci;
  static JButton akko;
  static JButton negirajFormulu;
  static JButton enter;
  static int brojNezatvorenihZagrada;
  static JButton[][] matricaUnosa;
  
  static JPanel calculatorPanel;
  static JPanel interpretacijePanel;
  static JPanel stablaPanel;
    
  public Calc(){
    super( "Simple Tree – Propositional Logic Calculator" );
		getContentPane().setLayout(new GridLayout( 1, 2));    
			GridBagLayout calculatorPanelGBLayout = new GridBagLayout();
			calculatorPanel = new JPanel();
			calculatorPanel.setLayout(calculatorPanelGBLayout);
				
				GridBagConstraints gbcDisplayPanel = new GridBagConstraints();
					gbcDisplayPanel.gridwidth = 3;
					gbcDisplayPanel.gridheight = 1;
					gbcDisplayPanel.fill = GridBagConstraints.HORIZONTAL;
					gbcDisplayPanel.weighty = 0.1;
				JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
					displayPanel.setBackground(Color.yellow);
					displayPanel.setBorder(BorderFactory.createLoweredBevelBorder());
						display = new JLabel(" ");
					displayPanel.add(display);
				calculatorPanelGBLayout.setConstraints( displayPanel, gbcDisplayPanel);
			calculatorPanel.add( displayPanel);
	
				GridBagConstraints gbcKeyPanel = new GridBagConstraints();
					gbcKeyPanel.gridx = 0;
					gbcKeyPanel.gridy = 1;
					gbcKeyPanel.gridwidth = 1;
					gbcKeyPanel.gridheight = 1;
					gbcKeyPanel.fill = GridBagConstraints.BOTH;
					gbcKeyPanel.weighty = 0.1;
					JPanel keysPanel = new JPanel(new GridLayout( 5, 3));
					JButton keys = new JButton("KEYS");
						keys.setFont(new Font("Times Roman", Font.BOLD,25));
						keys.setForeground(Color.blue);
				keysPanel.add(keys);
					backSpace = new JButton("BACKSPACE");
						backSpace.setFont(new Font("Times Roman", Font.BOLD, 12));
						backSpace.setForeground(Color.yellow);
						backSpace.addActionListener(this);
				keysPanel.add(backSpace);
					clear = new JButton("CLEAR");
						clear.setFont(new Font("Times Roman", Font.BOLD, 15));
						clear.setForeground(Color.yellow);
						clear.addActionListener(this);
				keysPanel.add(clear);
					negacija = new JButton( new Character(NEGACIJA_CHAR).toString() );
						negacija.addActionListener(this);
				keysPanel.add(negacija);
					lijevaZagrada = new JButton(new Character(LIJEVA_ZAGRADA).toString());
						lijevaZagrada.addActionListener(this);
				keysPanel.add(lijevaZagrada);
					desnaZagrada = new JButton(")");
						desnaZagrada.addActionListener(this);
				keysPanel.add(desnaZagrada);
					PButton = new JButton(new Character(P_CHAR).toString());
						PButton.addActionListener(this);
				keysPanel.add(PButton);
					QButton = new JButton(new Character(Q_CHAR).toString());
						QButton.addActionListener(this);
				keysPanel.add(QButton);
					RButton = new JButton( new Character(R_CHAR).toString() );
						RButton.addActionListener(this);
				keysPanel.add(RButton);
					and = new JButton( new Character(AND_CHAR).toString() );
						and.addActionListener(this);
				keysPanel.add(and);
					or = new JButton( new Character(OR_CHAR).toString() );
						or.addActionListener(this);
				keysPanel.add(or);
					negirajFormulu = new JButton(new Character(NEGACIJA_CHAR).toString() + " ( FORMULA )");
						negirajFormulu.setFont(new Font("Times Roman", Font.BOLD,12));
						negirajFormulu.setForeground(Color.yellow);
						negirajFormulu.addActionListener(this);
				keysPanel.add(negirajFormulu);
					povlaci = new JButton( new Character(POVLACI_CHAR).toString() );
						povlaci.addActionListener(this);
				keysPanel.add(povlaci);
					akko = new JButton( new Character(AKKO_CHAR).toString() );
						akko.addActionListener(this);
				keysPanel.add(akko);
					enter = new JButton( " ENTER" );
						enter.setFont(new Font("Times Roman", Font.BOLD, 20));
						enter.setForeground(Color.yellow);
						enter.setBorder(BorderFactory.createLineBorder( Color.yellow, 2));
						enter.addActionListener(this);
				keysPanel.add(enter);
					calculatorPanelGBLayout.setConstraints( keysPanel, gbcKeyPanel);
			calculatorPanel.add(keysPanel);
		 
				GridBagConstraints gbcInterpretacijePanel = new GridBagConstraints();
					gbcInterpretacijePanel.gridx = 3;
					gbcInterpretacijePanel.gridy = 0;
					gbcInterpretacijePanel.gridwidth = 1;
					gbcInterpretacijePanel.gridheight = 6;
					gbcInterpretacijePanel.fill = GridBagConstraints.BOTH;
				interpretacijePanel = new JPanel(new GridLayout(10,1));
				interpretacijePanel.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
					JButton result = new JButton("RESULT :");
					result.setFont(new Font("Times Roman", Font.BOLD,16));
					result.setForeground(Color.yellow);
					result.setBackground(Color.blue);
				interpretacijePanel.add(result);
				for( int i = 1; i < 10; i++) {
					interpretacijePanel.add( new JButton("") );
				}
				calculatorPanelGBLayout.setConstraints( interpretacijePanel, gbcInterpretacijePanel);
			calculatorPanel.add(interpretacijePanel);
		getContentPane().add(calculatorPanel);
	
      stablaPanel = new JPanel( new GridLayout( 1, 2));
				stablaPanel.add( new JLabel( "FORMULA", JLabel.CENTER));
				stablaPanel.add( new JLabel( "glavni test", JLabel.CENTER));
    getContentPane().add(stablaPanel);
		
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    pack();
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameDim = getSize();
		setLocation( ( (int)screenDim.getWidth() - (int)frameDim.getWidth() ) / 2,
									 ( (int)screenDim.getHeight() - (int)frameDim.getHeight() ) / 2 );
    show();
    brojNezatvorenihZagrada = 0;
    matricaUnosa = new JButton[][] { 
      { null, backSpace, clear},
      { negacija, lijevaZagrada, desnaZagrada},
      { PButton, QButton, RButton},
      { and, or, negirajFormulu},
      { povlaci, akko, enter}};
    osvijetliKorakUnosa("pocetak");
  }//Calc()

  public void actionPerformed( ActionEvent event ) {
    Object action = event.getSource();

    if ( action.equals(enter)) {
			for( int i = 1; i < 10; i++){
				JButton gumb = (JButton) interpretacijePanel.getComponent(i);
				gumb.setText("");
				gumb.setBackground(new Color( 204, 204, 204));
			}
			Calc.stablaPanel.removeAll();
			try {
				DisjunktivnaFormaZaLS.disjunktivnaFormaZaLS();
			}
			catch(FaktorExpected exception){
				osvijetliKorakUnosa("faktor expected");
				//exception.printStackTrace();
			}
			catch(Pocetak exception){
				osvijetliKorakUnosa("pocetak");
			}
			catch(ZatvoriZagradu exception){
				desnaZagrada.setBackground(Color.yellow);         
			}
			finally{
				if ( display.getText().length() > 1 && (DisjunktivnaFormaZaLS.i + 1) < display.getText().length()){
					int i = DisjunktivnaFormaZaLS.i + 1;
					if (( i + 1) < display.getText().length()){
						String smece = display.getText().substring(i);
						for ( int j = 0; j < smece.length(); j++){
							if (smece.charAt(j) == LIJEVA_ZAGRADA) brojNezatvorenihZagrada -= 1;
							if (smece.charAt(j) ==  ')')           brojNezatvorenihZagrada += 1;
						}
					}
					char trik =  display.getText().charAt(i);
					display.setText( display.getText().substring( 0, i) + trik);
					if ( trik == LIJEVA_ZAGRADA) brojNezatvorenihZagrada += 1;
					if ( trik ==  ')')           brojNezatvorenihZagrada -= 1;
					action = backSpace;
				}
				switch ( stablaPanel.getComponentCount()){
					case 0:
						stablaPanel.add( new JLabel( "FORMULA", JLabel.CENTER));
						stablaPanel.add( new JLabel( "glavni test" , JLabel.CENTER));
						break;
					case 1:// mozde se ne moze dogoditi?;  case 2:?
						stablaPanel.add( new JLabel( "glavni test", JLabel.CENTER));
						break;
				}
			}
    }
    if ( action.equals( backSpace)){
      int duljina = display.getText().length();
      if ( duljina == 2){ // display pocinje sa " "
				action = clear;
      }
      if ( duljina > 2) {
				if ( display.getText().charAt( duljina - 1) == LIJEVA_ZAGRADA) brojNezatvorenihZagrada -= 1;
				if ( display.getText().charAt( duljina - 1) == ')')            brojNezatvorenihZagrada += 1;
        switch (display.getText().charAt(duljina - 2)){
          case NEGACIJA_CHAR: action = negacija;
          break;
          case LIJEVA_ZAGRADA:  action = lijevaZagrada; brojNezatvorenihZagrada -= 1;
          break;
          case ')':             action = desnaZagrada;  brojNezatvorenihZagrada += 1;
          break;
          case P_CHAR:          action = PButton;
          break;
          case Q_CHAR:          action = QButton;
          break;
          case R_CHAR:          action = RButton;
          break;
          case AND_CHAR:        action = and;
          break;
          case OR_CHAR:         action = or;
          break;
          case POVLACI_CHAR:    action = povlaci;
          break;
          case AKKO_CHAR:       action = akko;
          break;
        }
        display.setText( display.getText().substring( 0, duljina - 2));
      }
    }
    if ( action.equals(clear)){
      display.setText( " " );
			for( int i = 1; i < 10; i++){
				JButton gumb = (JButton) interpretacijePanel.getComponent(i);
				gumb.setText("");
				gumb.setBackground(new Color( 204, 204, 204));
			}
			stablaPanel.removeAll();
				stablaPanel.add( new JLabel( "FORMULA", JLabel.CENTER));
				stablaPanel.add( new JLabel( "glavni test", JLabel.CENTER));
      brojNezatvorenihZagrada = 0;
      osvijetliKorakUnosa("pocetak");
    }
    if ( action.equals(negirajFormulu) ) {
      display.setText( " " + new Character(NEGACIJA_CHAR).toString() + new Character(LIJEVA_ZAGRADA).toString()
				+ display.getText().substring(1) + new Character(')').toString() );			
		}
    if ( action.equals(negacija) ) {
      display.setText( display.getText() + negacija.getText() );
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(lijevaZagrada) ) {
      display.setText( display.getText() + lijevaZagrada.getText() );
      brojNezatvorenihZagrada += 1;
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(desnaZagrada) ) {
      display.setText( display.getText() + desnaZagrada.getText() );
      brojNezatvorenihZagrada -= 1;
      osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(PButton) ) {
      display.setText( display.getText() + PButton.getText() );
      osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(QButton) ) {
      display.setText( display.getText() + QButton .getText());
      osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(RButton) ) {
      display.setText( display.getText() + RButton.getText() );
      osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(and) ) {
      display.setText( display.getText() + and .getText());
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(or) ) {
      display.setText( display.getText() + or.getText() );
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(povlaci) ) {
      display.setText( display.getText() + povlaci.getText() );
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(akko) ) {
      display.setText( display.getText() + akko.getText() );
      osvijetliKorakUnosa("faktor expected");
    }
  }//actionPerformed  

  public static void main( String args[] ) throws Exception {
    new Calc();
  }
  
  public static void osvijetliKorakUnosa(String ulaznoStanje){
    for( int i = 0; i < Calc.matricaUnosa.length; i++) {
      for( int j = 0; j < Calc.matricaUnosa[0].length; j++) {
        if (Calc.matricaUnosa[i][j] != null)
          Calc.matricaUnosa[i][j].setBackground(Color.LIGHT_GRAY);
      }
    }
    if (ulaznoStanje.equals("pocetak")){
      Calc.matricaUnosa[1][0].setBackground(Color.blue);
      Calc.matricaUnosa[1][1].setBackground(Color.blue);
      Calc.matricaUnosa[2][0].setBackground(Color.blue);
      Calc.matricaUnosa[2][1].setBackground(Color.blue);
      Calc.matricaUnosa[2][2].setBackground(Color.blue);
    }
    if (ulaznoStanje.equals("faktor expected")){ // propozicionalna varijabla, negacija, clear, backspace
      Calc.matricaUnosa[0][1].setBackground(Color.blue);
      Calc.matricaUnosa[0][2].setBackground(Color.blue);
      Calc.matricaUnosa[1][0].setBackground(Color.blue);
      Calc.matricaUnosa[1][1].setBackground(Color.blue);
      Calc.matricaUnosa[2][0].setBackground(Color.blue);
      Calc.matricaUnosa[2][1].setBackground(Color.blue);
      Calc.matricaUnosa[2][2].setBackground(Color.blue);
    }
    if (ulaznoStanje.equals("binarni veznik expected")){ // binarni veznik, desna zagrada ili ENTER
      Calc.matricaUnosa[0][1].setBackground(Color.blue);
      Calc.matricaUnosa[0][2].setBackground(Color.blue);
      if (Calc.brojNezatvorenihZagrada > 0) Calc.matricaUnosa[1][2].setBackground(Color.blue);
      Calc.matricaUnosa[3][0].setBackground(Color.blue);
      Calc.matricaUnosa[3][1].setBackground(Color.blue);
      Calc.matricaUnosa[3][2].setBackground(Color.blue);
      Calc.matricaUnosa[4][0].setBackground(Color.blue);
      Calc.matricaUnosa[4][1].setBackground(Color.blue);
      Calc.matricaUnosa[4][2].setBackground(Color.blue);
    }
  }
}//class
