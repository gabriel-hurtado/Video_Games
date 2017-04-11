package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Videogame;

public class VideogamesDao {

	public static List<Videogame> findAll() throws ClassNotFoundException {


		List<Videogame> videoGamesList = new ArrayList<Videogame>();
		Connection cnx=null;
		try {
			cnx = ConnectionDB.getInstance().getCnx();

			//SQL request
			String sql = "SELECT id,title,price FROM videogame";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution and request parsing
			ResultSet res = ps.executeQuery();
				
			while(res.next()){
				videoGamesList.add(new Videogame(res.getInt("id"), res.getString("title"), res.getFloat("price")));
			}
			
			res.close();
			ConnectionDB.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return videoGamesList;
	}
	
	public static Videogame find(int id) throws ClassNotFoundException {

		Videogame videoGame = null;

		Connection cnx=null;
		try {
			cnx = ConnectionDB.getInstance().getCnx();
		
			//Request
			String sql = "SELECT id,title,price FROM videogame WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);

			//Execution and parsing 

			ResultSet res = ps.executeQuery();

			while(res.next()){
				videoGame = new Videogame(res.getInt("id"), res.getString("title"), res.getFloat("price"));
			}

			res.close();
			ConnectionDB.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return videoGame;
	}
		
}
