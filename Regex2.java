package teste.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Referencia
// http://docs.oracle.com/javase/tutorial/essential/regex/

public class Regex2 {
	public Regex2() {

		//Bem simples, uma palavra somente
		String frase = " foofoofoo foo foo fooo";

		//Onde registramos a expressão regular
		Pattern pattern = Pattern.compile("foo");

		//Onde registramos o comparador
		Matcher matcher = pattern.matcher(frase);

		//Loop para verificar o que foi encontrado
		while (matcher.find()) {
			System.out.printf("Encontrado: \"%s\" de %d à %d.%n",
					matcher.group(), matcher.start(), matcher.end());
		}

		//Testando se exatamente
		if (matcher.matches()) {
			System.out.println("Bateu exatamente");
		}else{
			System.out.println("Nao Bateu exatamente");
		}
	}

	public static void main(String args[]) {
		new Regex2();
	}

}