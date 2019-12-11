<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navigation.jsp" %>


<h1 class="my-3 text-center text-info">Private index</h1>

<section>
	<p style="color:red">Sólo pueden acceder los usuarios loggeados</p>

	<p>Atributo desde servlet: ${atributoDesdeServlet}</p>
</section>


<a class="boton-top bg-danger" href="privado/index.jsp#top">^</a>

<%@include file="../includes/footer.jsp" %>