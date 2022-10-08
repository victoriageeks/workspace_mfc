package aplicacio;
import java.io.*;
import dades.*;

public class TornaCanviAplicacio {
	static double[] valorMonedes = { 0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100, 200, 500 };

	public static void main(String[] args) throws IOException {
		BufferedReader entrada = new BufferedReader(new FileReader("imports.txt"));

		// numero de problemes que te el fitxer
		int numProblemes = Integer.parseInt(entrada.readLine());
		int indexImports, problema = 0;
		String[] liniaMonedes, liniaImports;
		int[] monedes, resultat;
		double[] importsATornar;

		TornaCanvi canvi;
		
		System.out.println("num problemes " + numProblemes);
		while (problema < numProblemes) {
			liniaMonedes = entrada.readLine().split(" ");
			liniaImports = entrada.readLine().split(" ");
			monedes = new int[liniaMonedes.length];
			for (int i = 0; i < liniaMonedes.length; i++)
				monedes[i] = Integer.parseInt(liniaMonedes[i]);
			importsATornar = new double[liniaImports.length - 1]; // el 0 final ja no el poso
			for (int i = 0; i < liniaImports.length - 1; i++)
				importsATornar[i] = Double.parseDouble(liniaImports[i]);

			System.out.println("\n\nVaig a resoldre el problema " + (problema + 1));
			canvi=new TornaCanvi(valorMonedes, monedes);
			
			indexImports = 0;
			while (indexImports < importsATornar.length) {
				resultat = canvi.tornarCanviAvid(importsATornar[indexImports]);
				mostrarCanvi(importsATornar[indexImports], resultat);
				indexImports++;
			}
			problema++;
		}
		entrada.close();
	}

	public static void mostrarCanvi(double importATornar, int[] canvi) {
		if (canvi == null)
			System.out.println("\nNo hi ha canvi suficient per pagar " + importATornar);
		else {
			System.out.println("\nHe de pagar " + importATornar);
			for (int i = canvi.length - 1; i >= 0; i--) {
				if (canvi[i] != 0) {
					System.out.println("Pago amb: " + canvi[i] + " mon/bit de " + valorMonedes[i]);
				}
			}
		}
	}
}
