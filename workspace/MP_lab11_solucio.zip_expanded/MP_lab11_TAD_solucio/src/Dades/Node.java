package Dades;

public class Node {
	private int valor;
	private Node seguent;
	
	public Node() {
		valor=0;
		seguent=null;
	}
	
	public Node(int valor) {
		this.valor=valor;
		seguent=null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Node getSeguent() {
		return seguent;
	}

	public void setSeguent(Node seguent) {
		this.seguent = seguent;
	}
	
	
}
