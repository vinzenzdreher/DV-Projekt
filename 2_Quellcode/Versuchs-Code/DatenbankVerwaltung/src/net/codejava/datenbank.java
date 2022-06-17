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
	private String radius;
	public String[] iD;
	protected String[] her;
	protected String[] model;
	protected String[] mat; 
	protected String[] bear;
	protected String[] rad ;
	protected String[] vc ;
	protected String[] f;
	protected String[] ap ;
	protected String kE;
	String[] test = new String[3];

	datenbank(String material1, String beaumfang1, String radius1){
		kE = "keine Eingabe";  
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
		//f�r TEST

	}
	public void getSchneidplatte() {

		abfrage = "SELECT * FROM [Schneidplatten Datenbank] WHERE Material = '"+material+ "' AND Bearbeitungsumfang = '"+beaumfang+"'AND Radius = '"+radius+"'";


		try {
			System.out.println(abfrage);

			Connection con = DriverManager.getConnection(databaseURL);		//Verbindung
			System.out.println("Connected to  MS Access database");			

			Statement stm = con.createStatement();  //Statement bilden
			ResultSet rs = stm.executeQuery(abfrage);	//anlegen von Result set Art neue Tabelle mit den zutreffenden Inhalten
			ResultSetMetaData rsmd = rs.getMetaData();		
			int cols = rsmd.getColumnCount();		//bestimmen der gr��e der Tabelle 


			for(int i = 0; i<3; i++) {
				while(rs.next()) {

					//test[i]= rs.getString(9);
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


