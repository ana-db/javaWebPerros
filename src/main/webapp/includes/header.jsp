<!DOCTYPE html> <!-- html5 -->
<html lang="es"> <!-- lang: es un atributo; "es": su valor, idioma en español-->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>JavaWebPerros</title>

	<!-- imagen favicon -->
	<link rel="shortcut icon" type="image/png" href="images/favicon.png">

    <!-- la base para construir todas las rutas de esta página -->
    <base href="/perros/"> <!-- nombre de nuestro proyecto actual -->

	<!-- fontawesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">

    <!-- Bootstrap core CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

	<!-- datatables responsive -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/jq-3.3.1/dt-1.10.20/b-1.6.1/r-2.2.3/datatables.min.css" />
    
	<!-- https://fonts.google.com -->
	<link href="https://fonts.googleapis.com/css?family=Parisienne&display=swap" rel="stylesheet">
	
	<!-- nuestro css -->
    <link rel="stylesheet" href="css/styles.css?time=<%=System.currentTimeMillis()%>">
	
	
</head>

<body id="top"> <!-- esta es la parte que ve el usuario -->

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
