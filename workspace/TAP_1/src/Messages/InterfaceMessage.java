package Messages;

import Actores.ActorInstance;

public interface InterfaceMessage {
	public void setSender(ActorInstance sender);
	
	public ActorInstance getSender();
}
