import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Test {
	
	JLabel label1;
	JLabel label2;
	JButton button1;
	JPanel panel;
	JFrame frame;
	JComboBox box;
	int zähler = 0;
	String[] auswahl = {"bitte wählen!","Stahl","Messing", "Aluminium",};

	public Test() {
		frame = new JFrame();
		frame.setSize(500,500);
		frame.setTitle("My Test_GUI");
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		button1 = new JButton("Click me!");
		panel.add(button1);
		button1.setBounds(10,10,50,50);
		button1.addActionListener(new button1AL());
		
		
		label1 = new JLabel();
		label1.setText("that is awesome");
		panel.add(label1);
		
		box = new JComboBox(auswahl);
		box.setVisible(true);
		box.setSelectedIndex(0);
		box.addActionListener(new boxAL());
		box.setBounds(10,10,50,50);
		panel.add(box);
		
		label2 = new JLabel();
		label2.setText("Material: bitte wählen!");
		panel.add(label2);
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

	
	public class button1AL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		zähler++;
		label1.setText("that is awesome - it worked: "+zähler+" times!");
		}
	}

	public class boxAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==box) {
			JComboBox cb = (JComboBox)e.getSource();
			String wahl = (String)cb.getSelectedItem();
			label2.setText("Material: "+wahl);
		}
			
		
	}
	}
}
