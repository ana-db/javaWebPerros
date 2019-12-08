	</main> <!-- fin main -->

		<!-- footer -->                                
        <footer class="bg-info text-white">
            <div class="container p-1 p-sm-3 clearfix"> <!-- p-4: padding, p-sm-3 padding para tamaño de dispositivo pequeño -->
                <nav>
                    <ul class="p-0 d-flex flex-column flex-sm-row justify-content-between"> 
                        <!-- flex-column> ponemos los enlaces en columnas por defecto -->
                        <!-- flex-sm-row> los pasamos a filas cuando el dispositivo sea peque;o -->
                        <!-- justify-content-between> para justificar el contenido y que ocupe todo el ancho de la pantalla -->
                        <li><a href="login.jsp">Login</a></li>
                        <li><a href="perros">CRUD perros</a></li>
                    </ul>
                </nav>
                
                <div class="float-right"><!-- <div class="d-flex justify-content-end"> -->
                    <!-- siempre que hagamos que algo flote, el contenedor tiene que tener una clase CLEARFIX -->
                    Bootstrap4 &copy; 
                    <a class="fab fa-github" href="https://github.com/ana-db/javaWebPerros" target=_blank></a> Ana Díez Bravo 2019  
                    <a class="fas fa-paw"></a>
                </div>  
            </div>
        </footer>
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>