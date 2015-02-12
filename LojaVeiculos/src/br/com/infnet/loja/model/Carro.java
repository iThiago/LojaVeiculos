package br.com.infnet.loja.model;

public class Carro extends Veiculo{
	
	private float motorização; 
	private String cambio;
	
	public float getMotorização() {
		return motorização;
	}
	public void setMotorização(float motorização) {
		this.motorização = motorização;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	
}
