package Dades;

public class ConjEntersNoOrd implements TADConjuntEnters {

	private int[] enters;
	private int numElem;
	
	
	public ConjEntersNoOrd(int num) {
		enters=new int[num];
		numElem=0; 
	}
	
	public int afegir(int e) {
		int codi;
		int pos=posicio(e);
		if (pos==-1) {
			if (numElem<enters.length) {
				enters[numElem]=e;
				numElem++;
				codi=1;
			} else codi=-1;
		} else codi=0;
		return codi;
	}

	public int eliminar(int e) {
		int codi;
		int pos=posicio(e);
		if (pos!=-1) {
			enters[pos]=enters[numElem-1];
			numElem--;
			codi=1;
		} else codi=0;
		return codi;
	}

	public boolean pertany(int e) {
		if (posicio(e)!=-1) return(true);
		else return(false);
	}
	
	private int posicio(int e) {
		int i=0;
		boolean trobat=false;
		while ((!trobat) && (i<numElem)) {
			if (enters[i]==e) trobat=true;
			else i++;
		}
		if (trobat) return i;
		else return(-1);
	}
	
	public boolean ple(){
		return(numElem==enters.length);
	}
	
	public int numElems() {
		return(numElem);
	}
	
}
