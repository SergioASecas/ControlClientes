<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	 <script src="https://kit.fontawesome.com/ff3160d787.js" crossorigin="anonymous"></script>
	<title>Control Clientes</title>	

 </head>
  <body>
 
    <!-- Cabecera -->
    <jsp:include page="/cabecero.jsp"></jsp:include>
    
    
 
	
	<form action="${pageContext.request.contextPath}/ControladorServlet?accion=modificar&id_cliente=${cliente.id_cliente}" method="POST" class="was-validated">
		   <!-- botones navegacion -->
    	<jsp:include page="/editarBotonesNavegacion.jsp"></jsp:include>
		
		<section id="details">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="card">
							<div class="card-header">
								<h4>Editar Cliente</h4>
									<div class="form-group">
            							<label for="Nombre">Nombre</label>
            							<input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
          							</div>
          							<div class="form-group">
           								<label for="Apellido">Apellido</label>
            							<input type="text" class="form-control" name="apellido" required value="${cliente.apellido}">
          							</div>
          							<div class="form-group">
            							<label for="email">Dirección de Correo Electrónico</label>
            							<input type="email" class="form-control" name="email" required value="${cliente.email}">
          							</div>
          							<div class="form-group">
            							<label for="Telefono">Teléfono</label>
            							<input type="number" class="form-control" name="telefono" required value="${cliente.telefono}">
          							</div>
          							<div class="form-group">
            							<label for="Saldo">Saldo</label>
            							<input type="number" class="form-control" name="saldo" required value="${cliente.saldo}">
          							</div>
          							<div class="form-group">
              							<button type="submit" class="btn btn-primary">Submit</button>
          							</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
 
 
	  <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
  </body>
</html>
