package br.barretuino.test;

public class Teste {

	public static boolean numeroValido(int numero) {
		int nroCopy = numero;
		int valorFinal = nroCopy % 10;
		int value = numero;
		int soma = 0;
		while(value != 0) {
			soma = numero % 10;
			value = value / 10;
		}
		
		if(soma % 11 == valorFinal) {
			return Boolean.TRUE;
		}		
		return false; //TODO
	}
	public static void main(String[] args) {
		System.out.println(" é " + numeroValido(43675));
	}
}
