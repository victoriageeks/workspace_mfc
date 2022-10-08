package Graf;

import java.util.*;

/**
 * 
 * @author Marc Fonseca 
 *
 */

public class ZonaRecarrega implements Comparable<ZonaRecarrega>{
	
	private ArrayList<PuntRecarrega> punts;
	private int id_estacio;
	private String nom;
	private String data;
	private String carrer;
	private String ciutat;
	private double latitud;
	private double longitud;
	private String posicio;
	
	public ZonaRecarrega (int id_estacio, String nom, String data, String carrer, String ciutat, double latitud, double longitud, String posicio){
		this.id_estacio=id_estacio;
		this.nom = nom;
		this.data = data;
		this.carrer = carrer;
		this.ciutat = ciutat;
		this.latitud = latitud;
		this.longitud = longitud;
		this.punts = new ArrayList<PuntRecarrega>();
		this.posicio = posicio;
	}
	
	public ZonaRecarrega (int id_estacio, String nom, String data, String carrer, String ciutat, double latitud, double longitud, String posicio, PuntRecarrega punt){
		this.id_estacio=id_estacio;
		this.nom = nom;
		this.data = data;
		this.carrer = carrer;
		this.ciutat = ciutat;
		this.latitud = latitud;
		this.longitud = longitud;
		this.punts = new ArrayList<PuntRecarrega>();
		punts.add(punt);
		this.posicio = posicio;
	}
	
	public void afegirPunt (PuntRecarrega punt) {
		punts.add(punt);
	}
	
	public ArrayList<PuntRecarrega> getPunts() {
		return punts;
	}

	public void setPunts(ArrayList<PuntRecarrega> punts) {
		this.punts = punts;
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
		int i = 0;
		
		aux += "Zona '" + nom+ "' identidficada com " + id_estacio + " esta situada a " + ciutat + " al carrer "+ carrer +" [" + latitud + ", " + longitud + "] amb data " + data +": \n\n";
		aux += "\tPunt identificat com " + punts.get(i).toString() + "\n";
		for (i = 1; i < punts.size(); i++) {
			aux += "\tPunt identificat com " + punts.get(i).toString() + "\n";
		}
		
		return aux;
	}

	@Override
	public int compareTo(ZonaRecarrega o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
