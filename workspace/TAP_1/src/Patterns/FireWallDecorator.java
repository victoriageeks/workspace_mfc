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

public class FireWallDecorator implements ActorInstance {

	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();
	ActorInstance actor;
	private boolean exitThread = false, actorFound;
	
	public FireWallDecorator (ActorInstance actor)
	{
		this.actor = actor;
		Thread t = new Thread(actor);
		t.start();
	}
	
	@Override
	public void sendToQueue(ActorInstance proxy, InterfaceMessage message) {
		try {
			queueMessage.put(message);
			queueSenders.put(proxy);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void processMessage() {
		actorFound = false;
		try {
			InterfaceMessage message = queueMessage.take();
			ActorInstance proxy = queueSenders.take();
			ActorInstance sender = message.getSender();
			
			if (message instanceof QuitMessage)
			{
				send(message);
				exitThread = true;
			}
			else {
				ActorContext context = ActorContext.getInstance();
				String[] names = context.getNames();
				
				for (int i = 0; i < names.length; i++)
				{
					if (context.lookUp(names[i]).getActor() == sender)
					{
						actorFound = true;
						send(message);
					}
				}
				if (actorFound == false) System.out.println("Este proxy/actor no existe en la lista");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

    @Override
	public void run() {
    	while (!exitThread) {
			processMessage();
		}
	}
    
    @Override
	public void send(InterfaceMessage message) {
    	ActorInstance sender = message.getSender();
		actor.sendToQueue(sender, message);
	}

}
