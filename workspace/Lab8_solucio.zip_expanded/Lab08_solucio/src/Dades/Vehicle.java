package Dades;

public abstract class Vehicle {
	protected String matricula;
	private int numRodes;
	
	protected Vehicle(String matricula) {
		this.matricula=matricula;
		numRodes=4;
	}
	
	protected Vehicle(String matricula, int nRodes) {
		this.matricula=matricula;
		numRodes=nRodes;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getNumRodes() {
		return numRodes;
	}

	public void setNumRodes(int numRodes) {
		this.numRodes = numRodes;
	}
	
	@Override
	public String toString() {
		return "Vehicle => matricula: "+matricula+" numRodes "+numRodes;
	}
	
	public abstract double taxaIMV();
	
	//public abstract void jajas ();
	
	
}
