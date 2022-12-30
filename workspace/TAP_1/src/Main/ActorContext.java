package Main;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import Actores.ActorInstance;
import Actores.ActorProxy;

public class ActorContext implements Runnable{
	private static ActorContext actorContext = new ActorContext();
	private Map<String, ActorInstance> map = new HashMap<>();
	
	private ActorContext() {}
	
	// ActorContext entity based on Singleton pattern
	public static ActorContext getInstance() {
		return actorContext;					
	}
	
	// ActorContext.lookup(name)
	public ActorInstance lookUp (String name) {
		ActorInstance actor = map.get(name);
		
		return actor;
	}
		
	// ActorContext.getNames()
	public String[] getNames() {
		String[] names = new String[map.size()];
		Iterator <String> it = map.keySet().iterator();
		int i = 0;
		
		while (it.hasNext()) 
		{
			names[i] = it.next();
			i++;
		}
		
		return names;
	}
		
	// ActorContext.spawnActor(“name”, new ActorInstance())
	/* spawning an actor will create the required thread 
	   that will listen to messages for this actor. */
	public ActorProxy spawnActor (String name, ActorInstance actor) {
		ActorProxy actorProxy = new ActorProxy(actor, name);
		Thread t = new Thread(actor);
		t.start();

		map.put(name, actor);
		
		return actorProxy;
	}

	@Override
	public void run() {}
}
