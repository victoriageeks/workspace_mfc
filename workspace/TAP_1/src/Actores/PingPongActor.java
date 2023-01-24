package Actores;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import Messages.*;
import Patterns.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class PingPongActor implements ActorInstance{
	
	
	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();
	private boolean exitThread = false;
	
	private static LinkedList<ActorProxy> listProxy = new LinkedList<ActorProxy>();
	private LinkedList<Observer> listObservers = new LinkedList<Observer>();

	private static long start, end;
	private int contador = 0;
	private int randomValue;
	
	private static boolean firstTime = true;
	private static int messagesSent = 0;
	private static int eliminados = 0;
	
	String name = "";
	
	// receives a message
	public void sendToQueue(ActorInstance proxy, InterfaceMessage message) {
		try {
			queueMessage.put(message);
			queueSenders.put(proxy);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void send(InterfaceMessage message) {
		ActorInstance sender = message.getSender();
		sender.sendToQueue(sender, message);
	}
	
	// accepting three messages
	@Override
	public void processMessage() {
		try {
			InterfaceMessage message = queueMessage.take();
			ActorInstance sender = queueSenders.take();	
			notifySubscrib(ActorListener.RECEIVED, message);

			/* A QuitMessage forces the Actor to stop running */
			if (message instanceof QuitMessage) {
				if (this == listProxy.getFirst().getActor()){
					end = System.nanoTime();
					System.out.println("Tiempo en finalizar el PingPong: "+Float.parseFloat(""+(end-start))/1000000+"ms \tMensages enviados: "+messagesSent);
					firstTime = true;
					if (eliminados == 1) {
						listProxy.clear();
						eliminados = 0;
					}
					else {
						eliminados = 1;
					}
					messagesSent = 0;
				}
				else {
					if (eliminados == 1) {
						listProxy.clear();
						eliminados = 0;
					}
					else {
						eliminados = 1;
					}
				}
				exitThread = true;
			}
			
			if (message instanceof PingPongMessage)
			{
				if (firstTime == true) {
					start = System.nanoTime();
					firstTime = false;
				}
				Random rand = new Random();
				randomValue = rand.nextInt() % 2;
				if (randomValue == 1) contador++;
				
				if (contador == 5){
					InterfaceMessage newMessage = new QuitMessage();
					newMessage.setSender(listProxy.getFirst());
					send(newMessage);
					newMessage.setSender(listProxy.getLast());
					send(newMessage);
				}
				else{
					messagesSent++;
					if (this == listProxy.getFirst().getActor()){
						message.setSender(listProxy.getLast());
						//System.out.println("Actor 1 envia a Actor 2");
						send(message);
						notifySubscrib(ActorListener.SEND, message);
						
					}
					else{
						message.setSender(listProxy.getFirst());
						//System.out.println("Actor 2 envia a Actor 1");
						send(message);
						notifySubscrib(ActorListener.SEND, message);
					}
				}				
			}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			try {
				Thread.sleep(500); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notifySubscrib(ActorListener.CREATION, new QuitMessage());
			while (!exitThread) {
				processMessage();
			}
			notifySubscrib(ActorListener.FINALIZATION, new QuitMessage());
		}
		catch (Exception e) {
			notifySubscrib(ActorListener.INCORRECT_FINALIZATION, new QuitMessage());
            throw new RuntimeException(e);
		}
	}
	
	/**
	 * Metodo que añade un proxy a la lista
	 * @param proxy
	 */
	public static void add(ActorProxy proxy)
	{
		listProxy.add(proxy);
		
	}
	
	

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void subscrib(Observer observer) { 
		if(!listObservers.contains(observer)) {
			listObservers.add(observer);
		}
	}

	@Override
	public void unsubscrib(Observer observer) {
		 if(listObservers.contains(observer)) {
			 listObservers.remove(observer);
         }
	}

	@Override
	public void notifySubscrib(ActorListener actions, InterfaceMessage message) {
		if (!name.equals("")) {
			for(Observer o : listObservers){
	            o.update(name, actions, message);
	        }
		}
		else {
			boolean found = false;
			for (int i = 0; i < listProxy.size() && !found; i++) {
				if (this == listProxy.get(i).getActor()) {
					name = listProxy.get(i).getName();
					found = true;
				}
			}
			for(Observer o : listObservers){
	            o.update(name, actions, message);
	        }
		}
	}

	@Override
	public ActorInstance getActor() {
		// TODO Auto-generated method stub
		return this;
	}
}