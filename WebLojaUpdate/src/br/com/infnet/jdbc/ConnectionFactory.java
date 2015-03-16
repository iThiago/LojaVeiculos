package br.com.infnet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() throws ClassNotFoundException {
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			//return DriverManager.getConnection("jdbc:mysql://db4free.net/infnetloja","loja","$Passw0rd");
			return DriverManager.getConnection("jdbc:mysql://localhost:3307/infnetloja","root","usbw");
			
		} catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}