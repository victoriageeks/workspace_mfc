package Messages;

import Actores.ActorInstance;

public class Message implements InterfaceMessage{
	private ActorInstance sender;
	private String message;
	
	/* a Message includes a from field which is an Actor reference 
	   (used to reply to that actor) and a text message (String) */
	public Message (ActorInstance sender, String message) {
		this.sender = sender;
		this.message = message;
	}

	public ActorInstance getSender() {
		return sender;
	}

	public void setSender(ActorInstance sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
