package Dades;

public class ConjEntersDinamica implements TADConjuntEnters{
	
	private Node primer;
	private int numElem;
	private Node ultim;
	
	public ConjEntersDinamica () {
		primer = null;
		ultim = null;
		numElem = 0;
	}
	
	public int numElems () {
		return numElem;
	}

	public Node getPrimer() {
		return primer;
	}

	public Node getUltim() {
		return ultim;
	}

	@Override
	public String toString() {
		String text = "";
		Node aux = primer;
		
		while (aux != null) {
			text += aux.toString();
			aux = aux.getSeguent();				
		}
		return text;
	}
	
	public boolean esBuida () {
		return numElem == 0;
	}
	
	public boolean pertany (int valor) {
		Node aux = primer;
		
		if (esBuida()) {
			return false;
		}
		else {
			while (aux != null) {
				if (valor == aux.getValor()) {
					return true;
				}
				aux = aux.getSeguent();
			}
		}
		return false;
	}
	
	public boolean ple () {
		return false;
	}
	
	public int afegir (int valor) {
		
		if (esBuida()) {
			return afegirPrincipi(valor); 
		}
		else if (primer.getValor() > valor) {
			return afegirPrincipi(valor); 
        } else if (ultim.getValor() < valor) {
            return afegirFinal(valor);
        } else {
    		boolean trobat = false;
    		int control = 0;
    		if (primer.getSeguent().getValor() > valor) {
    			
    			Node aux = new Node(valor, primer.getSeguent());
    			primer.setSeguent(aux);
    			numElem++;
    			control = 1;
    		}
    		else {
    			Node buscado_actual = primer.getSeguent();
            	
            	while (!trobat && buscado_actual.getSeguent() != null) {
            		if (buscado_actual.getSeguent().getValor() > valor) {
            			Node aux = new Node(valor, buscado_actual.getSeguent());
            			buscado_actual.setSeguent(aux);
            			numElem++;
            			trobat = true;
            			control = 1;
            		}
            	buscado_actual = buscado_actual.getSeguent();
            	}
    		}
    		return control;
        }
	}
	public int afegirPrincipi (int valor) {
		Node aux;
		int control = 0;
		
		if (esBuida()) {
			aux = new Node (valor);
			primer = aux;
			ultim = aux;
			control = 1;
		}
		else {
			Node primerActual = primer;
			aux = new Node (valor, primerActual);
			primer = aux;
		}
		numElem++;
		
		return control;
	}
	
	public int afegirFinal (int valor) {
		 
        Node aux;
        int control = 0;
        
        if (esBuida()) {
            return afegirPrincipi(valor);
        } else {

            aux = new Node (valor, null);
 
            ultim.setSeguent(aux);
            ultim = aux;
            control = 1;
 
        }
        numElem++;
        return control;
 
    }
	
	public int eliminar (int valor) {
		if (esBuida() || pertany(valor)) {
			return 0;
		}
		if (primer.getValor() == valor) {
			return eliminarPrimer();
		}
		else if (ultim.getValor() == valor) {
			return eliminarUltim();
		}
		else {
			boolean trobat = false;
    		int control = 0;
    		if (primer.getSeguent().getValor() == valor) {
    			
    			 Node aux = primer.getSeguent();
    			 primer.setSeguent(aux.getSeguent());
    			 aux = null;
    			 numElem--;
    			 control = 1;
    		}
    		else {
    			Node aux = primer.getSeguent();
            	
            	while (!trobat && aux.getSeguent() != null) {
            		if (aux.getSeguent().getValor() == valor) {
            			Node basura = aux.getSeguent();
            			aux.setSeguent(basura.getSeguent());
            			basura = null;
            			numElem--;
            			trobat = true;
            			control = 1;
            		}
            	aux = aux.getSeguent();
            	}
    		}
    		return control;
		}
	}
	
	public int eliminarPrimer() {
	    Node aux = primer.getSeguent();
	    primer = null; 
	    primer = aux;
	    if (numElem == 1) {
	    	ultim = null;
	    }
	    numElem--;
	    return 1;
 
	}
	
	public int eliminarUltim() {
        Node aux = primer;
        int control = 0;
       
        if (numElem == 1 || numElem == 2) {
            ultim = null;
           
            if (numElem == 2) {
                ultim = primer;
            } else {
                primer = null;
            }
            control = 1;
        } 
        else {
        	while (aux.getSeguent() == null) {
        		aux = aux.getSeguent();
            }
            ultim = null;
            ultim = aux;
            ultim.setSeguent(null);
        }

        numElem--;
        control = 1;

        return control;
	}
}
