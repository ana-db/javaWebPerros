package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioDeportesController
 */
@WebServlet("/formulariodeportes")
public class FormularioDeportesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
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
		
		//1. recibimos los parámetros del formulario:
		String nombre = request.getParameter("nombre");
		//String email = request.getParameter("email");
		
		String vista ="";
		
		//2. lógica de negocio:
		
		//3. enviamos datos a la vista:
		request.setAttribute("nombre", nombre);
		vista = "/privado/resumenFormulario.jsp";
		
		//4. vamos al JSP:
		//request.getRequestDispatcher("/privado/resumenFormulario.jsp").forward(request, response);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		//SIEMPRE que hagamos una REDIRECCIÓN es necesario usar el GETCONTEXTPATH():
		String base = request.getContextPath(); //nos da el contexto de este proyecto
//		response.sendRedirect(base + vista); //así evitamos que en la url aparezca la web que envía la response
	}

}
