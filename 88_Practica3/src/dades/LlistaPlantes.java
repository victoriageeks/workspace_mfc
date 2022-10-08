package dades;

import java.util.Arrays;
/**
 * @author Jordi and ismael and edgar
 */
public class LlistaPlantes {
	private Planta[] plants;
	private	int nElem;
	

	public LlistaPlantes () {
		plants = new Planta[3];
		nElem = 0;
	}
	
	public boolean addPlant (Planta planta1) {
		if (nElem>=this.plants.length){
			for(int i=0;i<nElem;i++){
				if(this.plants[i].getName().equalsIgnoreCase(planta1.getName())){
					return false;
				}
			}
			Planta[] newList = new Planta[nElem+2];
			for (int i = 0; i<nElem;i++) 
				newList[i]=this.plants[i].copia();
			this.plants = newList;
		}
		this.plants[nElem]=planta1.copia();
		nElem++;
		return true;
	}

	@Override
	public String toString() {
		String text = "";
	    for(int i = 0;i<nElem;i++)
	        text = text + plants[i].toString() + "\n";
	    return text;
	}
	
	public String toString(int[] ha) {
		String text = "";
	    for(int i = 0;i<nElem;i++)
	        text = text + plants[i].toString() + " Unidades plantadas por Hra= " + ha[i] + "\n";
	    return text;
	}
	
	public Planta getPlanta(String p){
		for(int i=0; i<nElem;i++){
			if(plants[i].getName().equalsIgnoreCase(p)){
				return plants[i];
			}
		}
		return null;
	}
	
	public Planta[] getPlants() {
		return plants;
	}

	public int getnElem() {
		return nElem;
	}
	
	
	
}
	
