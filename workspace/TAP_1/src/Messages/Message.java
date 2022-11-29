package Messages;

import Actores.Actor;

public class Message {
	private Actor sender;
	private String message;
	
	public Message (Actor sender, String message) {
		this.sender = sender;
		this.message = message;
	}

	public Actor getSender() {
		return sender;
	}

	public void setSender(Actor sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
