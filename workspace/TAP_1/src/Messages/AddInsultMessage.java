package Messages;

import Actores.ActorInstance;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class AddInsultMessage implements InterfaceMessage{
	
	String message;
	private ActorInstance sender;
	
	/**
	 * Constructor de AddInsultMessage
	 * @param message
	 */
	public AddInsultMessage(String message) {
		this.message = message;
	}
	
	@Override
	public void setSender(ActorInstance sender) {
		this.sender = sender;
	}

	@Override
	public ActorInstance getSender() {
		return sender;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
	}
}
