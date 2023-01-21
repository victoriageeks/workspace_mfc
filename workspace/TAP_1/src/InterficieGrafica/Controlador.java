package InterficieGrafica;

import Actores.*;
import Patterns.*;
import Messages.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class Controlador {
	ActorContext context = ActorContext.getInstance();
    ActorProxy proxy;
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
                context.spawnActor(name+".2", new PingPongActor());
                proxy.send(new PingPongMessage());
                break;
                
            case "RingActor":
        		long start = System.nanoTime();
                proxy = context.spawnActor(name+"."+1, new RingActor());
                RingActor.setContador(number);
                for (int i = 1; i < number;)
                {
                    context.spawnActor(name+"."+(++i), new RingActor());
                    }
                    long end = System.nanoTime();
  
                    System.out.println("Tiempo en crear todos los threads: "+Float.parseFloat(""+(end-start))/1000000+"ms");
                proxy.send(new RingMessage());
                break;
                
            case "HelloWorld":
            	proxy = context.spawnActor(name, new HelloWorldActor());
        		proxy.send(new Message(null, "Hello World"));
            	break;

            case "HelloWorldDecorator":
            	proxy = context.spawnActor(name, new FireWallDecorator(new HelloWorldActor()));
        		proxy.send(new Message(proxy.getActor(), "Hello World Decorator"));
        		break;

            case "addInsult":
                if (!creado){
                    proxy = context.spawnActor(name, new InsultActor());
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
                    creado = true;
                }
                else{
                    proxy = context.lookUp(name);
                }
                proxy.send(new GetAllInsultsMessage());
            	break;
        }
    }
    
    /**
     * Metodo que devuelve la lista de actores creados
     * @return - lista
     */
    public String[] listarActores (){
        String[] names = context.getNames();
        String[] actores = new String[names.length];
        
        for (int i = 0; i < names.length; i++)
        {
            actores[i] = ""+names[i]+" tipo "+context.lookUp(names[i]).getActor().toString();
        }
   
        return actores;
    }
}
