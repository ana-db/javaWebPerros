package com.ipartek.formacion.privado;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Perro;
import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/privado/home")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(BackofficeController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackofficeController() {
        super();
        // TO DO Auto-generated constructor stub
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
				
		request.setAttribute("atributoDesdeServlet", "Prueba");
		
		//ir a JSP:
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


}
