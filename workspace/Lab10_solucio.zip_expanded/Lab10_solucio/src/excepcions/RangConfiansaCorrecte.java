package excepcions;

public class RangConfiansaCorrecte extends Exception {
	public RangConfiansaCorrecte() {
		super("El valor de confiança ha d'estar en el rang 0..100");
	}
}
