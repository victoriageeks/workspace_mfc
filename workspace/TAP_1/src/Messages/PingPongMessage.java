package Messages;

import Actores.ActorInstance;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class PingPongMessage implements InterfaceMessage{
	private ActorInstance sender;
	
	/**
	 * Constructor de PingPongMessage
	 */
	public PingPongMessage () {}
	
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
		return "PinPongMessage";
	}
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
	}
}
