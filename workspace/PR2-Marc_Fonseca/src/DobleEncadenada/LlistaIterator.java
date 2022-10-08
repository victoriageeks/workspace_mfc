package DobleEncadenada;
import java.util.Iterator;
import Excepcions.*;

/**
 * 
 * @author Marc Fonseca
 *
 * @param <T> - valor generalitzat
 */

public class LlistaIterator<T extends Comparable<T>> implements Iterator<T> {
	private LlistaDobleEncadenada<T> llista;	//nou atribut que ens guardar� una copia de la llista actual de punts
	private int posicioIterator;
	
	/**
	 * Contructor de la llista iteradora
	 * @param ll - llista a iterar
	 */
	public LlistaIterator(LlistaDobleEncadenada<T> ll) {
		llista=new LlistaDobleEncadenada<T>();
		for (int i = 0; i < ll.longitud(); i++) {
			try {
				llista.inserir(ll.obtenir(i));
			} catch (foraDeRang e) {
				System.out.println(e);
			}
			
		}
		posicioIterator=0; 	// ens preparem per a retornar els elements a partir de la posicio 0
	}
	
	@Override
	public boolean hasNext() {
		return ((posicioIterator<llista.longitud()));
	}

	@Override
	public T next() {
		try {
			T aux=llista.obtenir(posicioIterator);
			posicioIterator++;
			return aux;
		} catch (foraDeRang e) {
			System.out.println(e);
		}
		T aux = null;
		return aux;
	}
}
