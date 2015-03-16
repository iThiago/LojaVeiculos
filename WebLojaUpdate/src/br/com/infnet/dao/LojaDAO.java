package br.com.infnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.infnet.jdbc.ConnectionFactory;
import br.com.infnet.model.Loja;

public class LojaDAO {

private Connection connection;
	
	public LojaDAO() throws ClassNotFoundException {
		
		this.connection = new ConnectionFactory().getConnection();
		
		String sql =	"CREATE TABLE IF NOT EXISTS `Lojas` (" +
				  		"`idLoja` INT NOT NULL AUTO_INCREMENT," +
				  		"`nome` VARCHAR(255) NULL," +
				  		"`endereco` VARCHAR(255) NULL," +
				  		"PRIMARY KEY (`idLoja`));";
		try {
			
			Statement stmt = this.connection.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Loja> listar() {
		
		ArrayList<Loja> lojas = new ArrayList<Loja>();
		
		String sql =	"SELECT * FROM `Lojas`";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Loja loja = new Loja(rs.getInt("idLoja"),rs.getString("nome"),rs.getString("endereco"));
				lojas.add(loja);
			}
			
			rs.close();
			stmt.close();
			
			return lojas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adicionar(Loja loja) {
		String sql = 	"INSERT INTO `Lojas`" +
						"(`nome`, `endereco`)" +
						"values (?,?);";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, loja.getNome());
			stmt.setString(2, loja.getEndereco());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(int id) {
		
		String sql = 	"DELETE FROM `Lojas` WHERE `idLoja`= ? ;";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			
		}
	}

	public Loja ObterPorId(int idLoja) {

		
		Loja loja = null;
		
		String sql = "SELECT * FROM LOJAS WHERE idLoja = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idLoja);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				loja = new Loja(rs.getInt("idLoja"),rs.getString("nome"),rs.getString("endereco"));
			}
			
			rs.close();
			stmt.close();
			
			return loja;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
			
	}

	
	
}
