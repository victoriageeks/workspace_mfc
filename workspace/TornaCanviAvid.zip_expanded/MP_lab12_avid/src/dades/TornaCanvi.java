package dades;

public class TornaCanvi {
	
	private double[] valorMonedes;
	private int[] numMonedes;
	
	public TornaCanvi(double[] valorMonedes, int[] monedes) {
		this.valorMonedes=new double[valorMonedes.length];
		for (int i=0; i<valorMonedes.length; i++)
			this.valorMonedes[i]=valorMonedes[i];
		this.numMonedes=new int[monedes.length];
		for (int i=0; i<monedes.length; i++)
			this.numMonedes[i]=monedes[i];
	}

	/**
	 * Torno el canvi per l'import indicat
	 * 
	 * @param importAtornar import del canvi a tornar
	 * @return llista de monedes que he d'utilitzar per tornar el canvi
	 */
	public int[] tornarCanviAvid(double importAtornar) {
		int pos = numMonedes.length - 1;
		int[] resultat = new int[numMonedes.length];
		boolean canviComplert = false;
		for (int i = 0; i < resultat.length; i++) {
			resultat[i] = 0;
		}
		if (canviDisponible() >= importAtornar) {
			while (!canviComplert && pos >= 0) {
				// si hi ha monedes i el seu valor es mes petit o igual que el cost a
				// retornar...
				if (numMonedes[pos] > 0 && importAtornar >= valorMonedes[pos]) {
					// incremento en 1 que torno el canvi utilitzant la moneda de la posició pos
					resultat[pos]++;
					// actualitzo les monedes que em queden
					numMonedes[pos]--;
					// actualitzo l'import a tornar
					importAtornar = importAtornar - valorMonedes[pos];
					if (importAtornar == 0)
						canviComplert = true;
				} else {
					pos--; // busco amb monedes de valor inferior
				}
			}
		}
		if (canviComplert) {
			return resultat;
		}
		else {
			// no puc tornar canvi per tant, restauro les monedes que he anat treien per calcular el resultat
			for (int i=0; i<resultat.length; i++)
				numMonedes[i]=numMonedes[i]+resultat[i];
			return null;
		}
	}
	
	
	
	/**
	 * Calculo el canvi total que tinc disponible
	 *
	 * @return total import de les monedes disponibles, serà el màxim que podré tornar
	 */
	public double canviDisponible() {
		double sumaMonedes = 0.0;
		for (int i = 0; i < numMonedes.length; i++) {
			sumaMonedes = sumaMonedes + valorMonedes[i] * numMonedes[i];
		}
		return sumaMonedes;
	}
	
	
}
