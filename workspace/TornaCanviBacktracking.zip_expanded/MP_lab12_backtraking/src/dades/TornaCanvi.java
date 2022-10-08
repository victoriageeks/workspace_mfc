package dades;

public class TornaCanvi {

	private double[] valorMonedes;
	private int[] numMonedes;
	private int[][] tots;
	int[] result;
	private int nResults = 0;

	public TornaCanvi(double[] valorMonedes, int[] monedes) {
		this.valorMonedes = new double[valorMonedes.length];
		for (int i = 0; i < valorMonedes.length; i++)
			this.valorMonedes[i] = valorMonedes[i];
		this.numMonedes = new int[monedes.length];
		for (int i = 0; i < monedes.length; i++)
			this.numMonedes[i] = monedes[i];
	}

	/**
	 * Torno el canvi per l'import indicat
	 * 
	 * @param importAtornar import del canvi a tornar
	 * @return llista de monedes que he d'utilitzar per tornar el canvi
	 * @throws IOException 
	 */
	public int[][] tornarCanviBack(double importAtornar){

		
		nResults = 0;
		tots = new int[100][numMonedes.length];		// Limitem a 100 els resultats? es podria ampliar si ens quedem curts...
		result = new int[numMonedes.length];
		assignacio(0, importAtornar);
		
		if (nResults == 0)
			return null;
		else
			return tots;
	}

	private void assignacio(int posMoneda, double importAtornar)  {
		result[posMoneda] = 0;
		while (result[posMoneda] <= numMonedes[posMoneda]) {
			if (esFactible(importAtornar)) {
				if (posMoneda < valorMonedes.length - 1) {
					assignacio(posMoneda + 1, importAtornar);
					result[posMoneda + 1] = 0;
				} else {
					if (esSolucio(importAtornar, result)) {
						guardaSolucioActual();
						nResults++;
					}
				}
			}
			result[posMoneda]++;
		}
	}

	private void guardaSolucioActual() {
		if (nResults < 100) {
			for (int i = 0; i < numMonedes.length; i++) {
				tots[nResults][i] = result[i];
			}
		}
		// opcionalment podem ampliar la taula de resultats
	}

	private boolean esFactible(double importAtornar) {
		double valor = 0;

		for (int i = 0; i < numMonedes.length; i++) {
			valor = valor + result[i] * valorMonedes[i];
		}

		return (valor <= importAtornar);
	}

	public boolean esSolucio(double importAtornar, int[] result) {
		double sumaMonedes = 0.0;
		for (int i = 0; i < result.length; i++) {
			sumaMonedes = sumaMonedes + valorMonedes[i] * result[i];
		}
		return (sumaMonedes == importAtornar);
	}

}
