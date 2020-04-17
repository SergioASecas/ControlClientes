package Modelo;

public class cliente {
	   
	private int id_cliente,telefono;
	private String nombre,apellido,email;
	private double saldo;
	
	
	public cliente() { 
		  
	} 
	 
	public cliente(int id_cliente) { 
		this.id_cliente = id_cliente; 
	}
	
	public cliente(int id_cliente, String nombre, String apellido, String email, int telefono, double saldo) {
		super();
		this.id_cliente = id_cliente;		
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.saldo = saldo;
	}
	

	public cliente(String nombre, String apellido, String email, int telefono, double saldo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.saldo = saldo;
	}

	
	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "cliente [id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellido="
				+ apellido + ", email=" + email + ", telefono=" + telefono + ", saldo=" + saldo + "]";
	}

	
}
