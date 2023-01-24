package Main;

import Actores.*;
import Messages.*;
import Patterns.*;

import java.util.LinkedList;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * @author Marc Fpnseca y Joel Lacambra
 *
 */
public class UnitTests {

	@Test
	public void testActorContext(){
		ActorContext context1 = ActorContext.getInstance();
		ActorContext context2 = ActorContext.getInstance();
		String[] names;
        ActorProxy proxy;
        
		// 1. Pruebas de ActorContext
		System.out.println("\n\t[Pruebas de ActorContext]");
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
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHelloWorldActor(){
		ActorContext context = ActorContext.getInstance();
		ActorProxy proxy;
		
		// 2. Pruebas de HellowWorldActor
		System.out.println("\n\t[Pruebas de HellowWorldActor]");
		proxy = context.spawnActor("HelloWorldActor", new HelloWorldActor());
		
		System.out.println("// Enviamos varios mensajes de 'Hello World' y los printea por pantalla");
		proxy.send(new Message(null, "Hello World"));
		proxy.send(new Message(null, "Hello World"));
		proxy.send(new Message(null, "Hello World"));
		proxy.send(new Message(null, "Hello World"));
		proxy.send(new QuitMessage());
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsultActor(){
		ActorContext context = ActorContext.getInstance();
		ActorProxy proxy;
		
		// 3. Pruebas de InsultActor
        System.out.println("\n\t[Pruebas de InsultActor]");
        proxy = context.spawnActor("InsultActor", new InsultActor());
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
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testDecorator(){
		ActorContext context = ActorContext.getInstance();
		ActorProxy proxy, falseProxy;
		
		
		// 4. Pruebas de Decorator
		System.out.println("\n\t[Pruebas de Decorator]");
		proxy = context.spawnActor("Decorator", new FireWallDecorator(new HelloWorldActor()));
		
		System.out.println("// Si el actor está en la Hash, el FireWall permite pasar el mensaje al actor");
		proxy.send(new Message(proxy.getActor(), "Hello World Decorator"));
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		falseProxy = new ActorProxy (new FireWallDecorator(new HelloWorldActor()), "ProxyFalso");
		System.out.println("\n// Si el Proxy no está en la lista, el FireWall no deja pasar el mensaje");
		proxy.send(new Message(falseProxy.getActor(), "Hello World False"));
		
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		proxy = context.spawnActor("LambdaDecorator",new LambdaFirewallDecorator(new HelloWorldActor(), x -> x.getMessage() != null));

		System.out.println("\n// Enviamos un mensaje con un filtro base diferente a null.");
		proxy.send(new Message(proxy.getActor(), "DiferenteANull"));
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
				try {
					Thread.sleep(1000); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
		
		proxy.send(new AddClosureMessage(x -> x.getMessage().equals("Predicate")));
		
		System.out.println("\n//Despues de añadir un filtro, mensaje = predicate, enviamos dos mensajes más.");
		proxy.send(new Message(proxy.getActor(), "NoCumploElFiltro"));
		proxy.send(new Message(proxy.getActor(), "Predicate"));
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		proxy = context.spawnActor("LambdaDecorator",new EncryptionDecorator(new HelloWorldActor()));
		
		System.out.println("\n// Enviamos un mensaje para encriptar y que nos lo devuela desencriptado.");
		proxy.send(new Message(proxy.getActor(), "soy un mensaje encriptado"));
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		System.out.println("\n\t[Pruebas de PipeLine Decorator]");
		
		proxy = context.spawnActor("DobleDecorator",new EncryptionDecorator(new FireWallDecorator(new HelloWorldActor())));
		
		System.out.println("\n// Enviamos dos mensajes encriptados que pasan por un FireWall");
		proxy.send(new Message(proxy.getActor(), "Soy un mensaje encriptado que pasa por un FireWall."));
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();	
		proxy.send(new Message(falseProxy.getActor(), "En teoria no puedo pasar :D."));
		
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		proxy = context.spawnActor("DobleDecorator2",new FireWallDecorator(new EncryptionDecorator(new HelloWorldActor())));
		
		System.out.println("\n// Enviamos dos mensajes por un FireWall que despues se encriptan.");
		proxy.send(new Message(proxy.getActor(), "Soy un mensaje que pasa por un FireWall y se encripta."));
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();	
		proxy.send(new Message(falseProxy.getActor(), "En teoria no puedo pasar :D."));
		
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testDynamicProxy(){
		// 5. Pruebas de DynamicProxy
		System.out.println("\n\t[Pruebas de DynamicProxy]");
		
		System.out.println("\n// Interceptamos un Insult actor, y despues de haber añadido 6 insultos, mostraremos los insultos de cada uno");
		ActorContext context = ActorContext.getInstance();
		ActorProxy proxy = context.spawnActor("InsultActorDynamic", new InsultActor());
        InsultService insulter = DynamicProxy.intercept(new InsultServiceAux(), proxy);
       
        insulter.addInsult(new AddInsultMessage("me duele la cabeza"));
        insulter.addInsult(new AddInsultMessage("llevo sin dormir 2 semanas"));
        insulter.addInsult(new AddInsultMessage("me cuesta levantarme de la cama"));
        
        proxy.send(new AddInsultMessage("la vida es un circulo, como los anillos"));
        proxy.send(new AddInsultMessage("mañana duermo, hoy no"));
        proxy.send(new AddInsultMessage("llego tarde"));
        
        LinkedList<String> insultList = insulter.getAllInsults();
        
        System.out.println("'Interceptado'");
        System.out.println("List of insults:");
		for (int i = 0; i < insultList.size(); i++)
		{
			System.out.println("\t" + ++i + ". " + insultList.get(--i));
		}
        
		System.out.println("\n'Todos los insultos'");
        proxy.send((new GetAllInsultsMessage()));
        proxy.send(new QuitMessage());
		
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testObserver() {
		// 6. Pruebas de Observer
		System.out.println("\n\t[Pruebas de Observer]");
		ActorContext context = ActorContext.getInstance();
		ActorProxy proxy, proxy2;
		Observer observer = new MonitorService();
		
		proxy = context.spawnActor("PingPongActor 1", new PingPongActor());
		proxy2 = context.spawnActor("PingPongActor 2", new PingPongActor());
		
		((MonitorService)observer).monitorActor(proxy2.getActor());
		
		System.out.println("// Nos suscribimos a un actor del sistema de PingPongActor y vemos cuantos SEND ha hecho");
		proxy.send(new PingPongMessage());
		
		((MonitorService)observer).getNumberofMessages(proxy2.getActor());
		
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		proxy = context.spawnActor("PingPongActor 3", new PingPongActor());
		proxy2 = context.spawnActor("PingPongActor 4", new PingPongActor());
		
		((MonitorService)observer).monitorAllActors();
		
		System.out.println("\n// Nos suscribimos a un sistema de PingPongActor y vemos cuantos SEND han hecho");
		proxy.send(new PingPongMessage());
		
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		((MonitorService)observer).getNumberofMessages(proxy2.getActor());
		((MonitorService)observer).getNumberofMessages(proxy.getActor());
		
		System.out.println("\n// Vemos que mensages se han recibido y enviado en el sistema");
		
		Map<ActorInstance, LinkedList<InterfaceMessage>> sentMessages = ((MonitorService)observer).getSentMessages();
		Map<ActorInstance, LinkedList<InterfaceMessage>> recievedMessages = ((MonitorService)observer).getRecievedMessages();
		LinkedList<InterfaceMessage> messages;
		int i = 0;
		
		System.out.println("'Mensajes enviados'");
		for (ActorInstance actor : sentMessages.keySet()) {
			messages = sentMessages.get(actor);
			System.out.println("\t "+actor+":");
			for (InterfaceMessage m : messages) {
				System.out.println("\t\t "+m.getMessage()+ " enviado a "+m.getSender());
			}
		}
		
		System.out.println("'Mensajes recibidos'");
		for (ActorInstance actor : recievedMessages.keySet()) {
			messages = recievedMessages.get(actor);
			System.out.println("\t "+actor+":");
			for (InterfaceMessage m : messages) {
				System.out.println("\t\t "+m.getMessage()+ " recibido por "+m.getSender());
			}
		}
		
		System.out.println("\n// Mostramos el trafico y los eventos");
		
		Map<String, LinkedList<NodoObserver>> traffic = ((MonitorService)observer).getTraffic();
		Map<String, LinkedList<NodoObserver>> events = ((MonitorService)observer).getEvents();
		
		System.out.println("'Trafico del sistema'");
		i = 0;
		System.out.println("\t LOW: ");
		for (NodoObserver n : traffic.get("LOW")) {
			System.out.println("\t\t "+ ++i +". "+n.getActor());
		}
		i = 0;
		System.out.println("\t MEDIUM: ");
		for (NodoObserver n : traffic.get("MEDIUM")) {
			System.out.println("\t\t "+ ++i +". "+n.getActor());
		}
		i = 0;
		System.out.println("\t HIGH: ");
		for (NodoObserver n : traffic.get("HIGH")) {
			System.out.println("\t\t "+ ++i +". "+n.getActor());
		}
		
		System.out.println("\n'Eventos del sistema'");
		i = 0;
		System.out.println("\t CREATED: ");
		for (NodoObserver n : events.get("CREATED")) {
			System.out.println("\t\t "+ ++i +". "+n.getActor());
		}
		i = 0;
		System.out.println("\t STOPPED: ");
		for (NodoObserver n : events.get("STOPPED")) {
			System.out.println("\t\t "+ ++i +". "+n.getActor());
		}
		i = 0;
		System.out.println("\t ERROR: ");
		for (NodoObserver n : events.get("ERROR")) {
			System.out.println("\t\t "+ ++i +". "+n.getActor());
		}
		
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRingActor(){
		ActorContext context = ActorContext.getInstance();
		ActorProxy proxy;
		long start, end;
		
		// 7. Pruebas de RingActor
		System.out.println("\n\t[Pruebas de RingActor]");
		
		RingActor.setContador(100);
		
		start = System.nanoTime();
		proxy = context.spawnActor("RingActor 1.0", new RingActor());
		for (int i = 1; i < 100; i++)
		{
			context.spawnActor("RingActor 1."+i, new RingActor());
		}
		end = System.nanoTime();
		System.out.println("// Creamos todos los threads de manera normal");
		System.out.println("Tiempo en crear todos los threads: "+Float.parseFloat(""+(end-start))/1000000+"ms\n");
		
		System.out.println("// Enviamos 1 mensaje que pasara por 100 actores y dara 100 vueltas");
		proxy.send(new RingMessage());
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPinPongActor(){
		ActorContext context = ActorContext.getInstance();
		ActorProxy proxy;
		
		// 8. Pruebas de PinPongActor
		System.out.println("\n\t[Pruebas de PinPongActor]");
	
		proxy = context.spawnActor("PingPongActor 5", new PingPongActor());
		context.spawnActor("PingPongActor 6", new PingPongActor());
		
		System.out.println("// Enviamos 1 mensaje que sera renviado al emisor de este mismo un numero aleatorio de veces");
		proxy.send(new PingPongMessage());
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFactory(){
		ActorContext context = ActorContext.getInstance();
		ActorProxy proxy;
		long start, end;
		
		// 9. Pruebas de Factory
		System.out.println("\n\t[Pruebas de Factory]");
		
		context.setVirtual(true);
		RingActor.setContador(100);  
		
		start = System.nanoTime();
		proxy = context.spawnActor("RingActor 2.0", new RingActor());
		for (int i = 1; i < 100; i++)
		{
			context.spawnActor("RingActor 2."+i, new RingActor());
		}
		end = System.nanoTime();
		System.out.println("// Creamos todos los threads de manera virtual");
		System.out.println("Tiempo en crear todos los threads: "+Float.parseFloat(""+(end-start))/1000000+"ms\n"); 
        proxy.send(new RingMessage());
        
        context.setVirtual(false);
		
		// Retardamos un poco para que de tiempo a llegar los mensajes enviados anteriormente
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
