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
	String[] variableID;
	String[] variableHer;
	String[] variableModel;
	String[] variableMat;
	String[] variableBear;
	String[] variableRad;
	String[] variableVc;
	String[] variableF;
	String[] variableAp;
	//StringBuffer[] ergebnis;
	String[] ergebnis1;
	String[] ergebnis2;
	String[] ergebnis3;
	String id;
	String hersteller;
	String model;
	String material;
	String bear;
	String rad;
	String vc;
	String ap;
	String f;
	String test1;
	StringBuffer test2;
	//String ergebnisarr[][];
	String kE2; 
	
	String kE3;
	
	
	
	public GUI () {
		
		String [] werkstoff = {"Stahl","Harte Werkstoffe", "Aluminium","Nichtrostender Stahl","Titan","Gusseisen"};
		String [] bearbeitung = {"Schruppen","Schlichten"};
		String [] oberflaeche = {"1", "1.6", "2.5", "4", "6.3", "10", "16", "25", "40", "63"};
		String [] radius ={"0.2","0.4", "0.8", "1.0", "2.0", "4.0"};
		 kE2= "keine Eingabe";
		 //kE3 = "keine Eingabe1";
		 variableID = new String[]{kE2,kE2,kE2};
		 variableHer = new String[]{kE2,kE2,kE2};
		 variableModel = new String[]{kE2,kE2,kE2};
		 variableMat  = new String[]{kE2,kE2,kE2};
		 variableBear = new String[]{kE2,kE2,kE2};
		 variableRad = new String[]{kE2,kE2,kE2};
		 variableVc = new String[]{kE2,kE2,kE2};
		 variableF = new String[]{kE2,kE2,kE2};
		 variableAp = new String[]{kE2,kE2,kE2};
		 id = "ID: ";
		 hersteller = "Hersteller: ";
		 model = "Modell-Nr.: ";
		 material = "Werkstoff: ";
		 bear = "Bearbeitungsart: ";
		 rad = "Radius: ";
		 vc = "Schnittgeschwindigkeit: ";
		 ap = "Zustellung: ";
		 f = "Vorschub: ";
		 
		 
		 //StringBuffer[] ergebnis = {id variableID, hersteller+variableHer}; 
		//ergebnisarr = new String[3][];
		ergebnis1 = new String []{id+variableID[1].toString(),
				hersteller+variableHer[1].toString(),
				model+variableModel[1].toString(),
				material+variableMat[1].toString(),
				bear+variableBear[1].toString(),
				rad+variableRad[1].toString(),
				vc+variableVc[1].toString(),
				ap+variableAp[1].toString(),
				f+variableF[1].toString()}; 
		ergebnis2 = new String []{id+variableID[1].toString(),
				hersteller+variableHer[1].toString(),
				model+variableModel[1].toString(),
				material+variableMat[1].toString(),
				bear+variableBear[1].toString(),
				rad+variableRad[1].toString(),
				vc+variableVc[1].toString(),
				ap+variableAp[1].toString(),
				f+variableF[1].toString()}; 
		ergebnis3 = new String []{id+variableID[1].toString(),
				hersteller+variableHer[1].toString(),
				model+variableModel[1].toString(),
				material+variableMat[1].toString(),
				bear+variableBear[1].toString(),
				rad+variableRad[1].toString(),
				vc+variableVc[1].toString(),
				ap+variableAp[1].toString(),
				f+variableF[1].toString()}; 
//		 ergebnisarr[0] = ergebnis;
//		 ergebnisarr[1]= ergebnis;
//		 ergebnisarr[2]= ergebnis;
		
//		StringBuffer buffers[] = new StringBuffer[ergebnis.length];
//		for(int i = 0; i<ergebnis.length; i++) {
//			buffers[i] = new StringBuffer(ergebnis[i]);
//			
//		}
		JFrame frame = new JFrame("Werkzeugauswahl");

		int frame_x = 1000; //Breite des Programmfensters in Pixel
		int frame_y = 800; //H�he des Programmfensters in Pixel
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
		bSuchen.setBounds(350, 260, 300, 70);
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
		
		JLabel lbOberflaeche = new JLabel("Oberflaechenguete [Rz in mm]");
		lbOberflaeche.setBounds(505, 100, 230, 25);
		lbOberflaeche.setHorizontalAlignment(SwingConstants.CENTER);
		lbOberflaeche.setFont(new Font("@HP Simplified Hans", Font.BOLD, 14));
		cp.add(lbOberflaeche);
		
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
		SpinnerListModel spOberflaecheModel = new SpinnerListModel (oberflaeche);
		spOberflaeche.setModel(spOberflaecheModel);
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
		
		JList liVorschlag1 = new JList(ergebnis1);
		JList liVorschlag2 = new JList(ergebnis2);	
		JList liVorschlag3 = new JList(ergebnis3);
		
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
		frame.repaint();
		/*********************************************************/
		
	/*	JMenuBar mb = new JMenuBar();

		JMenu datei = new JMenu("Datei");
		JMenu hilfe = new JMenu("Hilfe");

		JMenuItem neu = new JMenuItem("neues Werkzeug anlegen");
		JMenuItem �berUns = new JMenuItem("�ber uns");

		datei.add(neu);
		hilfe.add(�berUns);
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
			//System.out.println(variableID[i]);
			JList liVorschlag4 = new JList(ergebnis1);
			if (i==0) {
			ergebnis1= new String[] {id+variableID[i],
					hersteller+variableHer[i],
					model+variableModel[i],
					material+variableMat[i],
					bear+variableBear[i],
					rad+variableRad[i],
					vc+variableVc[i],
					ap+variableAp[i],
					f+variableF[i]};
			}
			else if (i==1) {
				ergebnis2= new String[] {id+variableID[i],
						hersteller+variableHer[i],
						model+variableModel[i],
						material+variableMat[i],
						bear+variableBear[i],
						rad+variableRad[i],
						vc+variableVc[i],
						ap+variableAp[i],
						f+variableF[i]};
				}
			else if (i==2) {
				ergebnis3= new String[] {id+variableID[i],
						hersteller+variableHer[i],
						model+variableModel[i],
						material+variableMat[i],
						bear+variableBear[i],
						rad+variableRad[i],
						vc+variableVc[i],
						ap+variableAp[i],
						f+variableF[i]};
				}
			
			
		}
			
			
			
			//System.out.println(variableID[]);
		
			//System.out.println(ergebnis[0]);
			
		for (int g=0;g<9;g++) {
			System.out.println(ergebnis1[g]);
			
			}
		
		JComboBox cbWerkstoff1 = new JComboBox();
		DefaultComboBoxModel cbWerkstoff1Model = new DefaultComboBoxModel(ergebnis1);
		liVorschlag1.setModel(cbWerkstoff1Model);
		JComboBox cbWerkstoff2 = new JComboBox();
		DefaultComboBoxModel cbWerkstoff2Model = new DefaultComboBoxModel(ergebnis2);
		liVorschlag2.setModel(cbWerkstoff2Model);
		JComboBox cbWerkstoff3 = new JComboBox();
		DefaultComboBoxModel cbWerkstoff3Model = new DefaultComboBoxModel(ergebnis3);
		liVorschlag3.setModel(cbWerkstoff3Model);
			//frame.repaint();
		
			}
			});
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//datenbank data = new datenbank();
		new GUI();
		

	}

}