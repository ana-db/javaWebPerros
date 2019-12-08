<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>

<form action="login" method="post"> 
	<!-- nombre usuario -->
	<label for="nombre">Nombre:</label> 
	<input type="text" name="nombre" placeholder="Nombre ususario" required><br>
	
	<!-- contraseña -->
	<label for="contrasena">Contraseña:</label> 
    <input type="password" name="contrasena" required pattern=".{5,8}" placeholder="Contraseña (mín 5, máx 8)"><br>
    
    <!-- recuerdame -->
	<input type="checkbox" checked name="recuerdame" id="recuerdame" value="1" >Recuerdame <br>
	
	<input type="submit" value="Acceder">

</form>

<a class="boton-top bg-danger" href="index.jsp#top">^</a>

<%@include file="includes/footer.jsp" %>