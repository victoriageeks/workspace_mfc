package Main;

import java.util.HashMap;
import java.util.Map;

import Actores.Actor;


public class actorContext implements Runnable{
	private static actorContext actorContext = new actorContext();
	private Map<String, Actor> map = new HashMap<>();
	
	private actorContext() {}
	
	public static actorContext getInstance() {
		return actorContext;
	}
	
	public actorProxy spawnActor (String name, Actor actor) {
		actorProxy actorProxy = new actorProxy(actor);
		Thread t = new Thread(actor);
		t.start();

		map.put(name, actor);
		
		return actorProxy;
	}
	// guardar en hash el actor creado

	@Override
	public void run() {}

	
	
	// lookUp (string name) {}
	//buscar en hash el actor con name
	
	//getNames() {}
	// devolver todos los actores de la hash
}
