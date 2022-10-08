
public class BackTrackingMonedes_fase2_numSolucions1 {

	public static int[] monedes = {1,2};

	public static void printf( String text, Object...args) 
		{ System.out.printf("\n" + text,args);};	
	
	public static void main(String[] args) {
		int valorABescanviar = 4;
		printf("%d maneres bescanviar %d",
				funcioBackTraking(valorABescanviar), valorABescanviar);
	}
	
	public static int funcioBackTraking (int quantitat) {
				
		if (quantitat == 0) { printf("trobat!!"); return 1; } 	
		if (quantitat < 0)  { printf("M'he passat!!"); return 0;} 
		
		int maneresDeBescanviar = 0;
		
		for (int i = 0; i < monedes.length; i++) {
			printf("La moneda actual es %d", monedes[i]);
			maneresDeBescanviar += funcioBackTraking(quantitat - monedes[i]);
			//Retorn del cas base
			printf("\t Backtraking!");	
		}	
		return maneresDeBescanviar;
	}
}

