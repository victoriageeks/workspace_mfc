package Aplicacio;

import java.util.*;
import DobleEncadenada.*;
import Hash.*;
import Excepcions.*;
import java.lang.Math;
import java.io.*;

public class CostComputacional {
	public static void main(String[] ar) {
		float[] mitjes = new float[50];
		double[] desviacions = new double[50];
		
		// Llista Encadenada
		for (int i = 1000, j = 0; i < 50001; i += 1000, j++) {
			LlistaDobleEncadenada<Integer> llistaEncadenada = new LlistaDobleEncadenada<Integer>();
			int[] llistaProves = new int[i];
			generadorLlista(llistaEncadenada, i);
			
			for (Integer k = 0; k < i; k++) {
				try {
					llistaProves[k] = llistaEncadenada.buscar(new Random().nextInt(i / 2) + 1);
				} catch (noTrobat e) {
					llistaProves[k] = e.getN();
				}
			}
			mitjes[j] = media(llistaProves);
			desviacions[j] = desviacio(llistaProves, media(llistaProves));
		}
		
		guardarLlista(mitjes, desviacions, "LlistaEncadenada");
		
		// Taula Hash
		for (int i = 1000, j = 0; i < 50001; i += 1000, j++) {
			TaulaHash<Integer, Integer> taulaHash = new TaulaHash<Integer, Integer>(i);
			int[] llistaProves = new int[i];
			generadorLlista(taulaHash, i);
			
			for (Integer k = 0; k < i; k++) {
				try {
					llistaProves[k] = taulaHash.buscar(new Random().nextInt(i / 2) + 1);
				} catch (noTrobat e) {
					llistaProves[k] = e.getN();
				}
				
				mitjes[j] = media(llistaProves);
				desviacions[j] = desviacio(llistaProves, media(llistaProves));
			}
		}
		
		guardarLlista(mitjes, desviacions, "TaulaHash");
	}
	
	private static void generadorLlista (LlistaDobleEncadenada<Integer> llista, int n) {
		for (int i = 0; i < n; i++) {
			llista.inserir(new Random().nextInt(n / 2) + 1);
		}
	
	}
	
	private static void generadorLlista (TaulaHash<Integer,Integer> llista, int n) {
		for (int i = 0; i < n; i++) {
			int aux = new Random().nextInt(n / 2) + 1;
			llista.inserir(aux, aux);
		}
	}
	
	private static float media (int[] llista) {
		float suma = 0;
		
		for (int i = 0; i < llista.length; i++) {
			suma += llista[i];
		}
		
		return suma/llista.length;
	}
	
	private static double desviacio (int[] llista, float media) {
		double desviacio = 0;
		
		for (int i = 0; i < llista.length; i++) {
			desviacio += Math.pow(llista[i]-media, 2);
		}
		
		return Math.sqrt(desviacio/llista.length);
	}
	
	private static void guardarLlista (float[] mitjes, double[] desviacions, String nomFit) {
		
		try {
			File fit = new File(nomFit+"_CostComputacional.csv");
			PrintWriter esc = new PrintWriter(fit);
			
			esc.println("Mida;Cost;Desviacio");
			
			for (int j = 1000, i = 0; i < mitjes.length; i++, j += 1000) {
				esc.printf("%d;%f;%f\n", j, mitjes[i], desviacions[i]);
			}
			
			esc.close();
			
		} catch (IOException e){
			System.out.println(e);
		}
		
		
		
		
	}
 }
