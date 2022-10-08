package Graf;

/**
 * 
 * @author Marc Fonseca 
 *
 */

public class PuntRecarregaAux {
	
	private String id;
	private String id_estacio;
	private String nom;
	private String data;
	private String consum;
	private String carrer;
	private String ciutat;
	private String estat;
	private String temps;
	private String potencia;
	private String tipus;
	private String latitud;
	private String longitud;
	
	public PuntRecarregaAux (String id, String id_estacio, String nom, String data, String consum, String carrer, String ciutat, String estat, String temps, String potencia, String tipus, String latitud, String longitud){
		this.id = id;
		this.id_estacio = id_estacio;
		this.nom = nom;
		this.data = data;
		this.consum = consum;
		this.carrer = carrer;
		this.ciutat = ciutat;
		this.estat = estat;
		this.temps = temps;
		this.potencia = potencia;
		this.tipus = tipus;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_estacio() {
		return id_estacio;
	}

	public void setId_estacio(String id_estacio) {
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

	public String getConsum() {
		return consum;
	}

	public void setConsum(String consum) {
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

	public String getTemps() {
		return temps;
	}
	
	public void setTemps(String temps) {
		this.temps = temps;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "ZonaRecarrega [ID=" + id + ", id_estacio=" + id_estacio + ", nom=" + nom + ", data=" + data
				+ ", consum=" + consum + ", carrer=" + carrer + ", estat=" + estat + ", temps=" + temps + ", potencia="
				+ potencia + ", tipus=" + tipus + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
}
