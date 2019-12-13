<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navigation.jsp" %>


<h2 class="my-3 text-center text-info">Formulario Deportes</h2>

<div class="row justify-content-center align-items-center"> <!-- para centrar el fomulario necesitamos que esté dentro de las clases row y col -->
	<div class="col-6">
		<form action="formulariodeportes" method="post"> 
		
			<c:if test="${not empty mensaje}">
				<h4 style="color:red">${mensaje}</h4>
			</c:if>
		
			<!-- nombre usuario -->
			<!-- <div class="form-group"> -->
			<div>
			    <label for="nombre">Nombre:</label> 
			    <!-- <input type="text" class="form-control" name="nombre" value=${nombre} id="nombre" required pattern="[a-zA-Z]{1,50}" placeholder="Nombre ususario"> -->
				<input type="text" name="nombre" value=${nombre} id="nombre" required pattern="[a-zA-Z]{2,50}" placeholder="Nombre ususario (2-50 letras)">
			</div>
			
			<!-- email -->
			<div class="form-group">
			    <label for="email">Email</label> 
    			<input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="Escribe aquí tu email" required>
			</div>
			<!--
			<div class="form-group">
			    <label for="email">Email</label> 
    			<input type="text" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="Escribe aquí tu email" required>
			</div>-->
			
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
			
			<!-- sexo -->
			<div class="form-group">
			    <label for="sexo">Sexo:</label> 
			    <select name="sexo" id="sexo">
			    	<option value="">-- Selecciona --</option>
	                <option value="h" ${(sexo eq 'h') ? "selected" : ""}>Hombre</option>
	                <option value="m" ${(sexo eq 'h') ? "selected" : ""}>Mujer</option>
	                <option value="i" ${( (sexo eq 'h') or (empty sexo)) ? "selected" : ""}>Indefinido</option>
	            	<!-- selected es equivalente a:  ${(sexo eq 'h') ? "selected" : ""} -->
	            </select>
			</div>
		    
			<input type="submit" class="btn btn-info" value="Enviar">
		
		</form>
		
	</div> <!-- fin class="col" -->
</div> <!-- fin class="row" -->




<a class="boton-top bg-danger" href="privado/index.jsp#top">^</a>

<%@include file="../includes/footer.jsp" %>