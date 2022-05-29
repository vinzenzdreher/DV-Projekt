package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CuttingPlateManager {

	public static void main(String[] args) {
		
		String databaseURL = "jdbc:ucanaccess://cuttingplatedatabase.accdb"; //Datenbank im Ordner des Projekts
		
		try {
			Connection connection = DriverManager.getConnection(databaseURL);	// try catch beim Verbindungsaufbau
			
			System.out.println("succesfully connected");
			
			connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
