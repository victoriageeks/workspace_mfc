package dades;

import java.util.Arrays;
/**
 * @author Jordi and ismael and edgar
 */
public class Plantacions {

	private String name;
	private int year;
	private String[] terrain;
	private double[] standArea;
	private int nElem;

	public double getStandAreaMario(int i){
		return standArea[i];
	}
	public double[] getStandArea() {
		return standArea;
	}

	
	public Plantacions(String name, int year, String terrain, double standArea) {
		this.name = name;
		this.year = year;
		
		nElem=0;
		this.terrain = new String[3];
		this.standArea = new double[3];
		
		this.terrain[0]=terrain;
		this.standArea[0]=standArea;
		nElem++;
		
	}
	
	public void add(String terrain, double standArea) {
		if (nElem>=this.terrain.length) {
			// si la taula està plena reservem més espai
			String[] newAddTerrain=new String[nElem+2];
			double[] newAddStandArea=new double[nElem+2];
			for (int i=0; i<nElem; i++) {
				newAddTerrain[i]=this.terrain[i];
				newAddStandArea[i]=this.standArea[i];
				
			}
			this.terrain=newAddTerrain;
			this.standArea=newAddStandArea;
		}
		// ja podem assegurar que hi ha espai per afegir el nou tipus
		this.terrain[nElem]=terrain;
		this.standArea[nElem]=standArea;
		nElem++;
	} 
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

	public String[] getTerrain(){
		return terrain;
	}
	
	public String getTerrain(int i){
		return this.terrain[i];
	}
	
	public Plantacions copia(){
		Plantacions copia = new Plantacions(this.name, this.year, this.terrain[0], this.standArea[0]);

		for(int i = 1;i<this.nElem; i++){
			copia.add(this.terrain[i], this.standArea[i]);
		}

		return copia;
	}


	public void setStandArea(int i, double area){
		standArea[i] = area;
	}
	
	public double totalArea() {
		double aux=0;
		for (int i = 0; i < standArea.length; i++) {
			aux+=standArea[i];
		}
		return aux;
	}

	
	@Override
	public String toString() {
		return "Plantacions [name=" + name + ", year=" + year + ", terrains=" + Arrays.toString(terrain) + "]";
	}
	
}
