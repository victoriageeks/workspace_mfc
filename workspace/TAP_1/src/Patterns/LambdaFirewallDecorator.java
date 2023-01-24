package Patterns;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Actores.*;
import Messages.*;
/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class LambdaFirewallDecorator extends DecoratorActor{

	private LinkedList<Predicate<InterfaceMessage>> listPredicate = new LinkedList<Predicate<InterfaceMessage>>();

	public LambdaFirewallDecorator(ActorInstance actor, Predicate<InterfaceMessage> predicate) {
		super(actor);
		listPredicate.add(predicate);
	}
	
	@Override
	public void sendToQueue(ActorInstance sender, InterfaceMessage message) {
		if (message instanceof AddClosureMessage) {
			listPredicate.add(((AddClosureMessage)message).getPredicate());
		}
		else {
			if (listPredicate.stream().filter(x -> x.test(message)).collect(Collectors.toList()).size() == listPredicate.size()) {
				super.sendToQueue(sender, message);
			}
			else {
				System.out.println("El mensage '"+ message.getMessage() + "' no cumple el filtro.");
			}
		}
	}	
}
