package Actores;
import java.util.concurrent.*;

import Messages.Message;
public class HelloWorldActor implements Actor{

	private BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
	
	public void sendToQueue(Message message) {
		try {
			queue.put(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void processMessage() {
		Message message = queue.poll();
		if (message != null) { 
			System.out.println(message.getMessage());
		}
		
		
	}
	@Override
	public void run() {
		while (true) {
			processMessage();
		}
	}


	

}
