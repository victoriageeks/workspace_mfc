package Aplicacio;

import EstructuresDades.*;
import Exceptions.*;

public class Aplicacio {

	final static String ERROR = "\u001B[31m" + "ERROR: " + "\u001B[0m";

	public static void main(String[] args) {
		
		int N = 7;

		TADConjuntEnters conjuntArray [] = new TADConjuntEnters [2]; 
		conjuntArray[0] = new ConjEntersNoOrd(N);
		conjuntArray[1] = new ConjEntersOrd(N);

		for(int t=0; t<conjuntArray.length; t++){

			TADConjuntEnters conjunt = conjuntArray[t];
			//TADConjuntEnters conjunt = new ConjEntersNoOrd(N);
			
			// Comprovació ConjuntEntersNoOrd
			System.out.println("--------------------------------------");
			System.out.println("INFO: Comprovació que número d'elements és zero:");
			System.out.println("\t0 == " + conjunt.numElems() + "? ");
			if(0!=conjunt.numElems()) 
				System.out.println("RESULT: " + ERROR + " en la funció numElems() sobre conjut buit!");
			else
				System.out.println("RESULT: Num elems en conjunt buit correcte!");

			// Comprovació ple i saturar conjunt
			System.out.println("--------------------------------------");
			System.out.println("INFO: Avaluació conjunt saturat i funció ple");
			int [] vectorProva = {2,5,8,12,34,9,43,45,33};
			boolean haSaltatExepcioPle = false;
			boolean haSaltatExepcioRepetit = false;
			for(int i=0; i<vectorProva.length; i++) {
				try {
					conjunt.afegir(vectorProva[i]);
				} catch (conjuntPle exc) {				
					System.out.println(ERROR + "\tExcepció conjuntPle llançada amb exit!");
					haSaltatExepcioPle = true;
				}catch (jaExisteix exc) {
					System.out.println("\t" + ERROR + " en test conjunt ple. Excepció jaExisteix no hauria de saltar");
					haSaltatExepcioRepetit = true;
				}catch(valorImpossible exc){
					System.out.println("\t" + ERROR + " inesperat en test conjunt ple!");
				}
			}		
			if(conjunt.numElems()!=N || !conjunt.ple() || !haSaltatExepcioPle || haSaltatExepcioRepetit)
				System.out.println("RESULT: " + ERROR + " en la funció comprovació saturar conjunt!");
			else
				System.out.println("RESULT: Saturar conjunt correcte!");		

			// Comprovació afegir repetit
			System.out.println("--------------------------------------");
			System.out.println("INFO: Avaluació afegir repetit");		
			int numExepcioPle = 0;
			int numExepcioRepetit = 0;
			for(int i=0; i<vectorProva.length && i<N; i++) {
				try {
					conjunt.afegir(vectorProva[i]);
				} catch (conjuntPle exc) {				
					System.out.println("\t" + ERROR + " en test afegir repetit. Excepció conjuntPle no hauria de saltar!");
					numExepcioPle++;
				}catch (jaExisteix exc) {
					System.out.println(ERROR + "\tExcepció jaExisteix llançada amb exit!");
					numExepcioRepetit++;
				}catch(valorImpossible exc){
					System.out.println("\t" + ERROR + " inesperat en test afegir repetit!");
				}
			}		
			if(numExepcioRepetit!=N || numExepcioPle!=0)
				System.out.println("RESULT: " + ERROR + " en la funció afegir element repetit!");
			else
				System.out.println("RESULT: Funció afegir element repetit correcte!");		

			// Comprovació Eliminar
			System.out.println("--------------------------------------");
			System.out.println("INFO: Avaluació eliminar element");				
			int numErrors = 0;
			int numElemsOld = conjunt.numElems();
			
			try {
				conjunt.eliminar(vectorProva[0]);
			}catch(valorImpossible exc){
				System.out.println("\t" + ERROR + " inesperat en eliminar!");
			}		
			
			if(numElemsOld != (conjunt.numElems()+1)){
				System.out.println("\t" + ERROR + " en la funció eliminar, no decrementa correctament!");
				numErrors++;
			}
			try {
				conjunt.afegir(vectorProva[0]);
			} catch (conjuntPle exc) {				
				System.out.println("\t" + ERROR + " en test afegir element. Excepció conjuntPle no hauria de saltar!");
				numErrors++;
			}catch (jaExisteix exc) {
				System.out.println("\t" + ERROR + " en test eliminar element. Excepció jaExisteix no hauria de saltar!");
				numErrors++;
			}catch(valorImpossible exc){
					System.out.println("\t" + ERROR + " inesperat en test eliminar element!");
				}

			if(numElemsOld != (conjunt.numElems()) || numErrors>0){
				System.out.println("RESULT: " + ERROR + " en la funció eliminar!");
				numErrors++;
			}else{
				System.out.println("RESULT: Funció eliminar element repetit correcte!");		
			}
			
			// DISSENYAR COMPROVACIONS SIMILARS PER L'ORDENAT
			//<FILL_IN>
			
			try{
				System.out.println("SOC ORDENAT: " + ((ConjEntersOrd)conjunt).socOrdenat);
			}catch(java.lang.ClassCastException exec){
				System.out.println(ERROR + "Impossible interpretar-me com ConjEntersOrd, sóc de tipus: " + conjunt.getClass().toString());
			}

			try{
				System.out.println("SOC ORDENAT: " + ((ConjEntersNoOrd)conjunt).socOrdenat);
			}catch(java.lang.ClassCastException exec){
				System.out.println(ERROR + " Impossible interpretar-me com ConjEntersNoOrd, sóc de tipus: " + conjunt.getClass());
			}				
		}
	}
}
