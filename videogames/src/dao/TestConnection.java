package dao;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Connection connection = (Connection) ConnectionDB.getInstance().getCnx()) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
