import java.sql.*;
import java.util.*;
import java.lang.*;

public class database {

	private String databaseURL;
	private String material; 
	private String beaumfang;
	private double radius; 
	private String abfrage;
	private int a;



	database() {
		databaseURL = "jdbc:ucanaccess://Database1.accdb"; //"jdbc:ucanaccess://C://Users//ingo-//eclipse-workspace//KWH//Database1.accdb"; //"jdbc:ucanaccess:..//Database1.accdb";
		a=1;
		//Für Test:
		material = "Stahl";
		beaumfang= "Schlichten";
		radius= 0.4;
		
	}

	public void getMyExecutionPath()
	{	
		try{
			String executionPath = System.getProperty("user.dir");
			System.out.println("Executing at =>"+executionPath.replace("\\", "/"));
		}catch (Exception e){
			System.out.println("Exception caught ="+e.getMessage());
		}
	}

	
	public void getSchneidplatte() {
		//String abfrage = "SELECT * FROM [Schneidplatten Datenbank] WHERE [Material] = material AND RADIUS = radius AND Bearbeitungsumfang = beaumfang";	
		String abfrage= String.format("Select [ID], [Hersteller], [Modell] from [Schneidplatten Datenbank] where [Material] = '%s' ", 
				material);
//		String abfrage= String.format("Select [ID], [Hersteller] from [Schneidplatten Datenbank] where [Material] = '%s' AND Bearbeitungsumfang = %2.2f", 
//				material, beaumfang);
		
		
		
		try {
			System.out.println(abfrage);
			
			Connection con = DriverManager.getConnection(databaseURL);
			System.out.println("Connected to  MS Access database");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(abfrage);
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.println();
				//a++;
				//if (a==3) {
				//	break;
				//}
			}//eow

		}//oft
		catch (Exception e) {
			e.printStackTrace();
		}//ofc
	}//ofm

	public static void main(String[] args) {

		database one= new database();
		one.getMyExecutionPath();
		one.getSchneidplatte();

	}

}
