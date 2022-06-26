package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.*;

import javax.swing.JOptionPane;

/** Die Klasse DatenbankZugriff filtert die Datenbank nach uebergebenen Parametern
 * @author Leon Nopper
 * @author Vinzenz Dreher
 * @author Ingo Steinert
 * @author Robin Hofmann
 * @author Michel Schaenzle
 * @version 1.0
 * @since 20.06.2022*/
 public class DatenbankZugriff{
	private String databaseURL;
	private String material;
	private String beaumfang;
	private String abfrage;
	private String radius;
	protected String[] iD;
	protected String[] her;
	protected String[] model;
	protected String[] mat; 
	protected String[] bear;
	protected String[] rad ;
	protected String[] vc ;
	protected String[] f;
	protected String[] ap ;
	public String kE;
	
	
/**Im Konstruktor werden die Uebergabeparameter aus der Benutzeroberflaeche GUI uebergeben und die Arrays mit "Keine Eingabe" initialisiert
 * @param material1 ausgewaehltes Material
 * @param beaumfang1 ausgewaehlter Bearbeitungsumfang
 * @param radius1 ausgewaehlter Radius*/
	DatenbankZugriff(String material1, String beaumfang1, String radius1){
		kE = new String ("Keine Eingabe");  
		iD = new String[] {kE,kE,kE};
		her = new String[]{kE,kE,kE};
		model = new String[]{kE,kE,kE};
		mat  = new String[]{kE,kE,kE};
		bear = new String[]{kE,kE,kE};
		rad = new String[]{kE,kE,kE};
		vc = new String[]{kE,kE,kE};
		f = new String[]{kE,kE,kE};
		ap = new String[]{kE,kE,kE};

		material = material1;
		beaumfang = beaumfang1;
		radius = radius1;
		databaseURL = "jdbc:ucanaccess://Database1.accdb"; 
		
	
		
		
	

	}
	
	

	
/**Die Methode getSchneidplatte() erstellt ein Objekt der Klasse DatenbankAnbindung und fuehrt 
 * die Methode ConnectDB() aus um auf die Datenbank zugreifen zu koennen. Weiterhin filtert diese die die Datenbank 
 * nach den Eingabeparametern und initialisiert passende Ergebnisse.*/
	public void getSchneidplatte() {
//**Filtern nach den geforderten Parametern */
		abfrage = "SELECT * FROM [Schneidplatten Datenbank] WHERE Material = '"+material+ "' AND Bearbeitungsumfang = '"+beaumfang+"'AND Radius = '"+radius+"'";

		try {
			
			DatenbankAnbindung database = new DatenbankAnbindung();//Objekt der Klasse DatenbankAnbindung wird erstellt und die Verbindung zur Datenbank hergestellt
			database.ConnectDB();
			Connection con1 = database.con;
			
			
			Statement stm = con1.createStatement();  				//Statement bilden
			ResultSet rs = stm.executeQuery(abfrage);				//anlegen von Result set Art neue Tabelle mit den zutreffenden Inhalten
		
//Schleife fuer das Speichern der herausgefilterten Parameter in Arrays 
			for(int i = 0; i<3; i++) {
				while(rs.next()) {

					iD[i] = rs.getString(9);
					her[i] = rs.getString(1);
					model[i] = rs.getString(2);
					mat[i] = rs.getString(4);
					bear[i] = rs.getString(7);
					rad[i] = rs.getString(8);
					vc[i] = rs.getString(3);
					f[i] = rs.getString(5);
					ap[i] = rs.getString(6);
					break;




				}
			
			}
			rs.close();
		}


		catch (Exception e) {
			e.printStackTrace();

		}
	}
	

}


