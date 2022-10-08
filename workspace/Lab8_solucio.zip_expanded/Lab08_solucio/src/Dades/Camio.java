package Dades;

public class Camio extends Vehicle {
	protected int carregaUtil;
	
	public Camio(String matricula, int carrega) {
		super(matricula,8);
		//setNumRodes(8);
		this.carregaUtil=carrega;
	}
	
	public int getCarregaUtil() {
		return carregaUtil;
	}

	public void setCarregaUtil(int carregaUtil) {
		this.carregaUtil = carregaUtil;
	}

	@Override
	public String toString() {
		return "Camio => "+super.toString()+" carregaUtil: "+carregaUtil;
	}
	
	public double taxaIMV() {
		double preu;
		if (carregaUtil<1000)
			preu=60;
		else if (carregaUtil<3000)
			preu=200;
		else preu=350;
		
		return preu;
	}
}
