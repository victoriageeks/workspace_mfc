package Main;

import EstructuraDades.*;

public class Main {
	public static void main(String[] args) {
		LlistaGenerica<Punt> punts=new LlistaGenerica<Punt>(3);
		
		for (int i=0; i<10; i++) {
			punts.afegirPunt(new Punt(i, 4-i));
		}
		
		System.out.println("Llista de punts ordenada pel criteri natural");
		for(Punt p:punts) {
			System.out.println("\t"+p);
		}
		
		
	}
		
}
