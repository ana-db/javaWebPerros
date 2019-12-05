package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. recibir parámetros:
		String nombre = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		
		String vista="";
		
		//2. lógica de negocio:
			
		//recuperar sesión del usuario == browser
		HttpSession session = request.getSession();
		session.setAttribute("usuarioLogeado", nombre); //guarda 1 atributo  de la sesión
		session.setMaxInactiveInterval(60); //5 seg (60*5*24*7) -  -1 nunca caduca
	
		//request.getRequestDispatcher("login.jsp").forward(request, response);
		vista = "login.jsp";
		
		//ir a JSP:
		request.getRequestDispatcher(vista).forward(request, response);
	}

}
