package Patterns;

import Actores.ActorInstance;

public class VirtualThreadFactory implements ThreadFactory {

	@SuppressWarnings("preview")
	@Override
	public void createThread(ActorInstance actor) {
		Thread.ofVirtual().factory().newThread(actor).start();
	}

}
