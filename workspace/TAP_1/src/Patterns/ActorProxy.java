package Patterns;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Actores.ActorInstance;
import Main.*;
import Messages.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class ActorProxy implements ActorInstance{
	private ActorInstance actor;
	String name;
	
	// ActorProxy will have its own queue
	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();
	Message messageReceived = new Message (null, null);
	
	/**
	 * Constructor de ActorProxy
	 * @param actor
	 * @param name
	 */
	public ActorProxy (ActorInstance actor, String name) {
		this.actor = actor;
		this.name = name;
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
		
	// a method send(Message)
	@Override
	public void send (InterfaceMessage message) {
		ActorContext context = ActorContext.getInstance();
		actor.sendToQueue(context.lookUp(name), message);
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Metodo para recivir un mensaje del actor el cual representas
	 * @return - message
	 */
	public Message receive () 
	{
		processMessage();
		return messageReceived;
	}

	/**
	 * Getter del nombre del proxy
	 * @return - name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter de ActorInstance
	 * @return actor
	 */
	public ActorInstance getActor() {
		return actor;
	}
	
	@Override
	public String toString ()
	{
		return "Soy un proxy y represento a "+name;
	}

	@Override
	public void subscrib(Observer observer) {
		actor.subscrib(observer);
	}

	@Override
	public void unsubscrib(Observer observer) {
		actor.unsubscrib(observer);
	}

	@Override
	public void notifySubscrib(ActorListener actions, InterfaceMessage message) {
		// TODO Auto-generated method stub
	}
}
