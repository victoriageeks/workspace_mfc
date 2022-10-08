package excepcions;

public class RangTemperaturaCorrecte extends Exception {
	public RangTemperaturaCorrecte(float t) {
		super("El valor de "+t+" ha d'estar en el rang -100..20");
	}
}
