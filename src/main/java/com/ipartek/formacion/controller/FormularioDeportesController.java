package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class FormularioDeportesController
 */
@WebServlet("/formulariodeportes")
public class FormularioDeportesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(LoginController.class);
       
    
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
		String sexo = request.getParameter("sexo");
		
		String vista ="";
		String mensaje ="";
		
		//try-catch después de recoger parámetros porque eso nunca va a fallar (con parse sí podría haber errores)
		try {
			//2. lógica de negocio: 
			//validaciones:
			
			//nombre:
			//if ("".equals(nombre)) {
			if (nombre == null) {
				mensaje = "Por favor, escribe tu nombre";
				request.setAttribute("mensaje", mensaje);
				
				//4. le volvemos a enviar al formulario:
				request.getRequestDispatcher("privado/formulariodeportes.jsp").forward(request, response);
			
			}
			else {
				request.setAttribute("nombre", nombre);
			}
			
			
			//email:
			//if ("".equals(email)) {
			if (email == null) {
				mensaje = "Por favor, escribe tu correo";
				request.setAttribute("mensaje", mensaje);
				
				//4. le volvemos a enviar al formulario:
				request.getRequestDispatcher("privado/formulariodeportes.jsp").forward(request, response);
			
			}
			else {
				request.setAttribute("email", email);
			}
			
			
			
			//3 deportes mínimo:
			if (deportes != null && deportes.length >= 3) { //ok, ha elegido al menos 3 deportes
				//3. enviamos datos a la vista:
				request.setAttribute("nombre", nombre);
				request.setAttribute("email", email);
				request.setAttribute("deportes", deportes);
				request.setAttribute("sexo", sexo);
				
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
		catch(Exception e) {
			LOG.error(e);
			request.getRequestDispatcher("error500.jsp").forward(request, response);
		}
		
	}

}
