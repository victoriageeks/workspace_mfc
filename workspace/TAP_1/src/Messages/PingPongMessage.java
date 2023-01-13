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
	
	public void setSender(ActorInstance sender) {
		this.sender = sender;
	}

	@Override
	public ActorInstance getSender() {
		return sender;
	}
}
