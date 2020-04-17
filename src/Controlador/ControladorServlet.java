package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelo.cliente;

@WebServlet("/ControladorServlet")
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "Editar":
				update(request, response);
				break;
			case "eliminar":
				eliminar(request,response);
				break;
			default:
				accionDefault(request, response);
			}
		} else {
			accionDefault(request, response);
		}

	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "insertar":
				insertar(request, response);
				break;
			case "modificar":
				actualizar(request, response);
				break;
			default:
				accionDefault(request, response);
			}
		} else {
			accionDefault(request, response);
		}
	}


	private void accionDefault(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		Double saldo = 0.0;
		List<cliente> listaClientes = new DAOCliente().lista();
		for (cliente cliente : listaClientes) {
			response.getWriter().println(cliente);
			saldo += cliente.getSaldo();
		}

		HttpSession sesion = request.getSession();
		sesion.setAttribute("clientes", listaClientes);
		sesion.setAttribute("TotalSaldo", saldo);
		sesion.setAttribute("TotalClientes", listaClientes.size());
		response.sendRedirect("clientes.jsp");
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		int telefono = 0;
		String telefonoString = request.getParameter("telefono");
		if (telefonoString != null && !"".equals(telefonoString)) {
			telefono = Integer.parseInt(telefonoString);
		} 
		double saldo = 0;
		String saldoString = request.getParameter("saldo");
		if (saldoString != null && !"".equals(saldoString)) {
			saldo = Double.parseDouble(saldoString);
		}

		cliente clienteInsertado = new cliente(nombre, apellido, email, telefono, saldo);
		DAOCliente insertDAO = new DAOCliente();
		insertDAO.insert(clienteInsertado);
		System.out.println(clienteInsertado);
		accionDefault(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_cliente= Integer.parseInt(request.getParameter("id_cliente"));
		cliente clienteActualizado = new cliente(id_cliente);
		DAOCliente updateDao = new DAOCliente();
		updateDao.encontrarCliente(clienteActualizado);
		request.setAttribute("cliente", clienteActualizado);	
		request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id_cliente 	= Integer.parseInt(request.getParameter("id_cliente"));
		String nombre  	= request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email	= request.getParameter("email");
		int telefono	= Integer.parseInt(request.getParameter("telefono"));
		double saldo	= Double.parseDouble(request.getParameter("saldo"));
		
		cliente update = new cliente(id_cliente, nombre, apellido, email, telefono, saldo);
		DAOCliente Dao = new DAOCliente();
		Dao.actualizar(update);
		accionDefault(request, response);
	}

	

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		cliente eliminado = new cliente(id_cliente);
		DAOCliente daoEliminado = new DAOCliente();
		daoEliminado.delete(eliminado);
		accionDefault(request, response);
	}
	
}
