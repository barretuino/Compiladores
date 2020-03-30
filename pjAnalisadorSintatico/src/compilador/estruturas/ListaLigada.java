package compilador.estruturas;


public class ListaLigada<T> {
	
	/**
	 * O <code>No</code> inicial da lista ligada.
	 */
	private No<T> inicio;
	
	/**
	 * O tamanho atual da lista ligada.
	 */
	private int tamanho;
	
	public ListaLigada() {
		this.inicio = null;
		this.tamanho = 0;
	}
	
	/**
	 * Retorna o item da posi��o especificada.
	 * 
	 * @param indice
	 * @return
	 */
	public T get(int indice) {
		No<T> no = this.inicio;
		for(int i = 0; i < this.tamanho; i++) {
			if(i == indice)
				return no.getValor();
			no = no.proximo();
		}
		
		return null;
	}
	
	/**
	 * Insere um item na lista ligada.
	 * 
	 * @param item
	 */
	public void put(T item) {
		this.inicio = new No<T>(item, this.inicio);
		this.tamanho++;
	}
	
	/**
	 * Remove um item da lista ligada.
	 * 
	 * @param indice o �ndice do item a ser removido.
	 * @return <code>true</code>, caso o item foi removido. <code>false</code>, caso contr�rio.
	 */
	public boolean remove(int indice) {
		if(indice >= this.tamanho)
			return false;
		
		if(indice == 0) {
			this.inicio = this.inicio.proximo();
			this.tamanho--;
			return true;
		}
		
		No<T> no = this.inicio;
		for(int i = 0; i < indice - 1; i++)
			no = no.proximo();
		
		no.setProximo(no.proximo().proximo());
		this.tamanho--;
		
		return true;
	}
	
	/**
	 * Retorna a posi��o da primeira ocorr�ncia do item especificado.
	 * @param item
	 * @return a posi��o encontrada ou -1 caso o item n�o esteja na lista ligada. 
	 */
	public int localiza(T item) {
		No<T> no = this.inicio;
		for(int i = 0; i < this.tamanho; i++) {
			if(item.equals(no.getValor()))
				return i;
			no = no.proximo();
		}
		
		return -1;
	}
	
	/**
	 * @return o tamanho atual da lista ligada.
	 */
	public int tamanho() {
		return this.tamanho;
	}
	
	/**
	 * Verifica se a lista ligada est� vazia.
	 * 
	 * @return <code>true</code>, caso a lista ligada esteja vazia. <code>false</code>, caso contr�rio.
	 */
	public boolean vazia() {
		return (this.tamanho == 0);
	}
}