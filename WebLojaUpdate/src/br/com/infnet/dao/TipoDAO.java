package br.com.infnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.infnet.jdbc.ConnectionFactory;
import br.com.infnet.model.Atributo;
import br.com.infnet.model.Tipo;

public class TipoDAO {
	
	private Connection connection;
	
//	
	List<Atributo> atributos = null;
	
	public TipoDAO() throws ClassNotFoundException, SQLException
	{
		this.connection = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("CREATE TABLE if not exists TIPO(");
		sql.append("ID INT NOT NULL AUTO_INCREMENT, ");
		sql.append("DESCRICAO VARCHAR(40) NOT NULL, ");
		sql.append("PRIMARY KEY(ID));");
		
		Statement stmt = this.connection.createStatement();
		stmt.executeUpdate(sql.toString());
		stmt.close();
		
	}
	
	//@SuppressWarnings("unused")
	public Tipo obterPorId(int id) throws SQLException, ClassNotFoundException{
		
		Tipo tipo = null;
		
		String sql = "SELECT * FROM TIPO WHERE ID = ?";
		
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		AtributoDAO atributoDAO = new AtributoDAO();
		if(rs.next()){
			tipo.setId(rs.getInt("ID"));
			tipo.setDescricao(rs.getString("DESCRICAO"));
			
			atributos = atributoDAO.GetAtributosPorTipo(tipo.getId());
			tipo.setAtributos(atributos);
		}
		
		return tipo;
	}
	
//	@SuppressWarnings("unused")
	public List<Tipo> getList() throws SQLException, ClassNotFoundException{
		
		Tipo tipo = null;
		
		List<Tipo> tipos = new ArrayList<Tipo>();
		
		String sql = "SELECT * FROM TIPO WHERE ID = ?";
		
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		AtributoDAO atributoDAO = new AtributoDAO();
		while(rs.next()){
			tipo.setId(rs.getInt("ID"));
			tipo.setDescricao(rs.getString("DESCRICAO"));
			atributos = atributoDAO.GetAtributosPorTipo(tipo.getId());
			tipo.setAtributos(atributos);
			
			
			tipos.add(tipo);
		}
		
		return tipos;
	}
	
	public void Inserir(Tipo tipo) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO TIPO");
		sql.append(" (DESCRICAO)");
		sql.append(" VALUES( ? )");
		
		PreparedStatement ps = connection.prepareStatement(sql.toString());
		ps.setString(1, tipo.getDescricao());
		ps.executeUpdate();
		ps.close();
		
	}

	public void Excluir(int id) throws SQLException, ClassNotFoundException{
		
		String sql = "DELETE * FROM TIPO WHERE ID = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		
		AtributoDAO attrDAO = new AtributoDAO();
		attrDAO.ExcluirAtributosPorTipoId(id);
		
		ps.executeUpdate();
		ps.close();
		
	}

}
