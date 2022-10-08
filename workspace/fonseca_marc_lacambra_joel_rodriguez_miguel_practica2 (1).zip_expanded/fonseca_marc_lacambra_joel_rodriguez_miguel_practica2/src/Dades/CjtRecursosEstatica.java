/**
 * Classe pel conjunt de recursos amb memoria estatica
 * 
 * @author Joel Lacambra i Marc Fonseca
 *
 */
package Dades;

public class CjtRecursosEstatica implements TADcjtRecursos {

	private DadesAcces[] llista;
	private int numElem;
	
	public CjtRecursosEstatica(int num) {
		llista = new DadesAcces[num];
		numElem = 0;
	}
	
	public boolean ple(){
		return(numElem==llista.length);
	}
	
	public int numElems() {
		return(numElem);
	}
	
	//1. Afegir les dades duna consulta feta a un recurs per un usuari en un moment concret.
	//   Haureu de tenir en compte si el recurs que sha consultat es nou o si ja lhem guardat
	//   en algun altre cas
	public void afegir(DadesAcces dades){
		int j = numElem;
		boolean trobat = false;
		if (numElem < llista.length) {
			if (numElem == 0) {
				llista[0] = dades;
				numElem++;
			}
			else {
				for (int i = numElem-1; i >= 0 && (!trobat); i--){
					if (dades.getData().esDataInferiorOigual(llista[i].getData())){
						llista[j] = llista[j-1];
						j--;
					}
					else{
				
						llista[j] = dades;
						numElem++;
						j--;
						trobat = true;
					}
				}
				
				if (j == 0 && (!trobat)){
					llista[j] = dades;
					numElem++;
				}
			}
		}
		else{
			DadesAcces[] aux =  new DadesAcces[llista.length * 2];
			for (int i = 0; i < numElem; i++) {
				aux[i] = llista[i];
			}
			llista = aux;
			for (int i = numElem-1; i >= 0 && (!trobat); i--){
				if (dades.getData().esDataInferiorOigual(llista[i].getData())){
					llista[j] = llista[j-1];
					j--;
				}
				else{
			
					llista[j] = dades;
					numElem++;
					j--;
					trobat = true;
				}

			}
			
			if (j==0 && (!trobat)){
				llista[j] = dades;
				numElem++;
			}
				
		}
	}
	
	// 2. Esborrar totes les dades de una consulta a un recurs
	public void eliminarConsulta(String recurs) {
		for (int i = 0; i < numElem; i++) {
			if (llista[i].getRecurs().equalsIgnoreCase(recurs)) {
				for (int j = i; j < numElem-1; j++) {
					llista[j] = llista[j+1];
				}
				numElem--;
				i--;
			}
		}
	}
	
	// 3. Esborrar les dades de les consultes a un recurs que shan fet en una data concreta (dia/mes/any)
	public void eliminarConsultaData(String recurs, Data data) {
		int j = 0;
		for (int i = 0; i < numElem; i++) {
			if (!((llista[i].getRecurs().equalsIgnoreCase(recurs)) && (llista[i].getData().esIgual(data)))) {
				llista[j] = llista[i];
				j++;
			}
		}
		numElem = j;
		for (; j < llista.length; j++){
			llista[j] = null;
		}
	}
	
	// 4. Donat el nom dun recurs volem un metode que ens retorni la llista dusuaris que lhan consultat
	public DadesAcces[] llistaUsuarisRecurs(String recurs){
		
		DadesAcces[] aux = new DadesAcces[numElem];
		int j = 0;
		boolean control;
		for(int i = 0; i<numElem; i++){
			if (llista[i].getRecurs().equalsIgnoreCase(recurs)){
				control = false;
				for (int h=0; h < j; h++){
					if (aux[h].getAlies().equals(llista[i].getAlies())){
						control = true;
					}
				}
				if (!control){
					aux[j] = llista[i];
					j++;
				}
			}
		}
		return aux;
	}
	
	// 5. Donat el nom dun recurs i una data (dia/mes/any) volem un metode que ens retorni
	// la llista de usuaris que lhan consultat.
	public String[] llistaUsuarisRecursData(String recurs, Data data) {
		
		String[] aux = new String[numElem];
		boolean control;
		int j = 0;
		
		for (int i = 0; i < numElem; i++) {
			if ((llista[i].getRecurs().equalsIgnoreCase(recurs)) && (llista[i].getData().esIgual(data))) {
				control = false;
				for (int h = 0; h < j; h++) {
					if (aux[h].equals(llista[i].getAlies())) {
						control = true;
					}
				}
				if (!control) {
					aux[j] = llista[i].getAlies();
					j++;
				}
			}
		}
		return aux;
	}
	
	// 6. Fes un metode que retorni les dades del recurs que lhan consultat mes usuaris
 	 public String recursMesConsultat() {
 		String[] recursos = new String[numElem];
 		int[] visites = new int[numElem];
 		int max;
		String aux = "";
 		
 		for (int i = 0; i < numElem; i++) {
 			recursos[i] = llista[i].getRecurs();
 			visites[i] = 1;
 			for (int j = i; j < numElem; j++) {
 				if (recursos[i].equals(llista[j].getRecurs())) {
					visites[i]++;
				}
 			}
 		}
 		max = visites[0];
 		aux = recursos[0];
		for (int i = 1; i < numElem; i++) {
 			if (max < visites[i]) {
 				max = visites[i];
 				aux = recursos[i];
		 	}	
		 }
		return aux;
	}	
	
 	// 7. Donat un alies de usuari volem un metode que ens indiqui els recursos que ha consultat
	public String[] llistaRecursosPerUsuari(String alies){
		
		String[] aux = new String[numElem];
		boolean control;
		int j = 0;
		for (int i = 0; i < numElem; i++) {
			if (llista[i].getAlies().equals(alies)) {
				control = false;
				for (int h = 0; h < j; h++) {
					if (aux[h].equals(llista[i].getRecurs())) {
						control = true;
					}
				}
				if (!control) {
					aux[j] = llista[i].getRecurs();
					j++;
				}
				
			}
		}
		return aux;
	}

	public String toString () {
		String aux;
		if (numElem == 0) {
			aux = "No hi ha consulta a la llista.";
		}
		else {
			aux = "----------------Informacio de les consultes----------------\n";
			for (int i = 0; i < numElem; i++) {
					aux = aux +"\n"+ ++i + "- " +llista[--i].toString();
			}
		}
		return aux;
	}
}
