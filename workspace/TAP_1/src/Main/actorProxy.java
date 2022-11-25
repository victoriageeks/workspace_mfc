package Main;

import java.util.Queue;

public class actorProxy implements Actor{
	private String actorName;
	private Queue<Message> messageQueue; // cola para encolar las respuestas
	
	public actorProxy (String actorName) {
		this.actorName = actorName;
	}
	
	@Override
	public void send (Message message) {
		
	}
	
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}
	

}
