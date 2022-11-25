package Main;

import java.util.HashMap;
import java.util.Map;

public class actorContext {
	private static actorContext actorContext = new actorContext();
	private Map<String, Actor> map = new HashMap<>();
	
	private actorContext() {}
	
	public static actorContext getInstance() {
		return actorContext;
	}
	
	public actorProxy spawnActor (String name, Actor actor) {
		actorProxy actorX = new actorProxy(name);
		
		map.put(name, actor);
		
		
		return actorX;
	}
	// guardar en hash el actor creado
	
	// lookUp (string name) {}
	//buscar en hash el actor con name
	
	//getNames() {}
	// devolver todos los actores de la hash
}
