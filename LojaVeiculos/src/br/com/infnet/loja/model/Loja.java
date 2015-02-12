package br.com.infnet.loja.model;

import java.util.List;

public class Loja {

	private int id;
	private String nome;
	private String endereco;
	private List<Carro> carros;
	private List<Motocicleta> motocicletas;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Carro> getCarros() {
		return carros;
	}
	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	public List<Motocicleta> getMotocicletas() {
		return motocicletas;
	}
	public void setMotocicletas(List<Motocicleta> motocicletas) {
		this.motocicletas = motocicletas;
	}
	
	
}
