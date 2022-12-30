package Actores;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import Messages.*;

public class InsultActor implements ActorInstance{
	private LinkedList<String> insultList = new LinkedList<>();
	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();

	// receives a message
	public void sendToQueue(ActorInstance sender, InterfaceMessage message) {
		try {
			queueMessage.put(message);
			queueSenders.put(sender);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// accepting three messages
	@Override
	public void processMessage() {
		InterfaceMessage message = queueMessage.poll();
		ActorInstance actor = queueSenders.poll();
	 
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
			
			InterfaceMessage newMessage = new Message (actor, randomMessage);
			send(newMessage);
		}
		else if (message instanceof GetAllInsultsMessage) { 
			
		}
	}
	
	@Override
	public void run() {
		while (true) {
			processMessage();
		}
	}

	@Override
	public void send(InterfaceMessage message) {
		ActorInstance actor = ((Message)message).getSender();
		actor.send(message);
		
	}

}


/*public Message getInsultMessage() {
Message message = new Message(null, null);

int random = (int)(Math.random()*50+1);
random = random % insultList.size();
message.setMessage(insultList.get(random));

return message;
}

public void addInsultMessage(String insult) {
insultList.add(insult);

}


public LinkedList<String> getAllInsultsMessage() {
return insultList;
}*/