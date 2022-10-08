package Dades;

public class ConjEntersAltres implements TADConjuntEnters {

	private int[] enters;		// 0 - valor no afegit al conjunt, 1 - valor afegit
	private int numElem;
	
	public ConjEntersAltres(int num) {
		enters=new int[num];
		numElem=0; 
	}
	
	public int afegir(int e) {
		int codi;
		if ((e>=0) && (e<enters.length)) {
			if (enters[e]==0) {
				enters[e]=1;
				codi=1;
				numElem++;
			} else codi=0;	// el valor ja estava al conjunt
		} else codi=-1;
		return codi;
	}
	
	public int eliminar(int e) {
		int codi;
		if ((e>=0) && (e<enters.length)) {
			if (enters[e]!=0) {
				enters[e]=0;
				codi=1;
				numElem--;
			} else codi=0;
		} else codi=-1;
		return codi;
	}

	public boolean pertany(int e) {
		boolean hiEs;
		if ((e>=0) && (e<enters.length)) {
			if (enters[e]==1) hiEs=true;
			else hiEs=false;
		} else hiEs=false;
		return hiEs;
	}
	
	public boolean ple(){
		return(numElem==enters.length);
	}
	
	public int numElems() {
		return(numElem);
	}
	
}
