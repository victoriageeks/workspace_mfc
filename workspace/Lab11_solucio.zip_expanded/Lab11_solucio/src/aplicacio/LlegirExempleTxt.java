package aplicacio;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class LlegirExempleTxt {

	public static void main(String[] args) throws IOException {
		// Exemple.txt el separador decimal és ,
		// notació hispana (comentar la línia .useLocale dels mètodes)
		//llegirFitxerScannerVersio1("Exemple.txt");
		//llegirFitxerScannerVersio2("Exemple.txt");
		
		// ExempleSeparadorDecimalModificat, el separador decimal és .
		// notació anglosaxona (descomentar la línia .useLocale dels mètodes)
		llegirFitxerScannerVersio1("ExempleSeparadorDecimalModificat.txt");
		llegirFitxerScannerVersio2("ExempleSeparadorDecimalModificat.txt");
		
	}

	private static void llegirFitxerScannerVersio1(String nomFitxer) throws IOException {
		// utilitzem classe Scanner i llegim element a element
		
		Scanner lectura=new Scanner(new File(nomFitxer));
		BufferedWriter escriptura=new BufferedWriter(new FileWriter("Densitat.txt"));
		
		String nom;
		int poblacio;
		float superficie, densitat;
				
		lectura.useDelimiter(";");
		lectura.useLocale(Locale.ENGLISH);
		while (lectura.hasNext()) {
			nom=lectura.next();
			poblacio=lectura.nextInt();
			//poblacio=Integer.parseInt(lectura.next());
			superficie=lectura.nextFloat();
			//superficie=Float.parseFloat(lectura.next());
			densitat=poblacio/superficie;
			escriptura.write(nom+": "+densitat+" hab/km2");
			System.out.println(nom+": "+densitat+" hab/km2");
		}
		lectura.close();
		escriptura.close();
	}

	private static void llegirFitxerScannerVersio2(String nomFitxer) throws IOException {
		// utilitzem classe Scanner i llegim línia a línia
		// després separem el contingut de les línies
		
		Scanner lectura=new Scanner(new File(nomFitxer));
		Scanner particio;
		BufferedWriter escriptura=new BufferedWriter(new FileWriter("Densitat2.txt"));
		String frase, nom;
		int poblacio;
		float superficie, densitat;
		
		while (lectura.hasNext()) {
			frase=lectura.nextLine();
			// ara separem el contingut de la frase
			particio=new Scanner(frase);
			particio.useDelimiter(";");
			particio.useLocale(Locale.ENGLISH);
			nom=particio.next();
			poblacio=particio.nextInt();
			superficie=particio.nextFloat();
			densitat=poblacio/superficie;
			escriptura.write(nom+": "+densitat+" hab/km2\n");
			System.out.println(nom+": "+densitat+" hab/km2");
		}
		lectura.close();
		escriptura.close();
	}
	
}
