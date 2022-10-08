package Aplicacio;
import DobleEncadenada.*;
import Graf.*;
import Excepcions.*;
import Hash.*;
import com.google.gson.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 
 * @author Marc Fonseca
 *
 */

public class Aplicacio {
	
	public static void main(String[] ar) {
		
		// JSON
		String json = "";
        try {

            Charset charset = StandardCharsets.UTF_8;
            BufferedReader br = new BufferedReader(new FileReader("icaen.json", charset));
            String linea;

            while ((linea = br.readLine()) != null){
                json += linea+"\n";
            }
            br.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        Gson gson = new Gson();
        PuntRecarregaAux[] pAux = gson.fromJson(json, PuntRecarregaAux[].class);
        
        
        // PuntRecarregaAux(Strings) --> PuntRecarrega(Altres tipus)
        PuntRecarrega[] p = new PuntRecarrega[pAux.length];
        for (int i = 0; i < pAux.length; i++) {
        	p[i] = new PuntRecarrega(pAux[i].getId(), pAux[i].getId_estacio(), pAux[i].getNom(), pAux[i].getData(), pAux[i].getConsum(), pAux[i].getCarrer(), pAux[i].getCiutat(), pAux[i].getEstat(), pAux[i].getTemps(), pAux[i].getPotencia(), pAux[i].getTipus(), pAux[i].getLatitud(), pAux[i].getLongitud());
        }
        
        
        // Inicialitzacio de la taula de hash del graf amb ZonesRecarrega
        Graf<ZonaRecarrega, String, Double> g = new Graf<ZonaRecarrega, String, Double>(356);
        TaulaHash<ZonaRecarrega, String> h = new TaulaHash<ZonaRecarrega, String>(100);
        
        h.inserir(p[0].getPosicio(), new ZonaRecarrega(p[0].getId_estacio(), p[0].getNom(), p[0].getData(), p[0].getCarrer(), p[0].getCiutat(), p[0].getLatitud(), p[0].getLongitud(), p[0].getPosicio(), p[0]));
		g.afegirVertexs(new ZonaRecarrega(p[0].getId_estacio(), p[0].getNom(), p[0].getData(), p[0].getCarrer(), p[0].getCiutat(), p[0].getLatitud(), p[0].getLongitud(), p[0].getPosicio(), p[0]), p[0].getPosicio());
		
        for (int i = 1; i < p.length; i++) {
        	try {
        		h.buscar(p[i].getPosicio());
        		h.obtenir(p[i].getPosicio()).afegirPunt(p[i]);
        	}
        	catch(noTrobat e) {
        		h.inserir(p[i].getPosicio(), new ZonaRecarrega(p[i].getId_estacio(), p[i].getNom(), p[i].getData(), p[i].getCarrer(), p[i].getCiutat(), p[i].getLatitud(), p[i].getLongitud(), p[i].getPosicio(), p[i]));
        		try {
        			g.afegirVertexs(h.obtenir(p[i].getPosicio()), p[i].getPosicio());
            	}
            	catch(noTrobat a) {
            		System.out.println("No entrara nunca aqui :)");
            	}
        	}
        }
          
        
        // Afegim arestes entre ZonesRecarrega
        LlistaDobleEncadenada<NodeGrafGeneric<ZonaRecarrega,Double>> llista = g.getH().obtenirValors();
		NodeLlistaGenerica<NodeGrafGeneric<ZonaRecarrega, Double>> valor = llista.getPrimer(), valorAux;
		
		NodeGrafGeneric<ZonaRecarrega, Double> estacioAux = null;
		double distancia = 0.0, distanciaMinima = 1000.0;
		boolean conectat = false;
		
		for (int i = 0; i < llista.longitud(); i++, valor = valor.getSeguent()) {
			valorAux = llista.getPrimer();
			//distanciaMinima = 1000.0;
			for (int j = 0; j < llista.longitud(); j++, valorAux = valorAux.getSeguent()) {
				distancia = calculateDistanceByHarvesine(valor.getValor().getZona().getLatitud(), valor.getValor().getZona().getLongitud(), valorAux.getValor().getZona().getLatitud(), valorAux.getValor().getZona().getLongitud());
				if (i != j) {
					if (!g.existeixAresta(valorAux.getValor().getZona(), valor.getValor().getZona())) {
						if (distancia <= 40.0) {
							try {
								g.afegirAresta(valor.getValor().getZona(), valorAux.getValor().getZona(), distancia);
							} catch (noTrobat e) {
								System.out.println(e);
							}
							conectat = true;
						}
						else if(!conectat && distancia < distanciaMinima) {
							distanciaMinima = distancia;
							estacioAux = valorAux.getValor();
						}
					}
					else {
						conectat = true;
					}
				}
				
			}
			if (!conectat) {
				try {
					g.afegirAresta(valor.getValor().getZona(), estacioAux.getZona(), distanciaMinima);
				} catch (noTrobat e) {
					System.out.println(e);
				}
			}
			conectat = false;
		}
		
		// 1. Mostrem totes les zones de recarrega amb els seus punts
		System.out.println("1. Mostrem totes les zones de recarrega amb els seus punts");
		for (NodeGrafGeneric<ZonaRecarrega, Double> zonas:llista) {
			System.out.println(zonas.getZona());
		}
		
		// 2. Comprovem si hi ha aresta quan no hi hauria d'haver
		NodeLlistaGenerica<NodeGrafGeneric<ZonaRecarrega, Double>> valorAux1 = llista.getPrimer(), valorAux2 = valorAux1.getSeguent();
		
		try {
			distancia = calculateDistanceByHarvesine(valorAux1.getValor().getZona().getLatitud(), valorAux1.getValor().getZona().getLongitud(), valorAux2.getValor().getZona().getLatitud(), valorAux2.getValor().getZona().getLongitud());
			System.out.println("2. Comprovem si hi ha aresta amb una distancia de: " + distancia + "km");
			if (g.existeixAresta(valorAux1.getValor().getZona(), valorAux2.getValor().getZona())) {
				System.out.println("\tExisteix aresta amb valor: " + g.valorAresta(valorAux1.getValor().getZona(), valorAux2.getValor().getZona()) + "km\n");
			}
			else {
				System.out.println("\tNo existeix aresta");
				System.out.println();
			}
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		// 3. Comprovem si hi ha aresta quan hi hauria d'haver
		ZonaRecarrega valorAux3 = null;
		try {
			valorAux3 = g.adjacents(valorAux1.getValor().getZona()).getPrimer().getValor();
		} catch (noTrobat e) { }
		distancia = calculateDistanceByHarvesine(valorAux1.getValor().getZona().getLatitud(), valorAux1.getValor().getZona().getLongitud(), valorAux3.getLatitud(), valorAux3.getLongitud());
		System.out.println("3. Comprovem si hi ha aresta amb una distancia de: " + distancia + "km");
		
		try {
			if (g.existeixAresta(valorAux1.getValor().getZona(), valorAux3)) {
				System.out.println("\tExisteix aresta amb valor: " + g.valorAresta(valorAux1.getValor().getZona(), valorAux3) + "km\n");
			}
			else {
				System.out.println("\tNo existeix aresta\n");
			}
		} catch (noTrobat e) {
			System.out.println(e);
		}
			
		// 4. Comprovem que tots els adjacents estan a una distancia maxima de 40km
		System.out.println("4. Comprovem que tots els adjacents estan a una distancia maxima de 40km");
		
		int j = 0;
		
		try {
			LlistaDobleEncadenada<ZonaRecarrega> llistaAux = g.adjacents(valorAux1.getValor().getZona());
			System.out.println("\tEl primer vertex te " + llistaAux.longitud() + " adjacents que estan a una distancia de: ");
			
			for (ZonaRecarrega zonas:llistaAux) {
				j++;
				distancia = calculateDistanceByHarvesine(valorAux1.getValor().getZona().getLatitud(), valorAux1.getValor().getZona().getLongitud(), zonas.getLatitud(), zonas.getLongitud());
				System.out.println("\t\t" + j + ". "+ distancia + "km");
			}
		} catch (noTrobat e) {
			System.out.println(e);
		}
		
		// 5. Trobar camiOptim amb una autonomia baixa
		Algoritmes algoritme = new Algoritmes(g);
		LlistaDobleEncadenada<String> llistaAux = new LlistaDobleEncadenada<String>();
		String aux = "";
		
		System.out.println("\n5. Trobar camiOptim amb una autonomia baixa");
		try {
			llistaAux = algoritme.camiOptim("41.4124737396462.014127862566", "40.7947750.525542", 10);
			for (int i = llistaAux.longitud()-1; i >= 0; i--) {
     	   		aux = llistaAux.obtenir(i).toString();
     	   		if (i == llistaAux.longitud()-1) {
     	   			System.out.println("PuntRecarrega Origen: \t" + aux);
     	   		}
     	   		else if (i == 0) {
     	   			System.out.println("PuntRecarrega Desti: \t" + aux);
     	   		}
     	   		else {
     	   		System.out.println("PuntRecarrega Parada: \t" + aux);
     	   		}
			}
		} catch (noTrobat e) {
			System.out.println("Error");
		} catch (foraDeRang e) {
			System.out.println("Error");
		} catch (noArriba e) { System.out.println(e);}
		
		// 6. Llistat de ZonesDistMaxNoGarantida amb maxima autonomia
		System.out.println("6. Llistat de ZonesDistMaxNoGarantida amb maxima autonomia");
		try {
			llistaAux = algoritme.zonesDistMaxNoGarantida("41.4124737396462.014127862566", 40);
			for (int i = 0; i < llistaAux.longitud();) {
     	   		aux = llistaAux.obtenir(i).toString();
     	   		System.out.println(+ ++i +". ZonaRecarrega: " + aux);
			}
		} catch (noTrobat e) {} catch (foraDeRang e) { }
		
		// 7. Llistat de ZonesDistMaxNoGarantida amb una autonomia molt baixa
		System.out.println("\n7. Llistat de ZonesDistMaxNoGarantida amb una autonomia molt baixa");
		try {
			llistaAux = algoritme.zonesDistMaxNoGarantida("41.4124737396462.014127862566", 10);
			for (int i = 0; i < llistaAux.longitud();) {
     	   		aux = llistaAux.obtenir(i).toString();
     	   		System.out.println(+ ++i +". ZonaRecarrega: " + aux);
			}
		} catch (noTrobat e) { } catch (foraDeRang e) { }
		
		// 8. Nombre total de Zones de Recarrega
		System.out.println("\n8. Nombre total de Zones de Recarrega");
						
		System.out.println("\tLa taula te " + h.obtenirValors().longitud() + " Zones de Recarrega.\n");
		// 9. Nombre total de arestes
		System.out.println("9. Nombre total de arestes");
		
		NodeArestaGeneric<ZonaRecarrega, Double> aresta;
		valor = llista.getPrimer();
		int contador = 0;
		
		
		for (int i = 0; i < llista.longitud(); i++) {
			aresta = valor.getValor().getPrimera_Col();
			for (; aresta != null; aresta = aresta.getSeg_Col()) {
				contador++;
			}
			valor = valor.getSeguent();
		}
		System.out.println("\tEn total hi han " + contador + " arestes.");
		
		
		// 10. Anlisis temporal de algunes rutes
		System.out.println("\n10. Anlisis temporal de algunes rutes");

		long startNanoTime;
		double elapsedTime;
		
		//Ruta 1: 
		//	Origen: 							Destí: 
		//		"latitud": "41.412473739646" 		"latitud": "40.794775"
		//		"longitud": "2.014127862566"  		"longitud": "0.525542"
		
		startNanoTime = System.nanoTime(); 
		System.out.println("Ruta 1:");
		try {
			llistaAux = algoritme.camiOptim("41.4124737396462.014127862566", "40.7947750.525542", 40);
			for (int i = llistaAux.longitud()-1; i >= 0; i--) {
     	   		aux = llistaAux.obtenir(i).toString();
     	   		if (i == llistaAux.longitud()-1) {
     	   			System.out.println("PuntRecarrega Origen: \t" + aux);
     	   		}
     	   		else if (i == 0) {
     	   			System.out.println("PuntRecarrega Desti: \t" + aux);
     	   		}
     	   		else {
     	   		System.out.println("PuntRecarrega Parada: \t" + aux);
     	   		}
			}
			elapsedTime = (System.nanoTime() - startNanoTime);
            System.out.println("Ha recorregut " + algoritme.getDistancia() + "km en " +elapsedTime*1.0e-6+ "ms\n\n");
		} catch (noTrobat e) {
			System.out.println("Error");
		} catch (foraDeRang e) {
			System.out.println("Error");
		} catch (noArriba e) { System.out.println(e);}
       
		
		//Ruta 2: 
		//	Origen: 							Destí: 
		//		"latitud": "41.412473739646" 		"latitud": "41.5555823"
		//		"longitud": "2.014127862566"  		"longitud": "2.4005556"
        
		startNanoTime = System.nanoTime(); 
        System.out.println("Ruta 2:");
        try {
    	   llistaAux = algoritme.camiOptim("41.4124737396462.014127862566", "41.55558232.4005556", 40);
    	   for (int i = llistaAux.longitud()-1; i >= 0; i--) {
    	   		aux = llistaAux.obtenir(i).toString();
    	   		if (i == llistaAux.longitud()-1) {
    	   			System.out.println("PuntRecarrega Origen: \t" + aux);
    	   		}
    	   		else if (i == 0) {
    	   			System.out.println("PuntRecarrega Desti: \t" + aux);
    	   		}
    	   		else {
    	   		System.out.println("PuntRecarrega Parada: \t" + aux);
    	   		}
			}
    	   	elapsedTime = (System.nanoTime() - startNanoTime);
	        System.out.println("Ha recorregut " + algoritme.getDistancia() + "km en " +elapsedTime*1.0e-6+ "ms\n\n");
		} catch (noTrobat e) {
			System.out.println("Error");
		} catch (foraDeRang e) {
			System.out.println("Error");
		} catch (noArriba e) { System.out.println(e);}
       
		
		//Ruta 3: 
		//	Origen: 							Destí: 
		//		"latitud": "41.5555823" 		"latitud": "41.780674"
		//		"longitud": "2.4005556"  		"longitud": "3.022077"
		
        startNanoTime = System.nanoTime(); 
        System.out.println("Ruta 3:");
        try {
        	llistaAux = algoritme.camiOptim("41.55558232.4005556", "41.7806743.022077", 40);
        	for (int i = llistaAux.longitud()-1; i >= 0; i--) {
     	   		aux = llistaAux.obtenir(i).toString();
     	   		if (i == llistaAux.longitud()-1) {
     	   			System.out.println("PuntRecarrega Origen: \t" + aux);
     	   		}
     	   		else if (i == 0) {
     	   			System.out.println("PuntRecarrega Desti: \t" + aux);
     	   		}
     	   		else {
     	   		System.out.println("PuntRecarrega Parada: \t" + aux);
     	   		}
			}
        	elapsedTime = (System.nanoTime() - startNanoTime);
            System.out.println("Ha recorregut " + algoritme.getDistancia() + "km en " +elapsedTime*1.0e-6+ "ms\n\n");
		} catch (noTrobat e) {
			System.out.println("Error");
		} catch (foraDeRang e) {
			System.out.println("Error");
		} catch (noArriba e) { System.out.println(e); }
		
        
		//Ruta 4: 
		//	Origen: 							Destí: 
		//		"latitud": "41.5555823" 			"latitud": "41.375768"
		//		"longitud": "2.4005556"  			"longitud": "1.163327"
		
        startNanoTime = System.nanoTime(); 
    	System.out.println("Ruta 4:");
        try {
        	llistaAux = algoritme.camiOptim("41.55558232.4005556", "41.3757681.163327", 40);
        	for (int i = llistaAux.longitud()-1; i >= 0; i--) {
     	   		aux = llistaAux.obtenir(i).toString();
     	   		if (i == llistaAux.longitud()-1) {
     	   			System.out.println("PuntRecarrega Origen: \t" + aux);
     	   		}
     	   		else if (i == 0) {
     	   			System.out.println("PuntRecarrega Desti: \t" + aux);
     	   		}
     	   		else {
     	   		System.out.println("PuntRecarrega Parada: \t" + aux);
     	   		}
			}
		} catch (noTrobat e) {
			System.out.println("Error");
		} catch (foraDeRang e) {
			System.out.println("Error");
		} catch (noArriba e) { System.out.println(e); }
        elapsedTime = (System.nanoTime() - startNanoTime);
        System.out.println("Ha recorregut " + algoritme.getDistancia() + "km en " +elapsedTime*1.0e-6+ "ms\n\n");
        
		
		//Ruta 5: 
		//	Origen: 							Destí: 
		//		"latitud": "40.814151" 				"latitud": "42.268984"
		//		"longitud": "0.515161"  			"longitud": "2.966869"
		
        startNanoTime = System.nanoTime(); 
        System.out.println("Ruta 5:");
        try {
        	llistaAux = algoritme.camiOptim("40.8141510.515161", "42.2689842.966869", 40);
        	for (int i = llistaAux.longitud()-1; i >= 0; i--) {
     	   		aux = llistaAux.obtenir(i).toString();
     	   		if (i == llistaAux.longitud()-1) {
     	   			System.out.println("PuntRecarrega Origen: \t" + aux);
     	   		}
     	   		else if (i == 0) {
     	   			System.out.println("PuntRecarrega Desti: \t" + aux);
     	   		}
     	   		else {
     	   		System.out.println("PuntRecarrega Parada: \t" + aux);
     	   		}
			}
		} catch (noTrobat e) {
			System.out.println("Error");
		} catch (foraDeRang e) {
			System.out.println("Error");
		} catch (noArriba e) { System.out.println(e); }
        elapsedTime = (System.nanoTime() - startNanoTime);
        System.out.println("Ha recorregut " + algoritme.getDistancia() + "km en " +elapsedTime*1.0e-6+ "ms\n\n");
	}
	
	private static double calculateDistanceByHarvesine (double lat1, double lon1, double lat2, double lon2) {
		
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
}
