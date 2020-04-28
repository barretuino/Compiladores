package teste.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSimples3 {
	public RegexSimples3() {
		//valores a serem testados em um array
		String[] valores = {"testando1palavra","teste numero","teste3", "123","abc"};
		
		
		// \w{3} numero ou letras com exatamente 3 caracteres
		checkRegex(valores,"\\w{3}");
		
		//[a-z]+: uma letra obrigatorio ou mais que uma letra
		//[1]? pode aparecer o numero 1 ou nao no meio da palavra
		//[a-z]* pode aparecer nenhum ou varias letras depois
		checkRegex(valores,"[a-z]+[1]?[a-z]*");
		
		//[a-z]{1,5} no minimo 1 e no maximo 5
		//[0-9]* nenhum ou varios numeros
		checkRegex(valores,"[a-z]{1,5}[0-9]*");

	}

	public static void main(String[] args) {
		//criar uma nova classe assim que o programa e executado
		new RegexSimples3();
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
