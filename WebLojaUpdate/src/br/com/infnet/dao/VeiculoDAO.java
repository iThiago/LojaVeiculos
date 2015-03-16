package br.com.infnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.infnet.jdbc.ConnectionFactory;
import br.com.infnet.model.Atributo;
import br.com.infnet.model.Tipo;
import br.com.infnet.model.Veiculo;

public class VeiculoDAO {


	private Connection connection;

	public VeiculoDAO()throws SQLException, ClassNotFoundException{
	
		this.connection = new ConnectionFactory().getConnection();
		
		TipoDAO tipoDAO = new TipoDAO();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("CREATE TABLE IF NOT EXISTS VEICULOS( ");
			
			sql.append("ID INT NOT NULL AUTO_INCREMENT, ");
			sql.append("CHASSI VARCHAR(13) NOT NULL UNIQUE, ");
			sql.append("COR VARCHAR(30), ");
			sql.append("IDLOJA INT NOT NULL, ");
			sql.append("MODELO VARCHAR(30), ");
			sql.append("MONTADORA VARCHAR(80), ");
			sql.append("PRECO DECIMAL(8,2) NOT NULL, ");
			sql.append("CAMBIO VARCHAR(90), ");
			sql.append("MOTORIZACAO FLOAT, ");
			sql.append("CAPACIDADETANQUE INT, ");
			sql.append("CILINDRADA INT, ");
			sql.append("PRIMARY KEY(ID), ");
			sql.append("FOREIGN KEY(IDLOJA) REFERENCES LOJAS(IDLOJA)); ");
			
			PreparedStatement ps = connection.prepareStatement(sql.toString());
			ps.executeUpdate();
			ps.close();
			
	}
	
	public List<Veiculo> GetListVeiculos() throws SQLException, ClassNotFoundException{
		
		TipoDAO tipoDAO = new TipoDAO();
		
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		String sql = "SELECT * FROM VEICULOS";
		
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		Veiculo veiculo = new Veiculo();
		HashMap<String, Object> atributosVeiculo = new HashMap<String, Object>();
		
		while(rs.next()){
			Tipo tipo = new Tipo();
			tipo = tipoDAO.obterPorId(rs.getInt("TIPOID"));
			veiculo.setTipo(tipo);
			
			for(Atributo attr : tipo.getAtributos()){
				atributosVeiculo.put(attr.getDescricao(), rs.getObject(attr.getDescricao()));
			}
			
			veiculo.setAtributos(atributosVeiculo);
			veiculos.add(veiculo);
			
		}
		
		return veiculos;
	}
	
}
