<div class="modal fade" id="agregarClienteModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header bg-info text-white">
        <h5 class="modal-title">Agregar Cliente </h5>
        <button type="button" class="close" data-dismiss="modal" >
          <span>&times;</span>
        </button>
      </div>
      <form action="${pageContext.request.contextPath}/ControladorServlet?accion=insertar" method="POST" class="was-validated">
      	<div class="modal-body">
          <div class="form-group">
            <label for="Nombre">Nombre</label>
            <input type="text" class="form-control" name="nombre" required>
          </div>
          <div class="form-group">
            <label for="Apellido">Apellido</label>
            <input type="text" class="form-control" name="apellido" required>
          </div>
          <div class="form-group">
            <label for="email">Dirección de Correo Electrónico</label>
            <input type="email" class="form-control" name="email" required >
          </div>
          <div class="form-group">
            <label for="Telefono">Teléfono</label>
            <input type="number" class="form-control" name="telefono" required>
          </div>
          <div class="form-group">
            <label for="Saldo">Saldo</label>
            <input type="number" class="form-control" name="saldo" required>
          </div>
          <div class="form-group">
              <button type="submit" class="btn btn-primary">Submit</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
