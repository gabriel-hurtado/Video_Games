package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Address;
import beans.Client;

public class AddressDao {
	
	public static List<Address> findAllAddressesByClientId(int clientId) {
	
		List<Address> addresses = new ArrayList<Address>();
		Connection cnx=null;
		try {
			try {
				cnx = ConnectionDB.getInstance().getCnx();
				//Requete
				String sql = "SELECT id, address_line, city, country, owner FROM address WHERE owner = ?";
				PreparedStatement ps = cnx.prepareStatement(sql);
				ps.setInt(1, clientId);
				
				//Execution et traitement de la r�ponse
				ResultSet res = ps.executeQuery();
				
				while(res.next()){
					addresses.add(new Address(res.getInt("id"),
							res.getString("address_line"),
							res.getString("city"),
							res.getString("country"),
							res.getInt("owner")));
				}
				
				res.close();
				//ConnectionDB.getInstance().closeCnx();
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addresses;
	}
	

	public static Address findById(int id) {

		Address u = null;
		
		Connection cnx=null;
		try {
			try {
				cnx = ConnectionDB.getInstance().getCnx();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//Requete
			String sql = "SELECT id, address_line, city, country, owner FROM address WHERE id = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			//Execution et traitement de la r�ponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				Address newAddress = new Address(res.getInt("id"),
						res.getString("address_line"),
						res.getString("city"),
						res.getString("country"),
						res.getInt("owner"));
				
				u = newAddress;
				break;
			}
			
			res.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
}
