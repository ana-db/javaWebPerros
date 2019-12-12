<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navigation.jsp" %>


<h1 class="my-3 text-center text-info">Resumen Formulario Deportes</h1>

<div class="row justify-content-center align-items-center">
	<div class="col-6">

		<%
		//recibimos los atributos del controlador:
//		String nombre = (String)request.getAttribute("nombre");	
//		String email = (String)request.getAttribute("email");	
//		String deportes = (String)request.getAttribute("deportes");
		//como usamos notación ${XX}, no hacen falta estas líneas, se hace directamente
		%>
	
		<!-- visualizamos los datos recibidos: -->
		<ol>
			<li>Gracias <b>${nombre}</b></li>
			<li>Se enviará un correo a <b>${email}</b></li>
			<li>
				Has seleccionado los siguientes deportes:
				<!-- recorremos el array: -->
				<c:forEach items="${deportes}" var="deporte">
					<li><b>${deporte}</b></li>
				</c:forEach>
			</li>
			<li>Eres <b>${sexo}</b></li>
		</ol>
		
	</div> <!-- fin class="col" -->
</div> <!-- fin class="row" -->





<a class="boton-top bg-danger" href="privado/index.jsp#top">^</a>

<%@include file="../includes/footer.jsp" %>