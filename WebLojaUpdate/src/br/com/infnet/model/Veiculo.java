package br.com.infnet.model;

import java.util.HashMap;

public class Veiculo {

	private HashMap<String,Object> atributos;
	private Tipo tipo;
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public HashMap<String, Object> getAtributos() {
		return atributos;
	}
	public void setAtributos(HashMap<String, Object> atributos) {
		this.atributos = atributos;
	}	
	
	
}
