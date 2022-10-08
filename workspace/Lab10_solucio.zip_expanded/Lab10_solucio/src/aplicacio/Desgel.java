package aplicacio;

import java.util.*;

import dades.Temperatures;
import excepcions.*;

public class Desgel {

	public static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) {

		int numDies = 0, numEstacions = 0;
		Temperatures tempPolNord = new Temperatures(numDies);
		float[] valors = new float[numEstacions], pesos = new float[numEstacions];
		boolean llegit = false;

		while (!llegit) {
			try {
				// Demanem a l'usuari quantes mostres donarà (de quants dies tenim dades)
				System.out.println("Indica el número de dies dels que tens dades de temperatura: ");
				numDies = Integer.parseInt(teclat.nextLine());
				if (numDies==0)
					throw new Zero("numDies");
				tempPolNord = new Temperatures(numDies);
				llegit = true;
			} catch (NumberFormatException e) {
				System.out.println("El numero de dies ha de ser un valor numèric" + e);
			} catch (NegativeArraySizeException e) {
				System.out.println("El numero de dies ha de ser un valor positiu" + e);
			} catch (Zero e) {
				System.out.println(e);
			}
		}

		llegit = false;

		while (!llegit) {
			try {
				// Demanem a l'usuari el número de valors en cada dia (de quantes estacions
				// tenim dades)
				System.out.println("Ara indica quants valors de temperatura (estacions) tens per cada dia: ");
				numEstacions = Integer.parseInt(teclat.nextLine());
				if (numEstacions==0)
					throw new Zero("numEstacions");
				valors = new float[numEstacions];
				pesos = new float[numEstacions];
				llegit = true;
			} catch (NumberFormatException e) {
				System.out.println("El numero de valors de temperatura (estacions) ha de ser un valor numèric");
			} catch (NegativeArraySizeException e) {
				System.out.println("El numero de valors de temperatura (estacions) ha de ser un valor positiu");
			} catch (Zero e) {
				System.out.println(e);
			}
		}

		// L'usuari anirà entrant els num valors i la seva confiança per cada dia
		int i=0;
		while ( i < numDies) {
			try {
				System.out.println("\nIntrodueix els valors de temperatures i valors de confiança del dia: " + (i + 1));
				llegirTemp(valors, pesos);
				tempPolNord.anotaTemp(valors, pesos);
				i++;
			} catch (ArithmeticException e) {
				System.out.println("No tots els valors de confiança poden ser 0");
			}
		}
		System.out.println("Temperatures anotades correctament.");
		System.out.println(
				"Si vols consultar alguna temperatura mitjana, entra el número de dia (1..max): (indica -1 per acabar)");
		int num = 0;

		do {
			try {
				num = Integer.parseInt(teclat.nextLine());
				if (num != -1) {
					System.out.println(
							"La temperatura mitjana calculada és: " + tempPolNord.consultaTempMitjana(num - 1));
					System.out.println(
							"Per consultar una altra temperatura mitjana, entra el número de dia (1..max): (indica -1 per acabar)");
				}
			} catch (NumberFormatException e) {
				System.out.println("La posició ha de ser un valor numèric");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("La posició ha de ser una posició vàlida de la taula");
			}
		} while (num != -1);
	}

	public static void llegirTemp(float[] val, float[] pes) {
		int i = 0;

		while (i < val.length) {
			try {
				System.out.println("Valors estació : " + (i + 1) + "\n\t valor temperatura:");
				val[i] = Float.parseFloat(teclat.nextLine());
				if (val[i]<-100 || val[i]>20)
					throw new RangTemperaturaCorrecte(val[i]);
				System.out.println("\n\t valor confiança:");
				pes[i] = Float.parseFloat(teclat.nextLine());
				if (pes[i]<0 || pes[i]>100)
					throw new RangConfiansaCorrecte();
				i++;
			} catch (NumberFormatException e) {
				System.out.println("Els valors han de ser numèrics");
			} catch (RangTemperaturaCorrecte | RangConfiansaCorrecte e) {
				System.out.println(e);
			}
		}
	}
}
