package Dades;

public class ConjEntersDinamica implements TADConjuntEnters {

	private Node primer;
	private int numElem;

	public ConjEntersDinamica() {
		primer = null;
		numElem = 0;
	}

	/**
	 * Afegeix un enter al conjunt mentre hi ha espai, si l'element ja hi es, no fa
	 * res.
	 * 
	 * @param e - l'enter a afegir al conjunt
	 * @return codiError: =1 si l'enter s'ha afegit correctament al conjunt, =0 si
	 *         l'enter ja hi era, =-1 si no es pot afegit l'enter (problemes espai,
	 *         altres, ...)
	 */
	public int afegir(int e) {
		int codi;
		if (!pertany(e)) {
			// versió 1. Afegir el node al principi de la llista
			
			Node aux=new Node(e); 
			aux.setSeguent(primer); 
			primer=aux; 
			codi=1; 
			numElem++;
			 

			// versió 2. Afegir el node al final de la llista
			/*
			Node aux = primer;
			if (aux == null)
				primer = new Node(e);
			else {
				while (aux.getSeguent() != null)
					aux = aux.getSeguent();
				aux.setSeguent(new Node(e));
			}
			numElem++;
			codi = 1;
			*/
			// versió 3. Afegir el node ordenat per valor. Deixem com a exercici...

		} else
			codi = 0;
		return codi;
	}

	/**
	 * Elimina un valor del conjunt
	 * 
	 * @param e - l'enter a eliminar del conjunt
	 * @return codiError: =1 si l'enter s'ha esborrat del conjunt, =0 si l'enter no
	 *         s'ha esborrat perquè no hi era, =-1 qualsevol altre cas
	 */
	public int eliminar(int e) {
		int codi;
		boolean trobat = false;
		if (primer == null)
			codi = 0;
		else {
			if (primer.getValor() == e) {
				primer = primer.getSeguent();
				numElem--;
				trobat = true;
			} else {
				Node ant, aux;
				ant = primer;
				aux = ant.getSeguent();
				while (aux != null && !trobat) {
					if (aux.getValor() == e) {
						ant.setSeguent(aux.getSeguent());
						numElem--;
						trobat = true;
					} else {
						ant = aux;
						aux = aux.getSeguent();
					}
				}
			}
			if (!trobat)
				codi = 0;
			else
				codi = 1;
		}
		return codi;
	}

	/**
	 * Comprova si un enter pertany al conjunt
	 * 
	 * @param e - l'enter a comprovar
	 * @return cert si l'enter pertany i fals en cas contrari
	 */
	public boolean pertany(int e) {
		boolean hiEs = false;
		Node aux = primer;
		while (aux != null && !hiEs) {
			if (aux.getValor() == e)
				hiEs = true;
			else
				aux = aux.getSeguent();
		}
		return hiEs;
	}

	/**
	 * Comprova si el conjunt esta ple
	 * 
	 * @return cert si el el conjunt esta ple
	 */
	public boolean ple() {
		return (false);
	}

	/**
	 * Retorna el numero d'elements que te el conjunt
	 * 
	 * @return numero d'elements que hi ha en el conjunt
	 */
	public int numElems() {
		return (numElem);
	}

	public String toString() {
		String aux = "CJT DINAMIC ";
		Node a = primer;

		while (a != null) {
			aux = aux + "\t" + a.getValor();
			a = a.getSeguent();
		}
		return aux;
	}

}
