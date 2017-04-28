package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Client;
import beans.Address;
import com.google.gson.Gson;
import dao.ClientDao;
import dao.AddressDao;


/**
 * Servlet implementation class ClientManager
 */
@WebServlet("/ClientsManager")
public class ClientsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients= ClientDao.findAll();
		Gson gson = new Gson();
		response.getWriter().append("\nClient 3 : " + gson.toJson(clients));
		
		Address address = AddressDao.findById(1);
		gson = new Gson();
		response.getWriter().append("\n-----\n-----\nAddress 1 : " + gson.toJson(address));
		
		Client client = ClientDao.findById(3);
		gson = new Gson();
		response.getWriter().append("\n-----\n-----\nClient 3 : " + gson.toJson(client));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
