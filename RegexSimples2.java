package teste.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSimples2 {
	public RegexSimples2() {
		//valores a serem testados em um array
		String[] valores = {" ","b","c", "_", "1", "2", "3", "4"};
		//chamando o metodo para printar na tela
		//expressao que so aceita letras de A ate Z
		checkRegex(valores,"\\w");

		//expressao que so aceita letras de A ate B e de D ate Z
		checkRegex(valores,"\\s");

		//Os mesmos valores para uma expressao diferente, so aceita numericos
		checkRegex(valores,"\\d");

	}

	public static void main(String[] args) {
		//criar uma nova classe assim que o programa e executado
		new RegexSimples2();
	}

	private void checkRegex(String[] valores, String expressao) {

		System.out.println("\r\nNovo Teste:");
		//Looping para varrer todos os valores a serem testados
		for (String valor : valores) {

			//Setando a expressao regular passada de parametro
			Pattern pattern = Pattern.compile(expressao);

			//Setando com o valor atual, a ser testado, no loop
			Matcher matcher = pattern.matcher(valor);

			//imprimir resultado na tela
			System.out.println("o Valor " + valor + " para a expressao " + expressao + " resultou em " + matcher.matches());
		}
	}
}