package Main;

import java.util.Queue;

import Actores.Actor;
import Messages.Message;

public class actorProxy implements Actor{
	private Actor actor;
	private Queue<Message> messageQueue; // cola para encolar las respuestas
	
	public actorProxy (Actor actor) {
		this.actor = actor;
	}
	

	
	@Override
	public void sendToQueue(Message message) {
		actor.sendToQueue(message);
		
	}

	@Override
	public void processMessage() {
		
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

}
