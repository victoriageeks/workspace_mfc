package Patterns;

import Actores.ActorInstance;

public class NormalThreadFactory implements ThreadFactory {

	@Override
	public void createThread(ActorInstance actor) {
		new Thread(actor).start();
	}

}
