package dao;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import beans.Videogame;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Videogame> lp = null;

		try (Connection connection = (Connection) ConnectionDB.getInstance().getCnx()) {
		    System.out.println("Database connected!");
		    lp = VideogamesDao.findAll();
		    Videogame videogame = (Videogame) lp.get(0);
		    System.out.println(videogame.getTitle());
		    System.out.println(videogame.getPrice());
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
