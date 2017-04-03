package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;


import dao.UtilisateursDao;

/**
 * Servlet implementation class GestionUsers
 */
@WebServlet("/GestionUsersPagines")
public class GestionUsersPagines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUsersPagines() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page")); 
		
		
		//recuperer une liste d'utilisateurs de start et pour nbelts 
		
		
		int nbElts = 2;
		//int start = (page*nbElts)-1;
		int start = (page-1)*nbElts;
		
		int countUsers = UtilisateursDao.countUsers();
		boolean suiv = (page*nbElts)<countUsers;
		System.out.println(countUsers);
		System.out.println(suiv);
		
		List<Utilisateur> lu = UtilisateursDao.findAll(start,nbElts);
		request.setAttribute("listeU",lu);
		request.setAttribute("page",page);
		request.setAttribute("suiv",suiv);
	
		
		
		// rediriger vers une page
		request.getRequestDispatcher("UsersListPagine.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String tel = request.getParameter("tel");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		Utilisateur u = new Utilisateur(0,nom,tel,username,pwd);
		String idStr = request.getParameter("id");
		if(idStr!=null && !idStr.trim().equals("")){
			u.setId(Integer.parseInt(idStr));
			try {
				UtilisateursDao.update(u);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				UtilisateursDao.insert(u);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("listeU", UtilisateursDao.findAll());
		request.getRequestDispatcher("UsersListPagine.jsp").forward(request,response);
		
		
	}

}
