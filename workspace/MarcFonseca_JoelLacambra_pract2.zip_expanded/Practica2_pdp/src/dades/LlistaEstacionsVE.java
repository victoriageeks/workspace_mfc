/**
 * Practica 2 LlistaEstacionsVE
 * @author Marc Fonseca i Joel Lacambra
 */
package dades;

public class LlistaEstacionsVE {
	
	private static double radi = 30;
	private int nestacions;
	private EstacioRecarregaVE[] llista;
	
	/**
	 * Constructor per crear una llista amb n estacions
	 * @param n - numero de estacions que hi haura en la llista
	 */
	public LlistaEstacionsVE (int n) {
		nestacions = 0;
		llista = new EstacioRecarregaVE[n];
	}
	
	/**
	 * Getter de nestacions
	 * @return - nestacions
	 */
	public int getNumEstacions() {
		return nestacions;
	}
	
	/**
	 * Setter del nestacions
	 * @param x - nou nestacions
	 */
	public void setNumEstacions (int x) {
		nestacions = x;
	}
	
	/**
	 * Metode per agafar un element de la llista segons i
	 * @param i	- posicio a agafar de la llista
	 * @return una copia de la posicio de la llista
	 */
	public EstacioRecarregaVE estacioIessima (int i) {
		return llista[i].copia();
	}
	
	/**
	 * Metode toString de la llista
	 */
	 public String toString () {
		String aux;
		if (nestacions == 0) {
			aux = "No hi ha cap estacio a la llista.";
		}
		else {
			aux = "----------------Llista de estacions a Catalunya----------------\n";
			for (int i = 0; i < nestacions; i++) {
				aux = aux + ++i + "- " +llista[--i].toString();
			}
		}
		return aux;
	}
	 
	/**
	 * Setter del radi
	 * @param r - nou radi
	 */
	public static void setRadi (double r) {
		radi = r;
	}
	
	/**
	 * Getter del radi
	 * @return radi 
	 */
	public static double getRadi (){
		return radi;
	}
	
	/**
	 * Metode per afegir al final de la llista una nova estacio
	 * @param estacio - estacio a posar al final de la llista
	 */
 	public void afegirEstacio(EstacioRecarregaVE estacio) {
		
		llista[nestacions] = estacio;
		nestacions++;
		
	}
	
 	/**
 	 * Metode per eliminar una estacio de la llista segons el municipi
 	 * @param poblacio - la poblacio de la qual s'eliminaran les estacions
 	 */
	public void eliminarEstacionsPoblacio (String poblacio) {
	
		for (int i = 0; i < nestacions; i++) {
			if (llista[i].esTrobaEnAquestMunicipi(poblacio)) {
				for (int j = i; j < nestacions - 1; j++) {
					llista[j] = llista [j+1];
				}
				nestacions--;
				i--;
			}
		}
	}
	
	/**
	 * Metode que retorna totes les dades de les estacions d'un municipi
	 * @param poblacio - municipi del qual agruparem estacions
	 * @return llista de les estacions d'un municipi
	 */
	public LlistaEstacionsVE dadesEstPob(String poblacio) {
		
		LlistaEstacionsVE llistaEstPob = new LlistaEstacionsVE(nestacions);
				
		for (int i = 0; i < nestacions; i++) {
			if (llista[i].esTrobaEnAquestMunicipi(poblacio)) {
				llistaEstPob.afegirEstacio(llista[i]);
			}
		}
		return llistaEstPob;
	}
	
	/**
	 * Metode que retorna la primera instancia d'una estacio que es troba en una provincia
	 * @param provincia - per trobar la primera estacio
	 * @return si hi ha estacio, retorna la instancia, si no retorna null
	 */
	public EstacioRecarregaVE primeraEstProv(String provincia) {
		
		EstacioRecarregaVE aux = null;
	
		for (int i = 0; i < nestacions; i++) {
			if (llista[i].esTrobaEnAquestaProvincia(provincia)) {
				aux = llista[i];
				break;
			}
		}
		return aux;
	}
	
	/**
	 * Metode que retorna quantes estacions d'un tipus determinat de velocitat
	 * @param tipusVel - el tipus de velocitat del qual es fara un comptatge
	 * @return quantes estacions tenen aquest tipus de velocitat
	 */
	public int numEstVel(String tipusVel) {
		
		int nEst = 0;
		for (int i = 0; i < nestacions; i++) {
			if(llista[i].teAquestTipusRecarrega(tipusVel)) {
				nEst++;
			}
		}
		return nEst;
	}
	
	/**
	 * Metode que calcula la instancia de la estacio amb mes places de capacitat
	 * @return instancia de llista amb mes places
	 */
	public EstacioRecarregaVE mesPlaces() {	
	
		int max = llista[0].getNumPlaces();
		EstacioRecarregaVE aux = llista[0];
		
		for (int i = 1; i < nestacions; i++) {
			if (llista[i].getNumPlaces() > max) {
				aux = llista[i];
				max = llista[i].getNumPlaces();
			}
		}
		return aux;
		
	}

	/**
	 * Metode que retorna un duplicat de la instancia de l'estacio mes propera al nostre muncipi
	 * @param lat - latitud segons l'usuari
	 * @param lon - longitud segons l'usuari
	 * @return la instancia de l'estacio mes propera 
	 */
	public EstacioRecarregaVE estPropera (float lat, float lon) {

		double min = llista[0].distanciaA(lat, lon);
		EstacioRecarregaVE aux = llista[0].copia();	
		
		for (int i = 1; i < nestacions; i++) {
			if (llista[i].distanciaA(lat, lon) < min) {
				aux = llista[i].copia();
				min = llista[i].distanciaA(lat, lon);		
			}
			
		}
		return aux;
	}
	
	
	/**
	 * Metode que retorna una instancia de l'estacio mes propera a nosaltres en un radi de 30km
	 * @param lat - latitud de l'usuari
	 * @param lon - longirut de l'usuari
	 * @return la instancia de la llista d'estació mes propera a nosaltres
	 */
	public EstacioRecarregaVE mesPropRadi (float lat, float lon) {
		
		EstacioRecarregaVE aux = null;
		double min = 0.0;
		int  i;
		
		for (i = 0; i < nestacions; i++) {
			if (llista[i].distanciaA(lat, lon) < radi) {
				min = llista[i].distanciaA(lat, lon);
				aux = llista[i];
				break;
			}
		}
		for (;i < nestacions; i++) {
			if (llista[i].distanciaA(lat, lon) < min) {
				aux = llista[i];
				min = llista[i].distanciaA(lat, lon);
			}
		}
		return aux;
	}
	
	
	/** 
	 * Metode que depenent del radi indicat, calcula totes aquelles estacions que es consideren properes
	 * @param lat - latitud de l'usuari
	 * @param lon - longitud de l'usuari
	 * @return una llista amb totes les estacions i la seva informacio d'aquelles mes properes a nosaltres
	 */
	public LlistaEstacionsVE allEstProp(float lat, float lon){
		LlistaEstacionsVE llistaMesPropera = new LlistaEstacionsVE(nestacions);
		int j = 1;
		for (int i = 0; i < nestacions; i++) {
			if (llista[i].distanciaA(lat, lon) < radi) {
				llistaMesPropera.afegirEstacio(llista[i]);
				llistaMesPropera.setNumEstacions(j);
				j++;
			}
		}
		return llistaMesPropera;
	}	
}
