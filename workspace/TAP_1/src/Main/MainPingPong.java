package Main;

import java.util.LinkedList;

import Actores.*;
import Messages.*;
import Patterns.*;

public class MainPingPong {
	public static LinkedList<String> insultList = new LinkedList<>();

	public static void main(String[] args) {
		
		ActorContext context = ActorContext.getInstance();
		long start = System.nanoTime();
		
		System.out.println("// Creamos dos actores para la prueba del PingPong");
		ActorProxy primero = context.spawnActor("PingPongActor 0", new PingPongActor());
		ActorProxy segundo = context.spawnActor("PingPongActor 1", new PingPongActor());
		
		long end = System.nanoTime();
		System.out.println("Tiempo en crear todos los threads: "+Float.parseFloat(""+(end-start))/1000000+"ms");
		primero.send(new PingPongMessage());
		
	}	
}
