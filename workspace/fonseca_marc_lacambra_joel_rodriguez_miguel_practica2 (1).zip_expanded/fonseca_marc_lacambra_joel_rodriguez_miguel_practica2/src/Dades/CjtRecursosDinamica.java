/**
 * Classe pel conjunt de recursos amb memoria dinamica
 * 
 * @author Joel Lacambra i Marc Fonseca
 *
 */
package Dades;

public class CjtRecursosDinamica implements TADcjtRecursos{
	
	private Node primer;
	private int numElem;
	private Node ultim;
	
	// 1. 
	public CjtRecursosDinamica () {
		primer = null;
		ultim = null;
		numElem = 0;
	}

	public Node getPrimer() {
		return primer;
	}

	public Node getUltim() {
		return ultim;
	}
	
	public boolean esBuida () {
		return numElem == 0;
	}

	public boolean ple () {
		return false;
	}
	
	public int numElems () {
		return numElem;
	}
	
	// 1. Afegir les dades de una consulta feta a un recurs per un usuari en un moment concret.
	// Haureu de tenir en compte si el recurs que sha consultat es nou o si ja lhem guardat
	// en algun altre cas
	public void afegir (DadesAcces valor) {
		
		if (esBuida()) {
			afegirPrincipi(valor); 
		}
		else if (!(primer.getValor().getData().esDataInferiorOigual(valor.getData()))) {
			afegirPrincipi(valor); 
        } else if (ultim.getValor().getData().esDataInferiorOigual(valor.getData())) {
            afegirFinal(valor);
        } else {
    		boolean trobat = false;
    		if (!(primer.getSeguent().getValor().getData().esDataInferiorOigual(valor.getData()))) {
    			
    			Node aux = new Node(valor, primer.getSeguent());
    			primer.setSeguent(aux);
    			numElem++;
    		}
    		else {
    			Node buscado_actual = primer.getSeguent();
            	
            	while (!trobat && buscado_actual.getSeguent() != null) {
            		if (!(buscado_actual.getSeguent().getValor().getData().esDataInferiorOigual(valor.getData()))) {
            			Node aux = new Node(valor, buscado_actual.getSeguent());
            			buscado_actual.setSeguent(aux);
            			numElem++;
            			trobat = true;
            		}
            	buscado_actual = buscado_actual.getSeguent();
            	}
    		}
        }
	}
	
	public void afegirPrincipi (DadesAcces valor) {
		Node aux;
		
		if (esBuida()) {
			aux = new Node (valor);
			primer = aux;
			ultim = aux;
		}
		else {
			Node primerActual = primer;
			aux = new Node (valor, primerActual);
			primer = aux;
		}
		numElem++;
	}
	
	public void afegirFinal (DadesAcces valor) {
		 
        Node aux;
        
        if (esBuida()) {
            afegirPrincipi(valor);
        } else {

            aux = new Node (valor, null);
 
            ultim.setSeguent(aux);
            ultim = aux;
 
        }
        numElem++;
 
    }
	
	// 2. Esborrar totes les dades duna consulta a un recurs
	public void eliminarConsulta (String valor) {
		if (primer.getValor().getRecurs().equals(valor)) {
			eliminarPrimer();
		}
		if (ultim.getValor().getRecurs().equals(valor)) {
			eliminarUltim();
		}
		if (primer.getSeguent().getValor().getRecurs().equals(valor)) {
			
			 Node aux = primer.getSeguent();
			 primer.setSeguent(aux.getSeguent());
			 aux = null;
			 numElem--;
		}
		Node aux = primer.getSeguent();
    	
    	while (aux.getSeguent() != null) {
    		if (aux.getSeguent().getValor().getRecurs().equals(valor)) {
    			Node basura = aux.getSeguent();
    			aux.setSeguent(basura.getSeguent());
    			basura = null;
    			numElem--;
    		}
    		else {
    			aux = aux.getSeguent();
    		}
    	
    	}
	}
	
	// 3. Esborrar les dades de les consultes a un recurs que shan fet en una data concreta (dia/mes/any)
	public void eliminarConsultaData(String recurs, Data data) {
		if (primer.getValor().getRecurs().equals(recurs) && primer.getValor().getData().esIgual(data)) {
			eliminarPrimer();
		}
		if (ultim.getValor().getRecurs().equals(recurs) && ultim.getValor().getData().esIgual(data)) {
			eliminarUltim();
		}
		if (primer.getSeguent().getValor().getRecurs().equals(recurs) && primer.getSeguent().getValor().getData().esIgual(data)) {
			Node aux = primer.getSeguent();
			primer.setSeguent(aux.getSeguent());
			aux = null;
			numElem--;
		}
		Node aux = primer.getSeguent();
		
		while (aux.getSeguent() != null) {
			if (aux.getSeguent().getValor().getRecurs().equals(recurs) && aux.getSeguent().getValor().getData().esIgual(data)) {
				Node basura = aux.getSeguent();
				aux.setSeguent(basura.getSeguent());
				basura = null;
				numElem--;
			}
			else {
				aux = aux.getSeguent();
			}
		}
	}
	
	public void eliminarPrimer() {
	    Node aux = primer.getSeguent();
	    primer = null; 
	    primer = aux;
	    if (numElem == 1) {
	    	ultim = null;
	    }
	    numElem--;
 
	}
	
	public void eliminarUltim() { 
        Node aux = primer;
       
        if (numElem == 1 || numElem == 2) {
            ultim = null;
           
            if (numElem == 2) {
                ultim = primer;
            } else {
                primer = null;
            }
        } 
        else {
        	while (aux.getSeguent().getSeguent() != null) {
        		aux = aux.getSeguent();
            }
            ultim = aux;
            ultim.setSeguent(null);
        }

        numElem--;
	}
	
	// 4. Donat el nom dun recurs volem un metode que ens retorni la llista de usuaris que lhan
	// consultat
	public DadesAcces[] llistaUsuarisRecurs (String recurs){
		DadesAcces[] aux = new DadesAcces[numElem];
		boolean control;
		int i = 0;
		if (primer.getValor().getRecurs().equals(recurs)) {
			aux[i] = primer.getValor();	
			i++;
		}
		if (primer.getSeguent().getValor().getRecurs().equals(recurs)) {
			aux[i] = primer.getSeguent().getValor();
			i++;
		}
		Node auxiliar = primer.getSeguent();
		while (auxiliar.getSeguent() != null) {
			if (auxiliar.getSeguent().getValor().getRecurs().equals(recurs)) {
				control = false;
				for (int h = 0; h < i; h++) {
					if (aux[h].getAlies().equals(auxiliar.getSeguent().getValor().getAlies())) {
						control = true;
					}	
				}
				if (control == false) {
					aux[i] = auxiliar.getSeguent().getValor();
					i++;
				}
				auxiliar = auxiliar.getSeguent();
			}
			else {
				auxiliar = auxiliar.getSeguent();
			}
		}	
		return aux;
	}
	
	// 5. Donat el nom dun recurs i la data volem un metode que ens retorni la llista dusuaris que lhan
	// consultat
	public String[] llistaUsuarisRecursData(String recurs, Data data) {
		String[] aux = new String[numElem];
		boolean control;
		int i = 0;
		if (primer.getValor().getRecurs().equals(recurs) && primer.getValor().getData().esIgual(data)) {
			aux[i] = primer.getValor().getAlies();	
			i++;
		}
		if (primer.getSeguent().getValor().getRecurs().equals(recurs) && primer.getSeguent().getValor().getData().esIgual(data)) {
			aux[i] = primer.getSeguent().getValor().getAlies();
			i++;
		}
		Node auxiliar = primer.getSeguent();
		while (auxiliar.getSeguent() != null) {
			if (auxiliar.getSeguent().getValor().getRecurs().equals(recurs) && auxiliar.getSeguent().getValor().getData().esIgual(data)) {
				control = false;
				for (int h = 0; h < i; h++) {
					if (aux[h].equals(auxiliar.getSeguent().getValor().getAlies())) {
						control = true;
					}	
				}
				if (control == false) {
					aux[i] = auxiliar.getSeguent().getValor().getAlies();
					i++;
				}
				auxiliar = auxiliar.getSeguent();
			}
			else {
				auxiliar = auxiliar.getSeguent();
			}
		}
		return aux;
	}
	
	// 6. Metode que torna el recurs mes consultat
	public String recursMesConsultat() {
		String[] recursos = new String[numElem];
 		int[] visites = new int[numElem];
 		int max;
		String aux = "";
		Node auxiliar = primer;
		Node auxiliar2;
		int i = 0;
		
 		while (auxiliar.getSeguent() != null && i <= numElem) {
 			recursos[i] = auxiliar.getValor().getRecurs();
 			visites[i] = 1;
 			auxiliar2 = auxiliar;
 			while (auxiliar2.getSeguent() != null) {
 				if (recursos[i].equals(auxiliar2.getSeguent().getValor().getRecurs())) {
					visites[i]++;
				}
 				auxiliar2 = auxiliar2.getSeguent();
 			}
 			auxiliar = auxiliar.getSeguent();
 			i++;
 		}
 		max = visites[0];
 		aux = recursos[0];
		for (int h = 1; h < numElem; h++) {
 			if (max < visites[h]) {
 				max = visites[h];
 				aux = recursos[h];
		 	}	
		 }
		return aux;
	}
	
	// 7. Metode que torna els recursos consultat per un usuari 
	public String[] llistaRecursosPerUsuari(String alies) {
		String[] recursos = new String[numElem];
		int i = 0;
		boolean control;
		if (primer.getValor().getAlies().equals(alies)) {
			recursos[i] = primer.getValor().getRecurs();
			i++;
		}
		if (primer.getSeguent().getValor().getAlies().equals(alies)) {
			recursos[i] = primer.getSeguent().getValor().getRecurs();
			i++;
		}
		Node aux = primer.getSeguent();
		while (aux.getSeguent() != null) {
			if (aux.getSeguent().getValor().getAlies().equals(alies)) {
				control = false;
				for (int h = 0; h < i; h++) {
					if (recursos[h].equals(aux.getSeguent().getValor().getRecurs())) {
						control = true;
					}	
				}
				if (control == false) {
					recursos[i] = aux.getSeguent().getValor().getRecurs();
					i++;
				}
				aux = aux.getSeguent();
			}
			else {
				aux = aux.getSeguent();
			}
		}
		
		return recursos;
	}
	
	@Override
	public String toString() {
		String text = "";
		Node aux = primer;
		int i = 1;
		
		if (numElem == 0) {
			text = "No hi ha consulta a la llista.";
		}
		else {
			text = "----------------Informacio de les consultes----------------\n";
			while (aux != null) {
				text += i + "- "+aux.toString()+"\n";
				aux = aux.getSeguent();		
				i++;
			}
		}
		
		return text;
	}
}
