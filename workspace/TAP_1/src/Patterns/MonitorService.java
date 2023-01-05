package Patterns;

import java.util.*;
import Actores.*;

public class MonitorService 
{
	private Map<String, ActorInstance> map = new HashMap<>();
	
	/* can subscribe to some specific Actors */
	public void monitorActor(ActorInstance actor)
	{
		
	}
	
	/*  can subscribe to all Actors in the system*/
	public void monitorAllActors()
	{
		
	}
	
	/* getTraffic can be used to obtain a Map 
	   where the key is the traffic (LOW, MEDIUM, HIG) 
	   and the value is the list of actor names */
	public void getTraffic( ) {
		
		
	}
	
	/* getNumberofMessages for a givenActor, to log all messages 
	   from one or more Actors, and to log all events */
	public void getNumberofMessages()
	{
		
	}
	
	/* getSentMessages method working over the message log, which
	   returns a Map where the key is the Actor, and the value is the 
	   messages sent by that actor */
	public void getSentMessages() {
		
	}
	
	/* getReceivedMessages returning a Map where the key is the Actor, 
	   and the value is the list of Messages sent by that Actor.*/
	public void getRecievedMessages() {
		
	}
}
