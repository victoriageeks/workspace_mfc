package Messages;

import java.util.LinkedList;

import Actores.ActorInstance;

public class GetAllInsultsMessage implements InterfaceMessage{

	LinkedList<InterfaceMessage> insultList =  new LinkedList<>();
	private ActorInstance sender;

	public GetAllInsultsMessage() {
		
	}
	
	public void add (InterfaceMessage message) {
		insultList.add(message);
	}

	@Override
	public void setSender(ActorInstance sender) {
		this.sender = sender;
		
	}

	@Override
	public ActorInstance getSender() {
		return sender;
	}

	
}
