<!DOCTYPE html> <!-- html5 -->
<html lang="es"> <!-- lang: es un atributo; "es": su valor, idioma en español-->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

	<!-- imagen favicon -->
	<link rel="shortcut icon" type="image/png" href="images/favicon.png">

    <!-- la base para construir todas las rutas de esta página -->
    <base href="/perros/"> <!-- nombre de nuestro proyecto actual -->

	<!-- fontawesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

    <!-- estilos -->
    <link rel="stylesheet" href="css/styles.css?time=<%=System.currentTimeMillis()%>"> <!-- linkamos la hoja de estilos para que se cargue -->
	<link rel="stylesheet" href="css/menu.css">
	<!-- https://fonts.google.com -->
	<link href="https://fonts.googleapis.com/css?family=Parisienne&display=swap" rel="stylesheet">
	
	
	
</head>
<body> <!-- esta es la parte que ve el usuario -->


<!-- incluimos datos de sesión del usuario -->
<section id="usuario">
	<% //usamos <% para meter scripts y <%= para pintar
		String usuario = (String)session.getAttribute("usuarioLogeado");
	%>
	
	<%
	if(usuario==null)
	{
		%>
			<p>Todavía no te has logeado. Por favor <a href="login.jsp">inicia sesion</a></p>
		<%
	}	
	else
	{
		%>
			<p>Usuario: <%=usuario%></p>
			<p><a href="logout">Cerrar sesion</a></p>	
			<!-- será el controlador logoutController quien escuchando en logout, cierre la sesión -->
		<%
	}
	%>
	
</section>




<hr>

HEAD

