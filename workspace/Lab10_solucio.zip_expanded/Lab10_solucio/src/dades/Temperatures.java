package dades;
/**
 * Classe per guardar la informació de les temperatures mitjanes 
 * enregistrades durant un periode de temps.
 * La taula s'inicialitza segons la mida indicada per paràmetre
 * que correspon al número de dies que s'indicaran.
 * 
 * @author Professores de Programació
 */

public class Temperatures {
    private float [] tempMitja;
    private int quants;
    
    /** Constructor
     * 
     * @param mida tamany de la taula per a guardar la mitjana de totes les dades
     */
	public Temperatures(int mida) {
	    quants=0;
	    tempMitja= new float[mida];
	}
	
/** 
 * Retorna el valor de la temperatura demanada
 * 
 * @param i posició de la temperatura mitjana a consultar
 * @return el valor de la temperatura mitjana de la posició i
 */
	public float consultaTempMitjana (int i)  {
		return(tempMitja[i]);
	}
	
/**
 * Rep les mesures obtingudes durant un dia, calcula
 * la mitjana ponderada i anota el seu valor a la següent
 * posició de la llista
 * 
 * @param valors taula amb la llista de temperatures
 * @param pesos taula amb la llista de valors de confiança
 */
	public void anotaTemp(float[] valors, float[] pesos) throws ArithmeticException {
		float suma=0;
		float pes=0;

		for (int i=0; i<valors.length; i++) {
			suma=suma+valors[i]*pesos[i];
			pes=pes+pesos[i];
		}
		if (pes==0)
			throw new ArithmeticException();
		tempMitja[quants]=suma/pes;   // Anoto la mitjana ponderada
		quants++;
	}
}
	