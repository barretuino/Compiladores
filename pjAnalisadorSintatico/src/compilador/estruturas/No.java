package compilador.estruturas;

public class No<T> {
	
	/**
	 * Refer�ncia para o pr�ximo n�.
	 */
	private No<T> proximo;
	
	/**
	 * Valor armazenado por este n�.
	 */
	private T valor;
	
	public No(T valor, No<T> proximo) {
		this.valor = valor;
		this.proximo = proximo;
	}
	
	/**
	 * @return o pr�ximo <code>No</code>.
	 */
	public No<T> proximo() {
		return this.proximo;
	}
	
	/**
	 * Seta o pr�ximo <code>No</code>.
	 * 
	 * @param proximo
	 */
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	
	/**
	 * @return o valor armazenado por este <code>No</code>.
	 */
	public T getValor() {
		return this.valor;
	}
}