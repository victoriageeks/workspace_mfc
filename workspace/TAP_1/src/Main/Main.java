package Main;
import java.lang.*;
import java.util.LinkedList;

import Actores.HelloWorldActor;
import Actores.InsultActor;
import Messages.Message;

public class Main {
	public static LinkedList<String> insultList = new LinkedList<>();

	public static void main(String[] args) {

		actorContext actor1 = actorContext.getInstance();
		actorProxy receptor = actor1.spawnActor("Marc", new HelloWorldActor());
		receptor.sendToQueue(new Message(null, "Hello world main1."));
		receptor.sendToQueue(new Message(null, "Hello world main2."));
		
		actorProxy enviador1 = actor1.spawnActor("Joel", new HelloWorldActor());
		
		actorProxy enviador2 = actor1.spawnActor("achis", new HelloWorldActor());

		receptor.sendToQueue(new Message(enviador1, "Hello world enviador 1"));
		receptor.sendToQueue(new Message(enviador2, "Hello world enviador 2"));
		
		
		actorProxy insult = actor1.spawnActor("insultador", new InsultActor());
		insult.sendToQueue(getInsultMessage());
		
		
	}
	
	private static Message getInsultMessage() {
		Message message = new Message(null, null);
		
		int random = (int)(Math.random()*50+1);
		random = random % insultList.size();
		message.setMessage(insultList.get(random));
		
		return message;
	}
		
}
