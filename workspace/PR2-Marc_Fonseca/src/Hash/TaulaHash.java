package Hash;

import DobleEncadenada.LlistaDobleEncadenada;
import Excepcions.noTrobat;

/**
 * 
 * @author Marc Fonseca
 *
 * @param <T> - valor generalitzat
 * @param <K> - clau
 */

public class TaulaHash<T extends Comparable<T>, K extends Comparable <K>> implements TADHash<T, K>{
	private int nElems;
	private NodeHashGeneric<T, K>[] taula;
	
	/**
	 * Funcio de Hash
	 * @param key - "posicio de la taula"
	 * @param taula - taula de Hash
	 * @return - posicio de la taula
	 */
	private int codeHash (K key, NodeHashGeneric<T, K>[] taula) {
		/*long contador = 0;
		for (int i = 0; i < key.toString().length(); i++) {
			contador = (contador + (long)Math.pow(37, i) * key.toString().charAt(i)) % taula.length;
		}
		return (int)contador;*/
		return Math.abs(key.hashCode()) % taula.length;
	}
	// 1. Constructor per inicialitzar la taula
	/**
	 * Constructor
	 * @param dim - tamany de la taula
	 */
	@SuppressWarnings("unchecked")
	public TaulaHash (int dim ) {
		taula = new NodeHashGeneric[dim];
		nElems = 0;
	}
	
	// 2. Funció per tal d’inserir un element a la taula de Hash
	//    Si l’element ja existia, actualitza el seu valor
	//    L’operació llença una excepció en cas que no es pugui inserir
	//    Si el factor de càrrega es superior a 0.75, haurem de redimensionar la taula
	@SuppressWarnings("unchecked")
	public void inserir(K key, T data) {
		int posicio, posicioAux;
		boolean trobat = false;
		NodeHashGeneric<T,K> auxNode, nodeAntic;
		
		if (ObtenirFactorDeCarrega() > 0.75) {
			NodeHashGeneric<T,K>[] taulaAux = new NodeHashGeneric[taula.length * 2];
			
			for (int i = 0; i < taula.length; i++) {
				if (taula[i] != null) {
					nodeAntic = taula[i];
					while (nodeAntic.getSeguent() != null) {
						posicioAux = codeHash(nodeAntic.getSeguent().getKey(), taulaAux);
						
						auxNode = taulaAux[posicioAux];
						
						if (auxNode == null) {
							auxNode = new NodeHashGeneric<T,K>();
							taulaAux[posicioAux] = auxNode;
						}
						else {
							while (auxNode.getSeguent() != null && !trobat) {
								if (auxNode.getSeguent().getKey().compareTo(key) == 0) {
									auxNode.getSeguent().setValor(data);
									trobat = true;
								}
								auxNode = auxNode.getSeguent();
							}
						}
						if (!trobat) {
							auxNode.setSeguent(new NodeHashGeneric<T, K> (nodeAntic.getSeguent().getValor(), nodeAntic.getSeguent().getKey()));
						}
						
						nodeAntic = nodeAntic.getSeguent();
					}
				}
			}
			
			posicio = codeHash(key, taulaAux);
			auxNode = taulaAux[posicio];
			
			if (auxNode == null) {
				auxNode = new NodeHashGeneric<T,K>();
				taulaAux[posicio] = auxNode;
			}
			else {
				trobat = false;
				while (auxNode.getSeguent() != null && !trobat) {
					if (auxNode.getSeguent().getKey().compareTo(key) == 0) {
						auxNode.getSeguent().setValor(data);
						trobat = true;
					}
					auxNode = auxNode.getSeguent();
				}
			}
			if (!trobat) {
				auxNode.setSeguent(new NodeHashGeneric<T, K> (data, key));
				nElems++;
			}
			taula = taulaAux;
		}
		else {
			posicio = codeHash(key, taula);
			auxNode = taula[posicio];
			
			if (auxNode == null) {
				auxNode = new NodeHashGeneric<T,K>();	
				taula[posicio] = auxNode;
			}
			else {
				while (auxNode.getSeguent() != null && !trobat) {
					if (auxNode.getSeguent().getKey().compareTo(key) == 0) {
						auxNode.getSeguent().setValor(data);
						trobat = true;
					}
					auxNode = auxNode.getSeguent();
				}
			}
			if (!trobat) {
				auxNode.setSeguent(new NodeHashGeneric<T, K> (data, key));
				nElems++;
			}
		}
	}
	
	// 3. Funció que retorna l’element que té la clau K
	//    L’operació llença una excepció en cas que no es pugui obtenir
	public T obtenir(K key) throws noTrobat {
		int posicio = codeHash(key, taula);
		NodeHashGeneric<T, K> auxNode = taula[posicio];
		
		if (auxNode != null) {
			auxNode = auxNode.getSeguent();
			while (auxNode != null) {
				if (auxNode.getKey().compareTo(key) == 0) {
					return auxNode.getValor();
				}
				auxNode = auxNode.getSeguent();
			}
		}
		throw new noTrobat();
	}
	
	// 4. Funció que comprova si un element està a la taula
	//    La funció retorna el cost de l’operació. Nombre d’elements que s’hagin accedit per tal
	//    de comprovar si l’element existeix o no
	//    L’operació llença una excepció en cas que l’element no s’hagi trobat. La mateixa
	//    excepció contindrà informació del nombre d’elements que s’han accedit per comprovar
	//    si l’element buscat existeix o no
	public int buscar (K key) throws noTrobat{
		int posicio = codeHash(key, taula);
		NodeHashGeneric<T, K> auxNode = taula[posicio];
		
		int contador = 1;
		
		if (auxNode != null) {
			while (auxNode.getSeguent() != null) {
				if (auxNode.getSeguent().getKey().compareTo(key) == 0) {
					return contador;
				}
				contador++;
				auxNode = auxNode.getSeguent();
			}
		}
		throw new noTrobat(contador);
	}
	
	// 5. Retorna el nombre d’elements que conté la taula en aquest moment
	public int mida() {
		return nElems;
	}
	
	// 6. Funció per tal d’esborrar un element de la taula.
	//    L’operació llença una excepció en cas que l’element no s’hagi trobat
	public void esborrar(K key) throws noTrobat{
		int posicio = codeHash(key, taula);
		NodeHashGeneric<T, K> auxNode = taula[posicio];
		
		if (auxNode != null) {
			if (auxNode.getSeguent().getKey().compareTo(key) == 0) {
				nElems--;
				auxNode.setSeguent(auxNode.getSeguent().getSeguent());
				return;
			}
			else {
				auxNode = auxNode.getSeguent();
				
				while (auxNode.getSeguent() != null) {
					if (auxNode.getSeguent().getKey().compareTo(key) == 0) {
						nElems--;
						auxNode.setSeguent(auxNode.getSeguent().getSeguent());
						return;
					}
					auxNode = auxNode.getSeguent();
				}
			}
		}
		throw new noTrobat();
	}
	
	// 7. Retorna una llista amb tots els valors de la taula
	public LlistaDobleEncadenada<T> obtenirValors (){
		NodeHashGeneric<T, K> auxNode = null;;
		LlistaDobleEncadenada<T> llistaValors = new LlistaDobleEncadenada<T>();
		
		for (int i = 0; i < taula.length; i++) {
			if (taula[i] != null) {
				auxNode = taula[i];
				while (auxNode.getSeguent() != null) {
					llistaValors.inserir(auxNode.getSeguent().getValor());
					auxNode = auxNode.getSeguent();
				}
			}
		}
		return llistaValors;
	}
	
	// 8. Retorna una llista amb tots les claus de la taula
	public LlistaDobleEncadenada<K> obtenirClaus() {
		NodeHashGeneric<T, K> auxNode = null;;
		LlistaDobleEncadenada<K> llistaClaus = new LlistaDobleEncadenada<K>();
		
		for (int i = 0; i < taula.length; i++) {
			if (taula[i] != null) {
				auxNode = taula[i];
				while (auxNode.getSeguent() != null) {
					llistaClaus.inserir(auxNode.getSeguent().getKey());
					auxNode = auxNode.getSeguent();
				}
			}
		}
		return llistaClaus;
	}
	
	// 9. Retorna el factor de carrega actual (#elements/mida taula)
	public float ObtenirFactorDeCarrega() {
		return (float)nElems/taula.length;
	}
	
	public String toString() {
		String aux = "";
        for (int i = 0; i < taula.length; i++) {
            NodeHashGeneric<T, K> nodeAux = taula[i];
            if (nodeAux != null) {
            	aux += "========================\n";
                aux += "Posició de la taula: " + i + "\n========================\n\n";
                aux += nodeAux.getSeguent() + "\n\n";
            }
        }
        return aux;
    }
}
