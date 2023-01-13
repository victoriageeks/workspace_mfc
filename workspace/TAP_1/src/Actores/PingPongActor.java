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
	private static long start, end;
	private int contador = 0;
	private int randomValue;
	
	private static boolean firstTime = true;
	private static int messagesSent = 0;
	
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
			
			/* A QuitMessage forces the Actor to stop running */
			if (message instanceof QuitMessage) {
				if (this == listProxy.getFirst().getActor()){
					end = System.nanoTime();
					System.out.println("Tiempo en finalizar el PingPong: "+Float.parseFloat(""+(end-start))/1000000+"ms \tMensages enviados: "+messagesSent);
					firstTime = true;
					messagesSent = 0;
					listProxy.clear();
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
				
				if (contador == 20){
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
					}
					else{
						message.setSender(listProxy.getFirst());
						//System.out.println("Actor 2 envia a Actor 1");
						send(message);
					}
				}				
			}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (!exitThread) {
			processMessage();
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
}