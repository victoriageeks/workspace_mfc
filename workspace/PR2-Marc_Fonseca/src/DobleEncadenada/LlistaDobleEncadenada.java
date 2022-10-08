package DobleEncadenada;
import java.util.Iterator;
import Excepcions.*;

/**
 * 
 * @author Marc Fonseca 
 *
 * @param <T> - valor generalitzat
 */

public class LlistaDobleEncadenada<T extends Comparable<T>> implements Iterable<T>, TADGenerics<T>  {
	
	private NodeLlistaGenerica<T> primer;
	private int numElem;
	private NodeLlistaGenerica<T> ultim;
	
	// 1. Constructor per inicialitzar la llista
	/**
	 * Constructor de la llista dinamica
	 */
	public LlistaDobleEncadenada () {
		primer = null;
		ultim = null;
		numElem = 0;
	}
	
	/**
	 * Getter primer node
	 * @return node - primer element de la llista
	 */
	public NodeLlistaGenerica<T> getPrimer() {
		return primer;
	}

	/**
	 * Getter ultim node
	 * @return node - ultim element de la llista
	 */
	public NodeLlistaGenerica<T> getUltim() {
		return ultim;
	}
	
	// 2. Funció per tal d’inserir un element al final de la llista
	public void inserir (T valor) { 
        NodeLlistaGenerica<T> aux = new NodeLlistaGenerica<T> (valor);
        
        if (primer == null && ultim == null) {
        	primer = aux;
        	ultim = aux;
        }
        else {
        	ultim.setSeguent(aux);
        	aux.setAnterior(ultim);
        	ultim = aux;
        }
        numElem++;
    }
	
	// 3. Funció per tal d’inserir un element a la llista en la posició indicada
	//    L’operació llença una excepció en cas que no es pugui realitzar l’operació.
	public void inserir (int posicio, T valor) throws foraDeRang {
		if (posicio < 0 || posicio > numElem) {
			throw new foraDeRang(numElem);
		}
		else {
			NodeLlistaGenerica<T> nou = new NodeLlistaGenerica<T> (valor);
			
			if (posicio == 0) {
				nou.setSeguent(primer);
				primer.setAnterior(nou);
				primer = nou;
			}
			else if (posicio == numElem) {
				inserir (valor);
			}
			else { 
				boolean trobat = false; int i = 1;
				NodeLlistaGenerica<T> aux = primer.getSeguent();
				
				while (!trobat) {
					if (posicio == i) {
						aux.getAnterior().setSeguent(nou);
						nou.setAnterior(aux.getAnterior());
						nou.setSeguent(aux);
						aux.setAnterior(nou);
						trobat = true;
					}
					aux = aux.getSeguent();
					i++;
				}
			}
			numElem++;
		}
	}
	
	// 4. Funció que retorna l’element que hi ha en una determinada posició
	//    L’operació llença una excepció en cas que no es pugui obtenir
	public T obtenir (int posicio) throws foraDeRang{
		T valor = primer.getValor();
		
		if (posicio < 0 || posicio >= numElem) {
			throw new foraDeRang(numElem);
		}
		else {
			if (posicio == 0) {
				return primer.getValor();
			}
			else if (posicio == numElem) {
				return ultim.getValor();
			}
			else { 
				int i = 1;
				NodeLlistaGenerica<T> aux = primer.getSeguent();
				
				while (aux != null) {
					if (posicio == i) {
						return valor = aux.getValor();
					}
					aux = aux.getSeguent();
					i++;
				}
			}
		}
		return valor;
	}
	
	// 5. Retorna el nombre d’elements que conté la llista en aquest moment
	public int longitud () {
		return numElem;
	}
	
	// 6. Funció per tal d’esborrar un element de la llista en una posició determinada
	//    L’operació llença una excepció en cas que no es pugui eliminar
	public void esborrar (int posicio) throws foraDeRang {
		if (posicio < 0 || posicio >= numElem) {
			throw new foraDeRang(numElem);
		}
		else {
			if (posicio == 0) { 
				primer.getSeguent().setAnterior(null);
				primer = primer.getSeguent();
			}
			else if (posicio == numElem-1) {
				ultim.getAnterior().setSeguent(null);
				ultim = ultim.getAnterior();
			}
			else { 
				boolean trobat = false; int i = 1;
				NodeLlistaGenerica<T> aux = primer.getSeguent();
				
				while (aux.getSeguent().getSeguent() != null && !trobat) {
					if (posicio == i) {
						aux.getAnterior().setSeguent(aux.getSeguent());
						aux.getSeguent().setAnterior(aux.getAnterior());
						trobat = true;
					}
					else {
						aux = aux.getSeguent();
						i++;
					}
				}
			}
		}
		numElem--;
	}
	
	// 7. Funció que comprova si un element està a la llista.
	//    La funció retorna el cost de l’operació. Nombre d’elements que s’hagin accedit per tal
	//    de comprovar si l’element existeix o no.
	//    L’operació llença una excepció en cas que l’element no s’hagi trobat. La mateixa
	//    excepció contindrà informació del nombre d’elements que s’han accedit per
	//    comprovar si l’element buscat existeix o no
	public int buscar (T valor) throws noTrobat{
		
		if (valor.compareTo(primer.getValor()) == 0 || valor.compareTo(ultim.getValor()) == 0) { 
			return 2;
		} 
		
		int elementsBuscats = 4;
		int posicioPrimer = 1;
		int posicioUltim = numElem-1;
		NodeLlistaGenerica<T> auxP = primer.getSeguent();
		NodeLlistaGenerica<T> auxU = ultim.getAnterior();
		
		while(posicioPrimer <= posicioUltim) { // 1 2 3
			if (valor.compareTo(auxP.getValor()) == 0 || valor.compareTo(auxU.getValor()) == 0) {
				if (auxP.getValor().compareTo(auxU.getValor()) == 0) {
					elementsBuscats--;
				}
				return elementsBuscats;
			}
			
			elementsBuscats+=2;
			
			posicioPrimer++;
			posicioUltim--;
			
			auxP = auxP.getSeguent();
			auxU = auxU.getAnterior();
		}
		throw new noTrobat(elementsBuscats);
	}
	
	public Iterator<T> iterator() {
		LlistaIterator<T> pI=new LlistaIterator<T>(this);
		return pI;
	}
}
