package aplicacio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dades.*;

public class UsaLlistaEstacionsVE {
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		int opcio;
		System.out.println("Indica el numero de linies a llegir del fitxer (maxim 418)");
		int numLinies = Integer.parseInt(teclat.nextLine());
		String[] dataset = llegirLiniesFitxer(numLinies);
		LlistaEstacionsVE llistaEstacions = new LlistaEstacionsVE (numLinies);
	
		for (int i = 0; i < dataset.length; i++) {
			actualitzarEstacio (dataset[i], llistaEstacions);
		}
	
		mostraMenu();
		opcio = Integer.parseInt(teclat.nextLine());
		while (opcio != 10) {
			switch (opcio) {
			case 1:
				opcio1(llistaEstacions);
				break;
			case 2:
				opcio2(llistaEstacions);
				break;
			case 3:
				opcio3(llistaEstacions);
				break;
			case 4:
				opcio4(llistaEstacions);
				break;
			case 5:
				opcio5(llistaEstacions);
				break;
			case 6:
				opcio6(llistaEstacions);
				break;
			case 7:
				opcio7(llistaEstacions);
				break;
			case 8:
				opcio8(llistaEstacions);
				break;
			case 9:
				opcio9(llistaEstacions);
				break;
			default:
				System.out.println("Aquesta no es una opcio disponible");
				break;
			}

			mostraMenu();
			opcio = Integer.parseInt(teclat.nextLine());
		}

	}
	
	// Metode per llegir el fitxer csv i carregar en uina string les linies
	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 418)
			nLinies = 418;
		result = new String[nLinies];
		Scanner f = new Scanner(new File("EstacionsRecarregaReduit.csv"));

		String capcalera = f.nextLine();
		System.out.println("El format de les dades en cada linia es el seguent\n" + capcalera);
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
			
		}
		f.close();
		return result;
	}
	// Metode per afegir en la llista els atributs separats per ";".
	public static void actualitzarEstacio(String dataset, LlistaEstacionsVE llista){
		String[] parts = dataset.split(";"); 
		String[] partsVelocitat = parts[1].split(" i ");
		
		EstacioRecarregaVE estacio = new EstacioRecarregaVE(parts[0], partsVelocitat[0], Float.parseFloat(parts[2].replace(',', '.')), Float.parseFloat(parts[3].replace(',', '.')), parts[4], parts[5], Integer.parseInt(parts[6]));	
	
		if (partsVelocitat.length == 2) {
			estacio.afegirTipusVelocitat(partsVelocitat[1]);
		}

		llista.afegirEstacio(estacio);
	}
	// Metode que mostra el menu principal del programa
	public static void mostraMenu() {
		System.out.println("\n\nOpcions del menu:");
		System.out.println("\n\t1. Eliminar el conjunt d’estacions de recàrrega que són d’un municipi");
		System.out.println("\t2. Estació més propera de BCN o Lleida");
		System.out.println("\t3. Numero de estacions per velocitat");
		System.out.println("\t4. Estació amb més places de capacitat");
		System.out.println("\t5. Estació més propera a la nostra posicio");
		System.out.println("\t6. Estacions més properes en un radi de 30Km");
		System.out.println("\t7. Estacions més properes en un radi de 50Km");
		System.out.println("\t8. Estacions properes amb més capaciat");
		System.out.println("\t9. Mostrar totes les estacions");
		System.out.println("\t10. Sortir");
		System.out.print("\n\t\t\tIndica opcio:\n");
	}
	// 1. Metode que elimina el conjunt d’estacions de recarrega que son d’una poblacio
	public static void opcio1(LlistaEstacionsVE llista) {
		System.out.println("Digues quina població:");
		String poblacio;
		poblacio = teclat.nextLine();
		System.out.println(llista.dadesEstPob(poblacio).toString());	
		llista.eliminarEstacionsPoblacio(poblacio);
		System.out.println(llista.dadesEstPob(poblacio).toString());
		
		
	}
	// 2.  Metode que calcula l'estacio mes propera de BCN o Lleida
	public static void opcio2(LlistaEstacionsVE llista) {
		float lat;
		float lon;
		EstacioRecarregaVE bcn =  llista.primeraEstProv("Barcelona");
		EstacioRecarregaVE lleida = llista.primeraEstProv("Lleida");
		
		System.out.println("En quina posicio et trobes?\n");
		System.out.println("Introdueix la latitud de la teva posicio: ");
		lat = Float.parseFloat(teclat.nextLine());
		System.out.println("Introdueix la longitud de la teva posicio: ");
		lon = Float.parseFloat(teclat.nextLine());

		if (bcn != null) {
			System.out.println("Barcelona: \n" + bcn.toString());
			
			if (lleida != null) {
				System.out.println("Lleida: \n" + lleida.toString());
				
				if (bcn.distanciaA(lat, lon) < lleida.distanciaA(lat, lon)) {
					System.out.println("La estacio mes propera es la de Barcelona.");
				}	
				else
				{
					System.out.println("La estacio mes propera es la de la Lleida");
				}
			}
			else
			{
				System.out.println("No hi ha cap estacio de Lleida");
			}
		}
		else
		{
			System.out.println("No hi ha cap estacio de Barcelona");
		}
	}
	// 3. Metode que calcula el numero de estacions per velocitat
	public static void opcio3 (LlistaEstacionsVE llista) {
		int contador = 0;
		String tipVel = "";
		do {
			System.out.println("Quin tipus de velocitat vols contar? (RAPID, semiRAPID,  NORMAL o FORA DE SERVEI)");
			tipVel = teclat.nextLine();
			contador = llista.numEstVel(tipVel);
			if (contador == 0){
				System.out.println("El tipus de velocitat introduit no es valid.");
			}
		} while (contador == 0);
		System.out.println("Hi han "+contador+" "+tipVel);
		
	}
	// 4. metode que calcula l'estacio amb mes places de capacitat
	public static void opcio4 (LlistaEstacionsVE llista) {
		System.out.println(llista.mesPlaces().toString());
		
	}
	// 5. Metode que calcula l'estacio mes propera a la nostra posicio
	public static void opcio5 (LlistaEstacionsVE llista) {
		float lat;
		float lon;
	
		System.out.println("En quina posicio et trobes?\n");
		System.out.println("Introdueix la latitud de la teva posicio: ");
		lat = Float.parseFloat(teclat.nextLine());
		System.out.println("Introdueix la longitud de la teva posicio: ");
		lon = Float.parseFloat(teclat.nextLine());
		
		System.out.println("La estacio mes propera es: " + llista.estPropera(lat, lon).toString());
	}
	// 6. Metode que calcula les estacions mes properes en un radi de 30Km	
	public static void opcio6(LlistaEstacionsVE llista) {
		LlistaEstacionsVE.setRadi (30);
		float lat;
		float lon;
	
		System.out.println("En quina posicio et trobes?\n");
		System.out.println("Introdueix la latitud de la teva posicio: ");
		lat = Float.parseFloat(teclat.nextLine());
		System.out.println("Introdueix la longitud de la teva posicio: ");
		lon = Float.parseFloat(teclat.nextLine());	
		
		if (llista.mesPropRadi(lat, lon) != null) {
			System.out.println("La estacio mes propera en un radi de 30km es: : " + llista.mesPropRadi(lat, lon).toString());
		}
		else {
			System.out.println("No hi cap estacio en aquest radi");
		}
	}
	// 7. Metode que calcula les estacions mes properes en un radi de 50Km
	public static void opcio7(LlistaEstacionsVE llista) {
		LlistaEstacionsVE.setRadi (50);
		float lat;
		float lon;
		
		System.out.println("En quina posicio et trobes?\n");
		System.out.println("Introdueix la latitud de la teva posicio: ");
		lat = Float.parseFloat(teclat.nextLine());
		System.out.println("Introdueix la longitud de la teva posicio: ");
		lon = Float.parseFloat(teclat.nextLine());
		
		if (llista.mesPropRadi(lat, lon) != null) {
			System.out.println("La estacio mes propera en un radi de 50km es: : " + llista.mesPropRadi(lat, lon).toString());
		}
		else {
			System.out.println("No hi cap estacio en aquest radi");
		}
		
	}
	// 8. Metode que calcula les estacions properes amb més capacitat
	public static void opcio8(LlistaEstacionsVE llista){
		float lat;
		float lon;
		
		System.out.println("En quina posicio et trobes?\n");
		System.out.println("Introdueix la latitud de la teva posicio: ");
		lat = Float.parseFloat(teclat.nextLine());
		System.out.println("Introdueix la longitud de la teva posicio: ");
		lon = Float.parseFloat(teclat.nextLine());	
		
		System.out.println(llista.allEstProp(lat, lon).toString());
	}
	// 9. Metode que mostra totes les estacions	
	public static void opcio9(LlistaEstacionsVE llista) {
		System.out.println(llista.toString());
		
	}

}