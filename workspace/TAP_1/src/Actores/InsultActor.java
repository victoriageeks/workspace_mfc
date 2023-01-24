package Actores;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import Messages.*;
import Patterns.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class InsultActor implements ActorInstance{
	private LinkedList<String> insultList = new LinkedList<>();
	private LinkedList<Observer> listObservers = new LinkedList<Observer>();

	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();
	
	private boolean exitThread = false;
	String name = "";

	// receives a message
	public void sendToQueue(ActorInstance proxy, InterfaceMessage message) {
		try {
			queueMessage.put(message);
			queueSenders.put(proxy);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void send(InterfaceMessage message) {
		ActorInstance sender = ((Message)message).getSender();
		sender.sendToQueue(sender, message);
		
	}
	
	// accepting three messages
	@Override
	public void processMessage() {
		try {
			InterfaceMessage message = queueMessage.take();
			ActorInstance sender = queueSenders.take();
			notifySubscrib(ActorListener.RECEIVED, message);

			/* a list of insults, that can be extended using the AddInsultMessage */
			if (message instanceof AddInsultMessage) { 
				insultList.add(((AddInsultMessage)message).getMessage());
			}
			/* GetInsultMessage will return a random insult in a 
			   Message to the requesting Actor or Proxy entity */
			else if (message instanceof GetInsultMessage) {
				int random = (int)(Math.random()*50+1);
				if (insultList.size() == 0){
					InterfaceMessage newMessage = new Message (sender, "");
					send(newMessage);
					notifySubscrib(ActorListener.SEND, message);
				}
				else{
					random = random % insultList.size();
					String randomMessage = insultList.get(random);
				
					InterfaceMessage newMessage = new Message (sender, randomMessage);
					send(newMessage);
					notifySubscrib(ActorListener.SEND, message);
				}
				
			}
			else if (message instanceof GetAllInsultsMessage) { 
				
				System.out.println("List of insults:");
				for (int i = 0; i < insultList.size(); i++)
				{
					System.out.println("\t" + ++i + ". " + insultList.get(--i));
				}
			}
			/* A QuitMessage forces the Actor to stop running */
			else if (message instanceof QuitMessage) {
				exitThread = true;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			try {
				Thread.sleep(500); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
			if (this == context.lookUp(names[i]).getActor()) {
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