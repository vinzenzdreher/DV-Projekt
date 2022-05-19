import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;


public class Test_v2 {
	
	JFrame frame;
	JButton b1;
	JMenuBar mb;
	JMenu datei;
	JMenu hilfe;
	JMenuItem neu;
	JMenuItem überUns;
	
	JComboBox box;

	public Test_v2 () {
		String[] auswahl = {"bitte wählen!","Automatenstahl","Messing", "Aluminium","Einsatzstahl","Vergütungsstahl","Werkzeugstahl"};

		JButton b1 = new JButton("Suche starten!");
		b1.setBounds(400,500,200,100);

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

	/*	neu.addActionListener(new neuML());*/
		überUns.addMenuKeyListener(new überUnsML());


		JComboBox box = new JComboBox(auswahl);
		box.setVisible(true);
		box.setSelectedIndex(0);
		/*box.addActionListener(new boxAL());*/
		box.setBounds(500,200,100,100);








		JFrame frame = new JFrame("Werkzeugauswahl");

		int frame_x = 1000; //Breite des Programmfensters in Pixel
		int frame_y = 700; //Höhe des Programmfensters in Pixel
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Bildschirmdimensionen in Pixeln holen
		frame.setBounds((screenSize.width-frame_x)/2, (screenSize.height-frame_y)/2, frame_x, frame_y);
		frame.setVisible(true);

		frame.setSize(1000,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Werkstattdolori3000");
		frame.setVisible(true);
		frame.setResizable(false);

		frame.add(b1);
		frame.add(box);
		frame.setJMenuBar(mb);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test_v2();
	}

	public class überUnsML implements MenuKeyListener{
			public void actionPerformed(ActionEvent e) {
				if (e = this.menuKeyPressed(e)) {
					JOptionPane.showMessageDialog(frame ,"Programm erstell von: Vinzenz Dreher, Ingo Steinert, Leon Nopper, Michel Schänzle, Robin Hofmann");
					System.out.println("S");
				}
			}
		}
	/*public class neuML implements MenuListener{
		public void menuSelected(MenuEvent e) {
			if (e.getSource()==überUns) {
				JOptionPane.showMessageDialog(frame ,"Programm erstell von: Vinzenz Dreher, Ingo Steinert, Leon Nopper, Michel Schänzle, Robin Hofmann");
				System.out.println("S");
			}
		}
	}*/
}
