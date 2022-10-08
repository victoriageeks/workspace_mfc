package Graf;
import Excepcions.*;
import DobleEncadenada.*;
import Hash.*;

/**
 * 
 * @author Marc Fonseca 
 *
 */

public class Graf<V extends Comparable<V>, K extends Comparable<K>, E> implements TADGraf<V, K, E>  {
	
	private TaulaHash<NodeGrafGeneric<V,E>, K> h;
	
	// 1. Constructor per inicialitzar la taula
	public Graf (int size) {
		h = new TaulaHash<NodeGrafGeneric<V,E>, K>(size);
	}
	
	public void afegirVertexs(V vertex, K key) {
		h.inserir(key, new NodeGrafGeneric<V,E>(vertex));
	}
	
	// 2. Funció per a afegir una aresta.
	//    L’operació llença una excepció en cas que no es pugui afegir. Cuando un V no exista
	public void afegirAresta (V v1, V v2, E e) throws noTrobat {
		LlistaDobleEncadenada<NodeGrafGeneric<V,E>> llista = h.obtenirValors();
		NodeLlistaGenerica<NodeGrafGeneric<V,E>> auxV1= llista.getPrimer();
		NodeLlistaGenerica<NodeGrafGeneric<V,E>> auxV2= llista.getPrimer();
		int i, j;
		boolean trobat = false;
		
		for (i = 0; i < llista.longitud() && !trobat;i++) {
			if (auxV1.getValor().getZona() == v1) { trobat = true; }
			else { auxV1 = auxV1.getSeguent(); }
		}
		
		if (trobat == false) throw new noTrobat();
		trobat = false;
		for (j = 0; j < llista.longitud() && !trobat;j++) {
			if (auxV2.getValor().getZona() == v2) { trobat = true; }
			else { auxV2 =auxV2.getSeguent(); }
		}
		if (trobat == false) throw new noTrobat();
		
		if (i < j) {
			NodeArestaGeneric<V,E> aresta = new NodeArestaGeneric<V,E>(e, auxV1.getValor().getPrimera_Fila(), auxV2.getValor().getPrimera_Col(), auxV1.getValor(), auxV2.getValor());
			auxV2.getValor().setPrimera_Col(aresta);
			auxV1.getValor().setPrimera_Fila(aresta);
		}
		else {
			NodeArestaGeneric<V,E> aresta = new NodeArestaGeneric<V,E>(e, auxV2.getValor().getPrimera_Fila(), auxV1.getValor().getPrimera_Col(), auxV2.getValor(), auxV1.getValor());
			auxV1.getValor().setPrimera_Col(aresta);
			auxV2.getValor().setPrimera_Fila(aresta);
		}
	}
	
	// 3. Funció que ens diu si una aresta existeix.
	public boolean existeixAresta (V v1, V v2) {
		LlistaDobleEncadenada<NodeGrafGeneric<V,E>> llista = h.obtenirValors();
		NodeLlistaGenerica<NodeGrafGeneric<V,E>> auxV1= llista.getPrimer();
		NodeLlistaGenerica<NodeGrafGeneric<V,E>> auxV2= llista.getPrimer();
		NodeArestaGeneric<V,E> arestaAux;
		int i, j;
		boolean trobat = false;
		
		for (i = 0; i < llista.longitud() && !trobat;i++) {
			if (auxV1.getValor().getZona() == v1) { trobat = true; }
			else { auxV1 = auxV1.getSeguent(); }
		}
		trobat = false;
		for (j = 0; j < llista.longitud() && !trobat;j++) {
			if (auxV2.getValor().getZona() == v2) { trobat = true; }
			else { auxV2 =auxV2.getSeguent(); }
		}
		
		if (i < j) {
			arestaAux = auxV1.getValor().getPrimera_Fila();
			while (arestaAux != null) {
				if (arestaAux.getRef_Col().getZona() == v2) {
					return true;
				}
				arestaAux = arestaAux.getSeg_Fila();
			}
		}
		else {
			arestaAux = auxV2.getValor().getPrimera_Fila();
			while (arestaAux != null) {
				if (arestaAux.getRef_Col().getZona() == v1) {
					return true;
				}
				arestaAux = arestaAux.getSeg_Fila();
			}
		}
		return false;
	}
	
	// 4. Funció que retorna el valor d'una aresta.
	//    L’operació llença una excepció en cas que no existeixi.
	public E valorAresta (V v1, V v2) throws noTrobat {
		LlistaDobleEncadenada<NodeGrafGeneric<V,E>> llista = h.obtenirValors();
		NodeLlistaGenerica<NodeGrafGeneric<V,E>> auxV1= llista.getPrimer();
		NodeLlistaGenerica<NodeGrafGeneric<V,E>> auxV2= llista.getPrimer();
		NodeArestaGeneric<V,E> arestaAux;
		int i, j;
		boolean trobat = false;
		
		for (i = 0; i < llista.longitud() && !trobat;i++) {
			if (auxV1.getValor().getZona() == v1) { trobat = true; }
			else { auxV1 = auxV1.getSeguent(); }
		}
		trobat = false;
		for (j = 0; j < llista.longitud() && !trobat;j++) {
			if (auxV2.getValor().getZona() == v2) { trobat = true; }
			else { auxV2 =auxV2.getSeguent(); }
		}
		
		if (i < j) {
			arestaAux = auxV1.getValor().getPrimera_Fila();
			while (arestaAux != null) {
				if (arestaAux.getRef_Col().getZona() == v2) {
					return arestaAux.getAresta();
				}
				arestaAux = arestaAux.getSeg_Fila();
			}
		}
		else {
			arestaAux = auxV2.getValor().getPrimera_Fila();
			while (arestaAux != null) {
				if (arestaAux.getRef_Col().getZona() == v1) {
					return arestaAux.getAresta();
				}
				arestaAux = arestaAux.getSeg_Fila();
			}
		}
		
		throw new noTrobat();
	}
	
	// 5. Funció que retorna una llista que conté tots els nodes adjacents al node passat per paràmetre.
	//    L’operació llença una excepció en cas que no es pugui crear aquesta llista (Cuando este vacia?)
	public LlistaDobleEncadenada<V> adjacents (V v) throws noTrobat {
		LlistaDobleEncadenada<NodeGrafGeneric<V,E>> llista = h.obtenirValors();
		NodeLlistaGenerica<NodeGrafGeneric<V,E>> auxV= llista.getPrimer();
		int i;
		
		boolean trobat = false;
		
		for (i = 0; i < llista.longitud() && !trobat;i++) {
			if (auxV.getValor().getZona() == v) { trobat = true; }
			else { auxV = auxV.getSeguent(); }
		}
		i--;
		
		LlistaDobleEncadenada<V> llis = new LlistaDobleEncadenada<V>();
		NodeArestaGeneric<V,E> aresta;
		
		aresta = auxV.getValor().getPrimera_Fila();
		while (aresta != null) {
			llis.inserir(aresta.getRef_Col().getZona());
			aresta = aresta.getSeg_Fila();
		}
		
		aresta = auxV.getValor().getPrimera_Col();
		while (aresta != null) {
			llis.inserir(aresta.getRef_Fila().getZona());
			aresta = aresta.getSeg_Col();
		}
		
		if (llis.longitud() == 0) {
			throw new noTrobat();
		}
		
		return llis;
	}
	
	public TaulaHash<NodeGrafGeneric<V,E>, K> getH() {
		return h;
	}

	public void setH(TaulaHash<NodeGrafGeneric<V,E>, K> h) {
		this.h = h;
	}

	public String toString() {
		return h.toString();
	}
}
