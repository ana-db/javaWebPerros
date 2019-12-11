package com.ipartek.formacion.controller.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.PerrosController;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/privado/*" })
public class SeguridadFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(PerrosController.class);

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.trace("destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//hacemos cast de reuqest y response de tipo ServletRequest y ServletResponse
		//a HttpServletRequest y HttpServletResponse:
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//hacemos el filtro de seguridad:
		HttpSession session = req.getSession();
		if (session.getAttribute("usuarioLogeado") == null) {
			LOG.warn("Intentan entrar sin loggearse");
			
			//sacamos unas trazas con info:
			LOG.debug("RequestURL: " + req.getRequestURL());
			LOG.debug("RequestURL: " + req.getRequestURI());
			LOG.debug("Protocolo HTTP: " + req.getProtocol());
			LOG.debug("HTTP RemoteAddress, IP: " + req.getRemoteAddr());
			LOG.debug("HTTP RemoteHost: " + req.getRemoteHost());
			LOG.debug("Navegador: " + req.getHeader("User-Agent"));
			
			
			Map parametosMap = req.getParameterMap(); //parámetros enviados
			
		}
		else {
			//dejamos pasar al filtro y continuar:
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.trace("init");
	}

}
