<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navigation.jsp" %>


<h1 class="my-3 text-center text-info">Index Privado</h1>

<section>
	<p style="color:red">Sólo pueden acceder los usuarios loggeados</p>

	<p>Atributo desde servlet: ${atributoDesdeServlet}</p>
</section>


<section>
	<!-- 
		LISTENNERS
		con la siguiente instrucción podemos ver cuántos usuarios están conectados a la 
		página de forma global, aunque utilicen navedagadores diferentes.
		Lo podemos hacer porque la variable numeroUsuariosConectados se ha declarado como
		variable de ÁMBITO GLOBAL
	 -->
	 <h3>Usuarios logeados</h3>
	 <p>Usuarios logeados: <b>${applicationScope.numeroUsuariosConectados}</b> </p>
	
	
	<h3>Accesos indebidos</h3>
	<p>Numero de Intentos de Acceso Indebidos: <b>X</b> </p>
	
	
	<h3>IPs sin repetir de accesos indebidos</h3>
	<ol>
		<li>192.x.x.x</li>
		<li>192.x.x.x</li>
		<li>192.x.x.x</li>
	</ol>
	
</section>


<a class="boton-top bg-danger" href="privado/index.jsp#top">^</a>

<%@include file="../includes/footer.jsp" %>