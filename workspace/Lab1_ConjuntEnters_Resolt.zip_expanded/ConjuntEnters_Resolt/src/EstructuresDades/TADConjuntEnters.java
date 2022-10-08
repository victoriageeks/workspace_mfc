package EstructuresDades;
import Exceptions.*;

/**
 * Interface per a definir la colleccio conjunt d'enters limitats.
 * 
 * @author Professors de l'assignatura 16-17
 *
 */
public interface TADConjuntEnters {
	/** 
	 * Afegeix un enter al conjunt mentre hi ha espai, si l'element ja hi es, no fa res.
	 * @param e - l'enter a afegir al conjunt
	 * @throws conjuntPle - si el conjunt esta ple no es pot afegir l'enter
	 * @throws jaExisteix - si el valor ja hi es, no es fa res
	 * @throws valorImpossible - casos particulars
	 */
	void afegir(int e) throws conjuntPle, jaExisteix, valorImpossible;
	
	/**
	 * Elimina un valor del conjunt
	 * @param e - l'enter a eliminar del conjunt
	 * @throws valorImpossible - casos particulars
	 */
	void eliminar(int e) throws valorImpossible;
	
	/**
	 * Comprova si el conjunt esta ple
	 * @return cert si el el conjunt esta ple
	 */
	boolean ple();
	
	/**
	 * Retorna el numero d'elements que te el conjunt
	 * @return numero d'elements que hi ha en el conjunt
	 */
	int numElems();
}
