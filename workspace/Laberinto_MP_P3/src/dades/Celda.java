/**
 * Clase de las celdas 
 * @author Marc Fonseca 
 * @author Joel Lacambra
 * @author Isamel Ruiz
 */

package dades;

public class Celda {

    private int numero;
    private String operacion;
    
    /**
     * Constructor
     * @param operacion
     * @param numero
     */
    public Celda(String operacion, int numero){
        this.numero = numero;
        this.operacion=operacion;
    }

    /**
     * Getter
     * @return
     */
    public int getNumero(){
        return numero;
    }

    /**
     * Setter
     * @return operacion
     */
    public String getOperacion(){
        return operacion;
    }
    
    /**
     * Setter
     * @param numero
     */
    public void setNumero(int numero) {
		this.numero = numero;
	}

    /**
     * Setter
     * @param operacion
     */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	/**
	 * Metodo para obtener la puntuacion en base de la actual y teniendo en cuenta la operacion a hacer
	 * @param puntosActuales
	 * @return
	 */
	public int operacion(int puntosActuales){

        switch(this.operacion){
            case "+":
                puntosActuales = puntosActuales + this.numero;
                break;
            case "-":
                puntosActuales = puntosActuales - this.numero;
                break;                
            case "*":
                puntosActuales = puntosActuales * this.numero;
                break;
            case "/":
                puntosActuales = puntosActuales / this.numero;
                break;
        }
        return puntosActuales;
    }
	
	/**
	 * Copia de una celda
	 * @return
	 */
	public Celda copia(){
        return new Celda(this.getOperacion(),this.getNumero());
    }
	
	@Override
	public String toString() {
		String aux = "";
		
		if (operacion.equalsIgnoreCase("N")) {
			aux += "NA";
		}
		else {
			aux += operacion+numero;
		}
		
		return aux;
	} 
}
