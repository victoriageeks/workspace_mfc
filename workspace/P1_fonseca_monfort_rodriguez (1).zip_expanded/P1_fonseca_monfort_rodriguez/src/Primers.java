// Import the class BIgInteger
import java.math.BigInteger;

public class Primers {
	
	/*public static boolean esNumeroPrimer_v1Long(long num) {

		int numeroDivisors = 0;

		// El numero u es NO primer per conveni, encara que nomes es divisible per
		// ell mateix i per u solament.
		if (num >= 2) {

			for (long i = 1; i <= num; i++) {
				if (num % i == 0) {
					numeroDivisors++;
				}
			}

			return (numeroDivisors == 2);

		} else {
			return false;
		}

	}*/


	/*public static boolean esNumeroPrimer_v2Long(long num) {

		boolean esPrimer = false;

		// El numero u es NO primer per conveni, encara que nomes es divisible per
		// ell mateix i per u solament
		if (num >= 2) {

			esPrimer = true;

			for (long i = 2; i < num; i++) {
				if (num % i == 0) {
					esPrimer = false;
					break;
				}
			}

		}

		return esPrimer;

	}*/

	/*public static boolean esNumeroPrimer_v3Long(long num) {

		boolean esPrimer = false;

		if (num >= 2) {

			if ((num == 2) || (num == 3)) {
				esPrimer = true;
			} else {

				if (num % 2 != 0) {

					esPrimer = true;

					for (long i = 3; i < num / 2; i = i + 2) {
						if (num % i == 0) {
							esPrimer = false;
							break;
						}
					}
				}
			}
		}

		return esPrimer;

	}*/
	
	
	public static boolean esNumeroPrimer_vLong(long num) {

		boolean esPrimer = true;
		long arrelDeN = (long) Math.sqrt((double) num) + 1; // Calculamos la raiz cuadrarda del numero pasado y 

		for (long i = 3; i <= arrelDeN; i = i + 2) { 	// Comprobamos si los numeros de 3 hasta la raiz del numero,
			if (num % i == 0) {							// es alguno de ellos divisor del número
				esPrimer = false;
				break; // No hace falta recorrer todo el bucle
			}
		}
		
		return esPrimer; 

	}
	
	public static boolean esNumeroPrimer_vBigInt(BigInteger num) {
		boolean esPrimer = true;
		
		// Calculamos la raiz cuadrarda del numero pasado y sumamos 1 para evitar aproximaciones
		BigInteger raiz = num.sqrt().add(BigInteger.ONE); 	
		// Comprobamos si los numeros de 3 hasta la raiz del numero, es alguno de ellos divisor del número
		for (BigInteger i = new BigInteger("3"); i.compareTo(raiz) == -1 || i.compareTo(raiz)==0; i = i.add(BigInteger.TWO)) { 	
			if (num.mod(i).equals(BigInteger.ZERO)) {	// num % i 
				esPrimer = false;				
				break; // No hace falta recorrer todo el bucle
			}
		}
		
		return esPrimer;
	}

	/* 
	 	{Pre ≡ 1 ≤ x ≤ 9223372036854775807}

		{Post ≡ max p : p ≤ x : ¬(#ⲁ,β : 1<ⲁ ⋀ 1<β ; ⲁ*β = p) = 0}

	 */
	public static String numeroPrimerMesGran(String num) {

		String primer = "1";
		
		BigInteger numero = new BigInteger(num);
	
		if (numero.compareTo(new BigInteger("9223372036854775808")) == -1)  {
	
			if (Long.parseLong(num) >= 2) { // Si el numero es mas pequeno que dos, 
											// significa que es un  numero invalido
				if ((Long.parseLong(num) == 2) || (Long.parseLong(num) == 3)) { // Si el numero es 2 o 3, 
					primer = num;												// significa que ya es primo
		
				}
				else {
					if (Long.parseLong(num) % 2 == 0) {		// Si el numero es par, ya no puede ser primo, 
						num = ""+(Long.parseLong(num)-1);	// por lo tanto lo pasamos a impar
					}
	
					for (long i = Long.parseLong(num); i > 2; i = i - 2) { // Bucle for para encontrar el primo mas grande 
	
						if (esNumeroPrimer_vLong(i)) {
								primer = ""+i;
								break;
						}
					}
				}	
			}
			return primer;
		}
		else {
			if (numero.mod((BigInteger.TWO)).equals((BigInteger.ZERO))) {	// Si el numero es par, ya no puede ser primo, 
						numero = numero.subtract(BigInteger.ONE);			// por lo tanto lo pasamos a impar
			}
		
			// Bucle for para encontrar el primo mas grande
			for (BigInteger i = numero; i.compareTo(BigInteger.TWO) == 1; i = i.subtract(BigInteger.TWO)) {  
	
				if (esNumeroPrimer_vBigInt(i)) {
						primer = i.toString();
						break;
				}
			}
			return primer;	
		}
	}
}	