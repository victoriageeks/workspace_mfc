package InterficieGrafica;

import java.util.LinkedList;
import java.util.Map;

import Actores.*;
import Patterns.*;
import Messages.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class Controlador {
	private ActorContext context = ActorContext.getInstance();
    private ActorProxy proxy, proxy2;
    private static Observer observer = new MonitorService();
    private int j;
    private static boolean creado = false;

    /**
     * Metodo que crea un actor nuevo
     * @param name
     * @param tipo
     * @param number
     * @param message
     */
    public void crearActor(String name, String tipo, int number, String message) {
	    switch(tipo) {
	        case "PingPong":       
                proxy = context.spawnActor(name+".1", new PingPongActor());
                proxy.subscrib(observer);
                proxy2 = context.spawnActor(name+".2", new PingPongActor());
                proxy2.subscrib(observer);
                proxy.send(new PingPongMessage());
                break;
                
            case "RingActor":
        		long start = System.nanoTime();
                proxy = context.spawnActor(name+"."+1, new RingActor());
                RingActor.setContador(number);
                for (int i = 1; i < number;)
                {
                    proxy2 = context.spawnActor(name+"."+(++i), new RingActor());
                 }
                 long end = System.nanoTime();
  
                    System.out.println("Tiempo en crear todos los threads: "+Float.parseFloat(""+(end-start))/1000000+"ms");
                proxy.send(new RingMessage());
                break;
                
            case "HelloWorld":
            	proxy = context.spawnActor(name, new HelloWorldActor());
            	proxy.subscrib(observer);
        		proxy.send(new Message(null, "Hello World"));
            	break;

            case "HelloWorldFireWall":
            	proxy = context.spawnActor(name, new FireWallDecorator(new HelloWorldActor()));
            	proxy.subscrib(observer);
            	proxy.send(new Message(proxy.getActor(), "Hello World FireWall"));
        		break;
        		
            case "HelloWorldLambda":
            	proxy = context.spawnActor(name, new LambdaFirewallDecorator(new HelloWorldActor(), x -> x.getMessage() != null));
            	proxy.subscrib(observer);
            	proxy.send(new Message(proxy.getActor(), "Hello World Lambda"));
        		break;
        		
            case "HelloWorldEncryption":
            	proxy = context.spawnActor(name, new EncryptionDecorator(new HelloWorldActor()));
            	proxy.subscrib(observer);
            	proxy.send(new Message(proxy.getActor(), "Hello World Encryption"));
        		break;

            case "addInsult":
                if (!creado){
                    proxy = context.spawnActor(name, new InsultActor());
                    proxy.subscrib(observer);
                    creado = true;
                }
                else{
                    proxy = context.lookUp(name);
                }
                proxy.send(new AddInsultMessage(message));
                break;

            case "getInsult":
                if (!creado){
                    proxy = context.spawnActor(name, new InsultActor());
                    proxy.subscrib(observer);
                    creado = true;
                }
                else{
                    proxy = context.lookUp(name);
                }
                proxy.send(new GetInsultMessage());
                Message result = proxy.receive();
                System.out.println("Mensage random obtenido es: " +result.getMessage());
            	break;

            case "getAllInsult":
                if (!creado){
                    proxy = context.spawnActor(name, new InsultActor());
                    proxy.subscrib(observer);
                    creado = true;
                }
                else{
                    proxy = context.lookUp(name);
                }
                proxy.send(new GetAllInsultsMessage());
            	break;
            	
            case "Traffic":
            	Map<String, LinkedList<NodoObserver>> traffic = ((MonitorService)observer).getTraffic();
            	
            	System.out.println("'Trafico del sistema'");
        		j = 0;
        		System.out.println("\t LOW: ");
        		for (NodoObserver n : traffic.get("LOW")) {
        			System.out.println("\t\t "+ ++j +". "+n.getActor());
        		}
        		j = 0;
        		System.out.println("\t MEDIUM: ");
        		for (NodoObserver n : traffic.get("MEDIUM")) {
        			System.out.println("\t\t "+ ++j +". "+n.getActor());
        		}
        		j = 0;
        		System.out.println("\t HIGH: ");
        		for (NodoObserver n : traffic.get("HIGH")) {
        			System.out.println("\t\t "+ ++j +". "+n.getActor());
        		}
            	
            	break;
            	
            case "Events":
            	Map<String, LinkedList<NodoObserver>> events = ((MonitorService)observer).getEvents();
            	
            	System.out.println("\n'Eventos del sistema'");
        		j = 0;
        		System.out.println("\t CREATED: ");
        		for (NodoObserver n : events.get("CREATED")) {
        			System.out.println("\t\t "+ ++j +". "+n.getActor());
        		}
        		j = 0;
        		System.out.println("\t STOPPED: ");
        		for (NodoObserver n : events.get("STOPPED")) {
        			System.out.println("\t\t "+ ++j +". "+n.getActor());
        		}
        		j = 0;
        		System.out.println("\t ERROR: ");
        		for (NodoObserver n : events.get("ERROR")) {
        			System.out.println("\t\t "+ ++j +". "+n.getActor());
        		}
            	break;
        }
    }
    
    /**
     * Metodo que devuelve la lista de actores creados
     * @return - lista
     */
    public String[] listarActores (){
        String[] names = context.getNames();
        
        return names;
    }
}
