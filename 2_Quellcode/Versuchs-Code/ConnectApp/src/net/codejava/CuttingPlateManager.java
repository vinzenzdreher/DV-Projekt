package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CuttingPlateManager {
	
	private String databaseURL;
	private String material; 
	private String beaumfang;
	private String radius; 
	private String abfrage;
	private int a;
	
	
	
	
	CuttingPlateManager(){
		databaseURL = "jdbc:ucanaccess://cuttingplatedatabase.accdb" ;
		a=1;
		
	}
	public void getConnection(){
		try {
			
			Connection con = DriverManager.getConnection(databaseURL);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(abfrage);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void getSchneidplatte(){
	
		String abfrage = "SELECT * FROM cuttingplatedatabase WHERE Material = material AND Radius = radius AND Bearbeitungsumfang = beaumfang";
		getConnection();
		
		
		return;
		{
		while(rs.next()) {
			System.out.println(rs.getString(a));
			a++;
			if(a==3) {
				break;
			}
			
		}
		}
		
		
	}
	

public static void main(String[]args) {
	CuttingPlateManager cut1 = new CuttingPlateManager();
	cut1.getConnection();
	cut1.getSchneidplatte();
	
}}


		
	
