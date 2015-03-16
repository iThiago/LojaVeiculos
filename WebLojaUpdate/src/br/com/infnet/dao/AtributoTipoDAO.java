package br.com.infnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import br.com.infnet.jdbc.ConnectionFactory;

public class AtributoTipoDAO {

	
	private Connection connection;
	
	public AtributoTipoDAO() throws ClassNotFoundException, SQLException
	{
		connection = new ConnectionFactory().getConnection();
		
		String sql = "CREATE TABLE IF NOT EXISTS ATRIBUTOTIPO( "
				+	"ID INT NOT NULL AUTO_INCREMENT, "
				+	"TIPOID INT NOT NULL, "
				+	"ATRIBUTOID INT NOT NULL, "
				+	"PRIMARY KEY(ID), "
				+	"FOREIGN KEY(TIPOID) REFERENCES TIPO(ID), "
				+	"FOREIGN KEY(ATRIBUTOID) REFERENCES ATRIBUTOS(ID));";
		//System.out.println(sql);
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.executeUpdate();
		ps.close();
		
	}
	
	
	public void setAtributesInType(HashMap<String,Object> atributos,int tipoId){
		
		String sql = "Insert into ";
		
		
		
		
	}
	
	
}
