package com.ipartek.formacion.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("usuarioLogeado");
		session.invalidate(); //cerramos la sesión
		session = null; 
		
		//request.getRequestDispatcher("index.jsp").forward(request, response); //enviamos a la página de inicio para volver a loggearse
		String mensaje="gracias por visitarnos";
		//SIEMPRE que hagamos una REDIRECCIÓN es necesario usar el GETCONTEXTPATH():
		String base = request.getContextPath(); //nos da el contexto de este proyecto
		response.sendRedirect(base + "/login.jsp?mensaje=" + URLEncoder.encode(mensaje, "UTF-8")); //URLEncoder.encode incluyte en la url el mensaje 
	}

}
