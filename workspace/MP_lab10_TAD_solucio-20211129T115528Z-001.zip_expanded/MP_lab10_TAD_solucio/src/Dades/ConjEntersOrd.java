package Dades;

public class ConjEntersOrd implements TADConjuntEnters {

	private int[] enters;
	private int numElem;
	
	public ConjEntersOrd(int num) {
		enters=new int[num];
		numElem=0;
	}
	
	public int afegir(int e) {
		int codi;
		int pos=posicio(e);
		if (pos==-1) {
			if (numElem<enters.length) {
				pos=numElem-1;
				while ((pos>=0) && (enters[pos]>e)) {
					enters[pos+1]=enters[pos];
					pos--;
				}
				enters[pos+1]=e;
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
			for (int i=pos; i<numElem-1; i++)
				enters[i]=enters[i+1];
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
		/* cerca dicotomica */
		
		int ini=0, fi=numElem-1, mig=0;
		boolean trobat=false;
		while ((!trobat) && (ini<=fi)){
			mig=(ini+fi)/2;
			if (enters[mig]==e) trobat=true;
			else if (enters[mig]<e) {
				ini=mig+1;
			} else {
				fi=mig-1;
			}
		}
		if (trobat) return(mig);
		else return(-1);
		 
	}
	
	public boolean ple(){
		return(numElem==enters.length);
	}
	
	public int numElems() {
		return(numElem);
	}
	
}
