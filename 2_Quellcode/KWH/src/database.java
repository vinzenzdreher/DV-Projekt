import java.sql.*;
public class database {

	private String databaseURL;
	private String material; 
	private String beaumfang;
	private double radius; 
	private String abfrage;
	private int a;
	
	
	database() {
		databaseURL = "jdbc:ucanaccess://Database1.accdb";
		a=1;
		//Für Test:
		material = "Stahl";
		beaumfang= "Schlichten";
		radius= 0.4;

		}
	
	public void getSchneidplatte() {
		String abfrage = "SELECT * FROM Database1 WHERE Material = material AND RADIUS = radius AND Bearbeitungsumfang = beaumfang";	
		try {
			Connection con = DriverManager.getConnection(databaseURL);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(abfrage);
			while (rs.next()) {
				System.out.println(rs.getString(a));
				a++;
				if (a==3) {
					break;
				}
			}//eow
			
	}//oft
	catch (Exception e) {
		e.printStackTrace();
	}//ofc
		}//ofm
	
	public static void main(String[] args) {
		
		database one= new database();
		one.getSchneidplatte();

	}

}
