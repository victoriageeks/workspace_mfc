package Exceptions;

public class jaExisteix extends Exception {
	private static final long serialVersionUID = 1L;

	public jaExisteix(int e){
		super("AVIS : El valor "+e+" ja existeix al conjunt");
	}

}
