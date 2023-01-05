package Actores;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import Messages.*;

public class InsultActor implements ActorInstance{
	private LinkedList<String> insultList = new LinkedList<>();
	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();
	private boolean exitThread = false;

	// receives a message
	public void sendToQueue(ActorInstance proxy, InterfaceMessage message) {
		try {
			queueMessage.put(message);
			queueSenders.put(proxy);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// accepting three messages
	@Override
	public void processMessage() {
		try {
			InterfaceMessage message = queueMessage.take();
			ActorInstance sender = queueSenders.take();
		 
			/* a list of insults, that can be extended using the AddInsultMessage */
			if (message instanceof AddInsultMessage) { 
				insultList.add(((AddInsultMessage)message).getMessage());
			}
			/* GetInsultMessage will return a random insult in a 
			   Message to the requesting Actor or Proxy entity */
			else if (message instanceof GetInsultMessage) {
				int random = (int)(Math.random()*50+1);
				random = random % insultList.size();
				String randomMessage = insultList.get(random);
				
				InterfaceMessage newMessage = new Message (sender, randomMessage);
				send(newMessage);
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
		while (!exitThread) {
			processMessage();
		}
	}

	@Override
	public void send(InterfaceMessage message) {
		ActorInstance sender = ((Message)message).getSender();
		sender.sendToQueue(sender, message);
		
	}

}