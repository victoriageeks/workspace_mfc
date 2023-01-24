package Messages;

import Actores.ActorInstance;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class Message implements InterfaceMessage{
	private ActorInstance sender;
	private String message;
	
	/* a Message includes a from field which is an Actor reference 
	   (used to reply to that actor) and a text message (String) */
	/**
	 * Constructor de Message
	 * @param sender
	 * @param message
	 */
	public Message (ActorInstance sender, String message) {
		this.sender = sender;
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
		this.message = message;
	}
}
