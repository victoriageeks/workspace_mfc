package Messages;

import java.util.function.Predicate;

import Actores.ActorInstance;

public class AddClosureMessage implements InterfaceMessage{
	Predicate<InterfaceMessage> predicate;
	public AddClosureMessage (Predicate<InterfaceMessage> predicate) {
		this.predicate = predicate;
	}
	
	@Override
	public void setSender(ActorInstance sender) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActorInstance getSender() {
		// TODO Auto-generated method stub
		return null;
	}

	public Predicate<InterfaceMessage> getPredicate() {
		return predicate;
	}


	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
	}
	
	

}
