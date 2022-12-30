package Main;
import java.lang.*;
import java.util.LinkedList;

import Actores.ActorProxy;
import Actores.HelloWorldActor;
import Actores.InsultActor;
import Messages.*;

public class Main {
	public static LinkedList<String> insultList = new LinkedList<>();

	public static void main(String[] args) {

		ActorContext actor1 = ActorContext.getInstance();
		ActorProxy hello = actor1.spawnActor("name1", new HelloWorldActor());
		hello.send(new Message(null, "Hello World"));
		
		ActorContext actor2 = ActorContext.getInstance();
		ActorProxy insult = actor2.spawnActor("name2", new InsultActor());
		insult.send(new AddInsultMessage("gilipollas"));
		insult.send(new GetInsultMessage());
		Message result = insult.receive();
		System.out.println(result.getMessage());
		
		/*ActorContext actor1 = ActorContext.getInstance();
		ActorProxy receptor = actor1.spawnActor("Marc", new HelloWorldActor());
		receptor.sendToQueue(new Message(null, "Hello world main1."));
		receptor.sendToQueue(new Message(null, "Hello world main2."));
		
		ActorProxy enviador1 = actor1.spawnActor("Joel", new HelloWorldActor());
		
		ActorProxy enviador2 = actor1.spawnActor("achis", new HelloWorldActor());

		receptor.sendToQueue(new Message(enviador1, "Hello world enviador 1"));
		receptor.sendToQueue(new Message(enviador2, "Hello world enviador 2"));
		
		
		ActorProxy insult = actor1.spawnActor("insultador", new InsultActor());
		insult.sendToQueue(getInsultMessage());*/
		
		
	}
	
	private static Message getInsultMessage() {
		Message message = new Message(null, null);
		
		int random = (int)(Math.random()*50+1);
		random = random % insultList.size();
		message.setMessage(insultList.get(random));
		
		return message;
	}
		
}
