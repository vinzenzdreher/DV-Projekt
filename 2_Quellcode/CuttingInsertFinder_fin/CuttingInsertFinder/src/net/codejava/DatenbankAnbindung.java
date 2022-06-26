package net.codejava;
import java.sql.Connection;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;

/** Die Klasse DatenbankAnbindung stellt die Verbindung zur Acces-Datei her und ueberprueft ob diese im angegeben Pfad existiert
 * @author Leon Nopper
 * @author Vinzenz Dreher
 * @author Ingo Steinert
 * @author Robin Hofmann
 * @author Michel Schaenzle
 * @version 1.0
 * @since 20.06.2022*/

 public class DatenbankAnbindung {
	public  Connection con;
	private  String databaseurl;
	private  String dbpfad;
	private  String dbverz; 
	private  String dbname;
	
	
/**Methode um die Datenbank(Database1) aus dem Quellordner in ein Verzeichniss zu kopieren, um anschliessend
 * die Verbindung zu dieser Datenbank aufzubauen 
 * @return Connection*/
    public Connection ConnectDB(){
       
        	dbverz = "c:/DatenbankCuttingInsertFinder";
        	File f = new File(dbverz);
        	if(!f.exists())
        		f.mkdir();
        	dbname = "Database1.accdb";
        	dbpfad = dbverz +"/"+dbname;
        	File f2 = new File(dbpfad);
        	if(!f2.exists()) {
        		InputStream stream = DatenbankAnbindung.class.getResourceAsStream("database/"+dbname);
        		try {
        			Files.copy(stream,f2.toPath(),StandardCopyOption.REPLACE_EXISTING);	
        		}
        	catch(IOException e) {
        		e.printStackTrace();
        		
        	}
        	}
        		
        	databaseurl = "jdbc:ucanaccess://"+dbpfad;
        	try {
        		 con = DriverManager.getConnection(databaseurl);
        		
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        		
        	}
            return con; 
            
        }
        
           
        }
    


