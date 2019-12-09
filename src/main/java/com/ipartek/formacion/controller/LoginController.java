package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.pojo.Perro;
import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String NOMBRE_USUARIO = "admin";
	public static final String PASSWORD_USUARIO = "admin";
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
       
        usuarios.add( new Usuario(1, "pepe", "123456", "https://github.com/pepe", "https://picsum.photos/") );
        usuarios.add( new Usuario(2, "pepa", "654321", "https://github.com/pepa", "https://picsum.photos/") );
        usuarios.add( new Usuario(3, "admin", "admin", "https://github.com/admin", "https://picsum.photos/") );

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
				
		String vista ="";
		
		//1. recibir parámetros:
		String nombre = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
				
				
		//2. lógica de negocio:
		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equalsIgnoreCase(nombre) && usuario.getPassword().equalsIgnoreCase(contrasena)) {
				//recuperar sesión del usuario == browser
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogeado", nombre); //guarda 1 atributo  de la sesión
				session.setMaxInactiveInterval(-1); //5 seg (60*5*24*7) -  -1 nunca caduca
				vista = "perros";
			}
			else {
				vista = "index.jsp";
			}
		}
		
		
		//ir a JSP:
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect(vista); //así evitamos que en la url aparezca la web que envía la response
	}

}