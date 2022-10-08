package dades;
import java.io.*;


import java.util.Arrays;

import aplicacio.main;
/**
 * @author Jordi and ismael and edgar and mario
 */
public class Terreny implements Serializable {

	private String name;
	private String[] plants;
	private int nElem;
	private double[] haPlants;

	private static int threshold=5;
	
	public Terreny(String name) {
		this.name = name;
		this.plants=new String[3];
		this.haPlants=new double[3];
		nElem=0;
	}
	
	
	
	public Terreny(String name, String plants, double haPlants) {
		this.name = name;
		
		this.plants=new String[3];
		this.plants[0] = plants;
		this.haPlants=new double[3];
		this.haPlants[0] = haPlants;

		nElem=1;
	}
	public boolean addPlantIsmael(String p, double haPlants){
		if(nElem>=this.plants.length) {
			// si la taula esta plena reservem mes espai
				String[] newAddPlants = new String[nElem+2];
				double[] newAddHa = new double[nElem+2];
				for(int i=0; i<nElem; i++) {
					newAddPlants[i] = this.plants[i];
					newAddHa[i] = this.haPlants[i];
				}
				this.plants=newAddPlants;
				this.haPlants=newAddHa;
			}
			//ja podem assegurar que hi ha espai per afegir el nou tipus
			for(int i=0;i<nElem;i++){
				if(this.plants[i].equalsIgnoreCase(p)){
					//System.out.println(this.plants[i]+" ES IGUAL");
					this.haPlants[i] = this.haPlants[i]+haPlants;
					return true;
				}
			}
			this.plants[nElem] = p;
			this.haPlants[nElem] = haPlants;
			nElem++;
			return true;
	}
	
	public boolean addPlant(String p, double haPlants) {
		if(nElem<threshold) {
			if(nElem>=this.plants.length) {
			// si la taula esta plena reservem mes espai
				String[] newAddPlants = new String[nElem+2];
				double[] newAddHa = new double[nElem+2];
				for(int i=0; i<nElem; i++) {
					newAddPlants[i] = this.plants[i];
					newAddHa[i] = this.haPlants[i];
				}
				this.plants=newAddPlants;
				this.haPlants=newAddHa;
			}
			//ja podem assegurar que hi ha espai per afegir el nou tipus
			for(int i=0;i<nElem;i++){
				if(this.plants[i].equalsIgnoreCase(p)){
					System.out.println(this.plants[i]+" ES IGUAL");
					this.haPlants[i] = this.haPlants[i]+haPlants;
					return true;
				}
			}
			this.plants[nElem] = p;
			this.haPlants[nElem] = haPlants;
			nElem++;
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String[] getPlants() {
		return plants;
	}
	
	public double[] getHaPlants() {
		return haPlants;
	}
	
	public double getHaPLantsMario(int i){
		return haPlants[i];
	}
	
	public void setHa(int i, double area){
		haPlants[i] = area;
	}

	public Terreny copia(){
		Terreny copia = new Terreny(this.name,this.plants[0], this.haPlants[0]);
		for(int i=1; i<this.nElem; i++){
			copia.addPlant(this.plants[i], this.haPlants[i]);
		}
		return copia;
	}
	
	public double countTrees() {
		double trees=0;
		for(int i = 0; i<this.nElem; i++) {	
			if(main.plantList.getPlanta(this.plants[i]) instanceof Arbre) {
				trees = trees + this.haPlants[i];
			}
			
			
		}
		return trees;
		
	}
	
	public double countBush(){
		
		double bush=0;
		for(int i = 0; i<this.nElem; i++) {	
			if(main.plantList.getPlanta(this.plants[i]) instanceof Arbust) {
				bush = bush + this.haPlants[i];
			}
			
			
		}
		return bush;
		
	}
	
	@Override
	public String toString() {
		return "Terreny:\nNom:" + name + "\nPlantes:" + Arrays.toString(plants) + "\nNumero d'elements:" + nElem + "\nPlantes per hectàrea:"
				+ Arrays.toString(haPlants);
	}
	
	
}
