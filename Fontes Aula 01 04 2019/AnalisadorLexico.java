 package compiladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnalisadorLexico {
	public static String retirarIdentacao(String fonte) {
		String saida = fonte.replaceAll("\t","");
		return saida;
	}
	
	public static String mimificacao(String fonte) {
		String saida = fonte.replaceAll("\t","").replaceAll("\n", "");
		return saida;
	}

	public static String retirarComentarios(String fonte) {
		String saida = "";
		String codigo[] = fonte.split("\n");
		for(int i=0; i<codigo.length; i++) {
			if(codigo[i].contains("\\**") || codigo[i].contains("*/")) {					
				while(!codigo[i].contains("*/")) {
					i++;
				}					
			}else {
				if(!codigo[i].contains("//")) {
					saida += codigo[i] + "\n";	
				}				
			}			
		}
		
		return saida;
	}
	
	public static String origemArquivo(String url) {
		File arquivo = new File(url);
		
		if(!arquivo.exists()){
			System.err.println("Desculpe, o arquivo " + url + " n�o foi encontrado.");
		}		
		
		BufferedReader buffer;
		String retorno = "";
		try {
			buffer = new BufferedReader(new FileReader(url));
			String linha;
			while ((linha = buffer.readLine()) != null) {
				 retorno += linha + "\n";
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return retorno;
	}
	
	public static void main(String[] args) {
		String fonte = "public class Produto() {\n";
		fonte += "\n";
		fonte += "	//Atributos - Exemplo de Coment�rio Curto\n";
		fonte += "	int codigo = 0;\n";
		fonte += "	String descricao = \"Novo Produto\";\n";
		fonte += "	float quantidade = 1000f;\n";
		fonte += "	boolean status = true;\n";
		fonte += "\n";
		fonte += "	\\**\n";
		fonte += "		M�todo para imprimir informa��es de produto\n";
		fonte += "		exemplo de coment�rio longo\n";
		fonte += "	*/\n";
		fonte += "	public void imprimir(){\n";
		fonte += "		System.out.println(\"C�digo do produto � \" + codigo);\n";
		fonte += "		System.out.println(\"Descri��o do produto � \" + descrica);\n";
		fonte += "	}\n";
		fonte += "\n";
		fonte += "}\n";		
		
		System.out.println(fonte);
		
		//Retirando a identa��o do c�digo
		System.out.println(retirarIdentacao(fonte));

//		//Realizar a Mimifica��o
		System.out.println(mimificacao(fonte));
//		
//		//Retirar coment�rios curtos e longos
		System.out.println(retirarComentarios(fonte));
//		
//		//Quando o fonte tem origem em um arquivo
		String entrada = origemArquivo("C:\\Users\\Paulo\\eclipse-workspace\\pjSistemaVenda\\src\\br\\barretuino\\modelagem\\Pessoa.java");
		System.out.println(entrada);
	}	
}