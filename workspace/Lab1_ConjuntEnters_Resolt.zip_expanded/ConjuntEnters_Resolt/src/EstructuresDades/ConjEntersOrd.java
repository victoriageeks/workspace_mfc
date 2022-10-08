package EstructuresDades;
import Exceptions.*;

public class ConjEntersOrd extends ConjuntEnters {

	public static final boolean socOrdenat = true;

	public ConjEntersOrd(int num) {
		super(num); 
	}
	
	public void afegir(int e) throws conjuntPle, jaExisteix, valorImpossible {
		int pos=posicio(e);
		if (pos==-1) {
			if (numElem<enters.length) {
				pos=numElem-1;
				while ((pos>=0) && (enters[pos]>e)) {
					enters[pos+1]=enters[pos];
					pos--;
				}
				if (pos>=0)
				 enters[pos+1]=e;
				else enters[0]=e;
				numElem++;
			} else throw new conjuntPle();
		}
		else throw new jaExisteix(e);
	}
	
	public void eliminar(int e) throws valorImpossible{
		int pos=posicio(e);
		if (pos!=-1) {
			for (int i=pos; i<numElem-1; i++)
				enters[i]=enters[i+1];
			numElem--;
		}
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
}
