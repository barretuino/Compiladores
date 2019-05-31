package br.barretuino.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static String[] popular(String conteudo, String separador) {
		return conteudo.split(separador);
	}
	
	public static List<String[]> popular(List<String> conteudo, String separador) {
		List<String[]> lista = new ArrayList<String[]>();
		
		for(String linha : conteudo) {
			lista.add(linha.split(separador));
		}
		
		return lista;
	}
}