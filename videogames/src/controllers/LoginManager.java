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
@WebServlet("/LoginManager")
public class LoginManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients= ClientDao.findAll();
		Gson gson = new Gson();
		response.getWriter().append(gson.toJson(clients));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("userPassword");
			
		int clientId = ClientDao.findClientByUsernameAndPassword(username, password);
		if(clientId == -1) {
			//invalid credentials
			response.sendError(401,"Wrong credentials...");
		} else {
			Gson gson = new Gson();
			response.getWriter().append(gson.toJson(clientId));
		}
	}
}
