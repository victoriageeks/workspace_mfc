package Patterns;

import Actores.ActorInstance;
import Messages.*;

public class DecoratorActor implements ActorInstance{
	
	protected ActorInstance actor;
	
	public DecoratorActor (ActorInstance actor) {
		this.actor = actor;
	}

	@Override
	public void sendToQueue(ActorInstance sender, InterfaceMessage message) {
		actor.sendToQueue(sender, message);
		
	}
	
	@Override
	public void send(InterfaceMessage message) {
		actor.send(message);
		
	}

	@Override
	public void processMessage() {
		actor.processMessage();
	}
	
	@Override
	public void run() {
		notifySubscrib(ActorListener.CREATION, null);
		while(true) {
			processMessage();
		}
	}

	public ActorInstance getActor() {
		return actor;
	}

	@Override
	public void subscrib(Observer observer) {
		actor.subscrib(observer);
	}

	@Override
	public void unsubscrib(Observer observer) {
		actor.unsubscrib(observer);
	}

	@Override
	public void notifySubscrib(ActorListener actions, InterfaceMessage message) {
		actor.notifySubscrib(actions, message);
	}
}
