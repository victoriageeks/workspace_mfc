package Messages;

import java.util.LinkedList;

import Actores.ActorInstance;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class GetAllInsultsMessage implements InterfaceMessage{

	LinkedList<InterfaceMessage> insultList =  new LinkedList<>();
	private ActorInstance sender;
	
	public GetAllInsultsMessage() {}
	
	@Override
	public void setSender(ActorInstance sender) {
		this.sender = sender;
	}

	@Override
	public ActorInstance getSender() {
		return sender;
	}
	
	/**
	 * Metodo para añadir un insulto a la lista
	 * @param message
	 */
	public void add (InterfaceMessage message) {
		insultList.add(message);
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
	}
}
