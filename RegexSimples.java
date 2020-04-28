package teste.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSimples {
	public RegexSimples() {
		//valores a serem testados em um array
		String[] valores = {"a","b","c", "d", "1", "2", "3", "4"};
		//chamando o metodo para printar na tela
		//expressao que so aceita letras de A ate Z
		checkRegex(valores,"[a-z]");

		//expressao que so aceita letras de A ate B e de D ate Z
		checkRegex(valores,"[a-bd-z]");

		//Os mesmos valores para uma expressao diferente, so aceita numericos
		checkRegex(valores,"[0-9]");

		//Os mesmos valores para uma expressao diferente, so aceita numericos retirando o numero 1
		checkRegex(valores,"[0-9&&[^1]]");
	}

	public static void main(String[] args) {
		//criar uma nova classe assim que o programa e executado
		new RegexSimples();
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