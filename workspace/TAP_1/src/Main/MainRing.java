package Main;

import java.util.LinkedList;

import Actores.*;
import Messages.*;
import Patterns.*;

public class MainRing {

	public static void main(String[] args) {
		
		ActorContext context = ActorContext.getInstance();
		long start = System.nanoTime();
		
		ActorProxy primero = context.spawnActor("RingActor 0", new RingActor());
		
		for (int i = 1; i < 100; i++)
		{
			context.spawnActor("RingActor "+i, new RingActor());
		}
		
		long end = System.nanoTime();
		System.out.println("Tiempo en crear todos los threads: "+Float.parseFloat(""+(end-start))/1000000+"ms\n");
		primero.send(new RingMessage());
		
	}	
}
