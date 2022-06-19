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
import javax.swing.ImageIcon;
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
	String[] variableID;
	String[] variableHer;
	String[] variableModel;
	String[] variableMat;
	String[] variableBear;
	String[] variableRad;
	String[] variableVc;
	String[] variableF;
	String[] variableAp;
	String[] ergebnis;
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
	String ergebnisarr[][];
	String kE2;
	String kT;





	public GUI () {

		String [] werkstoff = {"Stahl","Harte Werkstoffe", "Aluminium","Nichtrostender Stahl","Titan","Gusseisen"};
		String [] bearbeitung = {"Schruppen","Schlichten"};
		String [] oberflaeche = {"1", "1.6", "2.5", "4", "6.3", "10", "16", "25", "40", "63"};
		String [] radius ={"0.2","0.4", "0.8","1.2"};
		kE2= "Keine Eingabe";
		kT = "Kein Treffer";
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
		rad = "Radius [mm]: ";
		vc = "Schnittgeschwindigkeit [m/min]: ";
		ap = "Zustellung [mm]: ";
		f = "Vorschub [mm]: ";


		ergebnisarr = new String[3][];
		ergebnis = new String []{id+variableID[1],
				hersteller+variableHer[1],
				model+variableModel[1],
				material+variableMat[1],
				bear+variableBear[1],
				rad+variableRad[1],
				vc+variableVc[1],
				ap+variableAp[1],
				f+variableF[1]}; 

		ergebnisarr[0] = ergebnis;
		ergebnisarr[1]= ergebnis;
		ergebnisarr[2]= ergebnis;

		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("Schneidplatte.jpg"));
		
		JFrame frame = new JFrame("Werkzeugauswahl");

		int frame_x = 1000; //Breite des Programmfensters in Pixel
		int frame_y = 800; //Hoehe des Programmfensters in Pixel
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
		frame.setIconImage(logo.getImage());
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
		spOberflaeche.setVisible(true);

		JSpinner spRadius = new JSpinner();
		SpinnerListModel spRadiusModel = new SpinnerListModel (radius);
		spRadius.setModel(spRadiusModel);
		spRadius.setBounds(280, 150, 200, 30);
		spRadius.setEnabled(true);
		spRadius.setEditor(new JSpinner.DefaultEditor(spRadius));
		spRadius.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
		spRadius.setBackground(new Color(0xFFFFFF));
		cp.add(spRadius);
		spRadius.setVisible(true);

		/*********************************************************/

		JComboBox cbWerkstoff = new JComboBox();
		DefaultComboBoxModel cbWerkstoffModel = new DefaultComboBoxModel(werkstoff);
		cbWerkstoff.setModel(cbWerkstoffModel);
		cbWerkstoff.setBounds(40, 150, 200, 30);
		cbWerkstoff.setSelectedItem(0);
		cbWerkstoff.setBackground(new Color(0xFFFFFF));
		cp.add(cbWerkstoff);
		cbWerkstoff.setVisible(true);
		

		JComboBox cbBearbeitung = new JComboBox();
		DefaultComboBoxModel cbBearbeitungModel = new DefaultComboBoxModel(bearbeitung);
		cbBearbeitung.setModel(cbBearbeitungModel);
		cbBearbeitung.setBounds(760, 150, 200, 30);
		cbBearbeitung.setSelectedItem(0);
		cbBearbeitung.setBackground(new Color(0xFFFFFF));
		cp.add(cbBearbeitung);
		cbBearbeitung.setVisible(true);

		/*********************************************************/

		JList liVorschlag1 = new JList(ergebnisarr[0]);
		JList liVorschlag2 = new JList(ergebnisarr[1]);	
		JList liVorschlag3 = new JList(ergebnisarr[2]);

		/*********************************************************/

		JScrollPane liVorschlag1ScrollPane = new JScrollPane(liVorschlag1);
		liVorschlag1ScrollPane.setBounds(55, 450, 280, 170);
		liVorschlag1ScrollPane.setBackground(new Color(0xFFFFFF));
		cp.add(liVorschlag1ScrollPane);

		JScrollPane liVorschlag2ScrollPane = new JScrollPane(liVorschlag2);
		liVorschlag2ScrollPane.setBounds(355, 450, 280, 170);
		liVorschlag2ScrollPane.setBackground(new Color(0xFFFFFF));
		cp.add(liVorschlag2ScrollPane);

		JScrollPane liVorschlag3ScrollPane = new JScrollPane(liVorschlag3);
		liVorschlag3ScrollPane.setBounds(655, 450, 280, 170);
		liVorschlag3ScrollPane.setBackground(new Color(0xFFFFFF));
		cp.add(liVorschlag3ScrollPane);
		frame.repaint();


		/*********************************************************/

		//ImageIcon logo = new ImageIcon(".//res//Schneidplatte.jpg");
//		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("Schneidplatte.jpg"));
		
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
					try {
						if (Double.parseDouble(variableF[i])>vorschub) {
							variableF[i]= String.valueOf(vorschub);
						}
					} catch(NumberFormatException e1) {
						variableID[i] = kT;
						variableHer[i] = kT;
						variableModel[i] = kT;
						variableMat[i]  = kT; 
						variableBear[i] = kT;
						variableRad[i] = kT;
						variableVc[i] = kT;
						variableF[i] = kT;
						variableAp[i] = kT;
					}
					
				
					
					
					
					ergebnisarr[i]= new String[] {id+variableID[i],
							hersteller+variableHer[i],
							model+variableModel[i],
							material+variableMat[i],
							bear+variableBear[i],
							rad+variableRad[i],
							vc+variableVc[i],
							ap+variableAp[i],
							f+variableF[i]};
					


				}






				JComboBox vorschlag1 = new JComboBox();
				DefaultComboBoxModel vorschlag1Model = new DefaultComboBoxModel(ergebnisarr[0]);
				liVorschlag1.setModel(vorschlag1Model);
				JComboBox vorschlag2 = new JComboBox();
				DefaultComboBoxModel vorschlag2Model = new DefaultComboBoxModel(ergebnisarr[1]);
				liVorschlag2.setModel(vorschlag2Model);
				JComboBox vorschlag3 = new JComboBox();
				DefaultComboBoxModel vorschlag3Model = new DefaultComboBoxModel(ergebnisarr[2]);
				liVorschlag3.setModel(vorschlag3Model);
			}
		});
	}


}