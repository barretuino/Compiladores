package compiladores;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class AnalisadorSemantico {	
    public static void teste(String s) throws IOException {        
        StreamTokenizer st = new StreamTokenizer (new StringReader (s));
        st.ordinaryChar('/');        
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            switch (st.ttype) {
            case StreamTokenizer.TT_NUMBER:
                System.out.println ("Número: " + st.nval);
                break;
            case StreamTokenizer.TT_WORD:
                System.out.println ("Palavra-chave ou identificador: '" + st.sval + "'");
                break;
            case StreamTokenizer.TT_EOL:
                System.out.println ("Fim de linha:");
                break;
            case '(':
                System.out.println ("Abre parênteses");
                break;
            case ')':
                System.out.println ("Fecha parênteses");
                break;
            case '+':
                System.out.println ("Mais");
                break;
            case '/':
                System.out.println ("Dividir");
            case '*':
                System.out.println ("Multiplicar");
                break;
            default:
                System.out.println ("Token = '" + (char) st.ttype + "'");
            }
        }
    }
    public static void main(String[] args) throws IOException {		
        teste("System.out.println(\"Bom Dia Mundo\");");
        teste("s = (a + b * 36.14);");
    }
}