package Excepcions;

/**
 * 
 * @author Marc Fonseca
 *
 */

public class noArriba extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Error quan el camiOptim no arriba al destí
	 */
	public noArriba(){
		super("ERROR : La ruta no es posible\n");
	}

}
