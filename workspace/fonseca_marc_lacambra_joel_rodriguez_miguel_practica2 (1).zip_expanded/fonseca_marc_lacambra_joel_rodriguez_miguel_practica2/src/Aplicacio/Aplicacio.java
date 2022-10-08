package Aplicacio;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Dades.*;

public class Aplicacio {

	static Scanner teclat=new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		int opcio;
		int numElem = 49;
		int tipusLlista = 0;
		long startNanoTime;
		double elapsedTime;
		TADcjtRecursos cjt = null;
		
		System.out.println("Que tipus de memoria vols utilitzar: [1] - Estatica\t[2] - Dinamica");
		tipusLlista = Integer.parseInt(teclat.nextLine());

		switch(tipusLlista){
			case 1: cjt = new CjtRecursosEstatica(numElem);
			break;
			case 2: cjt = new CjtRecursosDinamica();
			break;
		}
		
		String[] dataset = llegirLiniesFitxer(numElem);
		
		startNanoTime = System.nanoTime();
		
		for (int i = 0; i < dataset.length; i++) {
			
			actualitzarLlista (dataset[i], cjt);
		}
		
		elapsedTime = (System.nanoTime() - startNanoTime);
		
		System.out.println("El ficher ha tardat en carregarse " +elapsedTime*1.0e-6+ " ms\n");
		
		System.out.println(cjt.toString());
		
		mostraMenu();
		opcio = Integer.parseInt(teclat.nextLine());
		while (opcio != 8) {
			switch (opcio) {
			case 1:
				opcio1(cjt);
				break;
			case 2:
				opcio2(cjt);
				break;
			case 3:
				opcio3(cjt);
				break;
			case 4:
				opcio4(cjt);
				break;
			case 5:
				opcio5(cjt);
				break;
			case 6:
				opcio6(cjt);
				break;
			case 7: 
				opcio7(cjt);
				break;
			default:
				System.out.println("Aquesta no es una opcio disponible");
				break;
			}

			mostraMenu();
			opcio = Integer.parseInt(teclat.nextLine());
		}
		
		
	}
	
	// Metode per llegir el fitxer csv i carregar en una string les linies
	private static String[] llegirLiniesFitxer (int nLinies) throws FileNotFoundException {
		String[] result = new String[nLinies];
		Scanner f = new Scanner(new File("DadesConsulta.csv"));

		f.nextLine();
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
			
		}
		f.close();
		return result;
	}

	// Metode per afegir en la llista els atributs separats per ";".
	public static void actualitzarLlista (String dataset, TADcjtRecursos llista){
		String[] parts = dataset.split(";"); 
		String[] partsData = parts[2].split("/");
		
		DadesAcces estacio = new DadesAcces(parts[0], parts[1], new Data (Integer.parseInt(partsData[0]) , Integer.parseInt(partsData[1]), Integer.parseInt(partsData[2]), Integer.parseInt(parts[3])));	

		llista.afegir(estacio);
	}
			
	public static void mostraMenu() {
		System.out.println("\n\nOpcions del menu:");
		System.out.println("\n\t1. Afegir dades al accedir a un recurs");
		System.out.println("\t2. Consultar si un alumne ha visualitzat un recurs");
		System.out.println("\t3. Numero d'usuaris que han accedit a un recurs");
		System.out.println("\t4. Consultar recursos visualitzats d'un alumne");
		System.out.println("\t5. Eliminar les dades d'acces a un recurs.");
		System.out.println("\t6. Consultar si un alumne ha visualitzat un recurs en una data concreta.");
		System.out.println("\t7. Recurs mes consultat.");
		System.out.println("\t8. Sortir");
		System.out.print("\n\t\t\tIndica opcio:\n");
	}
		
	// 1. Afegir les dades de acces a un recurs per part del usuari
	public static void opcio1(TADcjtRecursos llista) {	
		long startNanoTime;
		double elapsedTime;
		String alies, recurs;
		System.out.println("Quin es el teu nom d'usuari?");
		alies = teclat.nextLine();
		System.out.println("A quin recurs vols accedir?");
		recurs = teclat.nextLine();
		System.out.println("Introdueix la data(dd/mm/aa):");
		String data1 = teclat.nextLine();
		String dataParts1[] = data1.split("/");

		System.out.println("Quina hora es ara? (No cal ficar els minuts)");
		int hora = Integer.parseInt(teclat.nextLine());
		
		startNanoTime = System.nanoTime();
		llista.afegir(new DadesAcces(alies, recurs, new Data (Integer.parseInt(dataParts1[0]),Integer.parseInt(dataParts1[1]), Integer.parseInt(dataParts1[2]), hora)));
		System.out.println(llista.toString());
		elapsedTime = (System.nanoTime() - startNanoTime);
		System.out.println("\nTemps de execucio: " +elapsedTime*1.0e-6+ " ms\n");
	}
	
	// 2. Consultar si un alumne (donat un alies) ha visualitzat un recurs
	public static void opcio2(TADcjtRecursos llista) {
		long startNanoTime;
		double elapsedTime;
		boolean control = false, control2 = false;
		System.out.println("Quin es el nom d'usuari?");
		String alies = teclat.nextLine();
		System.out.println("Quin es el recurs?");
		String recurs = teclat.nextLine();
		startNanoTime = System.nanoTime();
		DadesAcces[] aux = llista.llistaUsuarisRecurs(recurs);
		for (int i = 0; i < aux.length && (!control2); i++){
			if (aux[i] == null) {
				control2 = true;
			}
			else if(aux[i].getAlies().equals(alies)){
				System.out.println("Ha estat consultat");
				control = true;
			}
		}
		if (!control || aux[0] == null) {
			System.out.println("NO ha estat consultat");
		}
		elapsedTime = (System.nanoTime() - startNanoTime);
		System.out.println("\nTemps de execucio: " +elapsedTime*1.0e-6+ " ms\n");
	}
	
	// 3. Consultar els usuaris que han accedit a un recurs, en qualsevol moment o entre
	// una franja de dates (nomes data, no cal tenir en compte hores)
	public static void opcio3 (TADcjtRecursos llista) {
		long startNanoTime;
		double elapsedTime;
		String recurs;
		boolean control = false;
		DadesAcces[] aux = null;
		System.out.println("Vols consultar els usuari que han accedit a un recurs en qualsevol moment [1] o entre una fraja de dates [2]");
		int opcioConsultar = Integer.parseInt(teclat.nextLine());
		if (opcioConsultar == 1){
			System.out.println("Indica el recurs ha accedir:");
			recurs = teclat.nextLine();
			startNanoTime = System.nanoTime();
			aux = llista.llistaUsuarisRecurs(recurs);
			for (int i = 0; i < aux.length && (!control); i++){
				if (aux[i] == null){
					control = true;
				}
				else {
					System.out.println(++i+"- "+aux[--i].getAlies());
				}
				
			}
			if (aux[0] == null) {
				System.out.println("Ningu ha accedit a aquest recurs");
			}
			elapsedTime = (System.nanoTime() - startNanoTime);
			System.out.println("\nTemps de execucio: " +elapsedTime*1.0e-6+ " ms\n");
		}
		else{
			System.out.println("Indica el recurs ha accedir:");
			recurs = teclat.nextLine();

			System.out.println("Introdueix la primera franja(dd/mm/aa):");
			String data1 = teclat.nextLine();

			String dataParts1[] = data1.split("/");
		
			Data iniData = new Data(Integer.parseInt(dataParts1[0]),Integer.parseInt(dataParts1[1]), Integer.parseInt(dataParts1[2]), 23);
			System.out.println("Introdueix la segona franja(dd/mm/aa):");
			String data2 = teclat.nextLine();	
			
			String dataParts2[] = data2.split("/");
			Data fiData = new Data(Integer.parseInt(dataParts2[0]),Integer.parseInt(dataParts2[1]), Integer.parseInt(dataParts2[2]), 23);
			startNanoTime = System.nanoTime();	
			DadesAcces auxAct[] = llista.llistaUsuarisRecurs(recurs);
			int i=0;
			
			control = false;
			if (auxAct[0] == null) {
				System.out.println("Ningu ha accedit a aquest recurs en aquesta franja horaria");
			}
			else {
				for (; i < auxAct.length && (!control); i++){
					if (!(auxAct[i].getData().esDataInferiorOigual(iniData))){
						control = true;
					}
				}
				control = false;
				i--;
				for (; i < auxAct.length && (!control); i++){
					if (auxAct[i] == null) {
						control = true;
					} 
					else if (auxAct[i].getData().esDataInferiorOigual(fiData)){
						System.out.println(++i+"- "+auxAct[--i].getAlies());
					}	
				}
			}
			
			
			elapsedTime = (System.nanoTime() - startNanoTime);
			System.out.println("\nTemps de execucio: " +elapsedTime*1.0e-6+ " ms\n");
		}
	}
	// 4. Consultar els recursos que ha visualitzat un alumne 
	// (tenir la informacio ordenada per dates i opcionalment per hores tambe)
	
	public static void opcio4 (TADcjtRecursos llista) {
		long startNanoTime;
		double elapsedTime;
		System.out.println("Introduzca el nombre del alumno:");
		String nombre = teclat.nextLine();
		startNanoTime = System.nanoTime();
		String[] aux = llista.llistaRecursosPerUsuari(nombre);
		
		if (aux[0] == null) {
			System.out.println("L'alumne encara no ha buscat cap recurs");
		}
		else {
			System.out.println("\nRecursos buscats (ordenats per m�s antics primer): \n");
			for (int i = 0; i < llista.numElems(); i++) {
				if (aux[i] != null) {
					System.out.println(++i +"- "+aux[--i]);
				}
				
			}
		}
		elapsedTime = (System.nanoTime() - startNanoTime);
		System.out.println("\nTemps de execucio: " +elapsedTime*1.0e-6+ " ms\n");
	}

	// 5. Eliminar les dades de consulta d'un recurs, en qualsevol moment o 
	// en una data especifcia
	public static void opcio5 (TADcjtRecursos llista){
		long startNanoTime;
		double elapsedTime;

		System.out.println("Especifica el recurs:");
		String recurs = teclat.nextLine();
		System.out.println("Vols eliminar totes les dades de un recurs [1] o en una data especifica [2]");
		int opcioEliminar = Integer.parseInt(teclat.nextLine());
		if (opcioEliminar == 1){
			startNanoTime = System.nanoTime();
			llista.eliminarConsulta(recurs);
			System.out.println(llista.toString());
			elapsedTime = (System.nanoTime() - startNanoTime);
			System.out.println("\nTemps de execucio: " +elapsedTime*1.0e-6+ " ms\n");
		}
		else{
			System.out.println("Introdueix la data(dd/mm/aa):");
			String data1 = teclat.nextLine();
			String dataParts1[] = data1.split("/");
			startNanoTime = System.nanoTime();
			llista.eliminarConsultaData(recurs, new Data(Integer.parseInt(dataParts1[0]),Integer.parseInt(dataParts1[1]), Integer.parseInt(dataParts1[2]), 23));
			System.out.println(llista.toString());
			elapsedTime = (System.nanoTime() - startNanoTime);
			System.out.println("\nTemps de execucio: " +elapsedTime*1.0e-6+ " ms\n");
		}
	}
	
	// 6. Donat el nom de un recurs i una data (dia/mes/any) volem un metode que ens retorni
	// la llista de usuaris que lhan consultat.
	public static void opcio6 (TADcjtRecursos llista){
		long startNanoTime;
		double elapsedTime;
		System.out.println("Especifica el recurs:");
		String recurs = teclat.nextLine();
		System.out.println("Introdueix la data(dd/mm/aa):");
		String data1 = teclat.nextLine();
		String dataParts1[] = data1.split("/");
		startNanoTime = System.nanoTime();
		String[] aux = llista.llistaUsuarisRecursData(recurs, new Data(Integer.parseInt(dataParts1[0]),Integer.parseInt(dataParts1[1]), Integer.parseInt(dataParts1[2]), 23));
		
		if (aux[0] == null) {
			System.out.println("Usuaris no trobats");
		}
		else {
			System.out.println("\nUsuaris que han accedit a aquest recurs en aquesta data: \n");
			for (int i = 0; i < llista.numElems(); i++) {
				if (aux[i] != null) {
					System.out.println(++i +"- "+aux[--i]);
				}
				
			}
		}
		elapsedTime = (System.nanoTime() - startNanoTime);
		System.out.println("\nTemps de execucio: " +elapsedTime*1.0e-6+ " ms\n");
	}
	
	// 7. Fes un metode que retorni les dades del recurs que lhan consultat mes usuaris.
	public static void opcio7 (TADcjtRecursos llista) {
		long startNanoTime;
		double elapsedTime;
		startNanoTime = System.nanoTime();
		System.out.println("El recurs mes consultat es: " +llista.recursMesConsultat());
		elapsedTime = (System.nanoTime() - startNanoTime);
		System.out.println("\nTemps de execucio: " +elapsedTime*1.0e-6+ " ms\n");
	}
}


