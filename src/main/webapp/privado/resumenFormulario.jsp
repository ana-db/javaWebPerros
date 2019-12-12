<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navigation.jsp" %>



<div class="row">
	<div class="col">
		
		<h1 class="my-3 text-center text-info">Resumen Formulario Deportes</h1>

		<%
		//recibimos los atributos del controlador:
		String nombre = (String)request.getAttribute("nombre");	
		String email = (String)request.getAttribute("email");		
		%>
	
		<!-- visualizamos los datos recibidos: -->
		<ol>
			<li>Gracias ${nombre}</li>
			<li>Se enviará un correo a ${email}</li>
			<!-- <li style="color:green;">Mensaje: ${mensaje}</li> -->
		</ol>
		
		</div> <!-- fin class="col" -->
	</div> <!-- fin class="row" -->





<a class="boton-top bg-danger" href="privado/index.jsp#top">^</a>

<%@include file="../includes/footer.jsp" %>