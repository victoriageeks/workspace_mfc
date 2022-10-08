/**
 * Classe Dades amb dades de consultes
 * 
 * @author Joel Lacambra i Marc Fonseca
 *
 */
package Dades;

public class DadesAcces {
    private String alies;
    private String recurs;  
    private Data data;
    /**
     * Constructor per les dades de les consultes
     * @param alies
     * @param recurs
     * @param data
     */
    public DadesAcces (String alies, String recurs, Data data){
        this.data = data;
        this.alies = alies;
        this.recurs = recurs;
    }
    /**
     * Getter
     * @return alies
     */
	public String getAlies() {
		return alies;
	}
	/**
	 * Setter
	 * @param alies - nou alies
	 */
	public void setAlies(String alies) {
		this.alies = alies;
	}
	/**
	 * Getter
	 * @return recurs
	 */
	public String getRecurs() {
		return recurs;
	}
	/**
	 * Setter
	 * @param recurs - nou recurs
	 */
	public void setRecurs(String recurs) {
		this.recurs = recurs;
	}
	/**
	 * Getter
	 * @return data (dia, mes, any, hora)
	 */
	
	public Data getData() {
		return data;
	}
	/**
	 * Setter
	 * @param data - nova data (dia, mes, any, hora)
	 */
	public void setData(Data data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "alies = " + alies + ",  recurs = " + recurs + ",  data = " + data;
	}
    
}
