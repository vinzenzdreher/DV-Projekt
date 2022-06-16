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
	public StringBuffer[] iD;
	protected StringBuffer[] her;
	protected StringBuffer[] model;
	protected StringBuffer[] mat; 
	protected StringBuffer[] bear;
	protected StringBuffer[] rad ;
	protected StringBuffer[] vc ;
	protected StringBuffer[] f;
	protected StringBuffer[] ap ;
	protected StringBuffer kE;
	String[] test = new String[3];
 	
	datenbank(String material1, String beaumfang1, String radius1){
		kE = new StringBuffer("keine Eingabe");  
		iD = new StringBuffer[] {kE,kE,kE};
		her = new StringBuffer[]{kE,kE,kE};
		model = new StringBuffer[]{kE,kE,kE};
		mat  = new StringBuffer[]{kE,kE,kE};
		bear = new StringBuffer[]{kE,kE,kE};
		rad = new StringBuffer[]{kE,kE,kE};
		vc = new StringBuffer[]{kE,kE,kE};
		f = new StringBuffer[]{kE,kE,kE};
		ap = new StringBuffer[]{kE,kE,kE};
		
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
							
							
						for(int i = 0; i<3; i++) {
							while(rs.next()) {
								 
								//test[i]= rs.getString(9);
								iD[i] = new StringBuffer(rs.getString(9));
								her[i] = new StringBuffer(rs.getString(1));
								model[i] = new StringBuffer(rs.getString(2));
								mat[i] = new StringBuffer(rs.getString(4));
								bear[i] = new StringBuffer(rs.getString(7));
								rad[i] = new StringBuffer(rs.getString(8));
								vc[i] = new StringBuffer(rs.getString(3));
								f[i] = new StringBuffer(rs.getString(5));
								ap[i] = new StringBuffer(rs.getString(6));
								//System.out.print(iD[i]);
								break;
								
								
								
								
								//System.out.println(iD[i]);
//								iD[i].replace(0,13,rs.getString(9));
//								System.out.println(her[i]);
//								her[i].replace(0, 13, rs.getString(1));
//								System.out.println(her[i]);
//								model[i].replace(0, 13, rs.getString(2));
//								System.out.println(her[i]);
//								mat[i].replace(0, 13, rs.getString(4)) ;
//								System.out.println(her[i]);
//								bear[i].replace(0, 13, rs.getString(7)) ;
//								System.out.println(her[i]);
//								rad[i].replace(0, 13, rs.getString(8)) ;
//								System.out.println(her[i]);
//								vc[i].replace(0, 13, rs.getString(3));
//								System.out.println(her[i]);
//								f[i].replace(0, 13, rs.getString(5)) ;
//								System.out.println(her[i]);
//								ap[i].replace(0, 13, rs.getString(6));
//								System.out.println(her[i]);
							}
							}
								
								//rs.close();					//ResultSet Schließen
//								System.out.println(iD[0]);
//								System.out.println(iD[1]);
//								System.out.println(iD[2]);	
		}
		
						
								catch (Exception e) {
										e.printStackTrace();
			
										}
	}

public static void main(String[] args) {

	datenbank one= new datenbank("Stahl","Schruppen","0.4"); // TEST
	
	one.getSchneidplatte();
}
}


