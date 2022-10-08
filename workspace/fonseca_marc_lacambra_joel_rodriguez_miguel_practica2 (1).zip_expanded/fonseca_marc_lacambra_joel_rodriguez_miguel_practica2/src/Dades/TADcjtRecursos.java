/**
 * TAD del conjunt de recursos
 * 
 * @author Joel Lacambra i Marc Fonseca
 *
 */
package Dades;


public interface TADcjtRecursos {
	
	/**
	 * Comprova si el conjunt esta ple
	 * @return cert si el el conjunt esta ple
	 */
	boolean ple();
	
	/**
	 * Retorna el numero delements que te el conjunt
	 * @return numero d'elements que hi ha en el conjunt
	 */
	int numElems();
	
	/** 
	 * Afegir les dades duna consulta feta a un recurs per un usuari en un moment concret.
	   Haureu de tenir en compte si el recurs que sha consultat es nou o si ja lhem guardat
	   en algun altre cas.
	 * @param dades - conjunt de dades a la consulta
	 */
	void afegir(DadesAcces dades);
	
	/**
	 * Esborrar totes les dades duna consulta a un recurs
	 * @param recurs - titol del recurs
	 */
	void eliminarConsulta(String recurs);
	
	/** 
	 * Esborrar les dades de les consultes a un recurs que shan fet en una data concreta
	   (dia/mes/any)
	 * @param recurs - titol del recurs
	 * @param data - data concreta a esborrar
	 */
	void eliminarConsultaData(String recurs, Data data);
	
	/** 
	 * Donat el nom dun recurs volem un metode que ens retorni la llista dusuaris que lhan
	   consultat
	 * @param recurs - titol del recurs
	 * @return llista de usuaris que han consultat
	 */
	DadesAcces[] llistaUsuarisRecurs(String recurs);
	/** 
	 * Donat el nom dun recurs i una data (dia/mes/any) volem un metode que ens retorni
	   la llista dusuaris que lhan consultat.
	 * @param recurs - titol del recurs 
	 * @param data - data concreta per buscar els usuaris
	 * @return llista dusuaris que han consultat el recurs en una data concreta
	 */
	String[] llistaUsuarisRecursData(String recurs, Data data);
	
	/** 
	 * Fes un metode que retorni les dades del recurs que lhan consultat mes usuaris.
	 * @return el recurs mes consultat
	 */
	String recursMesConsultat();
	
	/** 
	 * Donat un alies dusuari volem un metode que ens indiqui els recursos que ha consultat
	 * @param alies - nom de l’usuari
	 * @return recursos consultats per un usuari
	 */
	 String[] llistaRecursosPerUsuari(String alies);
}
