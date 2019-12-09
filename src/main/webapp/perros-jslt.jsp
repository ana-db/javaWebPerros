<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>

<h1>Perros JSTL</h1>

<p>Mismo ejemplo para hacer un CRUD pero usando taglibs y EL</p>


<c:if test="${not empty mensaje}">
	<p style="color: green; font-size:1.5em;">${mensaje}</p>
</c:if>

<c:if test="${empty mensaje}">
	<p style="color: blue; font-size:1.5em;">No tenemos ningún mensaje</p>
</c:if>


<h2>Tenemos ${fn:length(perros)} perros en adopción</h2>

<ul>
	<c:forEach items="${perros}" var="p"> <!-- iteramos sobre la lista "perros" con la variable "p" -->
		<li>
			${p.id} ${p.nombre}
			<img src="${p.foto}" style="width:100px; height: 100px;" alt="foto del perro">
			<a href="perros2?id=${p.id}&adoptar=s">Adoptar</a>
			<a href="perros2?id=${p.id}&editar=s">Modificar</a>
		</li> <!-- con {} porque queremos pintar el contenido -->
	</c:forEach>
</ul>


<c:if test="${empty perroEditar}">
	<p style="color: blue; font-size:1.5em;">No tenemos perro para editar, vamos a inicializarlo</p>
	<jsp:useBean id="perroEditar" class="com.ipartek.formacion.model.pojo.Perro"></jsp:useBean> <!-- para inicializar un perro la 1a vez que entramos, crear objetos -->
</c:if>
<!-- de todas formas, es el controlador es el que debería pasar al jsp el objeto inicializado -->


<br>id=> ${perroEditar.id}
<br>nombre=> ${perroEditar.nombre}
<br>foto=> ${perroEditar.foto}


<!-- ${perros}  pintará el toString del ArrayList sin necesidad de importar las clases Perros ni ArrayList -->


<a class="boton-top bg-danger" href="index.jsp#top">^</a>

<%@include file="includes/footer.jsp" %>