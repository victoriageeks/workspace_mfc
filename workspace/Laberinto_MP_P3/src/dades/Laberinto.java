/**
 * Clase Laberinto
 * @author Marc Fonseca 
 * @author Joel Lacambra
 * @author Isamel Ruiz
 */

package dades;

public class Laberinto {
	
	private Celda[][] laberinto;
	private int entradaX, entradaY; 
	private int salidaX, salidaY;
	private int rows, columns;
	private int tamCamino;

	/**
	 * Constructor
	 * @param rows - files
	 * @param columns - columnes
	 * @param entradaX - posicio entrada x
	 * @param entradaY - posicio entrada y
	 * @param salidaX - posicio salida x
	 * @param salidaY - posicio salida y
	 */
	public Laberinto(int rows, int columns, int entradaX, int entradaY, int salidaX, int salidaY) {
		this.entradaX = entradaX; this.entradaY = entradaY;
		this.salidaX = salidaX; this.salidaY = salidaY;
		this.rows = rows; this.columns = columns;
	}
	 /**
	  * Getter 
	  * @return laberinto
	  */
	public Celda[][] getLaberinto() {
		return laberinto;
	}

	/**
	 * Setter
	 * @param laberinto
	 */
	public void setLaberinto(Celda[][] laberinto) {
		this.laberinto = laberinto;
	}

	/**
	 * Getter
	 * @return
	 */
	public int getEntradaX() {
		return entradaX;
	}
	
	/**
	 * Setter
	 * @param entradaX
	 */
	public void setEntradaX(int entradaX) {
		this.entradaX = entradaX;
	}

	/**
	 * Getter
	 * @return
	 */
	public int getEntradaY() {
		return entradaY;
	}
	
	/**
	 * Setter
	 * @param entradaY
	 */
	public void setEntradaY(int entradaY) {
		this.entradaY = entradaY;
	}
	
	/**
	 * Getter
	 * @return salida posicion x
	 */
	public int getSalidaX() {
		return salidaX;
	}
	
	/**
	 * Setter 
	 * @param salidaX
	 */
	public void setSalidaX(int salidaX) {
		this.salidaX = salidaX;
	}

	/**
	 * Getter
	 * @return salida posicion y
	 */
	public int getSalidaY() {
		return salidaY;
	}
	
	/**
	 * Setter
	 * @param salidaY
	 */
	public void setSalidaY(int salidaY) {
		this.salidaY = salidaY;
	}
	
	/**
	 * Getter
	 * @return filas
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Setter
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public int getColumns() {
		return columns;
	}
	
	/**
	 * Setter
	 * @param columns
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * Pasar laberinto completo
	 * @param laberinto - laberinto
	 */
	public void anadirCeldas(Celda[][] laberinto) {
		this.laberinto = laberinto;
	}
	
	/**
	 * Calcula la distancia de un punto actual hasta la casilla final
	 * @param vx1 - entrada x
	 * @param vy1 - entrada y
	 * @param vx2 - salida x
	 * @param vy2 - salida y
	 * @return
	 */
	public double distanciaAlFinal(int vx1, int vy1, int vx2, int vy2){
		return Math.sqrt((double)((vx1-vx2)*(vx1-vx2)+(vy1-vy2)*(vy1-vy2)));
	}

	/**
	 * Metodo avid para encontrar un camino
	 * @return - matriz del camino encontrado/no encontrado
	 */
	public Laberinto avid(){
		int actualX = entradaX; int actualY = entradaY;
		int puntos = 1;
		int indiceListaCeldas = 1;
		
		Laberinto solucio = new Laberinto(rows, columns, entradaX, entradaY, salidaX, salidaY);
		Celda[][] auxLaberinto = new Celda[rows][columns];
		for(int i= 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				auxLaberinto[i][j]=laberinto[i][j].copia();
			}
		}
		solucio.anadirCeldas(auxLaberinto);
		
		CeldaVecina[] listaCeldas = new CeldaVecina[rows*columns];
		listaCeldas[0] = new CeldaVecina(solucio.laberinto[actualX][actualY].copia(), actualX, actualY,laberinto[actualX][actualY].operacion(puntos),distanciaAlFinal(actualX,actualY,salidaX,salidaY)); 
		
		while(!(salidaX == actualX && salidaY == actualY)){
			puntos = solucio.laberinto[actualX][actualY].operacion(puntos);
			
			CeldaVecina[] vecinos = new CeldaVecina[4];
			int indiceVecinos = 0;
			// Vecinos N, E, S, O 
			
			// Vecino N
			if((actualX-1) >= 0 && !solucio.laberinto[actualX-1][actualY].getOperacion().equals("N")){
				vecinos[indiceVecinos]=new CeldaVecina(solucio.laberinto[actualX-1][actualY].copia(), actualX-1, actualY, solucio.laberinto[actualX-1][actualY].operacion(puntos),distanciaAlFinal(actualX-1,actualY,salidaX,salidaY));
				indiceVecinos++;
			}
			// Vecino E
			if((actualY+1) < columns && !solucio.laberinto[actualX][actualY+1].getOperacion().equals("N")){
				vecinos[indiceVecinos]=new CeldaVecina(solucio.laberinto[actualX][actualY+1].copia(), actualX, actualY+1, solucio.laberinto[actualX][actualY+1].operacion(puntos),distanciaAlFinal(actualX,actualY+1,salidaX,salidaY));
				indiceVecinos++;
			}
			// Vecino S
			if((actualX+1) < rows && !solucio.laberinto[actualX+1][actualY].getOperacion().equals("N")){
				vecinos[indiceVecinos]=new CeldaVecina(solucio.laberinto[actualX+1][actualY].copia(), actualX+1, actualY, solucio.laberinto[actualX+1][actualY].operacion(puntos),distanciaAlFinal(actualX+1,actualY,salidaX,salidaY));
				indiceVecinos++;
			}
			// Vecino O
			if((actualY-1) >=0 && !solucio.laberinto[actualX][actualY-1].getOperacion().equals("N")){
				vecinos[indiceVecinos]=new CeldaVecina(solucio.laberinto[actualX][actualY-1].copia(), actualX, actualY-1, solucio.laberinto[actualX][actualY-1].operacion(puntos),distanciaAlFinal(actualX-1,actualY,salidaX,salidaY));
				indiceVecinos++;
			}
			
			// Elegir la mejor opcion
			double optim = 0;
			CeldaVecina mejorCelda = null;
			
			for(int i = 0; i < indiceVecinos;i++){
				if(vecinos[i].getPosiblePuntuacion()>0){
					if(vecinos[i].getPosiblePuntuacion()/vecinos[i].getDistancia() > optim){
						optim = vecinos[i].getPosiblePuntuacion()/vecinos[i].getDistancia();
						mejorCelda = vecinos[i];
					}		
				}
			}
			
			
			// Si no puede seguir, retorna ya el laberinto sin solucionar
			if(mejorCelda!=null){
				listaCeldas[indiceListaCeldas] = mejorCelda;
				solucio.laberinto[actualX][actualY].setOperacion("N"); solucio.laberinto[actualX][actualY].setNumero(0);
				actualX = mejorCelda.getEjeX(); actualY = mejorCelda.getEjeY();
			}
			else{
				return vector2matriz (listaCeldas, indiceListaCeldas);
			}
			
			indiceListaCeldas++;		
			
		}
		return vector2matriz(listaCeldas,indiceListaCeldas);
	}
	
	/**
	 * Metodo de busqueda exhaustiva de todos los camninos, para cuando se encuentra uno
	 * @return - Matriz con el camino encontrado/no encontrado
	 */
	public Laberinto cercaExhaustiva () {
		int actualX = entradaX; int actualY = entradaY;
		int puntos = 1;
		this.tamCamino = 1;
		boolean encontrado = false;
		
		CeldaVecina[] listaCeldas = new CeldaVecina[rows*columns];
		listaCeldas[0] = new CeldaVecina(laberinto[actualX][actualY].copia(), actualX, actualY,laberinto[actualX][actualY].operacion(puntos),distanciaAlFinal(actualX,actualY,salidaX,salidaY)); 
		puntos = laberinto[entradaX][entradaY].operacion(puntos);
		
		boolean[][] lugaresVisitados = new boolean[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				lugaresVisitados[i][j] = false;
			}
		}
		 
		lugaresVisitados[actualX][actualY] = true;
		
		// Vecinos N, E, S, O 
		// Vecino N
		if((actualX-1) >= 0 && !laberinto[actualX-1][actualY].getOperacion().equalsIgnoreCase("N") && puntos > 0 && !encontrado){
			encontrado = cercaExhaustivaRec(actualX-1, actualY, listaCeldas, puntos, lugaresVisitados);
		}
		// Vecino E
		if((actualY+1) < columns && !laberinto[actualX][actualY+1].getOperacion().equalsIgnoreCase("N") && puntos > 0 && !encontrado){
			tamCamino = 1;
			encontrado = cercaExhaustivaRec(actualX, actualY+1, listaCeldas, puntos, lugaresVisitados);
		}
		// Vecino S
		if((actualX+1) < rows && !laberinto[actualX+1][actualY].getOperacion().equalsIgnoreCase("N") && puntos > 0 && !encontrado){
			tamCamino = 1;
			encontrado = cercaExhaustivaRec(actualX+1, actualY, listaCeldas, puntos, lugaresVisitados);
		}
		// Vecino O
		if((actualY-1) >=0 && !laberinto[actualX][actualY-1].getOperacion().equalsIgnoreCase("N") && puntos > 0 && !encontrado){
			tamCamino = 1;
			encontrado = cercaExhaustivaRec(actualX, actualY-1, listaCeldas, puntos, lugaresVisitados);
		}
		
		return vector2matriz (listaCeldas, this.tamCamino);	
	}
	
	/**
	 * Recursividad para encontrar la salida
	 * @param actualX - posicion actual x
	 * @param actualY - posicion actual y
	 * @param opcionActual - camino a la salida 
	 * @param puntos - puntos en cada posicion
	 * @param lugaresVisitados - matriz booleana de lugares visitados
	 * @return boolean si encontrado
	 */
	private boolean cercaExhaustivaRec(int actualX, int actualY, CeldaVecina[] opcionActual, int puntos, boolean[][] lugaresVisitados) {
		
		boolean encontrado = false;
		
		// Si hemos llegado al final, se acaba
		if((this.salidaX==actualX) && (this.salidaY == actualY)){
			
			opcionActual[this.tamCamino]= new CeldaVecina(laberinto[actualX][actualY].copia(), actualX, actualY, laberinto[actualX][actualY].operacion(puntos), distanciaAlFinal(actualX, actualY, this.salidaX, this.salidaY));
			return true;
			
		} 
		else { // Anadir esta posicion al camino
			
			lugaresVisitados[actualX][actualY]=true;
			puntos = laberinto[actualX][actualY].operacion(puntos);
			opcionActual[this.tamCamino]= new CeldaVecina(laberinto[actualX][actualY].copia(), actualX, actualY, puntos, distanciaAlFinal(actualX, actualY, this.salidaX, this.salidaY));
		
		}
		
		
		if(puntos > 0){
			// Vecinos N, E, S, O
			// Vecino N
			if((actualX-1) >= 0 && !laberinto[actualX-1][actualY].getOperacion().equals("N") && !lugaresVisitados[actualX-1][actualY]){
				tamCamino++;
				encontrado = cercaExhaustivaRec(actualX-1, actualY, opcionActual, puntos, lugaresVisitados);
			}
			// Vecino E
			if((actualY+1) < columns && !laberinto[actualX][actualY+1].getOperacion().equals("N")&& !lugaresVisitados[actualX][actualY+1] && !encontrado){
				tamCamino++;
				encontrado = cercaExhaustivaRec(actualX, actualY+1, opcionActual, puntos, lugaresVisitados);
			}
			// Vecino S
			if((actualX+1) < rows && !laberinto[actualX+1][actualY].getOperacion().equals("N")&& !lugaresVisitados[actualX+1][actualY] && !encontrado){
				tamCamino++;
				encontrado = cercaExhaustivaRec(actualX+1, actualY, opcionActual, puntos, lugaresVisitados);
			}
			// Vecino O
			if((actualY-1) >=0 && !laberinto[actualX][actualY-1].getOperacion().equals("N")&& !lugaresVisitados[actualX][actualY-1] && !encontrado){
				tamCamino++;
				encontrado = cercaExhaustivaRec(actualX, actualY-1, opcionActual, puntos, lugaresVisitados);
			}
		}
		if (!encontrado) {
			tamCamino--;
		}
		return encontrado;
	}
	
	/**
	 * Funcion para pasar el camino que nos lleva a la salida a una matriz
	 * @param cami - camino hacia la salida
	 * @param tamCamino - tamano del camino
	 * @return Laberinto
	 */
	public Laberinto vector2matriz(CeldaVecina[] cami, int tamCamino){
	    Laberinto solucio = new Laberinto(rows, columns, entradaX, entradaY, salidaX, salidaY).copia();
	    Celda[][] matriz = new Celda[rows][columns];
	 
	    for(int i = 0; i < rows; i++){
	        for(int j = 0; j < columns; j++){
	    		matriz[i][j] = new Celda("N",0);
	        }
	    }
	    
	    matriz[entradaX][entradaY] = laberinto[entradaX][entradaY];
	    matriz[salidaX][salidaY] = laberinto[salidaX][salidaY];
	    
	    for(int i = 0; i < tamCamino; i++){
	        matriz[cami[i].getEjeX()][cami[i].getEjeY()] = cami[i].getCeldaVecina();
	    }
	    
	    solucio.anadirCeldas(matriz);
	    return solucio;
	}
	
	/**
	 * Copia de los datos de Laberinto
	 * @return Laberinto
	 */
	public Laberinto copia() {
		return new Laberinto (rows, columns, entradaX, entradaY, salidaX, salidaY);
	}
	
	public String toString () {
		String aux = "";
		
		aux += "Entrada: " +laberinto[entradaX][entradaY].getOperacion()+laberinto[entradaX][entradaY].getNumero()+ "(" +entradaX+ ", " +entradaY+ ")";
		aux += " Salida: "+laberinto[salidaX][salidaY].getOperacion()+laberinto[salidaX][salidaY].getNumero()+ "(" +salidaX+ ", " +salidaY+ ")\n";
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				aux += laberinto[i][j].toString()+ " ";
			}
			aux += "\n";
		}
		return aux;
	}
}
