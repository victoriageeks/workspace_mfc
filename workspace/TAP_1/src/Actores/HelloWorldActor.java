package Actores;
import java.util.concurrent.*;

import Messages.*;
public class HelloWorldActor implements ActorInstance{

	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();

	// receives a message
	public void sendToQueue(ActorInstance actor, InterfaceMessage message) {
		try {
			queueMessage.put(message);
			if (actor != null) {
				queueSenders.put(actor);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// writes it in System.out.
	@Override
	public void processMessage() {
		InterfaceMessage message = queueMessage.poll();
		ActorInstance actor = queueSenders.poll();
		if (message != null) { 
			System.out.println(((Message)message).getMessage());
		}
	}
	
	@Override
	public void run() {
		while (true) {
			processMessage();
		}
	}

	@Override
	public void send(InterfaceMessage message) {}
}
