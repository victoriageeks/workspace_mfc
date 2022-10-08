/**
 * Classe Data amb diferents metodes.
 * 
 * @author Joel Lacambra i Marc Fonseca
 *
 */
package Dades;


public class Data {
	
	private int dia, mes, any, hora;
	
	/**
	 * Constructor per defecte, comprova si la data introduida es correcta comprovant els rangs.
	 * Tambe, comprovant els anys de traspas. 
	 * Si la data es incorrecta, es posara una predeterminada.
	 * @param dia 
	 * @param mes
	 * @param any
	 * @param hora
	 */
	public Data (int dia, int mes, int any, int hora) {
		if (esDataCorrecta(dia, mes, any, hora)) { 
			this.dia = dia;
			this.mes = mes;
			this.any = any;
			this.hora = hora;
		} else { 
			this.dia = 1;
			this.mes = 1;
			this.any = 2000;
			this.hora = 10;
		}
	}

	/**
	 * Getter
	 * @return dia de la data
	 */
	public int getDia() {
		return dia;
	}
    
	/**
     * Setter
     * @param x
     */
    public void setDia(int x){
        dia = x;
    }

	/**
	 * Getter
	 * @return mes de la data
	 */
	public int getMes() {
		return mes;
	}

    /**
     * Setter
     * @param x
     */
	public void setMEs(int x){
        mes = x;
    }

	/**
	 * Getter
	 * @return any de la data
	 */
	public int getAny() {
		return any;
	}

    /**
     * Setter
     * @param x
     */
    public void setAny(int x){
        any = x;
    }

    /**
     * Getter
     * @return hora de la data
     */
    public int getHora(){
        return hora;
    }

    /**
     * Setter
     * @param x
     */
    public void setHora(int x){
        hora = x;
    }
    
	
	/**
	 * Comprova si la data introduida es correcta, crida a un altre metode per comprovar si es any traspas.
	 * @param dia
	 * @param mes
	 * @param any
	 * @param hora
	 * @return Si tot correcte, true.
	 */
	private static boolean esDataCorrecta(int dia, int mes, int any, int hora) {
		boolean hoEs = true;
		if (dia < 1 || dia > 31) { 
			hoEs = false;
		}
		if (mes < 1 || mes > 12) { 
			hoEs = false;
		}
		if (dia > diesMes(mes, any)) { 
			hoEs = false;
		}
		if (hora < 0 || hora > 23) {
			hoEs = false;
		}
		return hoEs;
	}
	/**
	 * Metode que comprova si es any traspas.
	 * @param any
	 * @return Si ho es, true.
	 */
	private static boolean esAnyTraspas(int any) {  
		if ((any % 4 == 0) && ((any % 100 != 0) || (any % 400 == 0))) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Metode que comprova si es any traspas, que els dies de febrer siguin correctes. 
	 * Altres comprovacions normals.
	 * @param mes
	 * @param any
	 * @return
	 */
	private static int diesMes(int mes, int any) { 
		int diesMes;
		if (mes == 2) {
			if (esAnyTraspas(any)) {
				diesMes = 29;
			} else {
				diesMes = 28;
			}
		} else {
			if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				diesMes = 30;
			} else {
				diesMes = 31;
			}
		}
		return diesMes;
	}
	
	/**
	 * Metode que comprova si la data de la instancia i la introduida per parametre es igual.
	 * @param data - data sencera.
	 * @return si tot es igual, true.
	 */
	public boolean esIgual(Data data) {
		if (this.dia == data.getDia() && this.mes == data.getMes() && this.any == data.getAny()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metode que calcula el dia seguent de la instancia actual.
	 */
	public void diaSeguent() {
		this.dia++;
		if (this.dia > diesMes(this.mes, this.any)) {
			this.dia = 1;
			this.mes++;
			if (this.mes > 12) {
				this.mes = 1;
				this.any++;
			}
		}
	}

	/**
	 * Metode que calcula el dia anterior de la instancia actual.
	 */
	public void diaAnterior() {
		this.dia--;
		if (this.dia < 1) {
			this.mes--;
			if (this.mes < 1) {
				this.mes = 12;
				this.any--;
			}
			this.dia = diesMes(this.mes, this.any);
		}
	}
	
	/**
	 * Metode que comprova si la data actual es inferior a la que es passa per parametre.
	 * @param nova - data que es passa per parametre.
	 * @return Si data inferior, true.
	 */
	public boolean esDataInferiorOigual(Data nova) {
	      boolean esInferior; 
	      if (any<nova.any) esInferior=true;
	      else if (any>nova.any) esInferior=false;
	      else {
	    	 if (mes<nova.mes) esInferior=true;
	    	 else if (mes>nova.mes) esInferior=false;
	    	 else {
	    		 if (dia<nova.dia) esInferior=true;
	    		 else if (dia>nova.dia) esInferior=false;
	    		 else {
	    			 if (hora<=nova.hora) esInferior=true;
	    			 else esInferior=false;
	    		 }
	    	 }		
	      }
		  return esInferior; 

	  }
	
	/**
	 * Metode que calcula els dias que falten per arriba a la data que es passa per parametre. 
	 * @param data -  data que es passa per parametre.
	 * @return si la data passada per parametre es superior a la de la instancia, es crida a un altre metode per contar
	 * el dies. 
	 * Si es inferior retorna -1.
	 */
	public int numDiesAData(Data data) { 
		Data dataTemp;
		int contador;
		
		dataTemp = new Data(dia, mes, any, hora);
		if (dataTemp.esDataInferiorOigual(data)) {
			contador = 0;
			while (!dataTemp.esIgual(data)) {
				dataTemp.diaSeguent();
				contador++;
			}
		} else
			contador = -1;
		return contador;
	}

	@Override
	public String toString() {
		return dia +"/"+  mes +"/"+ any +" a les " + hora + "h";
	}
	
	

}
