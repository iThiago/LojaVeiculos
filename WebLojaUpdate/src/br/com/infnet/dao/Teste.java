package br.com.infnet.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import br.com.infnet.model.Atributo;
import br.com.infnet.model.Tipo;
import br.com.infnet.model.Veiculo;

public class Teste {

	public static void main(String[] args){
		Tipo tipo = new Tipo();
		
		HashMap<String, Object> atributosVeiculo = new HashMap<String, Object>();
		
		Veiculo veiculo = new Veiculo();
		try {
			TipoDAO dao = new TipoDAO();
			AtributoDAO atrdao = new AtributoDAO();
			AtributoTipoDAO av = new AtributoTipoDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Atributo> atributos = new ArrayList<Atributo>();
		Atributo attr = new Atributo();
		attr.setId(1);
		attr.setDescricao("MOTORIZACAO");
		atributos.add(attr);
		attr = new Atributo();
		
		attr.setId(1);
		attr.setDescricao("TESTE");
		atributos.add(attr);
		
		tipo.setAtributos(atributos);
		
		for(Atributo attrr : tipo.getAtributos()){
			int i = 2;
			Object variavel = "a";
			
			atributosVeiculo.put(attrr.getDescricao(), variavel);
		}
		veiculo.setAtributos(atributosVeiculo);
		
		//veiculos.add(veiculo);
		
		for(Entry<String, Object> entri : veiculo.getAtributos().entrySet()){
			System.out.println(entri.getKey() + " - " + entri.getValue());
		}
	}

}
