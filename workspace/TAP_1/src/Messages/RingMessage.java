package Messages;

import Actores.ActorInstance;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class RingMessage implements InterfaceMessage{
	private ActorInstance sender;
	
	/**
	 * Constructor de RingMessage
	 */
	public RingMessage () {}
	
	public void setSender(ActorInstance sender) {
		this.sender = sender;
	}

	@Override
	public ActorInstance getSender() {
		return sender;
	}
}
