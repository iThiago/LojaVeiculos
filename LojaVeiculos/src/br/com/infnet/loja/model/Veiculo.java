package br.com.infnet.loja.model;

public class Veiculo {
	
	private int id;
	private String chassi;
	private String montadora;
	private String modelo;
	private int tipo;
	private String cor;
	private float preco;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getMontadora() {
		return montadora;
	}
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	
	
}
