package excepcions;

public class Zero extends Exception {
	public Zero(String cas) {
		super("El valor de "+cas+" no pot ser zero");
	}
}
