package EstructuraDades;

import java.util.Arrays;
import java.util.Iterator;

public class LlistaGenerica<T extends Comparable<T>> implements Iterable<T> {
	private T[] llista;
	private int num;
	
	public LlistaGenerica(int dim) {
		llista=(T[])new Object[dim];
		num=0;
	}

	public void afegirPunt(T p) {
		if (num>=llista.length) {
			// amplio
			T[] nova=(T[]) new Object[llista.length*2];
			for (int i=0; i<llista.length; i++)
				nova[i]=llista[i];
			llista=nova;
		}
		// segur que tinc espai
		int pos=num-1;
		while ((pos>=0) && (p.compareTo(llista[pos])<0)) {
			llista[pos+1]=llista[pos];
			pos--;
		}
		llista[pos+1]=p;
		num++;
	}
	
	public T consultarIessim(int i) {
		if (i<num) return(llista[i]);
		else return(null);
	}
	
	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return "LlistaPunts [llista=" + Arrays.toString(llista) + ", num=" + num + "]";
	}

	@Override
	public Iterator<T> iterator() {
		LlistaIterator<T> pI=new LlistaIterator<T>(this);
		return pI;
	}
	
}
