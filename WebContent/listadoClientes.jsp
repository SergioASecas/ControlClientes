<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_CO"/>

<section id="clientes">
  <div class="container">
    <div class="row">
      <div class="col-md-9">
        <div class="card">
          <div class="card-header">
            <h4>Listado de Clientes</h4>
          </div>
            <table class="table table-striped">
              <thead class="thead-dark">
                <tr>
                  <th>#</th>
                  <th>Nombre</th>
                  <th>Saldo</th>
                  <th></th>
                </tr>
                <tbody>
                  <c:forEach var="clientes" items="${clientes}" varStatus="status">
                    <tr>
                      <td> ${status.count}</td>
                      <td> ${clientes.nombre}</td>
                      <td> <fmt:formatNumber value="${clientes.saldo}" type="currency"></fmt:formatNumber></td>
                      <td>
                      	<a href='${pageContext.request.contextPath}/ControladorServlet?accion=Editar&id_cliente=${clientes.id_cliente}' class="btn btn-secondary">Edit
                      	</a>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
             </table>
        </div>
      </div>
      <div class="col-md-3">
      	<div class="card text-center bg-danger text-white mb-3">
      		<div class="=card body">
      			<h3>Saldo total</h3>
      			<h4 class="display-4"><fmt:formatNumber value="${TotalSaldo}" type="currency" ></fmt:formatNumber></h4>
      		</div>
      	</div>
      		<div class="card text-center bg-success text-white mb-3">
      			<div>
      				<h3>Total Clientes</h3>
      				<h4 class="display-4"><i class="fas fa-users"></i> ${TotalClientes}</h4>
      			</div>
      		</div>      	
      </div>
    </div>
  </div>
</section>

<!-- Agregar Cliente Modal -->
<jsp:include page="/agregarCliente.jsp"></jsp:include>




