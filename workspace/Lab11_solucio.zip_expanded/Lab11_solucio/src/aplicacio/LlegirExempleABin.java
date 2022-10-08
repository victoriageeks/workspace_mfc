package aplicacio;

import java.io.*;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import dades.Densitat;

public class LlegirExempleABin {
	public static void main(String[] args) throws IOException {

		llegirFitxerBufferedVersio1("ExempleSeparadorDecimalModificat.txt");

		llegirFitxerBufferedVersio2("ExempleSeparadorDecimalModificat.txt");
		llegirFitxerBufferedVersio2("ExempleErrors.txt");
	}

	private static void llegirFitxerBufferedVersio1(String nomFitxer) throws IOException {
		BufferedReader lectura;
		ObjectOutputStream sortida;
		String frase, nom;
		int poblacio;
		float superficie, densitat;
		lectura = new BufferedReader(new FileReader(nomFitxer));
		sortida = new ObjectOutputStream(new FileOutputStream("Densitats.bin"));
		Scanner particio;
		frase = lectura.readLine();
		while (frase != null) {
			particio = new Scanner(frase);
			particio.useDelimiter(";");
			particio.useLocale(Locale.ENGLISH);
			nom = particio.next();
			poblacio = particio.nextInt();
			superficie = particio.nextFloat();
			densitat = poblacio / superficie;
			sortida.writeObject(new Densitat(nom, densitat));
			System.out.println(nom + ": " + densitat + " hab/km2");
			frase = lectura.readLine();
		}
		lectura.close();
		sortida.close();

	}

	private static void llegirFitxerBufferedVersio2(String nomFitxer) {
		BufferedReader lectura;
		ObjectOutputStream sortida;
		String frase, nom;
		int poblacio;
		float superficie, densitat;
		try {
			lectura = new BufferedReader(new FileReader(nomFitxer));
			sortida = new ObjectOutputStream(new FileOutputStream("Densitats2.bin"));
			Scanner particio;
			frase = lectura.readLine();
			while (frase != null) {
				particio = new Scanner(frase);
				particio.useDelimiter(";");
				particio.useLocale(Locale.ENGLISH);
				try {
					nom = particio.next();
					poblacio = particio.nextInt();
					superficie = particio.nextFloat();
					densitat = poblacio / superficie;
					if (superficie==0) throw new ArithmeticException("Superficie no pot ser zero");
					sortida.writeObject(new Densitat(nom, densitat));
					System.out.println(nom + ": " + densitat + " hab/km2");
				} catch (NumberFormatException e) {
					System.out.println("El segon i/o tercer valor ha de ser numeric");
				} catch (NoSuchElementException e) {
					System.out.println("Falta algun valor a la línia o valors no numerics");
				} catch (ArithmeticException e) {
					System.out.println(e);
				}
				frase = lectura.readLine();
			}
			lectura.close();
			sortida.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fitxer d'entrada no existeix");
		} catch (IOException e) {
			System.out.println("Algun error amb els fitxers");
		}

	}
}
