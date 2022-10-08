package aplicacio;

import java.io.*;
import dades.*;

public class TornaCanviMini {
	static double[] valorMonedes = { 1, 2, 5, 10, 20 };

	public static void main(String[] args) throws IOException {
		int[] monedes = { 3, 4, 1, 0, 1 }; // mini joc de proves, número de monedes exemple
		int[] resultat;
		double importAtornar;

		TornaCanvi canvi;
		canvi = new TornaCanvi(valorMonedes, monedes);
		importAtornar = 15; // mini joc de proves, import a tornar exemple
		resultat = canvi.tornarCanviAvid(importAtornar);
		mostrarCanvi(importAtornar, resultat);
	}

	public static void mostrarCanvi(double importATornar, int[] canvi) {
		if (canvi == null)
			System.out.println("\nNo hi ha canvi suficient per pagar " + importATornar);
		else {
			for (int j = valorMonedes.length - 1; j >= 0; j--) {
				if (canvi[j] != 0) {
					System.out.println("Pago amb: " + canvi[j] + " mon/bit de " 
								+ valorMonedes[j]);
				}
			}
		}
	}

	private static boolean filaZeros(int fil, int[][] canvi) {
		boolean plenaZeros = true;
		int j = 0;

		while (plenaZeros && j < canvi[0].length) {
			if (canvi[fil][j] != 0)
				plenaZeros = false;
			else
				j++;
		}
		return plenaZeros;
	}
}
