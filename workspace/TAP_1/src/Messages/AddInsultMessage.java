package Messages;

import Actores.ActorInstance;

public class AddInsultMessage implements InterfaceMessage{
	
	String message;
	private ActorInstance sender;
	
	public AddInsultMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public void setSender(ActorInstance sender) {
		this.sender = sender;
		
	}

	@Override
	public ActorInstance getSender() {
		return sender;
	}

}
