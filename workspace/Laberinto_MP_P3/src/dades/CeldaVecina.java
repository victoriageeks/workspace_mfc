/**
 * Clase de las celdas vecinas/auxiliar
 * @author Marc Fonseca 
 * @author Joel Lacambra
 * @author Isamel Ruiz
 */

package dades;

public class CeldaVecina {

    private Celda celdaVecina;
    private int ejeX,ejeY;
    private int posiblePuntuacion;
    private double distancia;
    
    /**
     * Constructor
     * @param celda - celda
     * @param ejeX - posicion x
     * @param ejeY - posicion y
     * @param posiblePuntuacion - posible puntuacion
     * @param distancia - distancia
     */
    public CeldaVecina(Celda celda, int ejeX, int ejeY, int posiblePuntuacion, double distancia){
        this.celdaVecina = celda;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.posiblePuntuacion = posiblePuntuacion;
        this.distancia = distancia;
        
    }
    
    /**
     * Getter 
     * @return distancia
     */
    public double getDistancia(){
        return distancia;
    }
    
    /**
     * Setter 
     * @param distancia
     */
	public void setDistancia(double distancia){
        this.distancia=distancia;
    }

	/**
	 * Getter
	 * @return distancia x
	 */
	public int getEjeX() {
		return ejeX;
	}

	/**
	 * Setter
	 * @param ejeX
	 */
	public void setEjeX(int ejeX) {
		this.ejeX = ejeX;
	}

	/**Getter
	 * @return distancia y
	 */
	public int getEjeY() {
		return ejeY;
	}

	/**
	 * Setter
	 * @param ejeY
	 */
	public void setEjeY(int ejeY) {
		this.ejeY = ejeY;
	}

	/**
	 * Getter
	 * @return posible puntuacion
	 */
	public int getPosiblePuntuacion() {
		return posiblePuntuacion;
	}

	/**
	 * Setter
	 * @param posiblePuntuacion
	 */
	public void setPosiblePuntuacion(int posiblePuntuacion) {
		this.posiblePuntuacion = posiblePuntuacion;
	}

	/**
	 * Getter
	 * @return celda vecina/auxiliar
	 */
	public Celda getCeldaVecina() {
		return celdaVecina;
	}

	/**
	 * Setter
	 * @param celdaVecina
	 */
	public void setCeldaVecina(Celda celdaVecina) {
		this.celdaVecina = celdaVecina;
	}
	
	@Override
	public String toString() {
		String aux= "";
		
		aux = "Posicion x: " +ejeX+ "Posicion Y: " +ejeY;
		return aux;
	}
}
