package aplicacio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.*;


public class UsaExemple {
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		
	try {
		Scanner f = new Scanner(new File("Exemple.txt"));
		BufferedWriter g = new BufferedWriter(new FileWriter("Hola.dat")); 
		Scanner perSeparar;
		String linia;
		String poblacio;
		int numHab;
		float superficie;
		float densitat;
		
		while (f.hasNextLine()) {
			linia = f.nextLine();
			perSeparar = new Scanner (linia);
			perSeparar.useDelimiter(";");
			poblacio = perSeparar.next();
			numHab = perSeparar.nextInt();
			superficie = perSeparar.nextFloat();
			
			System.out.println("Linia llegida " +linia);
			System.out.println("Linia separada " +poblacio+ " hab " +numHab+" superf " +superficie);
			
			densitat = numHab / superficie;
			g.write(""+densitat);
			g.newLine();
		}
		
		System.out.println();
		System.out.println();
		
		f.close();
		g.close();
	}
	catch(FileNotFoundException e) {
	System.out.println("L'arxiu d'entrada no existeix");
	}
	catch(IOException e) {
	System.out.println("S'ha produit un error en els arxius");
	}
	
	try {
		BufferedReader f = new BufferedReader(new FileReader("Densitat.txt"));
		DataOutputStream g = new DataOutputStream(new FileOutputStream("Densitat.dat")); 
		String linia = "";
		
		linia = f.readLine();
		while (linia != null) {
			
			System.out.println("Linia llegida " +linia);

			g.writeChars(linia);
			linia = f.readLine();
		}
		
		f.close();
		g.close();
	}
	catch(FileNotFoundException e) {
	System.out.println("L'arxiu d'entrada no existeix");
	}
	catch(IOException e) {
	System.out.println("S'ha produit un error en els arxius");
	}
	
	
	
	
	

	}
}