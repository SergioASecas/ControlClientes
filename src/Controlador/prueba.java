package Controlador;

import Modelo.cliente;

public class prueba { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAOCliente cliente = new DAOCliente();
		cliente clienteI = new Modelo.cliente("Carmen", "Moreno", "Abuelame", 23568, 2028282.9);
		cliente.insert(clienteI);
		cliente.lista(); 
	}

}
