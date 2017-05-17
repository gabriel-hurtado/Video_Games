package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Client;
import beans.Address;
import dao.AddressDao;


public class ClientDao {
	
	public static List<Client> findAll() {
	
		List<Client> cu = new ArrayList<Client>();
		Connection cnx=null;
		try {
			try {
				cnx = ConnectionDB.getInstance().getCnx();
				//Requete
				String sql = "SELECT id, username, password FROM client";
				PreparedStatement ps = cnx.prepareStatement(sql);
				
				//Execution et traitement de la r�ponse
				ResultSet res = ps.executeQuery();
						
				while(res.next()) {
					int clientId = res.getInt("id");
					List<Address> addresses = AddressDao.findAllAddressesByClientId(clientId);
					Client newClient = new Client(res.getString("username"),
							clientId,
							res.getString("password"),
							addresses);
					
					cu.add(newClient);
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
	
	
	public static Client findClientByUsernameAndPassword(int id) {

		Client u = null;
		
		Connection cnx=null;
		try {
			try {
				cnx = ConnectionDB.getInstance().getCnx();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//Requete
			String sql = "SELECT username, password FROM client WHERE id = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			//Execution et traitement de la r�ponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				int clientId = id;
				List<Address> addresses = AddressDao.findAllAddressesByClientId(clientId);
				Client newClient = new Client(res.getString("username"),
						clientId,
						res.getString("password"),
						addresses);
				
				u = newClient;
				break;
			}
			
			res.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static Client findById(int id) {

		Client u = null;
		
		Connection cnx=null;
		try {
			try {
				cnx = ConnectionDB.getInstance().getCnx();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//Requete
			String sql = "SELECT username, password FROM client WHERE id = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			//Execution et traitement de la r�ponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				int clientId = id;
				List<Address> addresses = AddressDao.findAllAddressesByClientId(clientId);
				Client newClient = new Client(res.getString("username"),
						clientId,
						res.getString("password"),
						addresses);
				
				u = newClient;
				break;
			}
			
			res.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	
}
