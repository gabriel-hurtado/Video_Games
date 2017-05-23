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
import beans.Gametype;

public class VideogamesDao {

	public static List<Videogame> findAll() throws ClassNotFoundException, SQLException {

		ResultSet res =null;
		PreparedStatement ps = null;
		
		List<Videogame> videoGamesList = new ArrayList<Videogame>();
		Connection cnx=null;
		try {
			cnx = ConnectionDB.getInstance().getCnx();

			//SQL request
			String sql = "SELECT id,title,picture,price FROM videogame";
			ps = cnx.prepareStatement(sql);
			
			//Execution and request parsing
			res = ps.executeQuery();
				
			while(res.next()){
				int id=res.getInt("id");
				String title=res.getString("title");
				String picture = res.getString("picture");
				Float price=res.getFloat("price");
				// set new videogame using setters only
				Videogame g = new Videogame();
				g.setId(id);
				g.setTitle(title);
				g.setPrice(price);
				g.setPicture(picture);
				List<Console> consoles= ConsoleDao.findAllById(g.getId());
				g.setConsole(consoles);
				List<Gametype> types= GameTypeDao.findAllById(g.getId());
				g.setGametype(types);
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
			String sql = "SELECT id,title,picture,price FROM videogame WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);

			//Execution and parsing 

			ResultSet res = ps.executeQuery();

			while(res.next()){
				String title=res.getString("title");
				String picture=res.getString("picture");
				Float price=res.getFloat("price");
				// set new videogame using setters only
				Videogame g = new Videogame();
				g.setId(id);
				g.setTitle(title);
				g.setPrice(price);
				g.setPicture(picture);
				List<Console> consoles= ConsoleDao.findAllById(videoGame.getId());
				videoGame.setConsole(consoles);
				List<Gametype> types= GameTypeDao.findAllById(videoGame.getId());
				videoGame.setGametype(types);
			}

			res.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return videoGame;
	}
		
}
