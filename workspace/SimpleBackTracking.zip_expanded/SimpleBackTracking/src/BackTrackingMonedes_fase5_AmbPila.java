
public class BackTrackingMonedes_fase5_AmbPila {

	public static int[] monedes = {50,20,10,2,1};
	public static boolean debug = false;
	public static void printf( boolean imprimir , String text, Object...args) { 
			if (imprimir) System.out.printf("\n" + text,args);};	
	
	public static void main(String[] args) {
		
		int valorABescanviar = 47;
		Pila myPila = new Pila(valorABescanviar);
		printf(true, "Hi ha %d maneres de bescanviar %d",
				funcioBackTraking(valorABescanviar,0, myPila), valorABescanviar);
	}
	
	public static int funcioBackTraking (int quantitat, int monedaActual, Pila myPila) {
				
		if (quantitat == 0) { printf(true,"Trobat!!"  + myPila.printaPila()); return 1; } 	
		if (quantitat < 0)  { printf(debug,"M'he passat!!"); return 0;} 
		
		int maneresDeBescanviar = 0;
		for (int i = monedaActual; i < monedes.length; i++) {
			printf(debug,"La moneda actual es %d", monedes[i]);
			myPila.apilaValor(monedes[i]);
			maneresDeBescanviar += funcioBackTraking(quantitat - monedes[i], i, myPila);
			//Retorn del cas base
			myPila.desapilaValor();
			printf(debug,"\t Backtraking!");
		}
		return maneresDeBescanviar;
	}
}
 