package com.ipartek.formacion.controller;

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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(LoginController.class);
	
	public static final String NOMBRE_USUARIO = "admin";
	public static final String PASSWORD_USUARIO = "123456";
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
       
        /*
        usuarios.add( new Usuario(1, "pepe", "123456", "https://github.com/pepe", "https://picsum.photos/") );
        usuarios.add( new Usuario(2, "pepa", "654321", "https://github.com/pepa", "https://picsum.photos/") );
        usuarios.add( new Usuario(3, "admin", "admin", "https://github.com/admin", "https://picsum.photos/") );
		*/
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
				
		//1. recibir parámetros:
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		//String idioma = request.getParameter("idioma");
		//String recuerdame = request.getParameter("recuerdame");
		
		String vista ="";
				
				
		//2. lógica de negocio:
		//for (Usuario usuario : usuarios) {
		//	if (usuario.getNombre().equalsIgnoreCase(nombre) && usuario.getPassword().equalsIgnoreCase(contrasena)) {
		if (NOMBRE_USUARIO.equalsIgnoreCase(nombre) && PASSWORD_USUARIO.equalsIgnoreCase(contrasena)) {
			//recuperar sesión del usuario == browser
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", nombre); //guarda 1 atributo  de la sesión
			session.setMaxInactiveInterval(-1); //5 seg (60*5*24*7) -  -1 nunca caduca
			
			//vista = "perros"; //11/12
			vista = "/privado/index.jsp";
			
			LOG.info("Logging correcto");
		}
		else {
			//vista = "/index.jsp"; //11/12
			vista = "/login.jsp";
			LOG.warn("Las credenciales no son correctas");
		}
		//}
		
		
		//ir a JSP:
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		//SIEMPRE que hagamos una REDIRECCIÓN es necesario usar el GETCONTEXTPATH():
		String base = request.getContextPath(); //nos da el contexto de este proyecto
		response.sendRedirect(base + vista); //así evitamos que en la url aparezca la web que envía la response
	}

}