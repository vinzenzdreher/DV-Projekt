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
 	
	datenbank(String material, String beaumfang, String radius){
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
								variableID = rs.getString(1);
								variableHer = rs.getString(2);
								variableModel = rs.getString(3);
								variableMat = rs.getString(5); 
								variableBear = rs.getString(8);
								variableRad = rs.getString(9);
								variableVc = rs.getString(4);
								variableF = rs.getString(6);
								variableAp = rs.getString(7);
								
								
								
								System.out.println();
								
													//Ausgabe
							}
							rs.close();					//ResultSet Schließen
									}
								catch (Exception e) {
										e.printStackTrace();
			
										}
	}

public static void main(String[] args) {

	//datenbank one= new datenbank(); // TEST
	
	//one.getSchneidplatte();
}
}
