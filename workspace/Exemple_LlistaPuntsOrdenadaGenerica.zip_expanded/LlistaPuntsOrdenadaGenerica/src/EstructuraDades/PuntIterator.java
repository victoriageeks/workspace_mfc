package EstructuraDades;

import java.util.Iterator;

public class PuntIterator<T extends Comparable<T>> implements Iterator<T> {
	private LlistaGenerica<T> llista;	//nou atribut que ens guardar� una copia de la llista actual de punts
	private int posicioIterator;
	
	public PuntIterator(LlistaGenerica<T> ll) {
		llista=new LlistaGenerica<T>(ll.getNum());
		for (int i=0; i<ll.getNum(); i++) {
			llista.afegirPunt(ll.o);
		}
		posicioIterator=0; 	// ens preparem per a retornar els elements a partir de la posicio 0
	}
	
	@Override
	public boolean hasNext() {
		return ((posicioIterator<llista.getNum()));
	}

	@Override
	public T next() {
		T aux=llista.consultarIessim(posicioIterator);
		posicioIterator++;
		return aux;
	}

	

}
