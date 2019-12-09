<%@page import="com.ipartek.formacion.model.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>


<%
	String mensaje = (String)request.getAttribute("mensaje");
%>
<p style="color: green; font-size:1.5em;"><%=mensaje%></p>


<h1 class="my-3 text-center text-info">Perros</h1>


<%
	ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");
%>

<h2 class="my-3 text-center text-info">Listado</h1>

<ul>
	<% for ( Perro p : perros ){ %>
	
		<li>
			<%=p.getId()%> - <%=p.getNombre()%> 
			<img src="<%=p.getFoto()%>" style="width:100px; height: 100px;" alt="foto del perro">
			<a href="perros?id=<%=p.getId()%>&adoptar=s">Adoptar</a>
			<a href="perros?id=<%=p.getId()%>&editar=s">Modificar</a>
		</li>
		
	<% } %>
</ul>

<hr>



<h2 class="my-3 text-center text-info">Tabla</h1>

<div class="row justify-content-center align-items-center">
	<div class="col">
		<div class="table-responsive">
			<table class="table table-striped table-hover" width="40%">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Foto</th>
						<!-- 
						<th>Modificar datos</th>
						<th>Adoptar</th>
						-->
					</tr>
				</thead>
				
				<tbody>
					<%
						for ( Perro p :  perros ){
							int id = (int)p.getId();
					%>
					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getNombre()%></td>
						<td><img class="foto-perfil-perro" src="<%=p.getFoto()%>"></td>
					<%
						}
					%>
				</tbody>
					
			</table> <!-- fin tabla -->
		</div> <!-- fin class="table-responsive" -->
	</div> <!-- fin class="col" -->
</div> <!-- fin class="row" -->





<hr>

<h2 class="my-3 text-center text-info">Formulario</h1>

<%
	Perro perroEditar = (Perro)request.getAttribute("perroEditar");
	if ( perroEditar == null ){
		perroEditar = new Perro();
	}
%>

<div class="row justify-content-center align-items-center"> <!-- para centrar el fomulario necesitamos que esté dentro de las clases row y col -->
	<div class="col-6">
	    
	    <!-- formulario registro -->
		<form action="perros" method="post">
			<!-- id del perro -->
			<div class="form-group">
			    <label for="id">ID</label>
			    <input type="text" readonly class="form-control" name="id" id="id" required value="<%=perroEditar.getId()%> pattern="[a-zA-Z]{1,50}" placeholder="Nombre del perro">
			</div>
		
			<!-- nombre del perro -->
			<div class="form-group">
			    <label for="nombre">Nombre</label>
			    <input type="text" class="form-control" name="nombre" id="nombre" required pattern="[a-zA-Z]{1,50}" placeholder="Nombre del perro">
			</div>
			
			<!-- foto del perro -->
			<div class="form-group">
			    <label for="foto">Foto del perro</label>
			    <input type="text" class="form-control" name="foto" id="foto" required placeholder="url foto del perro">
			</div>
	
    		<!-- submit -->
			<input type="submit" class="btn btn-info" value="Registrar">
			<hr>
		
		</form>
	
	</div> <!-- fin class="col" -->
</div> <!-- fin class="row" -->	

<a class="boton-top bg-danger" href="index.jsp#top">^</a>

<%@include file="includes/footer.jsp" %>