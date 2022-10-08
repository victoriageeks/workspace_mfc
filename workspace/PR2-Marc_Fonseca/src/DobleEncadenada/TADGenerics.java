package DobleEncadenada;
import Excepcions.foraDeRang;
import Excepcions.noTrobat;

/**
 * 
 * @author Marc Fonseca
 *
 * @param <T> - valor generalitzat
 */

public interface TADGenerics<T> {
	
	/**
	 * Metode per inserir un element al final de la taula
	 * @param data - valor generalitzat
	 */
	public void inserir(T data);
	
	/**
	 * Metode per inserir un elemnt en una posicio de la taula
	 * @param posicio - posicio de la taula
	 * @param data - valor generalitzat
	 * @throws foraDeRang - error valor fora de rang
	 */
	public void inserir(int posicio, T data) throws foraDeRang;
	
	/**
	 * Metode per obtenir el valor duna posicio
	 * @param posicio - posicio de la taula
	 * @return data - valor generalitzat
	 * @throws foraDeRang - error valor fora de rang
	 */
	T obtenir(int posicio) throws foraDeRang;
	
	/**
	 * Metode per obtenir la longitud de la taula
	 * @return longitud de la taula
	 */
	public int longitud();
	
	/**
	 * Metode per esborrar una posicio de la taula
	 * @param posicio - posicio de la taula
	 * @throws foraDeRang - error valor fora de rang
	 */
	public void esborrar(int posicio) throws foraDeRang;
	
	/**
	 * Metode per buscar un valor en la taula
	 * @param data - valor generalitzat
	 * @return posicio de la taula
	 * @throws noTrobat - error valor no trobat
	 */
	public int buscar (T data) throws noTrobat;
}
