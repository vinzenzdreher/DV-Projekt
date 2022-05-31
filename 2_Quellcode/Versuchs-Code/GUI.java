import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

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

public class GUI {
	
	public GUI () {
		
		String[] werkstoff = {"bitte wählen!","Automatenstahl","Messing", "Aluminium","Einsatzstahl","Vergütungsstahl","Werkzeugstahl"};
		String [] bearbeitung = {"Längsrundschruppen","Längsrundschlichten","Plandrehen"};
		String [] oberfläche = {"0.4", "1", "2.5", "6.3", "16", "40", "100"};
		String [] radius ={"0.1", "0.2", "0.4", "0.8", "1.0", "2.0", "4.0"};
		String variableNorm = null;
		String variableHer = null;
		String variableAnw  = null; 
		String variableVc = null;
		String variableF = null;
		String variableAp = null;
		String variableRad = null;
		
		JFrame frame = new JFrame("Werkzeugauswahl");

		int frame_x = 1000; //Breite des Programmfensters in Pixel
		int frame_y = 800; //Höhe des Programmfensters in Pixel
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Bildschirmdimensionen in Pixeln holen
		frame.setBounds((screenSize.width-frame_x)/2, (screenSize.height-frame_y)/2, frame_x, frame_y);
		frame.setVisible(true);
		frame.setSize(1000,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Werkstattdolori3000");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBackground(new Color(0xC0C0C0));
		Container cp = frame.getContentPane();
		cp.setLayout(null);
		
		/*********************************************************/

		JButton bSuchen = new JButton("Suche starten!");
		bSuchen.setBounds(350, 285, 300, 70);
		bSuchen.setMargin(new Insets(2, 2, 2, 2));
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
		lbVorschlag1.setBounds(70, 460, 250, 22);
		lbVorschlag1.setHorizontalAlignment(SwingConstants.CENTER);
		lbVorschlag1.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
		cp.add(lbVorschlag1);
		
		JLabel lbVorschlag2 = new JLabel("Vorschlag 2");
		lbVorschlag2.setBounds(370, 460, 250, 22);
		lbVorschlag2.setHorizontalAlignment(SwingConstants.CENTER);
		lbVorschlag2.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
		cp.add(lbVorschlag2);
		
		JLabel lbVorschlag3 = new JLabel("Vorschlag 3");
		lbVorschlag3.setBounds(670, 460, 250, 22);
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
		spRadius.setBounds(520, 150, 200, 30);
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
		
		JList liVorschlag1 = new JList();
		DefaultListModel liVorschlag1Model = new DefaultListModel();
		liVorschlag1.setModel(liVorschlag1Model);
		liVorschlag1Model.addElement("Norm: "+variableNorm);
	    liVorschlag1Model.addElement("Hersteller: "+variableHer);
	    liVorschlag1Model.addElement("Anwendung: "+variableAnw);
	    liVorschlag1Model.addElement("Radius: "+variableRad+" mm");
	    liVorschlag1Model.addElement("Schnittgeschw.: "+variableVc+" m/min");
	    liVorschlag1Model.addElement("Vorschub: "+variableF+" mm/U");
	    liVorschlag1Model.addElement("Zustellung: "+variableAp+" mm");
	    
		
		
		JList liVorschlag2 = new JList();
		DefaultListModel liVorschlag2Model = new DefaultListModel();
		liVorschlag2.setModel(liVorschlag2Model);
		liVorschlag2Model.addElement("Norm: "+variableNorm);
	    liVorschlag2Model.addElement("Hersteller: "+variableHer);
	    liVorschlag2Model.addElement("Anwendung: "+variableAnw);
	    liVorschlag2Model.addElement("Radius: "+variableRad+" mm");
	    liVorschlag2Model.addElement("Schnittgeschw.: "+variableVc+" m/min");
	    liVorschlag2Model.addElement("Vorschub: "+variableF+" mm/U");
	    liVorschlag2Model.addElement("Zustellung: "+variableAp+" mm");
		
		
		JList liVorschlag3 = new JList();
		DefaultListModel liVorschlag3Model = new DefaultListModel();
		liVorschlag3.setModel(liVorschlag3Model);
		liVorschlag3Model.addElement("Norm: "+variableNorm);
	    liVorschlag3Model.addElement("Hersteller: "+variableHer);
	    liVorschlag3Model.addElement("Anwendung: "+variableAnw);
	    liVorschlag3Model.addElement("Radius: "+variableRad+" mm");
	    liVorschlag3Model.addElement("Schnittgeschw.: "+variableVc+" m/min");
	    liVorschlag3Model.addElement("Vorschub: "+variableF+" mm/U");
	    liVorschlag3Model.addElement("Zustellung: "+variableAp+" mm");
		
		/*********************************************************/
		
		JScrollPane liVorschlag1ScrollPane = new JScrollPane(liVorschlag1);
		liVorschlag1ScrollPane.setBounds(70, 500, 250, 130);
		liVorschlag1ScrollPane.setBackground(new Color(0xFFFFFF));
		cp.add(liVorschlag1ScrollPane);
		
		JScrollPane liVorschlag2ScrollPane = new JScrollPane(liVorschlag2);
		liVorschlag2ScrollPane.setBounds(370, 500, 250, 130);
		liVorschlag2ScrollPane.setBackground(new Color(0xFFFFFF));
		cp.add(liVorschlag2ScrollPane);
		
		JScrollPane liVorschlag3ScrollPane = new JScrollPane(liVorschlag3);
		liVorschlag3ScrollPane.setBounds(670, 500, 250, 130);
		liVorschlag3ScrollPane.setBackground(new Color(0xFFFFFF));
		cp.add(liVorschlag3ScrollPane);
		
		/*********************************************************/
		
		JMenuBar mb = new JMenuBar();

		JMenu datei = new JMenu("Datei");
		JMenu hilfe = new JMenu("Hilfe");

		JMenuItem neu = new JMenuItem("neues Werkzeug anlegen");
		JMenuItem überUns = new JMenuItem("Über uns");

		datei.add(neu);
		hilfe.add(überUns);
		mb.add(datei);
		mb.add(hilfe);
		mb.setVisible(true);
		cp.add(mb); }
		
		/*********************************************************/


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new GUI();

	}

}
