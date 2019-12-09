package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros")
public class PerrosController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(PerrosController.class);
	
    private ArrayList<Perro> perros = new ArrayList<Perro>();
    
   
   //constructor para crear perros
    /*
	public PerrosController() {
		super();
		perros.add( new Perro("bubba") );
		perros.add( new Perro("rataplan") );
		perros.add( new Perro("mosca") );
		perros.add( new Perro("txakur") );
		perros.add( new Perro("lagun") );
	} */
	
	
	//ciclo de vida de un servlet: init, destroy y service:
	@Override
	public void init(ServletConfig config) throws ServletException {
		LOG.trace("se ejecuta la 1º vez que se llama a este servlet y nunca más");
		super.init(config);
		
		//creamos perros desde init en lugar de usar el constructor:
		perros.add( new Perro("bubba") );
		perros.add( new Perro("rataplan") );
		perros.add( new Perro("mosca") );
		perros.add( new Perro("txakur") );
		perros.add( new Perro("lagun") );
	}
	
	
	@Override
	public void destroy() {
		LOG.trace("se ejecuta sólo 1 vez cuando se para el servidor de aplicaciones");
		super.destroy();
		perros = null;
	}

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("se ejecuta antes del doGet o doPost");
		super.service(request, response); //ejecuta doGet o doPost
		
		LOG.trace("se ejecuta después del doGet o doPost");
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros.jsp").forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//listar perros
		/*
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros.jsp").forward(request, response);
		*/
		LOG.trace("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recibir datos del formulario
		String nombre = request.getParameter("nombre");
		String foto = request.getParameter("foto");
				
		//crear registro para un nuevo perro
		Perro p = new Perro();
		p.setNombre(nombre);
		p.setFoto(foto);
		
		//guardar en la lista
		perros.add(p);
		
		//listar perros
		/*
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros.jsp").forward(request, response);
		*/
	}

}
