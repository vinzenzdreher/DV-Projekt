package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class datenbank{
	private String databaseURL;
	private String material;
	private String beaumfang;
	private String abfrage;
	private int a; 
	private String radius;
	String iD = "keine Eingabe";
	String her = "keine Eingabe";
	String model = "keine Eingabe";
	String mat  = "keine Eingabe"; 
	String bear = "keine Eingabe";
	String rad = "keine Eingabe";
	String vc = "keine Eingabe";
	String f = "keine Eingabe";
	String ap = "keine Eingabe";
 	
	datenbank(String material1, String beaumfang1, String radius1){
		material1 = material;
		beaumfang1 = beaumfang;
		radius1 = radius;
		databaseURL = "jdbc:ucanaccess://Database1.accdb"; 
		//für TEST
		
	}
	public void getSchneidplatte() {
	
		String abfrage = "SELECT * FROM [Schneidplatten Datenbank] WHERE Material = '"+material+ "' AND Bearbeitungsumfang = '"+beaumfang+"'AND Radius = '"+radius+"'";
		
		
		try {
			System.out.println(abfrage);
			
				Connection con = DriverManager.getConnection(databaseURL);		//Verbindung
				System.out.println("Connected to  MS Access database");			
			
					Statement stm = con.createStatement();  //Statement bilden
						ResultSet rs = stm.executeQuery(abfrage);	//anlegen von Result set Art neue Tabelle mit den zutreffenden Inhalten
							ResultSetMetaData rsmd = rs.getMetaData();		
							int cols = rsmd.getColumnCount();		//bestimmen der größe der Tabelle 
							while(rs.next()) {
								iD = rs.getString(1);
								her = rs.getString(2);
								model = rs.getString(3);
								mat = rs.getString(5); 
								bear = rs.getString(8);
								rad = rs.getString(9);
								vc = rs.getString(4);
								f = rs.getString(6);
								ap = rs.getString(7);
								
								
								
								System.out.println();
								
													//Ausgabe
							}
							rs.close();					//ResultSet Schließen
									}
								catch (Exception e) {
										e.printStackTrace();
			
										}
	}

//public static void main(String[] args) {

	//datenbank one= new datenbank(); // TEST
	
	//one.getSchneidplatte();
}

