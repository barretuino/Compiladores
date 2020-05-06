package pjAula14;

import java.util.HashMap;
import java.util.Map;

class Vocabulo{
	String id;
	String sintaxe;
	public Vocabulo(String id, String sintaxe) {
		super();
		this.id = id;
		this.sintaxe = sintaxe;
	}	
}

public class Vocabulario {
	public static void main(String[] args) {
		Map<String, Vocabulo> ts = new HashMap<String, Vocabulo>();
		
		Vocabulo _if = new Vocabulo("_if", "if(<expressao>){<bloco>}");
		Vocabulo _else = new Vocabulo("_else", "else{<bloco>}");
		
		ts.put(_if.id, _if);
		//ts.put(_else.id, _else);
		
		if(ts.containsKey(_else.id)) {
			System.out.println(ts.get(_else.id).sintaxe);
		}else {
			System.out.println(new Throwable("Comando não encontrado na LP"));
		}
	}	
	
}
