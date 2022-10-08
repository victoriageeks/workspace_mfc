package EstructuresDades;

public abstract class ConjuntEnters implements TADConjuntEnters {
	protected int[] enters;
	protected int numElem;
	
	public ConjuntEnters(int num) {
		enters=new int[num];
		numElem=0;
	}
	
	public boolean ple(){
		return(numElem==enters.length);
	}
	
	public int numElems() {
		return(numElem);
	}	
}
