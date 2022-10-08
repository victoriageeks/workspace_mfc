/**
 * Classe Node
 * 
 * @author Joel Lacambra i Marc Fonseca
 *
 */
package Dades;

public class Node {

	private DadesAcces valor;
	private Node seguent;
	
	/**
	 * Constructor
	 * @param valor
	 */
	public Node (DadesAcces valor) {
		this.valor = valor;
		seguent = null;
	}
	
	/**
	 * Constructor amb seguent
	 * @param valor
	 * @param seguent
	 */
	public Node (DadesAcces valor, Node seguent) {
		this.seguent = seguent;
		this.valor = valor;
	}
	
	/**
	 * Getter
	 * @return valor
	 */
	public DadesAcces getValor() {
		return valor;
	}
	
	/**
	 * Setter
	 * @param valor
	 */
	public void setValor(DadesAcces valor) {
		this.valor = valor;
	}

	/**
	 * Getter
	 * @return node seguent
	 */
	public Node getSeguent() {
		return seguent;
	}
	
	/**
	 * Setter
	 * @param seguent - Seguent node
	 */
	public void setSeguent(Node seguent) {
		this.seguent = seguent;
	}

	@Override
	public String toString() {
		return ""+valor;
	}
	
}
