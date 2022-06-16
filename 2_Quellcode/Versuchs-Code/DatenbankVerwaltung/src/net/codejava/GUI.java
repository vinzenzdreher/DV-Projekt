package net.codejava;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;

public class GUI{
//	String eingabeWerkstoff;
//	String eingabeBearbeitung;
//	String eingabeRadius;
	StringBuffer[] variableID;
	StringBuffer[] variableHer;
	StringBuffer[] variableModel;
	StringBuffer[] variableMat;
	StringBuffer[] variableBear;
	StringBuffer[] variableRad;
	StringBuffer[] variableVc;
	StringBuffer[] variableF;
	StringBuffer[] variableAp;
	//StringBuffer[] ergebnis;
	StringBuffer[] ergebnis;
	StringBuffer id;
	StringBuffer hersteller;
	StringBuffer model;
	StringBuffer material;
	StringBuffer bear;
	StringBuffer rad;
	StringBuffer vc;
	StringBuffer ap;
	StringBuffer f;
	String test1;
	StringBuffer test2;
	StringBuffer ergebnisarr[][];
	StringBuffer kE2; 
	
	StringBuffer kE3;
	
	
	
	public GUI () {
		
		String [] werkstoff = {"Stahl","Harte Werkstoffe", "Aluminium","Nichtrostender Stahl","Titan","Gusseisen"};
		String [] bearbeitung = {"Schruppen","Schlichten"};
		String [] oberfläche = {"1", "1.6", "2.5", "4", "6.3", "10", "16", "25", "40", "63"};
		String [] radius ={"0.1", "0.2", "0.4", "0.8", "1.0", "2.0", "4.0"};
		 kE2= new StringBuffer("keine Eingabe");
		 kE3 = new StringBuffer("keine Eingabe1");
		 variableID = new StringBuffer[]{kE2,kE2,kE2};
		 variableHer = new StringBuffer[]{kE2,kE2,kE2};
		 variableModel = new StringBuffer[]{kE2,kE2,kE2};
		 variableMat  = new StringBuffer[]{kE2,kE2,kE2};
		 variableBear = new StringBuffer[]{kE2,kE2,kE2};
		 variableRad = new StringBuffer[]{kE2,kE2,kE2};
		 variableVc = new StringBuffer[]{kE2,kE2,kE2};
		 variableF = new StringBuffer[]{kE2,kE2,kE2};
		 variableAp = new StringBuffer[]{kE2,kE2,kE2};
		 id = new StringBuffer("ID: ");
		 hersteller = new StringBuffer("Hersteller: ");
		 model = new StringBuffer("Modell-Nr.: ");
		 material = new StringBuffer("Werkstoff: ");
		 bear = new StringBuffer("Bearbeitungsart: ");
		 rad = new StringBuffer("Radius: ");
		 vc = new StringBuffer("Schnittgeschwindigkeit: ");
		 ap = new StringBuffer("Zustellung: ");
		 f = new StringBuffer("Vorschub: ");
		 
		 
		 //StringBuffer[] ergebnis = {id variableID, hersteller+variableHer}; 
		ergebnisarr = new StringBuffer[3][];
		ergebnis = new StringBuffer[] {id.append(variableID[1]),
				hersteller.append(variableHer[1]),
				model.append(variableModel[1]),
				material.append(variableMat[1]),
				bear.append(variableBear[1]),
				rad.append(variableRad[1]),
				vc.append(variableVc[1]),
				ap.append(variableAp[1]),
				f.append(variableF[1])}; 
		 ergebnisarr[0] = ergebnis;
		 ergebnisarr[1]= ergebnis;
		 ergebnisarr[2]= ergebnis;
		
//		StringBuffer buffers[] = new StringBuffer[ergebnis.length];
//		for(int i = 0; i<ergebnis.length; i++) {
//			buffers[i] = new StringBuffer(ergebnis[i]);
//			
//		}
		JFrame frame = new JFrame("Werkzeugauswahl");

		int frame_x = 1000; //Breite des Programmfensters in Pixel
		int frame_y = 800; //Höhe des Programmfensters in Pixel
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Bildschirmdimensionen in Pixeln holen
		frame.setBounds((screenSize.width-frame_x)/2, (screenSize.height-frame_y)/2, frame_x, frame_y);
		frame.setVisible(true);
		frame.setSize(1000,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CuttingPlateFinder");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBackground(new Color(0xC0C0C0));
															/*Image icon = Toolkit.getDefaultToolkit().getImage("");
															frame.setIconImage(icon);*/
		Container cp = frame.getContentPane();
		cp.setLayout(null);
		
		/*********************************************************/

		JButton bSuchen = new JButton("Suche starten!");
		bSuchen.setBounds(350, 285, 300, 70);
		//bSuchen.setMargin(new Insets(2, 2, 2, 2));
		bSuchen.setFont(new Font("@HP Simplified Hans",Font.BOLD, 16));
		bSuchen.setBackground(new Color(0xFFC800));
		cp.add(bSuchen);
		
		/*********************************************************/
		
		JLabel lbWerkstoff = new JLabel("Werkstoff");
		lbWerkstoff.setBounds(40, 100, 200, 25);
		lbWerkstoff.setHorizontalAlignment(SwingConstants.CENTER);
		lbWerkstoff.setFont(new Font("@HP Simplified Hans", Font.BOLD, 14));
		cp.add(lbWerkstoff);
		
		JLabel lbRadius = new JLabel("kleinster Radius [mm]");
		lbRadius.setBounds(280, 100, 200, 25);
		lbRadius.setHorizontalAlignment(SwingConstants.CENTER);
		lbRadius.setFont(new Font("@HP Simplified Hans", Font.BOLD, 14));
		cp.add(lbRadius);
		
		JLabel lbOberfläche = new JLabel("Öberflächengüte [Rz in µm]");
		lbOberfläche.setBounds(520, 100, 200, 25);
		lbOberfläche.setHorizontalAlignment(SwingConstants.CENTER);
		lbOberfläche.setFont(new Font("@HP Simplified Hans", Font.BOLD, 14));
		cp.add(lbOberfläche);
		
		JLabel lbBearbeitung = new JLabel("Bearbeitung");
		lbBearbeitung.setBounds(760, 100, 200, 25);
		lbBearbeitung.setHorizontalAlignment(SwingConstants.CENTER);
		lbBearbeitung.setFont(new Font("@HP Simplified Hans", Font.BOLD, 14));
		cp.add(lbBearbeitung);
		
		JLabel lbVorschlag1 = new JLabel("Vorschlag 1");
		lbVorschlag1.setBounds(70, 410, 250, 22);
		lbVorschlag1.setHorizontalAlignment(SwingConstants.CENTER);
		lbVorschlag1.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
		cp.add(lbVorschlag1);
		
		JLabel lbVorschlag2 = new JLabel("Vorschlag 2");
		lbVorschlag2.setBounds(370, 410, 250, 22);
		lbVorschlag2.setHorizontalAlignment(SwingConstants.CENTER);
		lbVorschlag2.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
		cp.add(lbVorschlag2);
		
		JLabel lbVorschlag3 = new JLabel("Vorschlag 3");
		lbVorschlag3.setBounds(670, 410, 250, 22);
		lbVorschlag3.setHorizontalAlignment(SwingConstants.CENTER);
		lbVorschlag3.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
		cp.add(lbVorschlag3);
		
		/*********************************************************/
		
		JSpinner spOberflaeche = new JSpinner();
		SpinnerListModel spOberflächeModel = new SpinnerListModel (oberfläche);
		spOberflaeche.setModel(spOberflächeModel);
		spOberflaeche.setBounds(520, 150, 200, 30);
	    spOberflaeche.setEnabled(true);
	    spOberflaeche.setEditor(new JSpinner.DefaultEditor(spOberflaeche));
	    spOberflaeche.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
	    spOberflaeche.setBackground(new Color(0xFFFFFF));
	    cp.add(spOberflaeche);
	    
		JSpinner spRadius = new JSpinner();
		SpinnerListModel spRadiusModel = new SpinnerListModel (radius);
		spRadius.setModel(spRadiusModel);
		spRadius.setBounds(280, 150, 200, 30);
		spRadius.setEnabled(true);
		spRadius.setEditor(new JSpinner.DefaultEditor(spRadius));
		spRadius.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
		spRadius.setBackground(new Color(0xFFFFFF));
	    cp.add(spRadius);
	    
		/*********************************************************/
		
		JComboBox cbWerkstoff = new JComboBox();
		DefaultComboBoxModel cbWerkstoffModel = new DefaultComboBoxModel(werkstoff);
		cbWerkstoff.setModel(cbWerkstoffModel);
		cbWerkstoff.setBounds(40, 150, 200, 30);
		cbWerkstoff.setSelectedItem(0);
		cbWerkstoff.setBackground(new Color(0xFFFFFF));
		cp.add(cbWerkstoff);
		
		JComboBox cbBearbeitung = new JComboBox();
		DefaultComboBoxModel cbBearbeitungModel = new DefaultComboBoxModel(bearbeitung);
		cbBearbeitung.setModel(cbBearbeitungModel);
		cbBearbeitung.setBounds(760, 150, 200, 30);
		cbBearbeitung.setSelectedItem(0);
		cbBearbeitung.setBackground(new Color(0xFFFFFF));
		cp.add(cbBearbeitung);
		
		/*********************************************************/
		
		JList liVorschlag1 = new JList(ergebnisarr[0]);
		JList liVorschlag2 = new JList(ergebnisarr[1]);	
		JList liVorschlag3 = new JList(ergebnisarr[2]);
		
		/*********************************************************/
		
		JScrollPane liVorschlag1ScrollPane = new JScrollPane(liVorschlag1);
		liVorschlag1ScrollPane.setBounds(70, 450, 250, 170);
		liVorschlag1ScrollPane.setBackground(new Color(0xFFFFFF));
		cp.add(liVorschlag1ScrollPane);
		
		JScrollPane liVorschlag2ScrollPane = new JScrollPane(liVorschlag2);
		liVorschlag2ScrollPane.setBounds(370, 450, 250, 170);
		liVorschlag2ScrollPane.setBackground(new Color(0xFFFFFF));
		cp.add(liVorschlag2ScrollPane);
		
		JScrollPane liVorschlag3ScrollPane = new JScrollPane(liVorschlag3);
		liVorschlag3ScrollPane.setBounds(670, 450, 250, 170);
		liVorschlag3ScrollPane.setBackground(new Color(0xFFFFFF));
		cp.add(liVorschlag3ScrollPane);
		
		/*********************************************************/
		
	/*	JMenuBar mb = new JMenuBar();

		JMenu datei = new JMenu("Datei");
		JMenu hilfe = new JMenu("Hilfe");

		JMenuItem neu = new JMenuItem("neues Werkzeug anlegen");
		JMenuItem überUns = new JMenuItem("Über uns");

		datei.add(neu);
		hilfe.add(überUns);
		mb.add(datei);
		mb.add(hilfe);
		mb.setVisible(true);
		cp.add(mb); */
		
		/*********************************************************/
	
		bSuchen.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
			String eingabeWerkstoff = (String)cbWerkstoff.getSelectedItem();
			String eingabeBearbeitung = (String)cbBearbeitung.getSelectedItem();
			String eingabeRadius = (String)spRadius.getValue();
			double eingabeOberflaeche = Double.parseDouble((String)spOberflaeche.getValue())/1000;
			double vorschub = Math.round(Math.sqrt(8*eingabeOberflaeche*Double.parseDouble(eingabeRadius))*1000.0)/1000.0;
			
			datenbank data = new datenbank(eingabeWerkstoff, eingabeBearbeitung, eingabeRadius);
			data.getSchneidplatte();
			
		for(int i = 0; i<3;i++) {
			variableID[i] = data.iD[i];
			variableHer[i] = data.her[i];
			variableModel[i] = data.model[i];
			variableMat[i]  = data.mat[i]; 
			variableBear[i] = data.bear[i];
			variableRad[i] = data.rad[i];
			variableVc[i] = data.vc[i];
			variableF[i] = data.f[i];
			variableAp[i] = data.ap[i];
			
			
			ergebnisarr[i]= new StringBuffer[] {id.insert(4,variableID[i].toString()),
					hersteller.replace(12,100,variableHer[i].toString()),
					model.replace(12,100,variableModel[i].toString()),
					material.replace(11,100,variableMat[i].toString()),
					bear.replace(17,100,variableBear[i].toString()),
					rad.replace(8,100, variableRad[i].toString()),
					vc.replace(24,100,variableVc[i].toString()),
					ap.replace(12,100,variableAp[i].toString()),
					f.replace(10,100,variableF[i].toString())};
		}
			
			
			
			//System.out.println(variableID[]);
		
			//System.out.println(ergebnis[0]);
			
			
		
			frame.repaint();
			}
			});
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//datenbank data = new datenbank();
		new GUI();
		

	}

}