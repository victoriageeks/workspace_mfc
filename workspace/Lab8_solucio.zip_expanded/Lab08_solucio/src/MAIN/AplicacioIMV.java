package MAIN;

import Dades.*;


public class AplicacioIMV {

	public static void main(String[] args) {
		int carrega = 0;
		double impTotal = 0.0;
		
		Turisme t=new Turisme("1245FDE", 12);
		Camio c=new Camio("7854FDR", 2500);
		Autobus a=new Autobus("5412AAA", 54);
		
		Vehicle[] llista=new Vehicle[3];
		llista[0]=new Turisme("1245FDE", 12);
		llista[1]=new Camio("7854FDR", 2500);
		llista[2]=new Autobus("5412AAA", 54);
		
		System.out.println(t+" i ha de pagar "+t.taxaIMV());
		System.out.println(c+" i ha de pagar "+c.taxaIMV());
		System.out.println(a+" i ha de pagar "+a.taxaIMV());

		System.out.println("\n");
		
		for (int i=0; i<llista.length; i++) {
			if (llista[i] instanceof Turisme) {
				System.out.println((((Turisme)llista[i]).jajas()));
			}
			
			impTotal = impTotal + llista[i].taxaIMV();
			if (llista[i] instanceof Camio) {
				carrega = carrega + ((Camio)llista[i]).getCarregaUtil();
			}
		}
		System.out.println(carrega+ "  " +impTotal);
	}

}
