/**
 * Main para probar los algoritmos de forma automatica
 * @author Marc Fonseca 
 * @author Joel Lacambra
 * @author Isamel Ruiz
 */

package aplicacio;

import java.io.*;
import java.util.Scanner;
import dades.*;

public class UsaLaberinto {

	static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        long startNanoTime;
		double elapsedTime;
        Laberinto laberinto = null;
        Laberinto laberintPrueba = null;
           
        for (int i = 1; i < 7; i++)  // Bucle para leer cada archivo 
        {
        	laberinto = leerFichero("Laberinto" +i+ ".txt");
            System.out.println("--------------------------Laberinto " +i+ "--------------------------");
            System.out.println("\n" +laberinto.toString());
            
            // Algorisme avid
            System.out.println("Algoritmo Voraz: \n");
            
            startNanoTime = System.nanoTime(); 
            laberintPrueba = laberinto.avid();
            elapsedTime = (System.nanoTime() - startNanoTime); 
            
            System.out.println(laberintPrueba.toString());
            System.out.println("Ha tardado " +elapsedTime*1.0e-6+ " ms\n\n");
            
            // Cerca exhaustiva
            System.out.println("Cerca exhaustiva: \n");
            
            startNanoTime = System.nanoTime();
            laberintPrueba = laberinto.cercaExhaustiva();  
            elapsedTime = (System.nanoTime() - startNanoTime);
            
            System.out.println(laberintPrueba.toString()); 
            System.out.println("Ha tardado " +elapsedTime*1.0e-6+ " ms\n\n");             
        }
    }
    
    /**
     * Funcion para leer fichero
     * @param fichero - fichero a leer
     * @return Laberinto
     * @throws IOException
     */
    public static Laberinto leerFichero (String fichero) throws IOException {
        BufferedReader f = new BufferedReader (new FileReader (fichero));
        String linea = f.readLine();

        String[] dataset = linea.split(" "), datasetAux, celda;
        Laberinto laberinto = new Laberinto(Integer.parseInt(dataset[0]),Integer.parseInt(dataset[1]), Integer.parseInt(dataset[2]), Integer.parseInt(dataset[3]), Integer.parseInt(dataset[4]), Integer.parseInt(dataset[5]));
        
        Celda[][] laberintoAux = new Celda[Integer.parseInt(dataset[0])][Integer.parseInt(dataset[1])];
        
        for (int i = 0; i < Integer.parseInt(dataset[0]); i++) {
            linea = f.readLine();
            datasetAux = linea.split(" ");
            for (int j = 0; j < Integer.parseInt(dataset[1]); j++){
            	if (datasetAux[j].equals("NA")) {
                    laberintoAux[i][j] = new Celda("N", 0);
            	}
            	else {
            		celda = datasetAux[j].split("");
                    laberintoAux[i][j] = new Celda(celda[0], Integer.parseInt(celda[1]));
            	}
            }
        }
        f.close();
        
        laberinto.anadirCeldas(laberintoAux);
        return laberinto;
    }
}