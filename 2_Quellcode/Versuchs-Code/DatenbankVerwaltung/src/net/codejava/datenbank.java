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
	public StringBuffer iD;
	protected StringBuffer her;
	protected StringBuffer model;
	protected StringBuffer mat; 
	protected StringBuffer bear;
	protected StringBuffer rad ;
	protected StringBuffer vc ;
	protected StringBuffer f;
	protected StringBuffer ap ;
 	
	datenbank(String material1, String beaumfang1, String radius1){
		  iD = new StringBuffer("keine Eingabe");
		 her = new StringBuffer("keine Eingabe");
		 model = new StringBuffer("keine Eingabe");
		 mat  = new StringBuffer("keine Eingabe");
		 bear = new StringBuffer("keine Eingabe");
		 rad = new StringBuffer("keine Eingabe");
		 vc = new StringBuffer("keine Eingabe");
		 f = new StringBuffer("keine Eingabe");
		 ap = new StringBuffer("keine Eingabe");
		material = material1;
		beaumfang = beaumfang1;
		radius = radius1;
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
								//for(int i = 1; i<= cols; i++) {
								//System.out.print(rs.getString(i)+ "\t");
								
								//}
								iD.replace(0, 13,rs.getString(9));
								her.replace(0, 13, rs.getString(1));
								model.replace(0, 13, rs.getString(2));
								mat.replace(0, 13, rs.getString(4)) ; 
								bear.replace(0, 13, rs.getString(7)) ;
								rad.replace(0, 13, rs.getString(8)) ;
								vc.replace(0, 13, rs.getString(3));
								f.replace(0, 13, rs.getString(5)) ;
								ap.replace(0, 13, rs.getString(6));
								
							}
								
								//System.out.println(her);
								
													//Ausgabe
							
							rs.close();					//ResultSet Schließen
									}
								catch (Exception e) {
										e.printStackTrace();
			
										}
	}

public static void main(String[] args) {

	datenbank one= new datenbank("Titan","Schruppen","1.2"); // TEST
	
	one.getSchneidplatte();
}
}


