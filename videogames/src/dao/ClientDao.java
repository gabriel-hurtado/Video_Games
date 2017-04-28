package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Client;

public class ClientDao {

//	public static int insert(Client c) throws ClassNotFoundException {
//		int res = 0;
//				
//		Connection cnx=null;
//		try {
//			cnx = ConnexionBDD.getInstance().getCnx();
//			
//			//Requete
//			String sql = "INSERT INTO client(username,password,adress) " +
//					"VALUES(?,?,?)";
//			//solve adress issue
//			PreparedStatement ps = cnx.prepareStatement(sql);
//			ps.setString(1, c.getNom());
//			
//			
//			
//			//Execution et traitement de la r�ponse
//			res = ps.executeUpdate();
//			
//			ConnectionDB.getInstance().closeCnx();			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return res;
//	}
	
	public static List<Client> findAll() {
	
		List<Client> cu = new ArrayList<Client>();
		Connection cnx=null;
		try {
			try {
				cnx = ConnectionDB.getInstance().getCnx();
				//Requete
				String sql = "SELECT id,username,password FROM client";
				PreparedStatement ps = cnx.prepareStatement(sql);
				
				//Execution et traitement de la r�ponse
				ResultSet res = ps.executeQuery();
				
				while(res.next()){
					cu.add(new Client(res.getString("username"),
							res.getInt("id"),
							res.getString("password")));
				}
				
				res.close();
				ConnectionDB.getInstance().closeCnx();
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cu;
	}
	
	public static Client find(int id) {


		Client u = null;
		
		Connection cnx=null;
		try {
			try {
				cnx = ConnectionDB.getInstance().getCnx();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,nom,tel,username,pwd FROM utilisateurs WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//Execution et traitement de la r�ponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				u = new Client(res.getString("username"),
						res.getInt("id"),
						res.getString("password"));
				break;
			}
			
			res.close();
			try {
				ConnectionDB.getInstance().closeCnx();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return u;
	}
	
	public static int delete(int id) throws ClassNotFoundException {
		int res = 0;
		Connection cnx=null;
		try {
			cnx = ConnectionDB.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql = "DELETE FROM client WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnectionDB.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	
	
}
