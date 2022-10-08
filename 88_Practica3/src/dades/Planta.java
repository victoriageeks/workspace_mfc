package dades;
/**
 * @author mario and ismael and edgar
 */
public abstract class Planta implements InterfacePlanta{

	private String name;
	
	public Planta(String name) {
		this.name=name;
	}
	
	public int getAbsortion(int age) {
		return 0;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Planta [name=" + name + "]";
	}

}
