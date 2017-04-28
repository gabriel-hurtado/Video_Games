package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Console;
import beans.Videogame;

public class VideogamesDao {

	public static List<Videogame> findAll() throws ClassNotFoundException, SQLException {

		ResultSet res =null;
		PreparedStatement ps = null;
		
		List<Videogame> videoGamesList = new ArrayList<Videogame>();
		Connection cnx=null;
		try {
			cnx = ConnectionDB.getInstance().getCnx();

			//SQL request
			String sql = "SELECT id,title,price FROM videogame";
			ps = cnx.prepareStatement(sql);
			
			//Execution and request parsing
			res = ps.executeQuery();
				
			while(res.next()){
				int id=res.getInt("id");
				String title=res.getString("title");
				Float price=res.getFloat("price");
				Videogame g=new Videogame(id,title,price);
				List<Console> consoles= ConsoleDao.findAllById(g.getId());
				g.setConsole(consoles);
				videoGamesList.add(g);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			res.close();
			ConnectionDB.getInstance().closeCnx();		
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
