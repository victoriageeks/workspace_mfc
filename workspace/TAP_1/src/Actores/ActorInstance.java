package Actores;

import Messages.*;;

public interface ActorInstance extends Runnable{
	// sens message to the defined actor
	public void send(InterfaceMessage message);
	
	// an Actor has methods to send messages to its queue
	public void sendToQueue(ActorInstance sender, InterfaceMessage message);
	
	// a process method that reacts to messages in that queue
	public void processMessage();
}
