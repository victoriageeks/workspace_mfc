/**
 * Classe Node
 * 
 * @author Joel Lacambra i Marc Fonseca
 *
 */
package DobleEncadenada;

public class NodeLlistaGenerica<T> {

	private T valor;
	private NodeLlistaGenerica<T> seguent;
	private NodeLlistaGenerica<T> anterior;
	
	/**
	 * Constructor
	 * @param valor
	 */
	public NodeLlistaGenerica (T valor) {
		this.valor = valor;
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
	 * @param valor
	 */
	public void setValor(T valor) {
		this.valor = valor;
	}

	/**
	 * Getter seguent
	 * @return node seguent
	 */
	public NodeLlistaGenerica<T> getSeguent() {
		return seguent;
	}
	
	/**
	 * Setter seguent
	 * @param seguent - seguent node
	 */
	public void setSeguent(NodeLlistaGenerica<T> seguent) {
		this.seguent = seguent;
	}
	
	/**
	 * Getter anterior
	 * @return node anterior
	 */
	public NodeLlistaGenerica<T> getAnterior() {
		return anterior;	
	}
	
	/**
	 * Setter anterior
	 * @param anterior - anterior node
	 */
	public void setAnterior(NodeLlistaGenerica<T> anterior) {
		this.anterior = anterior;
	}
	
	public String toString() {
		return ""+valor;
	}
	
}
