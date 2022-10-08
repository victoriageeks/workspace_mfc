
public class Pila {
	
	private int[] arrayValors;
	private int midaPila;
	private int ultimValor;
	
	public Pila (int midaPila) {
		arrayValors = new int[midaPila];
		this.midaPila = midaPila;
		this.ultimValor = 0;
	}

	public boolean apilaValor(int valor) {
		if (!pilaPlena()) {
			arrayValors[ultimValor] = valor;
			ultimValor++;
			return true;
		} else {
			return false;
		}
	}

	public int desapilaValor() {
		if (!pilaBuida()) {
			ultimValor--;
			return arrayValors[ultimValor];
		} else return -1;	
	}
	 
	
	public String printaPila() {
		if (!pilaBuida()) {		
			String retorn  = "";
			for (int i=0; i< ultimValor; i++ )
				retorn += "|" + arrayValors[i]; 
			return retorn;
		} else return "Pila buida";
	}
	
	public boolean pilaPlena() {
		return this.midaPila == this.ultimValor;
	}

	public boolean pilaBuida() {
		return this.ultimValor == 0;
	}

	public int elementsPila() {
		return this.ultimValor;
	}
	
}
