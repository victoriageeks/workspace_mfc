package Aplicacio;
import java.util.Scanner;
import Dades.*;

public class Aplicacio {

	static Scanner teclat=new Scanner(System.in);
	static int MAX_VALOR=99999;
	
	public static void main(String[] args) {
		TADConjuntEnters cjt=null;
		long tempsi, tempsf; // utilitzarem per a mesurar el temps que tardem en fer certes operacions
		
		int cas=mostraOpcionsConjunt();

		int numElem=100000;
		switch(cas) {
		case 1: cjt=new ConjEntersNoOrd(numElem);break;
		case 2: cjt=new ConjEntersOrd(numElem);break;
		case 3: cjt=new ConjEntersAltres(MAX_VALOR);break; 
		case 4: cjt=new ConjEntersDinamica();break; 
		}

		// a continuacio generarem num nros aleatoris entre 0-MAX_VALOR i els afegirem al conjunt
		int num=200000;
		tempsi=System.nanoTime();
		omplirConjunt(cjt, num);
		tempsf=System.nanoTime();
		System.out.println("Afegir "+num+" enters al conjunt ha tardat: "+(tempsf-tempsi)+" ns");
		
		// a continuacio generarem num nros aleatoris entre 0-MAX_VALOR i comprovarem si estan al conjunt
		num=200000;
		tempsi=System.nanoTime();
		consultarConjunt(cjt,num);
		tempsf=System.nanoTime();
		System.out.println("Consultar si els "+num+" enters estan al conjunt ha tardat: "+(tempsf-tempsi)+" ns");
		
		
		
		// afegim alguns valors especifics per assegurar-nos que hi son
		cjt.afegir(2016);
		
		// treiem alguns valors especifics per assegurar-nos que no hi son
		cjt.eliminar(2015);
		
		if (cjt.pertany(2016)) System.out.println("L'enter 2016 si pertany al conjunt");
		if (!cjt.pertany(2015)) System.out.println("L'enter 2015 no pertany al conjunt");
		
		/* afegir les intruccions per a eliminar tamb� num valors generats aleatoriament i controlar el temps
		 * que tardem en fer-ho en cada una de les opcions implementades. 
		 */
		
	}
	
	public static void omplirConjunt(TADConjuntEnters cjt, int num) {
		int e;
		for (int i=0; i<num; i++) {
			e = (int) (Math.random()*MAX_VALOR);
			cjt.afegir(e);
		}
	}
	
	public static void consultarConjunt(TADConjuntEnters cjt, int num) {
		int e, numSI=0, numNO=0;
		for (int i=0; i<num; i++) {
			e = (int) (Math.random()*MAX_VALOR);
			if (cjt.pertany(e)) numSI++;
			else numNO++;
		}
		System.out.println("Dels "+num+" numeros consultats, "+numSI+" s'han trobat al conjunt i "+numNO+" no hi son");
	}
	
	public static int mostraOpcionsConjunt() {
		System.out.println("Quin tipus de conjunt vols implementar?");
		System.out.println("1. Conjunt amb valors no ordenats");
		System.out.println("2. Conjunt amb valors ordenats");
		System.out.println("3. Conjunt altre");
		System.out.println("4. Conjunt amb memoria dinamica");
		return(llegirEnter(4));
	}
	
	public static int llegirEnter(int max) {
		int aux=0;
		boolean llegit=false;
		while (!llegit) {
			try {
				aux=Integer.parseInt(teclat.nextLine());
				if ((aux>max)||(aux<1)) throw new NumberFormatException();
				llegit=true;
			}
			catch(NumberFormatException e) {
				System.out.println("Has d'indicar un valor numeric entre 1 i "+max);
			}
		}
		
		return(aux);
	}

}
