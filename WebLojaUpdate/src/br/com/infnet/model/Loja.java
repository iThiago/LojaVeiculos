package br.com.infnet.model;

import java.util.List;

public class Loja {

	private int idLojas;
	private String nome;
	private String endereco;
	private List<Veiculo> veiculos;
	
	
	public Loja() {
		super();
	}
	
	public Loja(int idLojas, String nome, String endereco) {
		super();
		this.idLojas = idLojas;
		this.nome = nome;
		this.endereco = endereco;
	}
	public Loja(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}
	public Loja(Loja loja) {
		super();
		this.idLojas = loja.getId();
		this.nome = loja.getNome();
		this.endereco = loja.getEndereco();
	}
	public int getId() {
		return idLojas;
	}
	public void setId(int id) {
		this.idLojas = id;
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
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public void entrarEstoque() {
		
	}
	
}
