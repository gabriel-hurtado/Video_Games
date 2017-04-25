package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Client;

import dao.ClientDao;

/**
 * Servlet implementation class ClientsManager
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Client> lu = ClientDao.findAll();
		int id = 0;
		String action = request.getParameter("action");
		//action will determine which method to trigger
		if (action != null) {
			// parsing the client id
			String idCh = request.getParameter("id");
			if (idCh != null) {
				try {
					id = Integer.parseInt(idCh);
				} catch (Exception e) {

				}
			}

			if (action.equals("delete")) {
				try {
					ClientDao.delete(id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (action.equals("modify")) {
				request.setAttribute("uModif", ClientDao.find(id));
			} else if (action.equals("sort")) {
				// will sort the list of client 
				// Collections.sort(lu);
			}
		}
		// recuperer une liste d'utilisateurs

		request.setAttribute("listeU", lu);

		// rediriger vers une page
		request.getRequestDispatcher("UsersList.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
	}

}