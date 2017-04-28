package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Gametype;

public class GameTypeDao {

	//find all consoles for a videogame
	public static List<Gametype> findAllById(int id) throws ClassNotFoundException{
		List<Gametype> types = new ArrayList<Gametype>();
		Connection cnx=null;
		try {
			cnx = ConnectionDB.getInstance().getCnx();
		
			//Request
			String sql = "select gametype from gametyping where videogame=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);

			//Execution and parsing 

			ResultSet res = ps.executeQuery();

			while(res.next()){
				Gametype g = new Gametype(res.getString("gametype"));
				types.add(g);
			}

			res.close();
			//connection to be closed in calling class
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return types;
	}

	

}
