<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navigation.jsp" %>


<h2 class="my-3 text-center text-info">Formulario Deportes</h1>

<div class="row justify-content-center align-items-center"> <!-- para centrar el fomulario necesitamos que esté dentro de las clases row y col -->
	<div class="col-6">
		<form action="formulariodeportes" method="post"> 
		
			<c:if test="${not empty mensaje}">
				<h4 style="color:red">${mensaje}</h4>
			</c:if>
		
			<!-- nombre usuario -->
			<div class="form-group">
			    <label for="nombre">Nombre:</label> 
			    <input type="text" class="form-control" name="nombre" value=${nombre} id="nombre" required pattern="[a-zA-Z]{1,50}" placeholder="Nombre ususario"><br>
			</div>
			
			<!-- email -->
			<div class="form-group">
			    <label for="email">email</label> 
    			<input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="Escribe aquí tu email" required>
			</div>
			
			
			
			<!-- deportes -->
			<div class="form-group">
				<label for="deportes">Deportes:</label><br>
		        <input type="checkbox" checked name="deportes" id="deportes" value="Quidditch" >Quidditch <br>
		        <input type="checkbox" name="deportes" id="deportes" value="Jugger" >Jugger <br>
		        <input type="checkbox" name="deportes" id="deportes" value="BodyBoard" >Body board <br>
		        <input type="checkbox" name="deportes" id="deportes" value="Escalada" >Escalada <br>
		        <input type="checkbox" name="deportes" id="deportes" value="Natacion" >Natación <br>
			</div>
			
			<!--
			<c:forEach items="${deportesMarcados}" var="dm">
				<p>${dm}</p>
			</c:forEach>
			
			<c:forEach items="${applicationScope.deportes}" var="deporte">
					<input type="checkbox" name="deportes" value="${deporte.key}" > ${deporte.value}  
			</c:forEach>
			
			${deportes}
			-->
		    
			<input type="submit" class="btn btn-info" value="Enviar">
		
		</form>
		
	</div> <!-- fin class="col" -->
</div> <!-- fin class="row" -->




<a class="boton-top bg-danger" href="privado/index.jsp#top">^</a>

<%@include file="../includes/footer.jsp" %>