
public class BackTrackingMonedes_fase1_RecorrerArbre {

	public static int[] monedes = {1,2};

	public static void printf( String text, Object...args) 
		{ System.out.printf("\n" + text,args);};	
	
	public static void main(String[] args) {
		int elementsCombinacio = 4;
		funcioBackTraking(elementsCombinacio);
	}
	
	public static void funcioBackTraking(int profunditatArbre)
	{		
		if (profunditatArbre == 0) return;	
				
		for (int i = 0; i < monedes.length; i++) {
			printf("\tLa moneda actual es %d", monedes[i]);
			funcioBackTraking(--profunditatArbre);
			
			//Retorn d'un cas BASE
			printf("Fem Backtraking");	
			profunditatArbre++;
		}			
	}
}
