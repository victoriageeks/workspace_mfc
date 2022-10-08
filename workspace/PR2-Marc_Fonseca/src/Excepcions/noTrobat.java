package Excepcions;

/**
 * 
 * @author Marc Fonseca
 *
 */

public class noTrobat extends Exception {
	private static final long serialVersionUID = 1L;
	
	private int n;
	
	/**
	 * Error quan no troba el valor
	 */
	public noTrobat() {
		super("ERROR : No sha trobat el valor esperat");
	}
	
	/**
	 * Error quan no troba el valor
	 * @param e - valors accedits
	 */
	public noTrobat(int e){
		super("ERROR : No sha trobat el valor esperat i ha accedit a " +e+ " elements en total");
		this.n = e;
	}

	/**
	 * Getter n
	 * @return n
	 */
	public int getN() {
		return n;
	}

	
}

