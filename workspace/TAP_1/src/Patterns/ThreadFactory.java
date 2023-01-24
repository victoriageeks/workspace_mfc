package Patterns;

import Actores.ActorInstance;

public interface ThreadFactory {
	
	public void createThread(ActorInstance actor);
	
}
