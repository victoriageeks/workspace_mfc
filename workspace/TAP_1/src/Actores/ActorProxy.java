package Actores;

import java.util.Queue;

import Main.*;
import Messages.*;

public class ActorProxy implements ActorInstance{
	private ActorInstance actor;
	String name;
	
	// ActorProxy will have its own queue
	private Queue<InterfaceMessage> queueMessage; 
	private Queue<ActorInstance> queueSenders;
	Message messageReceived;
	
	
	public ActorProxy (ActorInstance actor, String name) {
		this.actor = actor;
		this.name = name;
	}
	

	// a method send(Message)
	@Override
	public void send (InterfaceMessage message) {
		ActorContext context = ActorContext.getInstance();
		actor.sendToQueue(context.lookUp(name), message);
	}
	
	// an Actor has methods to send messages to its queue
	/* we will extend ActorProxy to also 
	   receive messages from an Actor */
	public void sendToQueue (ActorInstance actor, InterfaceMessage message) {
		queueMessage.add(message);
		queueSenders.add(actor);
	}

	@Override
	public void processMessage() {
		InterfaceMessage message = queueMessage.poll();
		ActorInstance sender = queueSenders.poll();
		if (message != null) { 
			messageReceived = new Message(sender, ((Message)message).getMessage());
		}
		
	}
	
	public Message receive () 
	{
		processMessage();
		return messageReceived;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

}
