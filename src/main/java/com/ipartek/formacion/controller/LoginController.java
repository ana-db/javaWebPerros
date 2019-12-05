package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String NOMBRE_USUARIO = "admin";
	public static final String PASSWORD_USUARIO = "admin";
	public static final String VISTA = "index.jsp";
       
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
		String idioma = request.getParameter("idioma");
		String recuerdame = request.getParameter("recuerdame");
		
				
		//2. lógica de negocio:
		if (NOMBRE_USUARIO.equalsIgnoreCase(nombre) & PASSWORD_USUARIO.equalsIgnoreCase(contrasena)) {
			
			//recuperar sesión del usuario == browser
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", nombre); //guarda 1 atributo  de la sesión
			session.setAttribute("idiomaLogeado", idioma);
			session.setMaxInactiveInterval(60); //5 seg (60*5*24*7) -  -1 nunca caduca
			
		}
		
		//ir a JSP:
		request.getRequestDispatcher(VISTA).forward(request, response);
	}

}