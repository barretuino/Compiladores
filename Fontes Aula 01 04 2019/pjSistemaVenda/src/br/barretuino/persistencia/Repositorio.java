package br.barretuino.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.barretuino.modelagem.Pessoa;

public class Repositorio {	
	File arquivo;
	public Repositorio(String url) {
		File arquivo = new File(url);
		
		if(!arquivo.exists()){
			//Criar o arquivo
			try {
				arquivo.createNewFile();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}		
		this.arquivo = arquivo;
	}
	
	public static void escrever(String url, List<Pessoa> lista) throws IOException{
		FileWriter escrita = new FileWriter(url);
		PrintWriter grava = new PrintWriter(escrita);
		
		for(Pessoa p : lista){
			grava.println(p);
		}
		escrita.close();
	}
	
	public static List<String> ler(String url) throws IOException{
		new Repositorio(url);
		
		BufferedReader buffer = new BufferedReader(new FileReader(url));
		List<String> lista = new ArrayList<String>();
		
		String linha;
		while ((linha = buffer.readLine()) != null) {
		     lista.add(linha);
		}

		buffer.close();
		
		return lista;
	}
	
}