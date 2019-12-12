<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navigation.jsp" %>


<h2 class="my-3 text-center text-info">Formulario Deportes</h1>

<div class="row justify-content-center align-items-center"> <!-- para centrar el fomulario necesitamos que esté dentro de las clases row y col -->
	<div class="col-6">
		<form action="formulariodeportes" method="post"> 
		
			<!-- nombre usuario -->
			<div class="form-group">
			    <label for="nombre">Nombre:</label> 
			    <input type="text" class="form-control" name="nombre" id="nombre" required pattern="[a-zA-Z]{1,50}" placeholder="Nombre ususario"><br>
			</div>
			
			<!-- email 
			<div class="form-group">
			    <label for="email">Email:</label> 
    			<input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Escribe aquí tu email" required>
			</div>
		    
		    <!-- recuerdame 
			<input type="checkbox" checked name="recuerdame" id="recuerdame" value="1" >Recuerdame <br>
			-->
			<input type="submit" class="btn btn-info" value="Enviar">
		
		</form>
		
	</div> <!-- fin class="col" -->
</div> <!-- fin class="row" -->




<a class="boton-top bg-danger" href="privado/index.jsp#top">^</a>

<%@include file="../includes/footer.jsp" %>