package Graf;
import DobleEncadenada.*;
import Excepcions.*;

/**
 * 
 * @author Marc Fonseca
 *
 */

public interface TADGraf<V extends Comparable<V>, K extends Comparable<K>, E> {
	
	public void afegirAresta (V v1, V v2, E e) throws noTrobat ;
	
	public boolean existeixAresta (V v1, V v2);
	
	public E valorAresta (V v1, V v2) throws noTrobat ;
	
	public LlistaDobleEncadenada<V> adjacents (V v) throws noTrobat ;
}
