package Dades;

public class Autobus extends Vehicle {
	private int nPlaces;
	
	public Autobus(String matricula, int nPlaces) {
		super(matricula);
		this.nPlaces=nPlaces;
	}
	
	@Override
	public String toString() {
		return "Autobus => "+super.toString()+" nPlaces: "+nPlaces;
	}
	
	public double taxaIMV() {
		double preu;
		if (nPlaces<21)
			preu=93;
		else if (nPlaces<50)
			preu=117;
		else preu=234;
		
		return preu;
	}
}
