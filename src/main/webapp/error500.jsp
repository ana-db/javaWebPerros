<%@page isErrorPage="true"%> <!-- as� indicamos que es una p�gina de error. El resto lo tienen a false por defecto -->

<h1>Aprende a progarmar</h1>

<p>Causa <%=exception.getCause() %></p>
<p>Mensaje <%=exception.getMessage() %></p>

<pre>
	<!-- Stack trace -->
	<jsp:scriptlet>
		exception.printStackTrace(new java.io.PrintWriter(out));
	</jsp:scriptlet>
</pre>


