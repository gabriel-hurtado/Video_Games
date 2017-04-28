package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Console;
import beans.Gametype;
import beans.Orderline;
import beans.Orders;
import beans.Videogame;

public class OrdersDao {

	public static List<Orders> findAll() throws SQLException, ClassNotFoundException {
		ResultSet res =null;
		PreparedStatement ps = null;
		
		List<Orders> ordersList = new ArrayList<Orders>();
		Connection cnx=null;
		try {
			cnx = ConnectionDB.getInstance().getCnx();

			//SQL request
			String sql = "SELECT id,date,total,client,address FROM orders";
			ps = cnx.prepareStatement(sql);
			
			//Execution and request parsing
			res = ps.executeQuery();
				
			while(res.next()){
				int id=res.getInt("id");
				Date date=res.getDate("date");
				Float total=res.getFloat("total");
				int client=res.getInt("client");
				int adress=res.getInt("address");
				
				Orders o=new Orders(id,date,total,client,adress);
				
				List<Orderline> lines= OrderLineDao.findAllById(o.getId());
				o.setLines(lines);
				
				ordersList.add(o);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			res.close();
			ConnectionDB.getInstance().closeCnx();		
		}

		return ordersList;
	}

}
