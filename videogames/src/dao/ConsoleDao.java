package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Console;

public class ConsoleDao {

	//find all consoles for a videogame
	public static List<Console> findAllById(int id) throws ClassNotFoundException{
		List<Console> consoles = new ArrayList<Console>();
		Connection cnx=null;
		try {
			cnx = ConnectionDB.getInstance().getCnx();
		
			//Request
			String sql = "select console from consolebelonging where videogame=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);

			//Execution and parsing 

			ResultSet res2 = ps.executeQuery();

			while(res2.next()){
				Console c = new Console(res2.getString("console"));
				consoles.add(c);
			}

			res2.close();
			//connection to be closed in calling class
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consoles;
	}

	

}
