package Actores;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import Messages.*;
import Patterns.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class RingActor implements ActorInstance{
	
	
	private BlockingQueue<InterfaceMessage> queueMessage = new LinkedBlockingQueue<>();
	private BlockingQueue<ActorInstance> queueSenders = new LinkedBlockingQueue<>();
	private boolean exitThread = false;
	
	private static LinkedList<ActorProxy> listProxy = new LinkedList<ActorProxy>();
	private static long start, end;
	private static int contador = 0, maxContador = 100;
	
	private int position;
	
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
				if (this == listProxy.getFirst().getActor())
				{
					end = System.nanoTime();
					System.out.println("Tiempo en dar "+maxContador+" vueltas al anillo: "+Float.parseFloat(""+(end-start))/1000000+"ms\n");
				}
				if (!(this == listProxy.getLast().getActor()))
				{
					message.setSender(listProxy.get(position+1));
					send(message);
				}
				exitThread = true;
			}
			
			if (message instanceof RingMessage)
			{
				position = listProxy.indexOf(sender);
				if (position == 0 && contador == 0) {
					start = System.nanoTime();
				}
				if (this == listProxy.getLast().getActor())
				{
					contador++;
					
					if (contador == maxContador) {
						InterfaceMessage newMessage = new QuitMessage();
						newMessage.setSender(listProxy.getFirst());
						//System.out.println("Vuelta "+contador+": Actor "+(position+1)+" envia mensaje a Actor 1 y acaba");
						//System.out.println();
						send(newMessage);
					}
					else
					{
						//System.out.println("Vuelta "+contador+": Actor "+(position+1)+" envia mensaje a Actor 1");
						//System.out.println();
						message.setSender(listProxy.getFirst());
						send(message);
					}
				}
				else 
				{
					message.setSender(listProxy.get(position+1));
					//System.out.println("Vuelta "+(contador+1)+": Actor "+(position+1)+" envia mensaje a Actor "+(position+2));
					send(message);
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
	
	/**
	 * Setter del contador de vueltas
	 * @param number
	 */
	public static void setContador(int number){
		contador = 0;
		listProxy.clear();
		maxContador = number;
	}
}