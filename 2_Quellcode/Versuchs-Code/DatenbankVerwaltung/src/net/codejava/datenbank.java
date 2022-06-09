package net.codejava;
import java.sql.*;
import java.util.*;
import java.lang.*;


public class datenbank {
	private String databaseURL;
	private String material;
	private String beaumfang;
	private String abfrage;
	private int a; 
	private String radius;
 	
	datenbank(){
		databaseURL = "jdbc:ucanaccess://Database1.accdb"; 
		//für TEST
		material = "Stahl";
		beaumfang = "Schlichten";
		radius = "0.4";
		
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
								for(int i=1; i<=cols; i++) {
									System.out.print(rs.getString(i)+ "\t");
									}
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

