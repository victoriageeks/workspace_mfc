package Messages;

import Actores.ActorInstance;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class QuitMessage implements InterfaceMessage {
	private ActorInstance sender;
	
	/**
	 * Constructor de QuitMessage
	 */
	public QuitMessage () {}
	
	@Override
	public void setSender(ActorInstance sender) {
		this.sender = sender;
	}

	@Override
	public ActorInstance getSender() {
		return sender;
	}
}
