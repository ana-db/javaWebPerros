<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navigation.jsp" %>


<!-- para refrescar la p�gina cada 5 seg (llamar� al controlador cada 5 segs) -->
<meta http-equiv="refresh" content="5">

<h1 class="my-3 text-center text-info">Index Privado</h1>

<section>
	<p style="color:red">S�lo pueden acceder los usuarios loggeados</p>

	<p>Atributo desde servlet: ${atributoDesdeServlet}</p>
</section>


<section>	
	
	<!-- 
		LISTENNERS
		con la siguiente instrucci�n podemos ver cu�ntos usuarios est�n conectados a la 
		p�gina de forma global, aunque utilicen navedagadores diferentes.
		Lo podemos hacer porque la variable numeroUsuariosConectados se ha declarado como
		variable de �MBITO GLOBAL
	 -->
	 <h3>Usuarios logeados</h3>
	 <p>Usuarios logeados: <b>${applicationScope.numeroUsuariosConectados}</b> </p>
	
	
	<h3>Accesos indebidos</h3>
	<p>Numero de Intentos de Acceso Indebidos: <b>${applicationScope.numeroAccesosIndebidos}</b> </p>
	<!-- ${applicationScope.numeroAccesosIndebidos} -->
	
	
	<h3>IPs sin repetir de accesos indebidos</h3>
	<ol>
		<li>192.x.x.x</li>
		<li>192.x.x.x</li>
		<li>192.x.x.x</li>
	</ol>
	
</section>


<a class="boton-top bg-danger" href="privado/index.jsp#top">^</a>

<%@include file="../includes/footer.jsp" %>