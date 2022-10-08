package Dades;

/**
 * Interface per a definir la col.leccio conjunt d'enters.
 * 
 * @author Professors de l'assignatura
 *
 */
public interface TADConjuntEnters {
	/** 
	 * Afegeix un enter al conjunt mentre hi ha espai, si l'element ja hi es, no fa res.
	 * @param e - l'enter a afegir al conjunt
	 * @return codiError: =1 si l'enter s'ha afegit correctament al conjunt, =0 si l'enter ja hi era, =-1 si no es pot afegit l'enter (problemes espai, altres, ...)
	 */
	int afegir(int e);
	
	/**
	 * Elimina un valor del conjunt
	 * @param e - l'enter a eliminar del conjunt
	 * @return codiError: =1 si l'enter s'ha esborrat del conjunt, =0 si l'enter no s'ha esborrat perquè  no hi era, =-1 qualsevol altre cas
	 */
	int eliminar(int e);
	
	/** 
	 * Comprova si un enter pertany al conjunt
	 * @param e - l'enter a comprovar
	 * @return cert si l'enter pertany i fals en cas contrari
	 */
	boolean pertany(int e);
	
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
