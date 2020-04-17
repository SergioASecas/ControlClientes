
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 

import Modelo.cliente; 
 
public class DAOCliente { 
	
	private static final String SELECT		 = "SELECT * FROM CLIENTE";
	private static final String INSERT 		 = "INSERT INTO CLIENTE (nombre,apellido,email,telefono,saldo) VALUES (?,?,?,?,?)";
	private static final String UPDATE 		 = "UPDATE CLIENTE SET NOMBRE=?, APELLIDO=?, EMAIL=?, TELEFONO=?, SALDO=? WHERE ID_CLIENTE=?";
	private static final String DELETE 		 = "DELETE FROM CLIENTE WHERE id_cliente=?";
	private static final String SELECT_BY_ID = "SELECT * FROM cliente WHERE id_cliente=?";
	
	public List<cliente> lista(){  
		
		//DECLARACIÓN VARIABLES
		List<cliente>listado = new ArrayList<cliente>();
		Connection conn		 = null;
		PreparedStatement ps = null;
		ResultSet 		  rs = null; 
		
		try {
			
			//CONECTAR CON BASE DE DATOS Y EJECUTAR QUERY	
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = Conexion.getConnection();
			ps   = conn.prepareStatement(SELECT);
			rs	 = ps.executeQuery();
			
			//INSTANCIAR OBJETO DE TIPO CLIENTE			
			
			//RECORRER RESULTSET DE DATOS PARA ALMACENARLOS EN LA LIST<> LISTADO
			while (rs.next()) {
				
				//RECUPERAR VALORES DE CADA REGISTRO Y ASIGNARLO A UNA VARIABLE. 
				int id_cliente 	= rs.getInt(1);
				String nombre  	= rs.getString(2);
				String apellido = rs.getString(3);
				String email 	= rs.getString(4);
				int telefono 	= rs.getInt(5);
				int saldo 		= rs.getInt(6);
				
				cliente lista = new cliente();
				
				//TOMAR LAS VARIABLES E INSERTARLAS EN			
				lista.setId_cliente(id_cliente);
				lista.setNombre(nombre);
				lista.setApellido(apellido);
				lista.setEmail(email);
				lista.setTelefono(telefono);
				lista.setSaldo(saldo);
				
				//INSERTAR REGISTRO CON TODAS LAS VARIABLES EN LA LISTA
				
				listado.add(lista);			
			}			
			System.out.println(listado);
		} catch (Exception e) {
			e.printStackTrace(); 
		}		
		Conexion.close(rs);
		Conexion.close(ps);
		Conexion.close(conn);
		return listado;		
	}
	
	public cliente encontrarCliente(cliente clienteEncontrado) {
		
		Connection conn 	   = null;
		PreparedStatement ps   = null;
		ResultSet rs		   = null;
		
		try {
			conn = Conexion.getConnection();
			System.out.println("Haciendo Conexión");
			ps 	 = conn.prepareStatement(SELECT_BY_ID);
			System.out.println("Preparando consulta: " +SELECT_BY_ID);
			System.out.println("Ejecutando consulta");
			ps.setInt(1, clienteEncontrado.getId_cliente());
			rs	 = ps.executeQuery();	
			rs.absolute(1);
				
			String nombre		= rs.getString(2);
			String apellido 	= rs.getString(3);
			String email		= rs.getString(4);
			int telefono		= rs.getInt(5);
			double saldo 		= rs.getInt(6);
				
		//	clienteEncontrado= new cliente(nombre, apellido, email, telefono, saldo);				
			
			clienteEncontrado.setNombre(nombre);
			clienteEncontrado.setApellido(apellido);
			clienteEncontrado.setEmail(email);
			clienteEncontrado.setTelefono(telefono);
			clienteEncontrado.setSaldo(saldo);
			
			System.out.println(clienteEncontrado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Conexion.close(rs);
		Conexion.close(ps);
		Conexion.close(conn);
		return clienteEncontrado;		
	}
	
	
	public void actualizar(cliente clienteEncontrado) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = Conexion.getConnection();
			ps = conn.prepareStatement(UPDATE);
			ps.setString(1, clienteEncontrado.getNombre());
			ps.setString(2, clienteEncontrado.getApellido());
			ps.setString(3, clienteEncontrado.getEmail());
			ps.setInt(4, clienteEncontrado.getTelefono());
			ps.setDouble(5, clienteEncontrado.getSaldo());
			ps.setInt(6, clienteEncontrado.getId_cliente());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Conexion.close(rs);
		//Conexion.close(ps);
		//Conexion.close(conn);
	}
	
	public void delete( cliente clienteencontrado) {
		Connection conn 	 = null;
		PreparedStatement ps = null;	
		try {
			conn = Conexion.getConnection();
			ps = conn.prepareStatement(DELETE);
			ps.setInt(1,clienteencontrado.getId_cliente());
			ps.executeUpdate();
			System.out.println("-----CLIENTE ELIMINADO------");
			System.out.println(clienteencontrado);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	Conexion.close(ps);
	//	Conexion.close(conn);
	}
	
	public void insert(cliente clientes) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = Conexion.getConnection();
			ps = conn.prepareStatement(INSERT);
			ps.setString(1, clientes.getNombre());
			ps.setString(2, clientes.getApellido());
			ps.setString(3, clientes.getEmail());
			ps.setInt(4, clientes.getTelefono());
			ps.setDouble(5, clientes.getSaldo());
			ps.executeUpdate();
			System.out.println("Nuevo registro agregado");
			
			System.out.println(clientes);
			
		} catch (Exception e) {
			
		}
		
	}
}
