package Aplicacio;
import java.util.Scanner;
import Dades.*;

public class AplicacioDin {

	static Scanner teclat=new Scanner(System.in);
	
	public static void main(String[] args) {
		TADConjuntEnters cjt=new ConjEntersDinamica();
		
		
		// afegim alguns valors
		cjt.afegir(2016);
		cjt.afegir(1978);
		cjt.afegir(3457);
		cjt.afegir(1111);
		cjt.afegir(29);
		cjt.afegir(978542);
		System.out.println("El contingut del conjunt es \n\t" + cjt);
		
		// treiem alguns valors
		cjt.eliminar(2016);
		cjt.eliminar(978542);
		cjt.eliminar(1111);
		System.out.println("El contingut del conjunt es \n\t" + cjt);
		
	}

}
