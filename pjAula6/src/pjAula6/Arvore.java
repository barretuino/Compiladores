package pjAula6;

import java.util.Scanner;

public class Arvore{

    private static class ARVORE {
 
        public int num;
        public ARVORE dir, esq;
    }
 
    public static ARVORE inserir(ARVORE aux, int num) {
        if (aux == null) {
            aux = new ARVORE();
            aux.num = num;
            aux.esq = null;
            aux.dir = null;
 
        } else if (num < aux.num) {
            aux.esq = inserir(aux.esq, num);
        } else {
            aux.dir = inserir(aux.dir, num);
        }
        return aux;
    }
 
    public static String imprimir(ARVORE aux) {
    	String retorno;
    	retorno = "(";
        if (aux != null) {
        	retorno += "C" + aux.num; 
            retorno += imprimir(aux.esq);
            retorno += imprimir(aux.dir);
        }
        retorno += ")";
        return retorno;
    }
    
    public static boolean localizar(ARVORE aux, int num, boolean loc) {
        if (aux != null && loc == false) {
            if (aux.num == num) {
                loc = true;
            } else if (num < aux.num) {
                loc = localizar(aux.esq, num, loc);
            } else {
                loc = localizar(aux.dir, num, loc);
            }
        }
        return loc;
    }
    
    public static ARVORE excluir(ARVORE aux, int num) {
        ARVORE p, p2, r = null;
        if (aux.num == num) {
            if (aux.esq == aux.dir) {
                return null;
            } else if (aux.esq == null) {
                return aux.dir;
            } else if (aux.dir == null) {
                return aux.esq;
            } else {
                p2 = aux.dir;
                p = aux.dir;
                while (p.esq != null) {
                	r = p;
                    p = p.esq;
                }
                aux.num = p.num;
                p = null;
                r.esq = null;
                return aux;
            }
        } else if (aux.num < num) {
            aux.dir = excluir(aux.dir, num);
        } else {
            aux.esq = excluir(aux.esq, num);
        }
        return aux;
    }
  
    public static void main(String[] args) {
        
    	Scanner entrada = new Scanner(System.in);
    	ARVORE a = null;
        int n = entrada.nextInt();
    	
        for(int i = 0; i < n; i++){
        	a = inserir(a, entrada.nextInt());
        }
        int num = entrada.nextInt();
        if( localizar(a, num, false)){
        	excluir(a, num);
        }
        else{
        	inserir(a, num);
        }
        System.out.println(imprimir(a));
    }
}