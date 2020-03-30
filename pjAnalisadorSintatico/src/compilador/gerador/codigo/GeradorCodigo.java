package compilador.gerador.codigo;

import java.io.File;
import java.io.FileOutputStream;

import compilador.estruturas.String;
import compilador.helper.ArrayHelper;

public class GeradorCodigo {
	
	/**
	 * Buffer com as informa��es a serem inseridas na �rea de dados do c�digo-objeto.
	 */
	private BufferDados<String> bufferDados;
	
	/**
	 * Buffer com as informa��es a serem inseridas na �rea de c�digo do c�digo-objeto.
	 */
	private BufferCodigo<String> bufferCodigo;
	
	/**
	 * Endere�o (hexadecimal) do in�cio da �rea de c�digo.
	 */
	private static final int ENDERECO_AREA_CODIGO = 0;
	
	/**
	 * Endere�o (hexadecimal) do in�cio da �rea de dados.
	 */
	private static final int ENDERECO_AREA_DADOS = 200;
	
	public GeradorCodigo() {
		this.bufferCodigo = new BufferCodigo<String>();
		this.bufferDados = new BufferDados<String>();
	}
	
	/**
	 * Adiciona uma entrada na �rea de dados.
	 * @param str
	 */
	public void addAreaDados(String str) {
		this.bufferDados.add(str);
	}
	
	/**
	 * Adiciona uma entrada na �rea de c�digo.
	 * @param str
	 */
	public void addAreaCodigo(String str) {
		this.bufferCodigo.add(str);
	}
	
	/**
	 * Gera o c�digo-objeto completo.
	 * @return uma <code>compilador.estruturas.String</code> contendo todo o c�digo-objeto gerado.
	 */
	public String gerarCodigo() {
		String codigo = new String(("@ /"+GeradorCodigo.ENDERECO_AREA_CODIGO+"\n\tJP\tMAIN\n\n").toCharArray());
		
		while(!this.bufferCodigo.estaVazio())
			codigo = new String(ArrayHelper.concatenarVetoresChar(codigo.toCharArray(), this.bufferCodigo.proximo().toCharArray()));
		
		codigo = new String(ArrayHelper.concatenarVetoresChar(codigo.toCharArray(), ("\n@ /"+GeradorCodigo.ENDERECO_AREA_DADOS+"\n").toCharArray()));
		
		while(!this.bufferDados.estaVazio())
			codigo = new String(ArrayHelper.concatenarVetoresChar(codigo.toCharArray(), this.bufferDados.proximo().toCharArray()));
		
		this.gerarArquivoObjeto(codigo);
		
		return codigo;
	}
	
	private void gerarArquivoObjeto(String codigo) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("src/compilador/testes/source.asm"));
			fos.write(codigo.toString().getBytes());
			fos.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}