package Hash;

/**
 * 
 * @author Marc Fonseca
 *
 * @param <T> - valor generalitzat
 * @param <K> - clau
 */

public class NodeHashGeneric<T, K>{
	private T valor;
	private K key;
	private NodeHashGeneric<T, K> seguent;
	
	/**
	 * Constructor
	 */
	public NodeHashGeneric (){
		valor = null;
		key = null;
		seguent = null;
	}
	
	/**
	 * Constructor
	 * @param data - valor
	 * @param key - "posicio de la taula"
	 */
	public NodeHashGeneric (T data, K key){
		this.valor = data;
		this.key = key;
		seguent = null;
	}

	/**
	 * Getter valor
	 * @return valor
	 */
	public T getValor() {
		return valor;
	}

	/**
	 * Setter valor
	 * @param data - valor
	 */
	public void setValor(T data) {
		this.valor = data;
	}

	/**
	 * Getter clau
	 * @return "posicio de la taula"
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Setter clau
	 * @param key - "posicio de la taula"
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * Getter seguent
	 * @return seguent node
	 */
	public NodeHashGeneric<T, K> getSeguent() {
		return seguent;
	}

	/**
	 * Setter seguent
	 * @param seguent - seguent node
	 */
	public void setSeguent(NodeHashGeneric<T, K> seguent) {
		this.seguent = seguent;
	}

	@Override
	public String toString() {
		return "[valor = " + valor + ", key = " + key + "] seguent = " + seguent;
	}

	
}
