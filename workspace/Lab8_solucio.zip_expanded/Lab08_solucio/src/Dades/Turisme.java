package Dades;

public class Turisme extends Vehicle implements Cloneable {
	public int potencia;
	protected int jajajs;
	
	public Turisme(String matricula, int potencia) {
		super(matricula);
		this.potencia=potencia;
	}
	
	@Override
	public String toString() {
		return "Turisme => "+super.toString()+" potencia: "+potencia;
	}
	
	public double taxaIMV() {
		double preu;
		if (potencia<8)
			preu=55;
		else if (potencia<16)
			preu=80;
		else preu=160;
		
		return preu;
	}
	
	@Override
	public String getMatricula() {
		return "hola";
	}
	
	
	public String jajas () {
		return "ajajajaa";
	}
	
	
}
