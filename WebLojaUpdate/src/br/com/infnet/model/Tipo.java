package br.com.infnet.model;

import java.util.List;

public class Tipo {

	private int id;
	private String descricao;
	private List<Atributo> atributos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Atributo> getAtributos(){
		return atributos;
	}
	public void setAtributos(List<Atributo> atributos){
		this.atributos = atributos;
	}
	
}
