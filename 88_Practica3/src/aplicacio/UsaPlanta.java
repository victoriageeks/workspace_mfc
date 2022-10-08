package aplicacio;
import dades.*;
/**
 * @author mario and ismael
 */
public class UsaPlanta {

	public static void main(String[] args) {

		//Load Arbre dada
		int[] acerPseudoplatanusAge = {5,8};
		int[] acerPseudoplatanusAbsortion = {245,390};
		Planta acerPseudoplatanus = new Arbre("Acer Pseudoplatanus", 2018, acerPseudoplatanusAge, acerPseudoplatanusAbsortion);
		testArbreMethods(acerPseudoplatanus);
		
		//Load Arbust dada
		Planta corylusAvellana = new Arbust("Corylus Avellana", 2018, 110);
		testArbustMethods(corylusAvellana);
	}
	
	public static void testArbreMethods(Planta acerPseudoplatanus) {
		System.out.println(acerPseudoplatanus.toString());
		
		//test getAbsortion 
		System.out.println("Case 1: Arbre < minimThreshold -> (3<5)");
		System.out.println(acerPseudoplatanus.getAbsortion());
		System.out.println("Case 2: Arbre = 1 minimThreshold -> (5=5)");
		acerPseudoplatanus.setAge(2016);
		System.out.println(acerPseudoplatanus.getAbsortion());
		System.out.println("Case 3: Arbre > 1 minimThreshold -> (7>5)");
		acerPseudoplatanus.setAge(2014);
		System.out.println(acerPseudoplatanus.getAbsortion());
		System.out.println("Case 4: Arbre = 2 minimThreshold -> (8=8)");
		acerPseudoplatanus.setAge(2013);
		System.out.println(acerPseudoplatanus.getAbsortion());
		System.out.println("Case 5: Arbre > 2 minimThreshold) -> (100>8)");
		acerPseudoplatanus.setAge(1921);
		System.out.println(acerPseudoplatanus.getAbsortion());
		
	}
	
	public static void testArbustMethods(Planta corylusAvellana) {
		System.out.println(corylusAvellana.toString());
		
		//test getAbsortion 
		System.out.println("Case 1: Arbust < minimThreshold -> (3<5)");
		System.out.println(corylusAvellana.getAbsortion());
		System.out.println("Case 2: Arbust = Threshold -> (5=5)");
		corylusAvellana.setAge(2016);
		System.out.println(corylusAvellana.getAbsortion());
		System.out.println("Case 3: Arbust > Threshold -> (100>5)");
		corylusAvellana.setAge(1921);
		System.out.println(corylusAvellana.getAbsortion());
		
	}


}
