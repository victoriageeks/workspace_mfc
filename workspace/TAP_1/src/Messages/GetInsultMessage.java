package Messages;

import Actores.ActorInstance;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class GetInsultMessage implements InterfaceMessage{
	
	private ActorInstance sender;
	
	/**
	 * Constructor de GetInsultMessage
	 */
	public GetInsultMessage() {}

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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
	}
}
