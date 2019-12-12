<!-- taglibs necesarias para leer c:forEach : -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
		</ol>
		
	</div> <!-- fin class="col" -->
</div> <!-- fin class="row" -->





<a class="boton-top bg-danger" href="privado/index.jsp#top">^</a>

<%@include file="../includes/footer.jsp" %>