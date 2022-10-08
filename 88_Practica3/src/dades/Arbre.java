package dades;

import java.util.Arrays;

/**
 * @author mario and ismael
 */
public class Arbre extends Planta {

	private int[] minimThreshold;
	private int[] absortion;
	private int nElem;
	
	public Arbre(String name, int minimThreshold, int absortion) {
		
		super(name);
	
		nElem=0;
		this.minimThreshold = new int[2];
		this.absortion = new int[2];
		
		this.minimThreshold[0]=minimThreshold;
		this.absortion[0]=absortion;
		nElem++;
	
	}
	
	public void addAbsortion(int minimThreshold, int absortion) {
		if (nElem>=this.minimThreshold.length) {
			// si la taula està plena reservem més espai
			int[] newAddThreshold=new int[nElem+1];
			int[] newAddAbsortion=new int[nElem+1];
			for (int i=0; i<nElem; i++) {
				newAddThreshold[i]=this.minimThreshold[i];
				newAddAbsortion[i]=this.absortion[i];
				
			}
			this.minimThreshold=newAddThreshold;
			this.absortion=newAddAbsortion;			
		}
		// ja podem assegurar que hi ha espai per afegir el nou tipus
		this.minimThreshold[nElem]=minimThreshold;
		this.absortion[nElem]=absortion;
		nElem++;
		
	}
	
	@Override
	public Planta copia(){
		Planta copia = new Arbre(this.getName(), this.minimThreshold[0], this.absortion[0]);
		for(int i=1; i<this.nElem; i++){
			((Arbre)copia).addAbsortion(this.minimThreshold[i], this.absortion[i]);
		}
		return copia;
	}


	
	@Override
	public String toString() {
		return "Arbre [name=" + getName() +", minimThreshold="
				+ Arrays.toString(minimThreshold) + ", absortion=" + Arrays.toString(absortion) + "]";
	}

	@Override
	public int getAbsortion(int age) {
		if(age<minimThreshold[0]) {
			return 0;
		}
		for(int i=0; i<minimThreshold.length-1;i++) {
			if(age>=minimThreshold[i] && age<minimThreshold[i+1]) {
				return absortion[i];
			}
		}
		return absortion[absortion.length-1];
	}
	public int[] getAbsortionList(){
		return absortion;
	}
	public int[] getminimThreshold(){
		return minimThreshold;
	}

	@Override
	public int getAbsortion() {
		return 0;
	}
}








