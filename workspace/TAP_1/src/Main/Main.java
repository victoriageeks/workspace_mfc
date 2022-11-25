package Main;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
	
		System.out.println("Hello World Marc");
		actorContext actor1 = actorContext.getInstance();
		actorProxy hello = actor1.spawnActor(null, new HelloWorldActor());
		hello.send(new Message(null, "Hello World. :)"));
		
	}
		
}
