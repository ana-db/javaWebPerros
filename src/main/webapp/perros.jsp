<%@page import="com.ipartek.formacion.model.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>


<h1 class="my-3 text-center text-info">Perros</h1>


<%
	
	ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");

%>

listado

<ol>
	<% for ( Perro p :  perros ){ %>
	
		<li><%=p.getNombre()%> - <%=p.getId()%></li>
		
	<% } %>
</ol>

<hr>



<h2 class="my-3 text-left text-info">Tabla</h1>

<div class="row">
	<div class="col">
		<table class="table table-responsive table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Foto</th>
					<th>Modificar datos</th>
					<th>Adoptar</th>
				</tr>
			</thead>
			
			<tbody>
				<%
					for ( Perro p :  perros ){
						int id = (int)p.getId();
				%>
				<tr>
					<td><%=p.getId() %></td>
					<td><%=p.getNombre() %></td>
					<td><img class="foto-perfil-perro" src="<%=p.getFoto()%>"></td>
					<td><a href="perros?modificar=<%=p.getId()%>">Modificar datos</a></td>
					<td><a href="perros?eliminar=<%=p.getId()%>">Adoptar</a></td>
				<%
					}
				%>
			</tbody>
				
		</table> <!-- fin tabla -->
			
	</div> <!-- fin class="col" -->
</div> <!-- fin class="row" -->





<hr>

<h2 class="my-3 text-left text-info">Formulario</h1>

<form action="perros" method="post">
	
	<input name="nombre" placeholder="Nombre del perro" required>
		
	
	<input type="submit" value="Registrar">
</form>


<%@include file="includes/footer.jsp" %>