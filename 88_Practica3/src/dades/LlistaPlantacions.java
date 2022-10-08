package dades;
/**
 * @author Jordi and ismael and edgar
 */
public class LlistaPlantacions {
	private Plantacions[] plantacions;
	private	int nElem;
	
	//TODO
	//Llistes, mètode afegir, recordar a fer el duplicat del paràmetre que es rep
	
	public LlistaPlantacions() {
		plantacions = new Plantacions[3];
		nElem=0;
	}
	
	public void addPlantation (Plantacions Plantacion) {
		if (nElem>=this.plantacions.length){
			Plantacions[] newList = new Plantacions[nElem+2];
			for (int i = 0; i<nElem;i++) 
				newList[i]=this.plantacions[i];
			this.plantacions = newList;
		}
		this.plantacions[nElem]=Plantacion.copia();
		nElem++;
	}
	
	public LlistaPlantacions LlistTypesTerrains(String terreny){
		LlistaPlantacions plantacions2 = new LlistaPlantacions();
		int j=0;
		boolean trobat = false;
		
		for(int i=0;i<this.nElem;i++){
			do	{
				if(this.plantacions[i].getTerrain(j).equalsIgnoreCase(terreny)){
					plantacions2.addPlantation(plantacions[i].copia());
					trobat=true;
				}
				j++;
			}while(!trobat && j<this.plantacions[i].getTerrain().length);
			trobat = false;
			j=0;
		}
		return plantacions2;
	}
	
	public Plantacions[] getPlantacions() {
		return plantacions;
	}
	
	public Plantacions getPlantacionsFromIndex(int i){
		return plantacions[i];
	}
	public int getnElem(){
		return nElem;
	}
	public void removePlantation(String plantation){
		Plantacions[] aux = new Plantacions[nElem];
		int j=0;
		for(int i=0; i<nElem;i++){
			if(!(plantacions[i].getName().equalsIgnoreCase(plantation))){
				aux[j]=plantacions[i].copia();
				j++;
			}
		}
		
		if (j != nElem) {
			nElem--;
		}
		
		plantacions = aux;
	}
	
	public Plantacions getPlantation(String plantation){
		for (int i=0; i<nElem;i++){
			if(plantacions[i].getName().equalsIgnoreCase(plantation)){
				return plantacions[i];	
			}
		}
		return null;
	}
	public void setPlantationYear(String plantation, int age){
		for(int i=0; i<nElem; i++){
			if(plantacions[i].getName().equalsIgnoreCase(plantation)){
				plantacions[i].setYear(age);
			}
		}
	}
	
	@Override
	public String toString() {
		String text = "";
	    for(int i = 0;i<nElem;i++)
	        text = text + plantacions[i].toString() + "\n";
	    return text;
	}
	
}
