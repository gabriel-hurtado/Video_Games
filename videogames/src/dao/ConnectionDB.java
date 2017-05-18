package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class ConnectionDB {

	private static volatile ConnectionDB instance;
	private Connection cnx; 
	
	private ConnectionDB() throws ClassNotFoundException {
		try {
			
			// Properties p = new Properties();
			//p.load(Thread.currentThread().getContextClassLoader().
					//	getResourceAsStream("confBDD.properties"));
			
			
				
			//chargement du driver
			//Class.forName(p.getProperty("driver"));
			//cnx = DriverManager.getConnection(p.getProperty("url"),
				//	p.getProperty("user"), p.getProperty("pwd"));
			Class.forName("com.mysql.jdbc.Driver");  
			cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogames","root","root");
			
			//String url = "jdbc:mysql://localhost:3306/sr03";
			//String username = "root";
			//String password = "root";

			//System.out.println("Connecting database...");

			//cnx = (Connection) DriverManager.getConnection(url, username, password);
			//System.out.println("Database connected!");
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}/*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	} 
	
	public static synchronized ConnectionDB getInstance() throws ClassNotFoundException {
		if(instance==null)
			instance = new ConnectionDB();
		
		return instance;
	}

	public Connection getCnx() {
		return cnx;
	}

	public void closeCnx() throws SQLException{
		if(cnx!=null){
			cnx.close();
			instance=null;
		}
	}
}
