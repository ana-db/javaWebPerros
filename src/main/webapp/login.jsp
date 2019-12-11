<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>


<%
	//atributo
	String mensaje = (String)request.getAttribute("mensaje");

	//si el mensaje no viene como atributo, lo intentamos con la request
	if(mensaje !=null){ 
		mensaje = request.getParameter("mensaje");
	}
	
	//
	if(mensaje !=null){ 
	%>
		<p style="color:red;"><%=mensaje%></p>	
	<%
		
	}
		
%>

<!-- ------------------------------------------------------------------- -->

<h1 class="my-3 text-center text-info">Login Java Web Perros</h1>

<div class="row justify-content-center align-items-center"> <!-- para centrar el fomulario necesitamos que esté dentro de las clases row y col -->
	
	<!-- con estos 7 divs, añadimos una imagen en la col 1 (izqda del formulario) y el login en la col 2 -->
	<div class="col-xl-10 col-lg-12 col-md-9 o-hidden border-0 bg-white">
	    <!-- o-hidden : clase asociada al dispaly para ocultar contenido (https://getbootstrap.com/docs/4.0/utilities/display/)
	        border-0 : div sin borde, anulando el de styles.css
	        bg-white : div con fondo blanco, anulando el gris de styles.css
	    -->
	    <div class="card o-hidden border-0 shadow-lg my-5">
	        <div class="card-body p-0">
	            
	            <div class="row">
	                <div class="col-lg-6 d-none d-lg-block bg-login-image"></div> <!-- col 1 -->
	                <div class="col-lg-6"> <!-- col 2, aquí escribimos el formulario -->
	                    <div class="p-5">
	

							<form action="login" method="post"> 
								<!-- nombre usuario -->
								<div class="form-group">
								    <label for="nombre">Nombre:</label> 
								    <input type="text" class="form-control" name="nombre" id="nombre" required pattern="[a-zA-Z]{1,50}" placeholder="Nombre ususario"><br>
								</div>
								
								<!-- contraseña -->
								<div class="form-group">
								    <label for="contrasena">Contraseña:</label> 
								    <input type="password" class="form-control" name="contrasena" id="contrasena" required pattern=".{5,8}" placeholder="Contraseña (mín 5, máx 8)"><br>
								</div>
								
								<!-- idioma -->
								<div class="form-group">
								    <label for="idioma">Idioma:</label>
								    <select class="form-control" name="idioma" id="idioma">
								    	<option value="c" selected>Catellano</option>
								        <option value="eu">Euskera</option>
								        <option value="en">English</option>
								    </select>
								</div>
							    
							    <!-- recuerdame -->
								<input type="checkbox" checked name="recuerdame" id="recuerdame" value="1" >Recuerdame <br>
								
								<input type="submit" class="btn btn-info" value="Acceder">
							
							</form>
							
						</div> <!-- fin class="p-5" -->
					</div> <!-- fin class="col-lg-6" -->
				</div> <!-- fin class="row" -->
			</div> <!-- fin class="card-body p-0" -->
		</div> <!-- fin class="card o-hidden border-0 shadow-lg my-5" -->
	</div> <!-- fin class="col-xl-10 col-lg-12 col-md-9 o-hidden border-0 bg-white" -->
</div> <!-- fin class="row justify-content-center align-items-center" -->	

<!-- ------------------------------------------------------------------- -->


<!--

<h2 class="my-3 text-center text-info">Login</h1>

<div class="row justify-content-center align-items-center"> <!-- para centrar el fomulario necesitamos que esté dentro de las clases row y col 
	<div class="col-6">
		<form action="login" method="post"> 
			<!-- nombre usuario 
			<div class="form-group">
			    <label for="nombre">Nombre:</label> 
			    <input type="text" class="form-control" name="nombre" id="nombre" required pattern="[a-zA-Z]{1,50}" placeholder="Nombre ususario"><br>
			</div>
			
			<!-- contraseña 
			<div class="form-group">
			    <label for="contrasena">Contraseña:</label> 
			    <input type="password" class="form-control" name="contrasena" id="contrasena" required pattern=".{5,8}" placeholder="Contraseña (mín 5, máx 8)"><br>
			</div>
		    
		    <!-- recuerdame 
			<input type="checkbox" checked name="recuerdame" id="recuerdame" value="1" >Recuerdame <br>
			
			<input type="submit" class="btn btn-info" value="Acceder">
		
		</form>
		
	</div> <!-- fin class="col" 
</div> <!-- fin class="row" 

-->

<a class="boton-top bg-danger" href="index.jsp#top">^</a>

<%@include file="includes/footer.jsp" %>