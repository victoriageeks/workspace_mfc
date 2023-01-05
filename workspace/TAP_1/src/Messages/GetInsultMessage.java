package Messages;

import Actores.ActorInstance;

public class GetInsultMessage implements InterfaceMessage{
	
	private ActorInstance sender;
	public GetInsultMessage() {
	
		
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
