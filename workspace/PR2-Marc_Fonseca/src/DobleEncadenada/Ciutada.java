package DobleEncadenada;

/**
 * 
 * @author Marc Fonseca 
 *
 */

public class Ciutada implements Comparable<Ciutada>{
	private String Nom, Cognom;
	private String DNI;
	
	/**
	 * Contructor Ciutada
	 * @param Nom - Nom del Ciutada
	 * @param Cognom - Cognom del Ciutada
	 * @param DNI - DNI del Ciutada
	 */
	public Ciutada (String Nom, String Cognom, String DNI){
		this.Nom = Nom;
		this.Cognom = Cognom;
		this.DNI = DNI;
	}

	public int compareTo (Ciutada aux) {
		if (this.DNI.equals(aux.getDNI())) {
			return 0;
		}
		else {
			return 1;
		}
	}

	/**
	 * Getter nom
	 * @return nom del ciutada
	 */
	public String getNom() {
		return Nom;
	}

	/**
	 * Setter nom
	 * @param nom - nom del ciutada
	 */
	public void setNom(String nom) {
		Nom = nom;
	}

	/**
	 * Getter cognom
	 * @return cognom del ciutada
	 */
	public String getCognom() {
		return Cognom;
	}

	/**
	 * Setter cognom
	 * @param cognom - cognom del ciutada
	 */
	public void setCognom(String cognom) {
		Cognom = cognom;
	}

	/**
	 * gGetter dni
	 * @return dni del ciutada
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * Setter dni
	 * @param dni - dni del ciutada
	 */
	public void setDNI(String dni) {
		DNI = dni;
	}

	@Override
	public String toString() {
		return Nom + " " + Cognom + " amb DNI: " + DNI;
	}
}
