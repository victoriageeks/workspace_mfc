package Hash;

import DobleEncadenada.*;
import Excepcions.noTrobat;

/**
 * 
 * @author Marc Fonseca
 *
 * @param <T> - valor generalitzat
 * @param <K> - clau
 */

public interface TADHash<T extends Comparable<T>, K extends Comparable<K>> {
	/**
	 * Metode per inserir element en una posicio al final
	 * @param key - "posicio de la taula"
	 * @param data - valor
	 */
	public void inserir(K key, T data);
	
	/**
	 * Metode per obtenir un valor d'una certa posicio
	 * @param key - "posicio de la taula"
	 * @return data - valor
	 * @throws noTrobat - error valor no trobat
	 */
	public T obtenir(K key) throws noTrobat;
	
	/**
	 * Metode per buscar un element d'una certa posicio
	 * @param key - "posicio de la taula"
	 * @return data - valor
	 * @throws noTrobat - error valor no trobat
	 */
	public int buscar (K key) throws noTrobat;
	
	/**
	 * Metode per obtenir el numero d'elements en la taula
	 * @return nElems
	 */
	public int mida();
	
	/**
	 * Metode per esborrar un element d'una certa posicio
	 * @param key - "posicio de la taula"
	 * @throws noTrobat - error valor no trobat
	 */
	public void esborrar(K key) throws noTrobat;
	
	/**
	 * Metode per llistar tots els valors de la taula
	 * @return llista de valors
	 */
	public LlistaDobleEncadenada<T> obtenirValors();
	
	/**
	 *  Metode per llistar totes les claus de la taula
	 * @return llista de claus
	 */
	public LlistaDobleEncadenada<K> obtenirClaus();
	
	/**
	 * Metode per obtenir el factor de carrega de la taula
	 * @return factor de carrega de la taula
	 */
	public float ObtenirFactorDeCarrega();
	
}
