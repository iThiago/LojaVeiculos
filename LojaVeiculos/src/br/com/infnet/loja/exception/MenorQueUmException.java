package br.com.infnet.loja.exception;

public class MenorQueUmException extends RuntimeException{

	public MenorQueUmException(String message){
		System.out.println(message);
	}
	
	public MenorQueUmException(){
		System.out.println("N�o s�o permitidos valores menores ou iguais a 0!");
	}
	
	
}
