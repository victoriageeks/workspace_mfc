package Main;

import Actores.*;
import Messages.*;
import Patterns.*;

public class Main {

	public static void main(String[] args) {

		// Inicializaciones previas
		ActorContext context1 = ActorContext.getInstance();
		ActorContext context2 = ActorContext.getInstance();
		ActorProxy proxy, falseProxy;
		String[] names;
		long start, end;
 		
		// 1. Pruebas de ActorContext
		System.out.println("\t[Pruebas de ActorContext]");
		context1.spawnActor("ActorConext 1", new InsultActor());
		context2.spawnActor("ActorConext 2", new InsultActor());
		context1.spawnActor("ActorConext 3", new InsultActor());
		context2.spawnActor("ActorConext 4", new InsultActor());
		context1.spawnActor("ActorConext 5", new InsultActor());
		names = context2.getNames();
		
		System.out.println("// Añadimos 5 actores y recuperamos sus proxys");
		for (int i = 0; i < names.length; i++)
		{
			proxy = context1.lookUp(names[i]);
			System.out.println(proxy);
			proxy.send(new QuitMessage());
		}
		
		// 2. Pruebas de HellowWorldActor
		System.out.println("\n\t[Pruebas de HellowWorldActor]");
		proxy = context2.spawnActor("HelloWorldActor", new HelloWorldActor());
		
		System.out.println("// Enviamos varios mensajes de 'Hello World' y los printea por pantalla");
		proxy.send(new Message(null, "Hello World"));
		proxy.send(new Message(null, "Hello World"));
		proxy.send(new Message(null, "Hello World"));
		proxy.send(new Message(null, "Hello World"));
		proxy.send(new QuitMessage());
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(10); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 3. Pruebas de InsultActor
		System.out.println("\n\t[Pruebas de InsultActor]");
		proxy = context1.spawnActor("InsultActor", new InsultActor());
		proxy.send(new AddInsultMessage("la vida es un circulo, como los anillos"));
		proxy.send(new AddInsultMessage("mañana duermo, hoy no"));
		proxy.send(new AddInsultMessage("llego tarde"));
		proxy.send(new AddInsultMessage("examen facil = estudiante feliz"));
		proxy.send(new AddInsultMessage("no nos suspendas pls"));
		proxy.send(new AddInsultMessage("me duele la cabeza"));
		proxy.send(new AddInsultMessage("llevo sin dormir 2 semanas"));
		proxy.send(new AddInsultMessage("me cuesta levantarme de la cama"));
	
		proxy.send(new GetInsultMessage());
		Message result = proxy.receive();
		
		System.out.println("// Enviamos mensajes tipo GetInsultMessage para que nos devuelva mensajes aleatorios de la lista de 'insultos'");
		System.out.println("Mensage random obtenido es: " +result.getMessage());

		proxy.send(new GetInsultMessage());
		result = proxy.receive();
		System.out.println("Mensage random obtenido es: " +result.getMessage());

		proxy.send(new GetInsultMessage());
		result = proxy.receive();
		System.out.println("Mensage random obtenido es: " +result.getMessage());

		System.out.println("\n// Enviamos un mensaje tipo GetAllInsultsMessage para que nos devuelva la lista de 'insultos' ");
		proxy.send((new GetAllInsultsMessage()));

		proxy.send(new QuitMessage());
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(5); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 4. Pruebas de Decorator
		System.out.println("\n\t[Pruebas de Decorator]");
		proxy = context2.spawnActor("Decorator", new FireWallDecorator(new HelloWorldActor()));
		
		System.out.println("// Si el actor está en la Hash, el FireWall permite pasar el mensaje al actor");
		proxy.send(new Message(proxy.getActor(), "Hello World Decorator"));
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(5); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		falseProxy = new ActorProxy (new HelloWorldActor(), "ProxyFalso");
		System.out.println("\n// Si el Proxy no está en la lista, no deja pasar el mensaje");
		proxy.send(new Message(falseProxy.getActor(), "Hello World False"));
		
		proxy.send(new QuitMessage());
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(5); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 5. Pruebas de DynamicProxy
		System.out.println("\n\t[Pruebas de DynamicProxy]");
		System.out.println("No hemos sabido implementarlo");
		
		// 6. Pruebas de Observer
		System.out.println("\n\t[Pruebas de Observer]");
		System.out.println("No hemos sabido implementarlo");
		
		// 7. Pruebas de RingActor
		System.out.println("\n\t[Pruebas de RingActor]");
		
		start = System.nanoTime();
		proxy = context1.spawnActor("RingActor 0", new RingActor());
		for (int i = 1; i < 100; i++)
		{
			context2.spawnActor("RingActor "+i, new RingActor());
		}
		end = System.nanoTime();
		System.out.println("// Creamos todos los threads");
		System.out.println("Tiempo en crear todos los threads: "+Float.parseFloat(""+(end-start))/1000000+"ms\n");
		
		System.out.println("// Enviamos 1 mensaje que pasara por 100 actores y dara 100 vueltas");
		proxy.send(new RingMessage());
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(70); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 8. Pruebas de PinPongActor
		System.out.println("\n\t[Pruebas de PinPongActor]");
	
		proxy = context1.spawnActor("PingPongActor 0", new PingPongActor());
		context2.spawnActor("PingPongActor 1", new PingPongActor());
		
		System.out.println("// Enviamos 1 mensaje que sera renviado al emisor de este mismo un numero aleatorio de veces");
		proxy.send(new PingPongMessage());
	}	
}
