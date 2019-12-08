<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>

<style>
	img{
        display:block;
        margin:auto;
        width: 50%;
    }
</style>


<%
	
	out.print("<h1>Soy index.jsp</h1>");

%>

<a href="perros">CRUD Perros</a>


<h1 class="my-3 text-center text-info">Bienvenido</h1>


<img class="responsive" src="images/bg-index-image" alt="bg-index-image">
	


<a class="boton-top bg-danger" href="index.jsp#top">^</a>

<%@include file="includes/footer.jsp" %>