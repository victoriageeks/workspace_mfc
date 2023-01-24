package Patterns;

import java.util.*;
import Actores.*;
import Messages.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class MonitorService implements Observer
{
	private Map<String, LinkedList<NodoObserver>> map = new HashMap<>();
	private Map<ActorInstance, LinkedList<InterfaceMessage>> sentMessages = new HashMap<>();
	private Map<ActorInstance, LinkedList<InterfaceMessage>> recievedMessages = new HashMap<>();
	
	
	public MonitorService () {
		map.put("LOW", new LinkedList<NodoObserver>());
		map.put("MEDIUM", new LinkedList<NodoObserver>());
		map.put("HIGH", new LinkedList<NodoObserver>());
		
		map.put("CREATED", new LinkedList<NodoObserver>());
		map.put("STOPPED", new LinkedList<NodoObserver>());
		map.put("ERROR", new LinkedList<NodoObserver>());
	}
	
	@Override
    public void update(String name, ActorListener action, InterfaceMessage message) {
        
		if (action != ActorListener.SEND) {
			System.out.println("Soy " +name+ " y hago "+action.name());
			if (action != ActorListener.RECEIVED)
			{
				boolean found = false;
				ActorInstance actor = null;
				ActorContext context = ActorContext.getInstance();
				String[] names = context.getNames();
				
				for (int i = 0; i < names.length && !found; i++) {
					if (name == context.lookUp(names[i]).getName()) {
						actor = context.lookUp(names[i]).getActor().getActor();
						found = true;
					}
				}
				
				if (action == ActorListener.CREATION)
				{
					map.get("CREATED").add(new NodoObserver(actor, 0));
					recievedMessages.put(actor, new LinkedList<InterfaceMessage>());
					sentMessages.put(actor, new LinkedList<InterfaceMessage>());
				}
				else if (action == ActorListener.FINALIZATION) {
					map.get("STOPPED").add(new NodoObserver(actor, 0));
				}
				else {
					map.get("ERROR").add(new NodoObserver(actor, 0));
				}
			}
			else {
				boolean found = false;
				ActorInstance actor = null;
				ActorContext context = ActorContext.getInstance();
				String[] names = context.getNames();
				
				for (int i = 0; i < names.length && !found; i++) {
					if (name == context.lookUp(names[i]).getName()) {
						actor = context.lookUp(names[i]).getActor().getActor();
						found = true;
					}
				}
				
				recievedMessages.get(actor).add(message);
			}
		}
		else {
			boolean found = false;
			ActorInstance actor = null;
			ActorContext context = ActorContext.getInstance();
			String[] names = context.getNames();
			
			for (int i = 0; i < names.length && !found; i++) {
				if (name == context.lookUp(names[i]).getName()) {
					actor = context.lookUp(names[i]).getActor().getActor();
					found = true;
				}
			}
			
			sentMessages.get(actor).add(message);
			
			found = false;
			LinkedList<NodoObserver> listaLow, listaMedium, listaHigh;
			
			listaLow = map.get("LOW");
			listaMedium = map.get("MEDIUM");
			listaHigh = map.get("HIGH");
			
			for (NodoObserver n : listaLow) {
				if (n.getActor() == actor) {
					n.setSendMessages(n.getSendMessages()+1);
					if (n.getSendMessages() > 5) {
						listaLow.remove(n);
						listaMedium.add(n);
					}
					found = true;
				}
			}
			
			if (!found) {
				for (NodoObserver n : listaMedium) {
					if (n.getActor() == actor) {
						n.setSendMessages(n.getSendMessages()+1);
						if (n.getSendMessages() >= 15) {
							listaMedium.remove(n);
							listaHigh.add(n);
						}
						found = true;
					}
				}
			}
			
			if (!found) {
				for (NodoObserver n : listaHigh) {
					if (n.getActor() == actor) {
						n.setSendMessages(n.getSendMessages()+1);
						found = true;
					}
				}
			}
			
			if (!found) {
				listaLow.add(new NodoObserver(actor, 1));
			}
		}		
    }
	
	/* can subscribe to some specific Actors */
	public void monitorActor(ActorInstance actor)
	{
		actor.subscrib(this);
	}
	
	/*  can subscribe to all Actors in the system*/
	public void monitorAllActors()
	{
		ActorContext context = ActorContext.getInstance();
		String[] names = context.getNames();
		
		for (int i = 0; i < names.length; i++) {
			context.lookUp(names[i]).getActor().subscrib(this);
		}
	}
	
	/* getTraffic can be used to obtain a Map 
	   where the key is the traffic (LOW, MEDIUM, HIG) 
	   and the value is the list of actor names */
	public Map<String, LinkedList<NodoObserver>> getTraffic() {
		
		Map<String, LinkedList<NodoObserver>> traffic = new HashMap<>(map);
		
		traffic.remove("CREATED");
		traffic.remove("STOPPED");
		traffic.remove("ERROR");
		
		return traffic;
	}
	
	/* getNumberofMessages for a givenActor, to log all messages 
	   from one or more Actors, and to log all events */
	public void getNumberofMessages(ActorInstance actor)
	{
		boolean found = false;
		LinkedList<NodoObserver> listaLow, listaMedium, listaHigh;
		
		listaLow = map.get("LOW");
		listaMedium = map.get("MEDIUM");
		listaHigh = map.get("HIGH");
		
		for (NodoObserver n : listaLow) {
			if (n.getActor() == actor) {
				System.out.println(actor+" ha enviado "+n.getSendMessages()+" mensajes");
				found = true;
			}
		}
		
		if (!found) {
			for (NodoObserver n : listaMedium) {
				if (n.getActor() == actor) {
					System.out.println(actor+" ha enviado "+n.getSendMessages()+" mensajes");
					found = true;
				}
			}
		}
		
		if (!found) {
			for (NodoObserver n : listaHigh) {
				if (n.getActor() == actor) {
					System.out.println(actor+" ha enviado "+n.getSendMessages()+" mensajes");
					found = true;
				}
			}
		}
	}
	
	/* getSentMessages method working over the message log, which
	   returns a Map where the key is the Actor, and the value is the 
	   messages sent by that actor */
	public Map<ActorInstance, LinkedList<InterfaceMessage>> getSentMessages() {
		return sentMessages;
	}
	
	/* getReceivedMessages returning a Map where the key is the Actor, 
	   and the value is the list of Messages sent by that Actor.*/
	public Map<ActorInstance, LinkedList<InterfaceMessage>> getRecievedMessages() {
		
		return recievedMessages;
	}
	
	/* getEvents method working over the event log, which returns a Map
	   where the key is the enum (CREATED, STOPPED, ERROR), and the value 
	   contains the aforementioned events*/
	public Map<String, LinkedList<NodoObserver>> getEvents() {
		
		Map<String, LinkedList<NodoObserver>> events = new HashMap<>(map);
		
		events.remove("LOW");
		events.remove("MEDIUM");
		events.remove("HIGH");
		
		return events;
	}
}
