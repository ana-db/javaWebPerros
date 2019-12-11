package com.ipartek.formacion.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;


/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

	private final static Logger LOG = Logger.getLogger(AppListener.class);
	
    /**
     * Default constructor. 
     */
    public AppListener() {
        // TO DO Auto-generated constructor stub
    }

    
    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//se llama a este método cuando arrancamos la aplicación para inicializarla
    	LOG.info("La App se ha arrancado");
    	
    	//sc == applicationScope  
    	//Vamos a contar cuántos usuarios loggeados tenemos:
    	ServletContext sc =  sce.getServletContext();
    	sc.setAttribute("numeroUsuariosConectados", 0);  //incializamos la variable global "numeroUsuariosConectados" a 0 para evitar nulls
    }
    
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	//se llama a este método cuando la aplicación se detiene
    	LOG.info("La App se ha parado");
    }

	
	
}
