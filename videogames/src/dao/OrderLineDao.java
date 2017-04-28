package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Orderline;

public class OrderLineDao {

	public static List<Orderline> findAllById(int id) throws ClassNotFoundException {
		List<Orderline> lines = new ArrayList<Orderline>();
		Connection cnx=null;
		try {
			cnx = ConnectionDB.getInstance().getCnx();
		
			//Request
			String sql = "select videogame, quantity from orderline where order_id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);

			//Execution and parsing 

			ResultSet res = ps.executeQuery();

			while(res.next()){
				
				int videogameID=res.getInt("videogame");
			    int quantity=res.getInt("quantity");
			    Orderline g = new Orderline(VideogamesDao.find(videogameID),quantity);
				lines.add(g);
			}

			res.close();
			//connection to be closed in calling class
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
