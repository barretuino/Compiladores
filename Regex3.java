package teste.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Referencia
// http://docs.oracle.com/javase/tutorial/essential/regex/

public class Regex3 {
	public Regex3() {

		//E-mail que gostaria de testar
		String[] emails = { "pauloo@aeae", "pauloo@@", "", "l", "pauloo",
				"luaas.ior.io@gmail.com", "pauloo@gmail..com",
				"pauloo@gmail.a", "pauloo@a.com", "paul3o@a.com",
				"pauloo@gmail.com.", "pauloo@gmail.com",
				"paulo.ioro@gmail.com", "paulo-iorio@gmail.com",
				"paulo2-iorio@gmail.com", "paulo2-iorio@cas-tecnologia.com.br",
				"capitani.paulo.iorio@br.experian.com",
				"capitani....paulo.iorio@br.experian.com",
				"&capitani....paulo.iorio@br.experian.com" };

		//Testando todos os e-mails
		for (String email : emails) {
			if (email != null) {
				System.out.println(email + " : " + checkEmail(email));
			}

		}
	}

	public static void main(String args[]) {
			new Regex3();
	}

	private boolean checkEmail(String email) {
		//Registrando a expressao
		Pattern pattern = Pattern.compile("[\\w-_.&]+@[\\w-_&]+[.]{1}[\\w-_]+[.]?[\\w-_]+");
		Matcher matcher = pattern.matcher(email);

		//checando
		return matcher.matches();
	}
}