package Patterns;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import Actores.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class ActorContext {
	private static ActorContext actorContext = new ActorContext();
	private Map<ActorProxy, ActorInstance> map = new HashMap<>();
	
	boolean virtual = false;
	NormalThreadFactory normalFactory = new NormalThreadFactory();
	VirtualThreadFactory virtualFactory = new VirtualThreadFactory();

	/**
	 * Constructor de ActorContext
	 */
	private ActorContext() {}
	
	// ActorContext entity based on Singleton pattern
	/**
	 * Constructor generico de ActorContext
	 * @return - ActorContext
	 */
	public static ActorContext getInstance() {
		return actorContext;					
	}
	
	// ActorContext.lookup(name)
	/**
	 * Metodo que devuelve el Proxy a traves de su nombre
	 * @param name
	 * @return - proxy
	 */
	public ActorProxy lookUp (String name) {
		ActorProxy actorProxy;
		Iterator <ActorProxy> it = map.keySet().iterator();
		
		while (it.hasNext()) 
		{
			actorProxy = it.next();
			if (name.equals(actorProxy.getName()))
			{
				return actorProxy;
			}
		}
		
		return null;
	}
		
	// ActorContext.getNames()
	/**
	 * Metodo que devuelve todos los nombres de los actores dentro de la Hash 
	 * @return - names
	 */
	public String[] getNames() {
		String[] names = new String[map.size()];
		Iterator <ActorProxy> it = map.keySet().iterator();
		int i = 0;
		
		while (it.hasNext()) 
		{
			names[i] = it.next().getName();
			i++;
		}
		
		return names;
	}
		
	// ActorContext.spawnActor(name, new ActorInstance())
	/* spawning an actor will create the required thread 
	   that will listen to messages for this actor. */
	/**
	 * Metodo que crea un actor y lo asocia a un thread
	 * @param name
	 * @param actor
	 * @return - actorProxy
	 */
	public ActorProxy spawnActor (String name, ActorInstance actor) {
		ActorProxy actorProxy = new ActorProxy(actor, name);
		
		if (actor instanceof RingActor)
		{
			RingActor.add(actorProxy);
			map.put(actorProxy, actor);
			
			if (!isVirtual())
			{
				normalFactory.createThread(actor);
			}
			else {
				virtualFactory.createThread(actor);
			}
			
		}
		else if (actor instanceof PingPongActor)
		{
			PingPongActor.add(actorProxy);
			map.put(actorProxy, actor);
			
			if (!isVirtual())
			{
				normalFactory.createThread(actor);
			}
			else {
				virtualFactory.createThread(actor);
			}
		}
		else {
			map.put(actorProxy, actor);
			
			if (!isVirtual())
			{
				normalFactory.createThread(actor);
			}
			else {
				virtualFactory.createThread(actor);
			}
		}  
		
		return actorProxy;
	}
	
	public boolean isVirtual() {
		return virtual;
	}

	public void setVirtual(boolean virtual) {
		this.virtual = virtual;
	}
}
