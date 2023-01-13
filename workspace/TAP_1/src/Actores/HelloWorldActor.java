package Actores;
import java.util.concurrent.*;
import Messages.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class HelloWorldActor implements ActorInstance{

	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();
	private boolean exitThread = false;

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
		while (!exitThread) {
			processMessage();
		}
	}
}
