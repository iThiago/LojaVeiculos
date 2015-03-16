package br.com.infnet.enums;

public enum Tipo {
	
	
	SELECIONE(1),
	SEDAN(2),
	Hatch(3),
	FURGAO(4),
	SUV(5),
	PICKUPS(6),
	SPORTS(7),
	GRADCAB(8),
	OUTRO(9);
	
	public int tipo; 
	
	Tipo(int valor) 
	{ 
		tipo = valor;
	}
	
	
}
