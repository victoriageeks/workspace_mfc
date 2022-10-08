
public class BackTrackingMonedes_fase4_ambVector {

	
	public static boolean debug = false;
	
	public static void printf( boolean imprimir , String text, Object...args) { 
			if (imprimir) System.out.printf("\n" + text,args);};	
	
	public static int[] monedes = {1,2};
	
	public static void main(String[] args) {
		int valorABuscar = 4;		
		int[] combinacio = new int[valorABuscar + 1]; // N +1		
		funcioBackTraking(valorABuscar,valorABuscar, 0, combinacio);
	}

	public static void funcioBackTraking 
		(int nivellArbre, int valorABuscar, int monedaActual, int[] combinacio) {
		
		if (valorABuscar == 0) {
			printf(true, "\nLa combinacio trobada es %s",printaCombinacio(combinacio));
			return;
		}
		
		if (valorABuscar < 0) 	return;
		
		printf(debug,"Estem al nivell %d", nivellArbre);
		
		for (int i = monedaActual; i < monedes.length; i++) {
			printf(debug, "La moneda actual es %d",monedes[i]);
			combinacio[nivellArbre] = monedes[i];			
			//Fem la crida recursiva tot baixant un nivell de l'arbre
			funcioBackTraking(--nivellArbre, valorABuscar - monedes[i], i, combinacio);
			
			//Retorn del cas base			
			++nivellArbre; // pujem un nivell a l'arbre
			combinacio[nivellArbre] = 0; // esborrem la combinacio de sota
			printf(debug,"\t Backtraking!");
		}
	}
	
	public static String printaCombinacio (int[] combinacio ) {	
		String resultat = "";	
		for (int i = combinacio.length - 1; i > 0; i--) resultat += combinacio[i] + " ";	
		return resultat;	
	}

	public static int calculaImportCombinacio (int[] combinacio ) {		
		int resultat = 0;
		for (int valorActual: combinacio) resultat +=valorActual;
		return resultat;	
	}	
}
