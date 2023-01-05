package Messages;

import Actores.ActorInstance;

public class QuitMessage implements InterfaceMessage {
	private ActorInstance sender;
	
	@Override
	public void setSender(ActorInstance sender) {
		this.sender = sender;
		
	}

	@Override
	public ActorInstance getSender() {
		return sender;
	}
	
}
