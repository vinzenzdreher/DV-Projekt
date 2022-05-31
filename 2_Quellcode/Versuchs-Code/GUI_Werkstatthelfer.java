import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Hashtable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

	
public class Test extends JFrame {
	String variableNorm ;
	String variableHer;
	String variableAnw;
	String variableVc;
	String variableF;
	String variableAp;
	String variableRad;
	// Anfang Attribute
  private JComboBox<String> cbWerkstoff = new JComboBox<String>();
    private DefaultComboBoxModel<String> cbWerkstoffModel = new DefaultComboBoxModel<String>();
  private JComboBox<String> cbBearbeitung = new JComboBox<String>();
    private DefaultComboBoxModel<String> cbBearbeitungModel = new DefaultComboBoxModel<String>();
  private JLabel lableWerkstoff = new JLabel();
  private JLabel lableBearbeitung = new JLabel();
  private JLabel Radius = new JLabel();
  private JLabel lableOberflaeche = new JLabel();
  private JButton bSuchen = new JButton();
  private JSpinner spinneroberflaeche = new JSpinner();
    private SpinnerListModel spinneroberflaecheModel = new SpinnerListModel(new String[] {"0.4", "1", "2.5", "6.3", "16", "40", "100"});
  private JMenuBar jMenuBar1 = new JMenuBar();
  private JSpinner spinnerRadius = new JSpinner();
    private SpinnerListModel spinnerRadiusModel = new SpinnerListModel(new String[] {"0.1", "0.2", "0.4", "0.8", "1.0", "2.0", "4.0"});
  private JList listVorschlag1 = new JList();
    private DefaultListModel listVorschlag1Model = new DefaultListModel();
    private JScrollPane listVorschlag1ScrollPane = new JScrollPane(listVorschlag1);
  private JList listVorschlag2 = new JList();
    private DefaultListModel listVorschlag2Model = new DefaultListModel();
    private JScrollPane listVorschlag2ScrollPane = new JScrollPane(listVorschlag2);
  private JList listvorschlag3 = new JList();
    private DefaultListModel listvorschlag3Model = new DefaultListModel();
    private JScrollPane listvorschlag3ScrollPane = new JScrollPane(listvorschlag3);
  private JLabel lVorschlag1 = new JLabel();
  private JLabel lVorschlag2 = new JLabel();
  private JLabel lVorschlag3 = new JLabel();
  // Ende Attribute
  
  public Test() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    int frameWidth = 1000; 
    int frameHeight = 801;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Gui_Werkstatthelfer");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    lVorschlag1.setBounds(70, 460, 250, 22);
    lVorschlag1.setText("Vorschlag 1");
    lVorschlag1.setHorizontalAlignment(SwingConstants.CENTER);
    lVorschlag1.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
    cp.add(lVorschlag1);
    listVorschlag1.setModel(listVorschlag1Model);
    listVorschlag1ScrollPane.setBounds(70, 500, 250, 150);
    listVorschlag1Model.addElement("Norm: "+variableNorm);
    listVorschlag1Model.addElement("Hersteller: "+variableHer);
    listVorschlag1Model.addElement("Anwendung: "+variableAnw);
    listVorschlag1Model.addElement("Radius: "+variableRad);
    listVorschlag1Model.addElement("Schnittgeschw.: "+variableVc);
    listVorschlag1Model.addElement("Vorschub: "+variableF);
    listVorschlag1Model.addElement("Zustellung: "+variableAp);
    cp.add(listVorschlag1ScrollPane);
    spinnerRadius.setBounds(280, 150, 200, 30);
    spinnerRadius.setValue(0);
    spinnerRadius.setModel(spinnerRadiusModel);
    spinnerRadius.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
    cp.add(spinnerRadius);
    spinneroberflaeche.setBounds(520, 150, 200, 30);
    spinneroberflaeche.setValue(0);
    spinneroberflaeche.setModel(spinneroberflaecheModel);
    spinneroberflaeche.setEnabled(true);
    spinneroberflaeche.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
    cp.add(spinneroberflaeche);
    bSuchen.setBounds(380, 300, 240, 40);
    bSuchen.setText("Schneidplatte suchen");
    bSuchen.setMargin(new Insets(2, 2, 2, 2));
    bSuchen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSuchen_ActionPerformed(evt);
      }
    });


    bSuchen.setBackground(new Color(0xFFC800));
    Hashtable<TextAttribute, Object> bSchneidplattesuchen_map = new Hashtable<TextAttribute, Object>();
    bSchneidplattesuchen_map.put(TextAttribute.FAMILY, "@HP Simplified Hans");
    bSchneidplattesuchen_map.put(TextAttribute.SIZE, new Integer(20));
    bSchneidplattesuchen_map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
    bSuchen.setFont(new Font(bSchneidplattesuchen_map));
    cp.add(bSuchen);
    lableOberflaeche.setBounds(520, 100, 200, 25);
    lableOberflaeche.setText("Geforderte Oberflaeche");
    lableOberflaeche.setHorizontalAlignment(SwingConstants.CENTER);
    lableOberflaeche.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
    cp.add(lableOberflaeche);
    Radius.setBounds(280, 100, 200, 25);
    Radius.setText("Kleinster Radius");
    Radius.setHorizontalAlignment(SwingConstants.CENTER);
    Radius.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
    cp.add(Radius);
    lableBearbeitung.setBounds(760, 100, 200, 25);
    lableBearbeitung.setText("Bearbeitungsart");
    lableBearbeitung.setHorizontalAlignment(SwingConstants.CENTER);
    lableBearbeitung.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
    cp.add(lableBearbeitung);
    lableWerkstoff.setBounds(40, 100, 200, 25);
    lableWerkstoff.setText("Werkstoff");
    lableWerkstoff.setHorizontalAlignment(SwingConstants.CENTER);
    lableWerkstoff.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
    cp.add(lableWerkstoff);
    cbBearbeitung.setModel(cbBearbeitungModel);
    cbBearbeitung.setBounds(760, 150, 200, 30);
    cbBearbeitungModel.addElement("Laengsschruppen");
    cbBearbeitungModel.addElement("Laengsschlichten");
    cbBearbeitungModel.addElement("Querplandrehen");
    cp.add(cbBearbeitung);
    cbWerkstoff.setModel(cbWerkstoffModel);
    cbWerkstoff.setBounds(40, 150, 200, 30);
    cbWerkstoffModel.addElement("Alu");
    cbWerkstoffModel.addElement("Stahl");
    cbWerkstoffModel.addElement("Guss");
    cbWerkstoffModel.addElement("Messing");
    cbWerkstoffModel.addElement("PVC");
    cbWerkstoff.setBackground(Color.WHITE);
    cp.add(cbWerkstoff);
    
    cp.setBackground(new Color(0xC0C0C0));

    setJMenuBar(jMenuBar1);
    jMenuBar1.setBorderPainted(true);

    listVorschlag2ScrollPane.setBounds(370, 500, 250, 150);
    listVorschlag2.setModel(listVorschlag2Model);
    listVorschlag2Model.addElement("Norm: "+variableNorm);
    listVorschlag2Model.addElement("Hersteller: "+variableHer);
    listVorschlag2Model.addElement("Anwendung: "+variableAnw);
    listVorschlag2Model.addElement("Radius: "+variableRad);
    listVorschlag2Model.addElement("Schnittgeschw.: "+variableVc);
    listVorschlag2Model.addElement("Vorschub: "+variableF);
    listVorschlag2Model.addElement("Zustellung: "+variableAp);
    cp.add(listVorschlag2ScrollPane);
    listvorschlag3ScrollPane.setBounds(670, 500, 250, 150);
    listvorschlag3.setModel(listvorschlag3Model);
    listvorschlag3Model.addElement("Norm: "+variableNorm);
    listvorschlag3Model.addElement("Hersteller: "+variableHer);
    listvorschlag3Model.addElement("Anwendung: "+variableAnw);
    listvorschlag3Model.addElement("Radius: "+variableRad);
    listvorschlag3Model.addElement("Schnittgeschw.: "+variableVc);
    listvorschlag3Model.addElement("Vorschub: "+variableF);
    listvorschlag3Model.addElement("Zustellung: "+variableAp);
    cp.add(listvorschlag3ScrollPane);
    lVorschlag2.setBounds(370, 460, 250, 22);
    lVorschlag2.setText("Vorschlag 2");
    lVorschlag2.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
    cp.add(lVorschlag2);
    lVorschlag3.setBounds(670, 460, 250, 22);
    lVorschlag3.setText("Vorschlag 3");
    lVorschlag3.setFont(new Font("@HP Simplified Hans", Font.BOLD, 16));
    cp.add(lVorschlag3);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Test
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Test();
  } // end of main
  
  public void bSuchen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
             System.out.println("Hi");
  } // end of bSuchen_ActionPerformed

  // Ende Methoden
} // end of class Test