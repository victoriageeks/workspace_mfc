package Patterns;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Actores.ActorInstance;
import Main.*;
import Messages.*;

public class ActorProxy implements ActorInstance{
	private ActorInstance actor;
	String name;
	
	// ActorProxy will have its own queue
	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();
	Message messageReceived = new Message (null, null);
	
	
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
		if (message instanceof RingMessage || message instanceof QuitMessage || message instanceof PingPongMessage)
		{
			processMessage();
		}
	}

	@Override
	public void processMessage() {
		try {
			InterfaceMessage message = queueMessage.take();
			ActorInstance sender = queueSenders.take();
			if (message != null) { 
				if (message instanceof Message)
				{
					messageReceived = new Message(sender, ((Message)message).getMessage());
				}
				else if (message instanceof RingMessage || message instanceof QuitMessage || message instanceof PingPongMessage) {
					send(message);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
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


	public String getName() {
		return name;
	}


	public ActorInstance getActor() {
		return actor;
	}
	
	
	@Override
	public String toString ()
	{
		return "Soy un proxy y represento a "+name;
	}
	

}
