package Graf;

/**
 * Classe Node
 * 
 * @author Marc Fonseca
 *
 */

public class NodeGrafGeneric<V, E> implements Comparable<NodeGrafGeneric<V, E>>{

	V zona;
	NodeArestaGeneric<V, E> Primera_Fila, Primera_Col;
	
	public NodeGrafGeneric (V zona) {
		this.zona = zona;
		Primera_Fila = null;
		Primera_Col = null;
	}

	public V getZona() {
		return zona;
	}

	public void setZona(V zona) {
		this.zona = zona;
	}

	public NodeArestaGeneric<V, E> getPrimera_Fila() {
		return Primera_Fila;
	}

	public void setPrimera_Fila(NodeArestaGeneric<V, E> primera_Fila) {
		Primera_Fila = primera_Fila;
	}

	public NodeArestaGeneric<V, E> getPrimera_Col() {
		return Primera_Col;
	}

	public void setPrimera_Col(NodeArestaGeneric<V, E> primera_Col) {
		Primera_Col = primera_Col;
	}

	public String toString() {
		return "" + zona.toString();
	}

	public int compareTo(NodeGrafGeneric<V, E> o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
