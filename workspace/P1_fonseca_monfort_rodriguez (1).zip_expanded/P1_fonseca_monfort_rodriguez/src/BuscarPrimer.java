
// importing file
import java.io.File;
// importing scanner
import java.util.Scanner;
//importing writer
import java.io.PrintWriter;
// Import the IOException class to handle errors
import java.io.IOException;


public class BuscarPrimer {

	static Scanner teclat = new Scanner(System.in);  //Abrimos un nuevo Scanner

	public static void main(String[] args) {
 
        //Declaramos algunas varibles
		String[] primerGran; 
		long startNanoTime;
		double[] elapsedTime;
		
		System.out.println("Indica el numero de linies a llegir del fitxer (max 9)"); 
		int numLinies = Integer.parseInt(teclat.nextLine()); //Almeacenamos el numero que lee el Scanner
		String[] fichero = leerFichero(numLinies); //Creamos un String[] con los datos

		primerGran = new String[numLinies];
		elapsedTime = new double[numLinies];

		for (int i = 0; i < fichero.length; i++) { //Bucle for para saber la longitud del numero

			startNanoTime = System.nanoTime();
			
			primerGran[i] = Primers.numeroPrimerMesGran(fichero[i]);
	
			elapsedTime[i] = (System.nanoTime() - startNanoTime);
			
			System.out.printf("%20s\t%20s\t%20.3f ms%n", fichero[i], primerGran[i], elapsedTime[i]*1.0e-6);
		}

		imprimirFichero(fichero, primerGran, elapsedTime);
		System.out.println("Programa finalitzat;");

	}

	public static String[] leerFichero(int numLinies) { // Usamos el metodo static ya que la funcion esta en el main
		String[] result = new String[numLinies];
		try {
			Scanner f = new Scanner(new File("libro.txt"));
			for (int i = 0; i < numLinies; i++) { // Bucle for para leer cada linea del documento
				result[i] = f.nextLine();
			}
			f.close();
		} catch (Exception e) { // Si no se encuentra el fichero deseado se muestra el mensaje por consola
			System.out.println("Error occurs!!");
		}
		return result;
	}

	public static void imprimirFichero(String[] fichero, String[] primeros, double[] tiempo) {
		try {
			System.out.println("Com vols que es digui el fitxer?"); //Pedimos al usuario el nombre del fichero
			String fit = teclat.nextLine(); 
			File myObj = new File(fit + ".csv"); //Creamos un fichero nuevo

			PrintWriter f = new PrintWriter(myObj);
				for (int i = 0; i < fichero.length; i++) { //Bucle for para escribir sobre el fichero
					f.printf("%d.; %s\t; %s\t; %.3f ms\n", i + 1, fichero[i], primeros[i], tiempo[i] * 1.0e-6);
				}
			f.close(); //Cerramos la impresion
		}

		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}