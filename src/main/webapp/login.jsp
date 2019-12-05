<form action="login" method="post"> 
	<!-- nombre usuario -->
	<label for="contrasena">Nombre:</label> 
	<input type="text" name="usuario" placeholder="Nombre ususario" required><br>
	
	<!-- contraseña -->
	<label for="contrasena">Contraseña:</label> 
    <input type="password" name="contrasena" required pattern=".{5,8}" placeholder="Contraseña (mín 5, máx 8)"><br>
    
    <!-- recuerdame -->
	<input type="checkbox" checked name="recuerdame" id="recuerdame" value="1" >Recuerdame <br>
	
	<input type="submit" value="Acceder">

</form>