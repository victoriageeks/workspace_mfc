package Actores;

import Messages.Message;

public interface Actor extends Runnable{
	
	public void sendToQueue(Message message);
	public void processMessage();
}
