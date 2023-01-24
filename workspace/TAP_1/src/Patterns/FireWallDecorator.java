package Patterns;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Actores.*;
import Messages.AddInsultMessage;
import Messages.GetAllInsultsMessage;
import Messages.GetInsultMessage;
import Messages.InterfaceMessage;
import Messages.Message;
import Messages.QuitMessage;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class FireWallDecorator extends DecoratorActor {

	boolean actorFound = false;
	
	/**
	 * Constructor de FireWallDecorator
	 * @param actor
	 */
	public FireWallDecorator (ActorInstance actor)
	{
		super(actor);
	}

	
	@Override
	public void sendToQueue(ActorInstance sender, InterfaceMessage message) {
		ActorContext context = ActorContext.getInstance();
		String[] names = context.getNames();
		actorFound = false;
		for (int i = 0; i < names.length && !actorFound; i++)
		{
			if (context.lookUp(names[i]).getActor() == message.getSender())
			{
				actorFound = true;
				
				super.sendToQueue(super.actor, message);
			}
		}
    	if (actorFound == false) System.out.println("El proxy no está en la lista.");
	}
}
