package dades;
/**
 * @author Jordi and ismael and edgar
 */
public class LlistaTerrenys {
	private Terreny[] terrenys;
	private	int nElem;

	
	public LlistaTerrenys() {
		terrenys = new Terreny[3];
		nElem=0;
	}
	public Terreny getTerreny(String terrain){
		for(int i=0; i<nElem; i++){
			if(terrenys[i].getName().equalsIgnoreCase(terrain)){
				return terrenys[i];
			}
		}
		return null;
	}
	public Terreny[] getTerrenys() {
		return terrenys;
	}

	public LlistaTerrenys(Terreny Terreny1) {
		terrenys = new Terreny[3];
		terrenys[0] = Terreny1.copia();
		nElem=1;
	}
	
	public boolean addTerreny (Terreny Terreny1) {
		if (nElem>=this.terrenys.length){
			for(int i=0;i<nElem;i++){
				if(this.terrenys[i].getName().equalsIgnoreCase(Terreny1.getName())){
					return false;
				}
			}
		}
		if (nElem>=this.terrenys.length){
			Terreny[] newList = new Terreny[nElem+2];
			for (int i = 0; i<nElem;i++) 
				newList[i]=this.terrenys[i];
			this.terrenys = newList;
		}
		this.terrenys[nElem]=Terreny1.copia();
		nElem++;
		return true;
	}

	public int getnElem(){
		return nElem;
	}
	
	@Override
	public String toString() {
		String text = "";
	    for(int i = 0;i<nElem;i++)
	        text = text + terrenys[i].toString() + "\n";
	    return text;
	}
}
