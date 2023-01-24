package Actores;

import java.util.LinkedList;
import java.util.concurrent.*;
import Messages.*;
import Patterns.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class HelloWorldActor implements ActorInstance{

	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();
	private LinkedList<Observer> listObservers = new LinkedList<Observer>();

	private boolean exitThread = false;
	
	String name = "";
	
	// receives a message
	public void sendToQueue(ActorInstance sender, InterfaceMessage message) {
		try {
			queueMessage.put(message);
			if (sender == null) {
				queueSenders.put(new HelloWorldActor());
			}
			else
			{
				queueSenders.put(sender);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void send(InterfaceMessage message) {}
	
	// writes it in System.out.
	@Override
	public void processMessage() {
		try {
			InterfaceMessage message = queueMessage.take();
			notifySubscrib(ActorListener.RECEIVED, message);

			queueSenders.take();
			if (message != null) { 
				if (message instanceof QuitMessage) {
					exitThread = true;
				}
				else
				{
					System.out.println(((Message)message).getMessage());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			notifySubscrib(ActorListener.CREATION, new QuitMessage());
			while (!exitThread) {
				processMessage();
			}
			notifySubscrib(ActorListener.FINALIZATION, new QuitMessage());
		}
		catch (Exception e) {
			notifySubscrib(ActorListener.INCORRECT_FINALIZATION, new QuitMessage());
            throw new RuntimeException(e);
		}
	}

	@Override
	public void subscrib(Observer observer) { 
		if(!listObservers.contains(observer)) {
			listObservers.add(observer);
		}
	}

	@Override
	public void unsubscrib(Observer observer) {
		 if(listObservers.contains(observer)) {
			 listObservers.remove(observer);
         }
	}

	@Override
	public void notifySubscrib(ActorListener actions, InterfaceMessage message) {
		 
		boolean found = false;
		ActorContext context = ActorContext.getInstance();
		String[] names = context.getNames();
		
		for (int i = 0; i < names.length && !found; i++) {
			if (this == context.lookUp(names[i]).getActor().getActor()) {
				name = context.lookUp(names[i]).getName();
				found = true;
			}
		}
		
		for(Observer o : listObservers){
            o.update(name, actions, message);
        }
	}

	@Override
	public ActorInstance getActor() {
		// TODO Auto-generated method stub
		return this;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
