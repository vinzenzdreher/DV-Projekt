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

 class DatenbankAnbindung {
	public  Connection con;
	private  String databaseurl;
	private  String dbpfad;
	private  String dbverz; 
	private  String dbname;
	
	

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
    


