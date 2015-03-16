package br.com.infnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.infnet.jdbc.ConnectionFactory;
import br.com.infnet.model.Atributo;
import br.com.infnet.model.Tipo;

public class AtributoDAO {
	
	private Connection connection;
	
	public AtributoDAO() throws ClassNotFoundException, SQLException
	{
		this.connection = new ConnectionFactory().getConnection();
		
		TipoDAO tipoDAO = new TipoDAO();
		StringBuilder sql = new StringBuilder();
		
			sql.append("CREATE TABLE IF NOT EXISTS ATRIBUTOS(");
			sql.append(" ID INT NOT NULL AUTO_INCREMENT,");
			sql.append(" DESCRICAO VARCHAR(80) NOT NULL,");
			sql.append(" PRIMARY KEY(ID));");
			PreparedStatement ps = connection.prepareStatement(sql.toString());
			ps = connection.prepareStatement(sql.toString());
			ps.executeUpdate();
			ps.close();
			
	}
	
	public List<Atributo> GetAtributosPorTipo(int tipoId) throws SQLException{
		
		List<Atributo> atributos = new ArrayList<Atributo>();
		
		String sql = "SELECT * FROM ATRIBUTOTIPO AT, ATRIBUTOS A WHERE AT.ATRIBUTOID = A.ID AND AT.TIPOID = ?";
		
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setInt(1, tipoId);
		ResultSet rs = ps.executeQuery();
		Atributo atributo = new Atributo();
		while(rs.next()){
			atributo.setId(rs.getInt("ID"));
			atributo.setDescricao(rs.getString("DESCRICAO"));
			
			atributos.add(atributo);
		}
		
		return atributos;
	}
	
	public void Inserir(List<Atributo> atributos) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		for(Atributo atributo : atributos)
		{
			sql.append("INSERT INTO ATRIBUTO(DESCRICAO)");
			sql.append(" VALUES( ? ); ");
			
			PreparedStatement ps = connection.prepareStatement(sql.toString());
			ps.setString(1, atributo.getDescricao());
			ps.executeUpdate();
			ps.close();
		}
		
	}

	public void ExcluirAtributosPorTipoId(int id) throws SQLException {

		String sql = "DELETE FROM ATRIBUTOS WHERE TIPOID = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.executeUpdate();
		ps.close();
		
	}

}
