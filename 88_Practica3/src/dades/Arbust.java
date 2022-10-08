package dades;


/**
 * @author mario and ismael
 */
public class Arbust extends Planta {
	private static int threshold=5;
	private int absortion;
	private int useless;
	
	public Arbust(String name, int absortion, int useless) {
		super(name);
		this.absortion=absortion;
		this.useless=useless;
	}

	public int getUseless() {
		return useless;
	}

	@Override
	public int getAbsortion(int age) {
		return ((age<Arbust.threshold)||(age>=useless)) ? 0 : this.absortion;
	}
	
	@Override
	public int getAbsortion() {
		return absortion;
	}

	@Override
	public String toString() {
		return "Arbust [name=" + getName() + ", absortion=" + absortion + "]";
	}
	
	@Override
	public Planta copia(){
		return new Arbust(this.getName(),this.absortion,this.useless);
	}
	
}
