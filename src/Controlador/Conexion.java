package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.*;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion { 
		 
	private static final String URL = "jdbc:mysql://localhost:3306/clientes?useSSL=false&serverTimezone=UTC";
	private static final String USER= "root";
	private static final String PASSWORD="admin";
	
	private static BasicDataSource bds;
	
    public static DataSource getDataSource() {    
    	//Pool de conexiones
    
    	if (bds==null) {
    		bds = new BasicDataSource();
        	bds.setUrl(URL); 
        	bds.setUsername(USER); 
        	bds.setPassword(PASSWORD);    	
        	bds.setInitialSize(50);
		}
    	    	 
    	return bds;
    }
     
    public static Connection getConnection() throws SQLException{
    	return getDataSource().getConnection();
    }
	
    
    public static void close(ResultSet rs) {
    	try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
    
    public static void close(PreparedStatement ps) {
    	try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void close(Connection conn) {
    	try {
			conn.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
