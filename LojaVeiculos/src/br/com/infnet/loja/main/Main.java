package br.com.infnet.loja.main;

import br.com.infnet.loja.exception.MenorQueUmException;
import br.com.infnet.loja.model.Carro;

public class Main {

	public static void main(String[] args) {
	
		Carro carro = new Carro();
		
		try{
			carro.setId(-1);
			carro.setCambio("Cambio teste");
			carro.setChassi("12321");
			carro.setCor("Azul");
			carro.setModelo("Modelo teste 1");
			carro.setMontadora("Montadora teste 1");
			carro.setMotorização(12.3f);
			carro.setPreco(20.300f);
			carro.setTipo("Sedan");
			
			//System.out.println(carro.getId());
			
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

}
