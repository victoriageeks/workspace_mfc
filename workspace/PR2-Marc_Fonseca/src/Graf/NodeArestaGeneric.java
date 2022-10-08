package Graf;

/**
 * Classe Node
 * 
 * @author Marc Fonseca
 *
 */

public class NodeArestaGeneric<V, E> {

	private E aresta;
	private NodeArestaGeneric<V, E> Seg_Fila, Seg_Col; 
	private NodeGrafGeneric<V, E> Ref_Fila, Ref_Col;
	
	public NodeArestaGeneric (E aresta, NodeArestaGeneric<V, E> Seg_Fila, NodeArestaGeneric<V, E> Seg_Col, NodeGrafGeneric<V, E> Ref_Fila, NodeGrafGeneric<V, E> Ref_Col) {
		this.aresta = aresta;
		this.Seg_Fila = Seg_Fila;
		this.Seg_Col = Seg_Col;
		this.Ref_Fila = Ref_Fila;
		this.Ref_Col = Ref_Col;
	}

	public E getAresta() {
		return aresta;
	}

	public void setAresta(E aresta) {
		this.aresta = aresta;
	}

	public NodeArestaGeneric<V, E> getSeg_Fila() {
		return Seg_Fila;
	}

	public void setSeg_Fila(NodeArestaGeneric<V, E> seg_Fila) {
		Seg_Fila = seg_Fila;
	}

	public NodeArestaGeneric<V, E> getSeg_Col() {
		return Seg_Col;
	}

	public void setSeg_Col(NodeArestaGeneric<V, E> seg_Col) {
		Seg_Col = seg_Col;
	}

	public NodeGrafGeneric<V, E> getRef_Fila() {
		return Ref_Fila;
	}

	public void setRef_Fila(NodeGrafGeneric<V, E> ref_Fila) {
		Ref_Fila = ref_Fila;
	}

	public NodeGrafGeneric<V, E> getRef_Col() {
		return Ref_Col;
	}

	public void setRef_Col(NodeGrafGeneric<V, E> ref_Col) {
		Ref_Col = ref_Col;
	}

	@Override
	public String toString() {
		return "NodeArestaGeneric [aresta=" + aresta + ", Seg_Fila=" + Seg_Fila + ", Seg_Col=" + Seg_Col + ", Ref_Fila="
				+ Ref_Fila + ", Ref_Col=" + Ref_Col + "]";
	}
}
