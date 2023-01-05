package Patterns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import Actores.*;

public class ActorContext implements Runnable{
	private static ActorContext actorContext = new ActorContext();
	private Map<ActorProxy, ActorInstance> map = new HashMap<>();
	
	private ActorContext() {}
	
	// ActorContext entity based on Singleton pattern
	public static ActorContext getInstance() {
		return actorContext;					
	}
	
	// ActorContext.lookup(name)
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
		
	// ActorContext.spawnActor(“name”, new ActorInstance())
	/* spawning an actor will create the required thread 
	   that will listen to messages for this actor. */
	public ActorProxy spawnActor (String name, ActorInstance actor) {
		ActorProxy actorProxy = new ActorProxy(actor, name);
		
		if (actor instanceof RingActor)
		{
			RingActor.add(actorProxy);
		}
		if (actor instanceof PingPongActor)
		{
			PingPongActor.add(actorProxy);
		}
		
		map.put(actorProxy, actor);
		
		Thread t = new Thread(actor);
		t.start();
		
		return actorProxy;
	}

	@Override
	public void run() {}
}
