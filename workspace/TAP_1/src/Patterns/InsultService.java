package Patterns;

import java.util.LinkedList;

import Messages.InterfaceMessage;

public interface InsultService {
	 
	public void addInsult(InterfaceMessage insult);
	
	public InterfaceMessage getInsult();
	
	public LinkedList<String> getAllInsults();
}
