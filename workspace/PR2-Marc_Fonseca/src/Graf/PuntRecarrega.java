package Graf;

/**
 * 
 * @author Marc Fonseca 
 *
 */

public class PuntRecarrega {
	
	private int id;
	private int id_estacio;
	private String nom;
	private String data;
	private double consum;
	private String carrer;
	private String ciutat;
	private String estat;
	private int temps;
	private double potencia;
	private String tipus;
	private double latitud;
	private double longitud;
	private String posicio;
	
	public PuntRecarrega (String id, String id_estacio, String nom, String data, String consum, String carrer, String ciutat, String estat, String temps, String potencia, String tipus, String latitud, String longitud){
		this.id = Integer.parseInt(id);
		this.id_estacio = Integer.parseInt(id_estacio);
		this.nom = nom;
		this.data = data;
		
		if (consum.isEmpty()) {
			this.consum = 0;
		}
		else {
			this.consum = Double.parseDouble(consum);
		}
		
		this.carrer = carrer;
		this.ciutat = ciutat;
		this.estat = estat;
		
		if (temps.isEmpty()) {
			this.temps = 0;
		}
		else {
			this.temps = Integer.parseInt(temps);
		}
		
		if (potencia.isEmpty()) {
			this.potencia = 0;
		}
		else {
			this.potencia = Double.parseDouble(potencia);
		}
		
		this.tipus = tipus;
		
		this.latitud = Double.parseDouble(latitud);
		this.longitud = Double.parseDouble(longitud);
		
		posicio = latitud.toString()+longitud.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_estacio() {
		return id_estacio;
	}

	public void setId_estacio(int id_estacio) {
		this.id_estacio = id_estacio;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public double getConsum() {
		return consum;
	}

	public void setConsum(double consum) {
		this.consum = consum;
	}

	public String getCarrer() {
		return carrer;
	}

	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}

	public String getCiutat() {
		return ciutat;
	}

	public void setCiutat(String ciutat) {
		this.ciutat = ciutat;
	}

	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		this.estat = estat;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getPosicio() {
		return posicio;
	}

	public void setPosicio(String posicio) {
		this.posicio = posicio;
	}

	public String toString() {
		String aux = "";
		
		aux += id + ":   tipus -> " + tipus;
		aux += "\n\t\t\t\t\t estat -> " + estat;
		aux += "\n\t\t\t\t\t consum necesari -> " + consum + "kWh";
		aux += "\n\t\t\t\t\t potencia necessaria -> " + potencia + "kW";
		aux += "\n\t\t\t\t\t temps de espera -> " + temps + "s\n";
		
		return aux;
	}
	
}
