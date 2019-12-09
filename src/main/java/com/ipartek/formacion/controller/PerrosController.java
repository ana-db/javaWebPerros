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
	private int indice = 0;
	private String mensaje = "";
	
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
		
		//creamos perros desde init en lugar de usar el constructor PerrosController():
		perros.add( new Perro(1, "bubba") );
		perros.add( new Perro(2, "rataplan") );
		perros.add( new Perro(3, "mosca") );
		perros.add( new Perro(4, "txakur") );
		perros.add( new Perro(5, "lagun") );
		indice = 6;
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
		mensaje = "";
		super.service(request, response); //ejecuta doGet o doPost
		
		LOG.trace("se ejecuta después del doGet o doPost");
		request.setAttribute("mensaje", mensaje);
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
		
		//recibimos parámetros:
		int id = ( request.getParameter("id") == null ) ? 0 : Integer.parseInt(request.getParameter("id")); 
		boolean adoptar = ( request.getParameter("adoptar") == null ) ? false : true;
		boolean editar = ( request.getParameter("editar") == null ) ? false : true;
		
		LOG.debug("id = " + id + "adoptar = " + adoptar + "editar = " + editar);
		
		if (id > 0) {
			//busacmos el perro en el ArrayList
			Perro perro = null;
			
			for (Perro p : perros) {
				if (p.getId() == id) {
					perro = p; // el perro seleccionado p, es del que vamos a modificar sus datos
					break;
				}
			}
			
			if (adoptar) {
				perros.remove(perro);
				mensaje = "Ya has adoptado a " + perro.getNombre() + " gracias";
				LOG.info(perro.getNombre() + " ha sido adoptado");
			}
			
			if (editar) {
				request.setAttribute("perroEditar", perro);
			}
				
		}
		else {
			LOG.trace("Sólo se listan los perros");
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("doPost");
		
		//recibir datos del formulario
		int id = Integer.parseInt( request.getParameter("id") );
		String nombre = request.getParameter("nombre");
		String foto = request.getParameter("foto");
		
		//TODO validar parámetros
		/*
		 * try {
				//lógica de negocio:
				if ("".equals(nombre)) {
					mensaje = "Por favor, rellena el campo del nombre";
				}
				else {
					if ("".equals(foto)) {
						mensaje = "Por favor, rellena el campo con la url de la foto";
					}
				}
			}
			catch(NumberFormatException e) {
				mensaje = "Por favor, escribe un valor numérico";
			}
			catch(Exception e) { //excepción general
				mensaje = "Lo siento pero hay algún error en la escritura";
			} 
			finally {
				//seguimos con la ejecución del programa
		 */
		
		
		//en función del id del perro:
		//1. se modificará si el id > 0, significa que el perro está en la lista
		//2. se creará un registro nuevo en caso contrario, puesto que si id = 0, significa que el perro todavía no está en la lista
		if (id > 0) {
			LOG.trace("Modificar datos del perro");
			
			Perro perro = null;
			
			//buscamos el perro en el ArrayList			
			for (Perro p : perros) {
				if (p.getId() == id) {
					perro = p; // el perro seleccionado p, es del que vamos a modificar sus datos (perro)
					break;
				}
			}
			
			//modificamos los datos
			perro.setNombre(nombre);
			perro.setFoto(foto);
			
			mensaje = "Los datos del perro se han modificado correctamente";
		}
		else {
			//crear registro para un nuevo perro
			Perro p = new Perro();
			p.setNombre(nombre);
			p.setFoto(foto);
			p.setId(indice);
			indice++; //incrementamos para el siguiente
			
			mensaje = "Gracias por dar de alta un perro nuevo";
			
			//lo guardamos en la lista
			perros.add(p);
		}
			
		
		//listar perros
		/*
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros.jsp").forward(request, response);
		*/
	}

}
