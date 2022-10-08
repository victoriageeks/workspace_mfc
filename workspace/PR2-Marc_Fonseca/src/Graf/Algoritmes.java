package Graf;
import DobleEncadenada.LlistaDobleEncadenada;
import DobleEncadenada.NodeLlistaGenerica;
import Excepcions.*;
import java.util.*;

/**
 * 
 * @author Marc Fonseca
 *
 */

public class Algoritmes {
	
	Graf<ZonaRecarrega, String, Double> graf;
	double distancia;
	int[] visitats;
	
	public Algoritmes (Graf<ZonaRecarrega, String, Double> graf) {
		this.graf = graf;
	}
	
	public LlistaDobleEncadenada<String> camiOptim(String identificador_origen, String identificador_desti, int autonomia) throws noTrobat, foraDeRang, noArriba {
		LlistaDobleEncadenada<NodeGrafGeneric<ZonaRecarrega,Double>> llistaHash = graf.getH().obtenirValors();
		NodeLlistaGenerica<NodeGrafGeneric<ZonaRecarrega,Double>> aux = llistaHash.getPrimer();
		
		NodeGrafGeneric<ZonaRecarrega, Double> origen = null;
		NodeGrafGeneric<ZonaRecarrega, Double> desti = null;
		
		boolean trobat1 = false, trobat2 = false;
		for (; aux != null && (!trobat1 || !trobat2); aux = aux.getSeguent()) {
			if (aux.getValor().getZona().getPosicio().equalsIgnoreCase(identificador_origen)) { trobat1 = true; origen = aux.getValor();}
			if (aux.getValor().getZona().getPosicio().equalsIgnoreCase(identificador_desti)) { trobat2 = true; desti = aux.getValor(); }
		}
		
		int inici = posicioHash(origen.getZona());
		
		ArrayList<ZonaRecarrega> openSet = new ArrayList<ZonaRecarrega>();
		openSet.add(origen.getZona());
		
		ZonaRecarrega[] cameFrom = new ZonaRecarrega[llistaHash.longitud()];
		double[] gScore = new double[llistaHash.longitud()];
		double[] fScore = new double[llistaHash.longitud()];
		
		for(int k = 0; k < gScore.length; k++) { gScore[k] = 10000; }
		gScore[inici] = 0;
		
		for(int k = 0; k < fScore.length; k++) fScore[k] = 10000;
		fScore[inici] = calculateDistanceByHarvesine(origen.getZona().getLatitud(), origen.getZona().getLongitud(), desti.getZona().getLatitud(), desti.getZona().getLongitud());
		
		distancia = fScore[inici];
		
		ZonaRecarrega current;
		LlistaDobleEncadenada<ZonaRecarrega> adjacents;
		int contador = 0;
		
		while(!openSet.isEmpty()) {
			current = openSet.get(0);
			
			if (current == desti.getZona()) {
				ArrayList<NodeGrafGeneric<ZonaRecarrega, Double>> cami =  reconstruct_path(cameFrom, current);
				LlistaDobleEncadenada<String> cami_final = new LlistaDobleEncadenada<String>();
				String auxPunt = "";
				double auxPotencia = -1;
				for(int k = 0; k < cami.size(); k++) {
					for (int m = 0; m < cami.get(k).getZona().getPunts().size(); m++) {
						if (auxPotencia < cami.get(k).getZona().getPunts().get(m).getPotencia()) {
							auxPunt = ""+cami.get(k).getZona().getPunts().get(m).getId();
						}
					}
					cami_final.inserir(auxPunt);
				}
				return cami_final;
			}
			else if(contador == 358) {
				throw new noArriba();
			}
			
			openSet.remove(current);
			adjacents = graf.adjacents(current);
			
			for (int k = 0; k < adjacents.longitud(); k++) {
				int posAdjacent = posicioHash(adjacents.obtenir(k));
				double tentative_gScore = gScore[posicioHash(current)] + graf.valorAresta(current, adjacents.obtenir(k));
				
				if (tentative_gScore < gScore[posAdjacent] && graf.valorAresta(current, adjacents.obtenir(k)) <= autonomia ) {
					cameFrom[posAdjacent] = current;
					gScore[posAdjacent] = tentative_gScore;
					fScore[posAdjacent] = tentative_gScore + calculateDistanceByHarvesine(llistaHash.obtenir(posAdjacent).getZona().getLatitud(), llistaHash.obtenir(posAdjacent).getZona().getLongitud(), desti.getZona().getLatitud(), desti.getZona().getLongitud());
					
					if (!openSet.contains(adjacents.obtenir(k))) {
						openSet.add(adjacents.obtenir(k));
					}
				}
			}
			openSet = ordenarLista (openSet, fScore);
			contador++;
		}
		throw new noArriba();
	}
	
	public LlistaDobleEncadenada<String> zonesDistMaxNoGarantida (String identificador_origen, int autonomia) throws noTrobat, foraDeRang{
		LlistaDobleEncadenada<NodeGrafGeneric<ZonaRecarrega,Double>> llistaHash = graf.getH().obtenirValors();
		NodeLlistaGenerica<NodeGrafGeneric<ZonaRecarrega,Double>> aux = llistaHash.getPrimer();
		
		NodeGrafGeneric<ZonaRecarrega, Double> origen = null;
		
		boolean trobat1 = false;
		for (; aux != null && !trobat1; aux = aux.getSeguent()) {
			if (aux.getValor().getZona().getPosicio().equalsIgnoreCase(identificador_origen)) { trobat1 = true; origen = aux.getValor();}
		}
		
		visitats = new int[llistaHash.longitud()];
		for (int k = 0; k < visitats.length; k++) { visitats[k] = 0; }
		
		profunditat0(origen.getZona(), autonomia);
		
		LlistaDobleEncadenada<String> llis = new LlistaDobleEncadenada<String>();
		for (int k = 0; k < visitats.length; k++) {
			if (visitats[k] == 0) {
				llis.inserir(""+llistaHash.obtenir(k).getZona().getId_estacio());
			}
		}
		return llis;
	}
	
	private void profunditat0 (ZonaRecarrega v, int autonomia) throws noTrobat, foraDeRang{
		visitats[posicioHash(v)] = 2;
		LlistaDobleEncadenada<ZonaRecarrega> adjacents = graf.adjacents(v);
		
		for (int k = 0; k < adjacents.longitud(); k++) {
			if (graf.valorAresta(v, adjacents.obtenir(k)) <= autonomia && visitats[posicioHash(adjacents.obtenir(k))] == 0) {
				profunditat0(adjacents.obtenir(k), autonomia);
			}
		}
		
		visitats[posicioHash(v)] = 1;
	}

	
	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	

	private double calculateDistanceByHarvesine (double lat1, double lon1, double lat2, double lon2) {
		
		double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

         double a = Math.pow(Math.sin(dLat / 2), 2) +
                      Math.pow(Math.sin(dLon / 2), 2) *
                      Math.cos(lat1) *
                      Math.cos(lat2);
         double rad = 6371;
         double c = 2 * Math.asin(Math.sqrt(a));

         return rad * c;
	}
	
	private int posicioHash (ZonaRecarrega v) {
		LlistaDobleEncadenada<NodeGrafGeneric<ZonaRecarrega,Double>> llistaHash = graf.getH().obtenirValors();
		NodeLlistaGenerica<NodeGrafGeneric<ZonaRecarrega,Double>> auxNodeHash = llistaHash.getPrimer();
		
		boolean trobat = false;
		int i;
		
		for (i = 0; i < llistaHash.longitud() && !trobat; i++) {
			if(v == auxNodeHash.getValor().getZona()) { trobat = true; }
			else { auxNodeHash = auxNodeHash.getSeguent(); }
		}
		
		return --i;
	}
	
	private ArrayList<ZonaRecarrega> ordenarLista (ArrayList<ZonaRecarrega> openSet, double[] fScore) throws foraDeRang{
		ZonaRecarrega[] aux = new ZonaRecarrega[openSet.size()];
		ArrayList<ZonaRecarrega> auxOpenSet = new ArrayList<ZonaRecarrega>();
		
		double[] auxDouble = new double[aux.length];
		for (int i = 0; i < auxDouble.length; i++) {
			auxDouble[i] = fScore[posicioHash(openSet.get(i))];
		}
		
		Arrays.sort(auxDouble);
		
		boolean trobat;
		for (int i = 0; i < auxDouble.length; i++) {
			trobat = false;
			for (int j = 0; j < openSet.size() && !trobat; j++) {
				if (auxDouble[i] == fScore[posicioHash(openSet.get(j))]) {
					auxOpenSet.add(openSet.get(j));
					trobat = true;
				}
			}
		}
		
		return auxOpenSet;
	}
	
	private ArrayList<NodeGrafGeneric<ZonaRecarrega,Double>> reconstruct_path (ZonaRecarrega[] cameFrom, ZonaRecarrega actual) throws foraDeRang {
		LlistaDobleEncadenada<NodeGrafGeneric<ZonaRecarrega,Double>> llistaHash = this.graf.getH().obtenirValors();
		
		ArrayList<NodeGrafGeneric<ZonaRecarrega,Double>> total_path = new ArrayList<NodeGrafGeneric<ZonaRecarrega,Double>>();
		boolean fi = false;
		
		while(!fi) {
			total_path.add(llistaHash.obtenir(posicioHash(actual)));
			actual = cameFrom[posicioHash(actual)];
			if(actual == null) { fi=true; }
		}
		return total_path;
	}
}
