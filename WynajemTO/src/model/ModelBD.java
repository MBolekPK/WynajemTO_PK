package model;

import java.sql.*;
import java.util.*;

import typy.WierszOplaty;
import typy.WierszNajemne;
import model.AktualneDane;


public class ModelBD extends Observable{
        private static final String url 		= "jdbc:mysql://localhost:3306/";	//adres plus port standardowy przy XAMP'ie
        private static final String user 		= "root";							//urzytkownik, koniecznie admin
        private static final String password	= "";								//haslo
        private static final String dataBase 	= "wynajem";	//nazwa bazy danych
        
        protected static ResultSet res;
        protected static Connection con;
        protected static Statement stt;
        
        public static void conection(){
	        try
	        {
	        	
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = DriverManager.getConnection(url, user, password);	            
	            stt = con.createStatement();
	            stt.execute("USE " + dataBase);
 
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
        
        public static void close()  
        {

        		try {
        			stt.close();
        			con.close();
        		} catch (SQLException e) 
        		{
        			e.printStackTrace();
        		}
        	
        }
        
        public void start(){
	        try
	        {
	        	boolean czyIstnieje = false;
	        	
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = DriverManager.getConnection(url, user, password);	            
	            stt = con.createStatement();         
	            res = con.getMetaData().getCatalogs();
	            
	            while(res.next()){
	            String catalogs = res.getString(1);
	            if(dataBase.equals(catalogs)) {
	            	czyIstnieje = true;
	            };
	            
	            if (!czyIstnieje)
	            {
	            	stt.execute("CREATE DATABASE "+dataBase);
	            	stt.execute("USE "+dataBase);
	            	stt.execute("CREATE TABLE Oplaty"
	            			+ "("
	            			+ "Id int(11) NOT NULL AUTO_INCREMENT, "
	            			+ "Data varchar(55) NOT NULL, "
	            			+ "Opis varchar(155) NOT NULL, "
	            			+ "TerminPlatnosci varchar(55) NOT NULL, "
	            			+ "NrFaktury varchar(55) NOT NULL, "
	            			+ "Kwota double(7,2) NOT NULL, "
	            			+ "StanAdministrator BOOLEAN NOT NULL DEFAULT 0, "
	            			+ "DataOplaceniaAdministrator varchar(55) NULL, "
	            			+ "StanWynajmujacy BOOLEAN NOT NULL DEFAULT 0, "
	            			+ "DataOplaceniaWynajmujacy varchar(55) NULL,"
	            			+ "PRIMARY KEY(Id)"
	            			+ ");");
	            	stt.execute("CREATE TABLE Najemne"
	            			+ "("
	            			+ "Id int(11) NOT NULL AUTO_INCREMENT, "
	            			+ "Data varchar(55) NOT NULL, "
	            			+ "Opis varchar(155) NOT NULL, "
	            			+ "TerminPlatnosci varchar(55) NOT NULL, "
	            			+ "Kwota double(7,2) NOT NULL, "
	            			+ "Stan BOOLEAN NOT NULL DEFAULT 0,"
	            			+ "DataOplacenia varchar(55) NULL, "
	            			+ "PRIMARY KEY(Id)"
	            			+ ");");
	            }
	            }
	        }catch (Exception e)
	        {
	           // e.printStackTrace();
	        }
	        close();
	        update();
	    }
        
        public void dodajOplate(WierszOplaty wo){
        	conection();
        	try {
        		stt.execute("INSERT INTO Oplaty ("
        				+ "Data, Opis, TerminPlatnosci, NrFaktury, Kwota, "
        				+ "StanAdministrator, DataOplaceniaAdministrator, "
        				+ "StanWynajmujacy, DataOplaceniaWynajmujacy) "
        				+ "VALUES ("
        				+ wo.getData()+", "+wo.getOpis()+", "+wo.getTerminPlatnosci()+", "
        				+ wo.getNrFaktury()+", "+wo.getKwota()+", "+(wo.getStanAdministrator()==true?1:0)+", "
        				+ (wo.getDataOplaceniaAdministrator().equals("")?"NULL":wo.getDataOplaceniaAdministrator())+", "+(wo.getStanWynajmujacy()==true?1:0)+", "
        				+ (wo.getDataOplaceniaWynajmujacy().equals("")?"NULL":wo.getDataOplaceniaWynajmujacy())+");");
        	} catch (SQLException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	close();
        	update();
        }
        
        public void usunOplate(int i)
        {
        	conection();
        	try {
        		stt.execute("DELETE FROM Oplaty WHERE id = "+i+";");
        	} catch (SQLException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	close();
        	update();
        }
        
        public void modyfikujOplate(WierszOplaty wo)
        {
        	conection();
        	try {
        		stt.execute("UPDATE Oplaty SET "
        				+ "Data = "+wo.getData()+", "
        				+ "Opis = "+wo.getOpis()+", "
        				+ "TerminPlatnosci = "+wo.getTerminPlatnosci()+", "
        				+ "NrFaktury = "+ wo.getNrFaktury()+", "
        				+ "Kwota = "+wo.getKwota()+", "
        				+ "StanAdministrator = "+(wo.getStanAdministrator()==true?1:0)+", "
        				+ "DataOplaceniaAdministrator = "+(wo.getDataOplaceniaAdministrator().equals("")?"NULL":wo.getDataOplaceniaAdministrator())+", "
        				+ "StanWynajmujacy = "+(wo.getStanWynajmujacy()==true?1:0)+", "
        				+ "DataOplaceniaWynajmujacy = "+ (wo.getDataOplaceniaWynajmujacy().equals("")?"NULL":wo.getDataOplaceniaWynajmujacy())+" WHERE Id = "
        				+ wo.getId()+";");
        				
        				
        	} catch (SQLException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	close();
        	update();
        }
        
        public void dodajNajemne(WierszNajemne wn)
        {
        	conection();
        	try {
        		stt.execute("INSERT INTO Najemne ("
        				+ "Id, Data, Opis, TerminPlatnosci, Kwota, "
        				+ "Stan, DataOplacenia) "
        				+ "VALUES ("
        				+ wn.getId()+", "+wn.getData()+", "+wn.getOpis()+", "+wn.getTerminPlatnosci()+", "
        				+ wn.getKwota()+", "+(wn.getStan()==true?1:0)+", "
        				+ (wn.getDataOplacenia().equals("")?"NULL":wn.getDataOplacenia())+");");
        	} catch (SQLException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	close();
        	update();
        }
        
        public void usunNajemne(int i)
        {
        	conection();
        	try {
        		stt.execute("DELETE FROM Najemne WHERE id = "+i+";");
        	} catch (SQLException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	close();
        	update();
        }
        
        public void modyfikujNajemne(WierszNajemne wn)
        {
        	conection();
        	try {
        		stt.execute("UPDATE Najemne SET "
        				+ "Data = "+wn.getData()+", "
        				+ "Opis = "+wn.getOpis()+", "
        				+ "TerminPlatnosci = "+wn.getTerminPlatnosci()+", "
        				+ "Kwota = "+wn.getKwota()+", "
        				+ "Stan = "+(wn.getStan()==true?1:0)+", "
        				+ "DataOplacenia = "+(wn.getDataOplacenia().equals("")?"NULL":wn.getDataOplacenia())+" WHERE Id = "
        				+ wn.getId()+";");
        	} catch (SQLException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	close();
        	update();
        }
        
        public void update()
        {
        	conection();
        	try {
        		ArrayList<WierszOplaty> listaOplat = new ArrayList<WierszOplaty>();
        		ArrayList<WierszNajemne> listaNajemnego = new ArrayList<WierszNajemne>();
        		
        		res = stt.executeQuery("SELECT * FROM Oplaty");
        		while(res.next())
        		{
        			listaOplat.add(new WierszOplaty(res.getInt("Id"),
        											res.getString("Data"),
        											res.getString("Opis"),
        											res.getString("TerminPlatnosci"),
        											res.getString("NrFaktury"),
        											res.getDouble("Kwota"),
        											res.getBoolean("StanAdministrator"),
        											res.getString("DataOplaceniaAdministrator"),
        											res.getBoolean("StanWynajmujacy"),
        											res.getString("DataOplaceniaWynajmujacy")));
        		}
        		AktualneDane.listaOplat = listaOplat;
        		
        		res = stt.executeQuery("SELECT * FROM Najemne");
        		while(res.next())
        		{
        			listaNajemnego.add(new WierszNajemne(res.getInt("Id"),
														 res.getString("Data"),
														 res.getString("Opis"),
														 res.getString("TerminPlatnosci"),
														 res.getDouble("Kwota"),
														 res.getBoolean("Stan"),
														 res.getString("DataOplacenia")));
        		}
        		AktualneDane.listaNajemnego = listaNajemnego;
        		
        		res = stt.executeQuery("SELECT SUM(Kwota) AS ZaleglosciAdministrator FROM Oplaty WHERE StanAdministrator = 0;");
        		while(res.next()){
        			AktualneDane.zaleglosciAdministrator = res.getDouble("ZaleglosciAdministrator");
        		}
        		
        		double a = 0;
        		res = stt.executeQuery("SELECT SUM(Kwota) AS ZaleglosciWynajmujacy FROM Oplaty WHERE StanWynajmujacy = 0;");
        		while(res.next()){
        			a = res.getDouble("ZaleglosciWynajmujacy");
        			AktualneDane.zaleglosciWynajmujacy = a;
        		}
        		
        		double b = 0;
        		res = stt.executeQuery("SELECT SUM(Kwota) AS ZaleglosciNajemne FROM Najemne WHERE Stan = 0;");
        		while(res.next()){
        			b = res.getDouble("ZaleglosciNajemne");
        			AktualneDane.zaleglosciNajemne = b;
        		}
        		
        		AktualneDane.zaleglosciCalkowite = (a+b);
        	} catch (SQLException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	close();
        	
        	setChanged();
        	notifyObservers();
        }
}
