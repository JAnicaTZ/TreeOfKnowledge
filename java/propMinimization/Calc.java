package propMinimization;
/**
 * PROPOSITIONAL LOGIC – MINIMIZATION CALCULATOR
 * Minimal Normal Forms & Prime Implicants
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
* 🕯 Dedicated to every unborn child lost to abortion — an estimated ~200 000 each day worldwide. (Based on WHO global estimates of ~73 million abortions per year.)
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
  public static final char P_CHAR = 'A';
  public static final char Q_CHAR = 'B';
  public static final char R_CHAR = 'C';
  public static final char S_CHAR = 'D';
  static ArrayList propozicVarijable = new ArrayList();
  static {
    propozicVarijable.add(new Character(NEGACIJA_CHAR));
    propozicVarijable.add(new Character(LIJEVA_ZAGRADA));
    propozicVarijable.add(new Character(P_CHAR));
    propozicVarijable.add(new Character(Q_CHAR));
    propozicVarijable.add(new Character(R_CHAR));
    propozicVarijable.add(new Character(S_CHAR));
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
  static String formulaLS;
  static JButton backSpace;
  static JButton clear;
  static JButton negacija;
  static JButton lijevaZagrada;
  static JButton desnaZagrada;
  static JButton PButton;
  static JButton QButton;
  static JButton RButton;
  static JButton SButton;
  static JButton and;
  static JButton or;
  static JButton povlaci;
  static JButton akko;
  static JButton negirajFormulu;
  static JButton enter;
  static int brojNezatvorenihZagrada;
  static JButton[][] matricaUnosa;

  static JButton primjer0;
  static JButton primjer1;
  static JButton primjer2;
  static JButton primjer3;
  static JButton primjer4;
  static JButton primjer5;
  static JButton primjer6;
	
  static JPanel calculatorPanel;
  static JPanel interpretacijePanel;
  static JTextArea minimalneNormalneForme;
	static JPanel primjeriPanel;
	//static JPanel primjeriPanel2;
  static JPanel stablaPanel;
    
  public Calc(){
    super( "MINIMAL NORMAL  FORMs  of Propositional Logic Formulas (DNF/CNF)" );
		getContentPane().setLayout(new BorderLayout());    
			GridBagLayout calculatorPanelGBLayout = new GridBagLayout();
			calculatorPanel = new JPanel();
			calculatorPanel.setLayout(calculatorPanelGBLayout);
				
				GridBagConstraints gbcDisplayPanel = new GridBagConstraints();
					gbcDisplayPanel.gridwidth = 2;
					gbcDisplayPanel.gridheight = 1;
					gbcDisplayPanel.fill = GridBagConstraints.HORIZONTAL;
					//gbcDisplayPanel.weighty = 0.1;
				JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
					displayPanel.setBackground(Color.yellow);
					displayPanel.setBorder(BorderFactory.createLoweredBevelBorder());
						display = new JLabel(" ");
						formulaLS = new String(" ");
					displayPanel.add(display);
				calculatorPanelGBLayout.setConstraints( displayPanel, gbcDisplayPanel);
			calculatorPanel.add( displayPanel);
	
				GridBagConstraints gbcKeyPanel = new GridBagConstraints();
					gbcKeyPanel.gridx = 0;
					gbcKeyPanel.gridy = 1;
					gbcKeyPanel.gridwidth = 1;
					gbcKeyPanel.gridheight = 1;
					gbcKeyPanel.fill = GridBagConstraints.BOTH;
					JPanel keysPanel = new JPanel(new GridLayout( 5, 3));

          	clear = new JButton(" CLEAR ");
								clear.setFont(new Font("Times Roman", Font.PLAIN, 23));
								clear.setForeground(Color.yellow);
								clear.addActionListener(this);
						keysPanel.add(clear);


							backSpace = new JButton("BACKSPACE");
								backSpace.setFont(new Font("Times Roman", Font.BOLD, 12));
								backSpace.setForeground(Color.yellow);
								backSpace.addActionListener(this);
						keysPanel.add(backSpace);

 							negirajFormulu = new JButton(new Character(NEGACIJA_CHAR).toString() + " ( FORMULA )");
								negirajFormulu.setFont(new Font("Times Roman", Font.BOLD,12));
								negirajFormulu.setForeground(Color.yellow);
								negirajFormulu.addActionListener(this);
						keysPanel.add(negirajFormulu);
           
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
							SButton = new JButton( new Character(S_CHAR).toString() );
								SButton.addActionListener(this);
						keysPanel.add(SButton);
							and = new JButton( new Character(AND_CHAR).toString() );
								and.addActionListener(this);
						keysPanel.add(and);
							or = new JButton( new Character(OR_CHAR).toString() );
								or.addActionListener(this);
						keysPanel.add(or);
							povlaci = new JButton( new Character(POVLACI_CHAR).toString() );
								povlaci.addActionListener(this);
						keysPanel.add(povlaci);
							akko = new JButton( new Character(AKKO_CHAR).toString() );
								akko.addActionListener(this);
						keysPanel.add(akko);
							enter = new JButton( " ENTER " );
								enter.setFont(new Font("Times Roman", Font.PLAIN, 33));
								enter.setForeground(Color.yellow);
								enter.setBorder(BorderFactory.createLineBorder( Color.yellow, 2));
								enter.addActionListener(this);
						keysPanel.add(enter);
					calculatorPanelGBLayout.setConstraints( keysPanel, gbcKeyPanel);
			calculatorPanel.add(keysPanel);

				GridBagConstraints gbcMinimalneNormalneForme = new GridBagConstraints();
					gbcMinimalneNormalneForme.gridx = 0;
					gbcMinimalneNormalneForme.gridy = 2;
					gbcMinimalneNormalneForme.gridwidth = 1;
					gbcMinimalneNormalneForme.gridheight = 1;
					gbcMinimalneNormalneForme.fill = GridBagConstraints.BOTH;
					gbcMinimalneNormalneForme.weighty = 1;
					minimalneNormalneForme = new JTextArea("");
					JScrollPane minimalneNormalneFormeView = new JScrollPane(minimalneNormalneForme);
				calculatorPanelGBLayout.setConstraints( minimalneNormalneFormeView, gbcMinimalneNormalneForme);
			calculatorPanel.add(minimalneNormalneFormeView);

				GridBagConstraints gbcPrimjeriFormula = new GridBagConstraints();
					gbcPrimjeriFormula.gridx = 0;
					gbcPrimjeriFormula.gridy = 3;
					gbcPrimjeriFormula.gridwidth = 1;
					gbcPrimjeriFormula.gridheight = 1;
					gbcPrimjeriFormula.fill = GridBagConstraints.HORIZONTAL;
					JLabel primjeriFormula = new JLabel("READY-made EXAMPLES of Propositional Logic Formulas:");
					primjeriFormula.setForeground(Color.blue);
					primjeriFormula.setFont(new Font("Times Roman", Font.BOLD,15));
				calculatorPanelGBLayout.setConstraints( primjeriFormula, gbcPrimjeriFormula);
			calculatorPanel.add(primjeriFormula);			
			
				GridBagConstraints gbcPrimjeriPanel = new GridBagConstraints();
					gbcPrimjeriPanel.gridx = 0;
					gbcPrimjeriPanel.gridy = 4;
					gbcPrimjeriPanel.gridwidth = 2;
					gbcPrimjeriPanel.gridheight = 1;
					gbcPrimjeriPanel.fill = GridBagConstraints.HORIZONTAL;//BOTH;
					JPanel primjeriPanel = new JPanel(new GridLayout( 1, 7));
							primjer0 = new JButton("1.");
								primjer0.addActionListener(this);
						primjeriPanel.add(primjer0);
							primjer1 = new JButton("2.");
								primjer1.addActionListener(this);
						primjeriPanel.add(primjer1);
							primjer2 = new JButton("3.");
								primjer2.addActionListener(this);
						primjeriPanel.add(primjer2);
							primjer3 = new JButton("4.");
								primjer3.addActionListener(this);
						primjeriPanel.add(primjer3);
							primjer4 = new JButton("5.");
								primjer4.addActionListener(this);
						primjeriPanel.add(primjer4);
							primjer5 = new JButton("6.");
								primjer5.addActionListener(this);
						primjeriPanel.add(primjer5);
							primjer6 = new JButton("7.");
								primjer6.addActionListener(this);
						primjeriPanel.add(primjer6);
				calculatorPanelGBLayout.setConstraints( primjeriPanel, gbcPrimjeriPanel);
			calculatorPanel.add(primjeriPanel);
						
				GridBagConstraints gbcInterpretacijePanel = new GridBagConstraints();
					gbcInterpretacijePanel.gridx = 1;
					gbcInterpretacijePanel.gridy = 1;
					gbcInterpretacijePanel.gridwidth = 1;
					gbcInterpretacijePanel.gridheight = 3;
					gbcInterpretacijePanel.fill = GridBagConstraints.BOTH;
				interpretacijePanel = new JPanel(new GridLayout(18,1));
				interpretacijePanel.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
					JButton result = new JButton("SEMANTIC TABLE");
					result.setForeground(Color.blue);
				interpretacijePanel.add(result);
				for( int i = 1; i < 18; i++) {
					interpretacijePanel.add( new JButton("") );
				}
				calculatorPanelGBLayout.setConstraints( interpretacijePanel, gbcInterpretacijePanel);
			calculatorPanel.add(interpretacijePanel);
			
		getContentPane().add( calculatorPanel, BorderLayout.CENTER);
	
      stablaPanel = new JPanel( new GridLayout( 1, 2));
				stablaPanel.add( new JLabel( "FORMULA", JLabel.CENTER));
				stablaPanel.add( new JLabel( "glavni test", JLabel.CENTER));

        //getContentPane().add(stablaPanel, BorderLayout.EAST); // ! ZEC JE U GRMU
		
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    pack();
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameDim = getSize();
		setLocation( ( (int)screenDim.getWidth() - (int)frameDim.getWidth() ) / 2,
									 ( (int)screenDim.getHeight() - (int)frameDim.getHeight() ) / 2 );
    show();
    brojNezatvorenihZagrada = 0;
    matricaUnosa = new JButton[][] { 
      { negirajFormulu, backSpace, clear},
      { negacija, lijevaZagrada, desnaZagrada},
      { PButton, QButton, RButton},
      { SButton, and, or},
      { povlaci, akko, enter}};
    osvijetliKorakUnosa("pocetak");
  }//Calc()

  public void actionPerformed( ActionEvent event ) {
    Object action = event.getSource();

    if ( action.equals(primjer0)){
      formulaLS = (Primjeri.primjer0());brojNezatvorenihZagrada = 0;osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(primjer1)){
      formulaLS = (Primjeri.primjer1());brojNezatvorenihZagrada = 0;osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(primjer2)){
      formulaLS = (Primjeri.primjer2());brojNezatvorenihZagrada = 0;osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(primjer3)){
      formulaLS = (Primjeri.primjer3());brojNezatvorenihZagrada = 0;osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(primjer4)){
      formulaLS = (Primjeri.primjer4());brojNezatvorenihZagrada = 0;osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(primjer5)){
      formulaLS = (Primjeri.primjer5());brojNezatvorenihZagrada = 0;osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(primjer6)){
      formulaLS = (Primjeri.primjer6());brojNezatvorenihZagrada = 0;osvijetliKorakUnosa("binarni veznik expected");
    }

    if ( action.equals(enter)) {
			for( int i = 1; i < 18; i++){
				JButton gumb = (JButton) interpretacijePanel.getComponent(i);
				gumb.setText("");
				gumb.setBackground(new Color( 204, 204, 204));
			}
			Calc.stablaPanel.removeAll();
			try {
				MinimalneNormalneForme.minimalneNormalneForme(StabloFormule.parsiraj());
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
				if ( formulaLS.length() > 1 && (StabloFormule.i + 1) < formulaLS.length()){
					int i = StabloFormule.i + 1;
					if (( i + 1) < formulaLS.length()){
						String smece = formulaLS.substring(i);
						for ( int j = 0; j < smece.length(); j++){
							if (smece.charAt(j) == LIJEVA_ZAGRADA) brojNezatvorenihZagrada -= 1;
							if (smece.charAt(j) ==  ')')           brojNezatvorenihZagrada += 1;
						}
					}
					char trik =  formulaLS.charAt(i);
					formulaLS = ( formulaLS.substring( 0, i) + trik);
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
      int duljina = formulaLS.length();
      if ( duljina == 2){ // display pocinje sa " "
				action = clear;
      }
      if ( duljina > 2) {
				if ( formulaLS.charAt( duljina - 1) == LIJEVA_ZAGRADA) brojNezatvorenihZagrada -= 1;
				if ( formulaLS.charAt( duljina - 1) == ')')            brojNezatvorenihZagrada += 1;
        switch (formulaLS.charAt(duljina - 2)){
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
          case S_CHAR:          action = SButton;
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
        formulaLS = ( formulaLS.substring( 0, duljina - 2));
      }
    }
    if ( action.equals(clear)){
      formulaLS = " " ;
			for( int i = 1; i < 18; i++){
				JButton gumb = (JButton) interpretacijePanel.getComponent(i);
				gumb.setText("");
				gumb.setBackground(new Color( 204, 204, 204));
			}
      brojNezatvorenihZagrada = 0;
      osvijetliKorakUnosa("pocetak");
			minimalneNormalneForme.setText("");
    }
    if ( action.equals(negacija) ) {
      formulaLS = ( formulaLS + negacija.getText() );
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(lijevaZagrada) ) {
      formulaLS = ( formulaLS + lijevaZagrada.getText() );
      brojNezatvorenihZagrada += 1;
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(desnaZagrada) ) {
      formulaLS = ( formulaLS + desnaZagrada.getText() );
      brojNezatvorenihZagrada -= 1;
      osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(PButton) ) {
      formulaLS = ( formulaLS + PButton.getText() );
      osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(QButton) ) {
      formulaLS = ( formulaLS + QButton .getText());
      osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(RButton) ) {
      formulaLS = ( formulaLS + RButton.getText() );
      osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(SButton) ) {
      formulaLS = ( formulaLS + SButton.getText() );
      osvijetliKorakUnosa("binarni veznik expected");
    }
    if ( action.equals(and) ) {
      formulaLS = ( formulaLS + and .getText());
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(or) ) {
      formulaLS = ( formulaLS + or.getText() );
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(povlaci) ) {
      formulaLS = ( formulaLS + povlaci.getText() );
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(akko) ) {
      formulaLS = ( formulaLS + akko.getText() );
      osvijetliKorakUnosa("faktor expected");
    }
    if ( action.equals(negirajFormulu) ) {
      formulaLS = ( " " + new Character(NEGACIJA_CHAR).toString() + new Character(LIJEVA_ZAGRADA).toString()
				+ formulaLS.substring(1) + new Character(')').toString() );			
		}
		
		 if (formulaLS.length() < 68) display.setText(formulaLS);
			 else display.setText(formulaLS.substring(formulaLS.length() - 68));
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
      Calc.matricaUnosa[2][0].setBackground(Color.blue); //A
      Calc.matricaUnosa[2][1].setBackground(Color.blue); //B
      Calc.matricaUnosa[2][2].setBackground(Color.blue); //C
      Calc.matricaUnosa[3][0].setBackground(Color.blue); //D
    }
    if (ulaznoStanje.equals("faktor expected")){ // propozicionalna varijabla, negacija, clear, backspace
      Calc.matricaUnosa[0][1].setBackground(Color.blue);
      Calc.matricaUnosa[0][2].setBackground(Color.blue);
      Calc.matricaUnosa[1][0].setBackground(Color.blue);
      Calc.matricaUnosa[1][1].setBackground(Color.blue);
      Calc.matricaUnosa[2][0].setBackground(Color.blue); //A
      Calc.matricaUnosa[2][1].setBackground(Color.blue); //B
      Calc.matricaUnosa[2][2].setBackground(Color.blue); //C
      Calc.matricaUnosa[3][0].setBackground(Color.blue); //D
    }
    if (ulaznoStanje.equals("binarni veznik expected")){ // binarni veznik, desna zagrada ili ENTER
      Calc.matricaUnosa[0][0].setBackground(Color.blue); //negirajFormulu
      Calc.matricaUnosa[0][1].setBackground(Color.blue);
      Calc.matricaUnosa[0][2].setBackground(Color.blue);
      //Calc.matricaUnosa[4][0].setBackground(Color.blue);
      Calc.matricaUnosa[3][1].setBackground(Color.blue); //and
      Calc.matricaUnosa[3][2].setBackground(Color.blue); //or
      Calc.matricaUnosa[4][0].setBackground(Color.blue); //povlaci
      Calc.matricaUnosa[4][1].setBackground(Color.blue); //akko - negirajFormulu
      if (Calc.brojNezatvorenihZagrada > 0) Calc.matricaUnosa[1][2].setBackground(Color.blue);
      else Calc.matricaUnosa[4][2].setBackground(Color.blue); //enter
    }
  }
}//class
