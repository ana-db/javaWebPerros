package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashSet;

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
		String email = request.getParameter("email");
		String deportes[]=request.getParameterValues("deportes");
		String vista ="";
		
		//2. lógica de negocio:
		//3 deportes mínimo:
		if (deportes != null && deportes.length >= 3) { //ok, ha elegido al menos 3 deportes
			//3. enviamos datos a la vista:
			request.setAttribute("nombre", nombre);
			request.setAttribute("email", email);
			request.setAttribute("deportes", deportes);
			
			//4. vamos al JSP:
			request.getRequestDispatcher("privado/resumenFormulario.jsp").forward(request, response);
		}
		else { //si elige menos de 3
			//enviamos mensaje con info:
			request.setAttribute("nombre", nombre);
			request.setAttribute("mensaje", "Selecciona al menos 3 deportes");
			
			//4. le volvemos a enviar al formulario:
			request.getRequestDispatcher("privado/formulariodeportes.jsp").forward(request, response);
		}
		
		
		vista = "/privado/resumenFormulario.jsp";
		
		}

}
