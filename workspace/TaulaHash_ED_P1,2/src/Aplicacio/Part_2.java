package Aplicacio;
import DobleEncadenada.*;
import Excepcions.*;
import Hash.*;

/**
 * 
 * @author Marc Fonseca
 *
 */

public class Part_2 {
	
	public static void main(String[] ar) {
		TaulaHash<Ciutada, String> taulaHash = new TaulaHash<>(10);
		
		Ciutada ciutada1 = new Ciutada("Pablo", "Garcia", "47223427M");
		Ciutada ciutada2 = new Ciutada("Marc", "Fontseca", "48017307T");
		Ciutada ciutada3 = new Ciutada("Jesus", "Sepulveda", "35718295R");
		Ciutada ciutada4 = new Ciutada("Oscar", "Perez", "34578924G");
		Ciutada ciutada5 = new Ciutada("Ramon", "Rey", "3541157H");
		Ciutada ciutada6 = new Ciutada("Angel", "Rey", "48010773A");
		Ciutada ciutada7 = new Ciutada("Font", "Vella", "54797147G");
		Ciutada ciutada8 = new Ciutada("Benito", "Camela", "23456781E");
		Ciutada ciutada9 = new Ciutada("Raquel", "Hernandez", "23415627Y");
		Ciutada ciutada2Repetit = new Ciutada("Marc", "Fonseca", "48017307T");
		Ciutada ciutadaNoInserit = new Ciutada("jeje", "NoEstoy", "12345678F");
		
		// 1. Inserim 8 elements a la taula
		System.out.println("[Insercio Normal]\n");
		taulaHash.inserir(ciutada1.getDNI(), ciutada1);
		taulaHash.inserir(ciutada2.getDNI(), ciutada2);
		taulaHash.inserir(ciutada3.getDNI(), ciutada3);
		taulaHash.inserir(ciutada4.getDNI(), ciutada4);
		taulaHash.inserir(ciutada5.getDNI(), ciutada5);
		taulaHash.inserir(ciutada6.getDNI(), ciutada6);
		taulaHash.inserir(ciutada7.getDNI(), ciutada7);
		taulaHash.inserir(ciutada8.getDNI(), ciutada8);
 		
		System.out.println("Numero de elements: " + taulaHash.mida() + "\n");
		System.out.println(taulaHash.toString());
		
		// 2. Inserim l'element numero 9 per tal de redimensionar-la
		System.out.println("[Insercio Redimensionada]\n");
		taulaHash.inserir(ciutada9.getDNI(), ciutada9);
		
		System.out.println("Numero de elements: " + taulaHash.mida() + "\n");
		System.out.println(taulaHash.toString());
		
		// 3. Inserim un element repetit, per modificar el seu valor
		System.out.println("[Insercio Repetit]\n");
		taulaHash.inserir(ciutada2Repetit.getDNI(), ciutada2Repetit);
		
		System.out.println("Numero de elements: " + taulaHash.mida() + "\n");
		System.out.println(taulaHash.toString());
		
		// 4. Obtenim un valor de la taula
		System.out.println("[Obtenció Inserit]");
		try {
			System.out.println(taulaHash.obtenir(ciutada2.getDNI()) + "\n");
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		// 5. Obtenim un valor que no esta a la Taula
		System.out.println("[Obtenció no Inserit]");
		try {
			System.out.println(taulaHash.obtenir(ciutadaNoInserit.getDNI()) + "\n");
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		// 6. Busquem un element que esta en la primera colisio
		System.out.println("\n[Busqueda Primera Colisio]");
		try {
			System.out.println("S'han accedit " + taulaHash.buscar(ciutada9.getDNI()) + " element/s.\n");
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		// 7. Busquem un element que no esta en la primera colisio
		System.out.println("[Busqueda no Primera Colisio]");
		try {
			System.out.println("S'han accedit " + taulaHash.buscar(ciutada8.getDNI()) + " element/s.\n");
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		// 8. Busquem un element que no esta a la taula
		System.out.println("[Busqueda no Existeix]");
		try {
			System.out.println("S'han accedit " + taulaHash.buscar(ciutadaNoInserit.getDNI()) + " element/s.\n");
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		// 9. Esborrem un element que esta en la primera colisio
		System.out.println("\n[Borrat Primera Colisio]");
		try {
			taulaHash.esborrar(ciutada9.getDNI());
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		System.out.println("Numero de elements: " + taulaHash.mida() + "\n");
		System.out.println(taulaHash.toString());
		
		// 10. Esborrem un element que no esta en la primera colisio
		System.out.println("[Borrat no Primera Colisio]");
		try {
			taulaHash.esborrar(ciutada8.getDNI());
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		System.out.println("Numero de elements: " + taulaHash.mida() + "\n");
		System.out.println(taulaHash.toString());
		
		// 11. Esborrem un element que no esta a la taula
		System.out.println("[Borrat no Existeix]");
		try {
			taulaHash.esborrar(ciutadaNoInserit.getDNI());
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		System.out.println("Numero de elements: " + taulaHash.mida() + "\n");
		System.out.println(taulaHash.toString());
		
		// 12. Llistar valors de la taula
		System.out.println("[Llistar Valors]");
		LlistaDobleEncadenada<Ciutada> valors = new LlistaDobleEncadenada<Ciutada>();
		
		valors = taulaHash.obtenirValors();
		
		System.out.println("Numero de elements: " + valors.longitud());
		for(Ciutada c:valors) {
			System.out.println("\t"+ c);
		}
		
		// 13. Llistar claus de la taula
		System.out.println("\n[Llistar Claus]");
		LlistaDobleEncadenada<String> claus = new LlistaDobleEncadenada<String>();
		
		claus = taulaHash.obtenirClaus();
		
		System.out.println("Numero de elements: " + claus.longitud());
		for(String c:claus) {
			System.out.println("\t"+ c);
		}
	 }
}
