package EstructuresDades;
import Exceptions.*;

public class ConjEntersNoOrd extends ConjuntEnters {

	public static final boolean socOrdenat = false;

	public ConjEntersNoOrd(int num) {
		super(num); 
	}
	
	public void afegir(int e) throws conjuntPle, jaExisteix, valorImpossible {
		int pos=posicio(e);
		if (pos==-1) {
			if (numElem<enters.length) {
				enters[numElem]=e;
				numElem++;
			} else throw new conjuntPle();
		}
		else throw new jaExisteix(e);
	}

	public void eliminar(int e) throws valorImpossible{
		int pos=posicio(e);
		if (pos!=-1) {
			enters[pos]=enters[numElem-1];
			numElem--;
		}
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
}
