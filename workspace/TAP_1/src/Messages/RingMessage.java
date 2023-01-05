package Messages;

import Actores.ActorInstance;

public class RingMessage implements InterfaceMessage{
	private ActorInstance sender;
	
	public void setSender(ActorInstance sender) {
		this.sender = sender;
	}

	@Override
	public ActorInstance getSender() {
		return sender;
	}
}
