package Excepcions;

/**
 * 
 * @author Marc Fonseca
 *
 */

public class foraDeRang extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Error quan el valor esta fora del rang
	 * @param e
	 */
	public foraDeRang(int e){
		super("ERROR : La posicio ha d'estar entre el seguent rang de valors: [0 - " +--e+"]\n");
	}

}
