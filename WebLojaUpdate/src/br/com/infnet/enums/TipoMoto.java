package br.com.infnet.enums;

public enum TipoMoto {

	Selecione(1),
	Bobber(2),
	CafeRacer(3),
	Custom(4),
	Chopper(5),
	Esportiva(6),
	FunBike(7),
	Naked(8),
	Scooters(9),
	Underbones(10);
	
	public int tipo;
	
	TipoMoto(int valor){
	
		tipo = valor;
		
	}
	
}
