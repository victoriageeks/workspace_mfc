package Patterns;

import Actores.*;

public class NodoObserver {
	
	private ActorInstance actor;
	private int sendMessages;
	
	public NodoObserver (ActorInstance actor, int sendMessages) {
		this.actor = actor;
		this.sendMessages = sendMessages;
	}

	public ActorInstance getActor() {
		return actor;
	}

	public void setActor(ActorInstance actor) {
		this.actor = actor;
	}

	public int getSendMessages() {
		return sendMessages;
	}

	public void setSendMessages(int sendMessages) {
		this.sendMessages = sendMessages;
	}
}
