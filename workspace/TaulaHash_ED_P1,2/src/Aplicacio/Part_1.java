package Aplicacio;
import DobleEncadenada.*;
import Excepcions.*;

/**
 * 
 * @author Marc Fonseca
 *
 */

public class Part_1 {
	
	public static void main(String[] ar) {
			
		LlistaDobleEncadenada<Ciutada> llista = new LlistaDobleEncadenada<Ciutada>();
		
		int posicio = 2;
		
		Ciutada ciutada1 = new Ciutada("Pablo", "Garcia", "47223427M");
		Ciutada ciutada2 = new Ciutada("Marc", "Fontseca", "48017307T");
		Ciutada ciutada3 = new Ciutada("Jesus", "Sepulveda", "35718295R");
		Ciutada ciutada4 = new Ciutada("Oscar", "Perez", "34578924G");
		Ciutada ciutada5 = new Ciutada("Marc", "Fonseca", "48017307T");
		Ciutada ciutadaNoInserit = new Ciutada("jeje", "NoEstoy", "12345678F");
		
		// 1. Inserim de manera normal
		System.out.println("[Insercio Nromal]");
		
		llista.inserir(ciutada1);
		llista.inserir(ciutada2);
		llista.inserir(ciutada3);
		llista.inserir(ciutada4);
		
		System.out.println("Numero de elements = " +llista.longitud());	
		for (Ciutada c:llista) {
			System.out.println("\t"+c+"\n");
		}
		
		// 2. Inserim en una certa posicio
		System.out.println("[Insercio Posicio]");
		
		try {
			llista.inserir(posicio, ciutada5);
		} catch (foraDeRang e) {
			System.out.println(e);
		}
		
		System.out.println("Numero de elements = " +llista.longitud());
		for (Ciutada c:llista) {
			System.out.println("\t"+c+"\n");
		}
		
		// 3. Comparem valors diferents
		System.out.println("[Comparacio diferents]");
		
		try {
			if (llista.obtenir(1).compareTo(llista.obtenir(0)) != 0) {
				System.out.println("Primer i segon tenen diferent DNI\n");
			}
			else
			{
				System.out.println("Segon i tercer tenen el mateix DNI\n");
			}
		} catch (foraDeRang e) {
			System.out.println(e);
		}
		
		// 4. Comparem valors iguals
		System.out.println("[Comparacio iguals]");
		
		try {
			if (llista.obtenir(1).compareTo(llista.obtenir(2)) == 0) {
				System.out.println("Primer i tercer tenen el mateix DNI\n");
			}
			else {
				System.out.println("Primer i tercer tenen diferent DNI\n");
			}
		} catch (foraDeRang e) {
			System.out.println(e);
		}
		
		// 5. Obtenim una posicio que no existeix
		System.out.println("[Obtencio no existeix]");
		
		try {
			llista.obtenir(5);
		} catch (foraDeRang e) {
			System.out.println(e);
		}
		
		// 6. Esborrem l'element insertat previament
		System.out.println("[Esborrat Existeix]");
		
		try {
			llista.esborrar(posicio);
		} catch (foraDeRang e) {
			System.out.println(e);
		}
		
		System.out.println("Numero de elements = " +llista.longitud());
		for (Ciutada c:llista) {
			System.out.println("\t"+c+"\n");
		}
		
		
		// 7. Esborrem un element que no existeix
		System.out.println("[Esborrat no Existeix]");
		
		try {
			llista.esborrar(5);
		} catch (foraDeRang e) {
			System.out.println(e);
		}
		
		
		// 8. Busquem un element que existeix
		System.out.println("[Busqueda Existeix]");
		try {
			System.out.println("Ha accedit a " +llista.buscar(ciutada1)+ " elements per trobar el ciutada\n");
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		// 9. Busquem un element que no existeix
		System.out.println("[Busqueda no Existeix]");
		
		try {
			System.out.println("Ha accedit a " +llista.buscar(ciutadaNoInserit)+ " elements per trobar el ciutada\n");
		} catch (noTrobat e) {
			System.out.println(e);
		}
	 }
}
