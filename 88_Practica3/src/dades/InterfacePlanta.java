package dades;
/**
 * Interface for the Abstract class Planta
 * 
 * @author grup_88
 *
 */
public interface InterfacePlanta {

	/**
	 * Return the CO2 value of the plant, depending of its age
	 * 
	 * @return CO2 value, -1 error
	 */

	int getAbsortion(int age);
	
	Planta copia();

	int getAbsortion();
	
	
	
	
	
}
