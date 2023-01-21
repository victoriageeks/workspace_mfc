package Actores;

import Messages.*;;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public interface ActorInstance extends Runnable {
	
	// sens message to the defined actor
	/**
	 * Metodo que envia un mensaje a un actor
	 * @param message
	 */
	public void send(InterfaceMessage message);
	
	// an Actor has methods to send messages to its queue
	/**
	 * Metodo que pone en tu cola los mensajes
	 * @param sender
	 * @param message
	 */
	public void sendToQueue(ActorInstance sender, InterfaceMessage message);
	
	// a process method that reacts to messages in that queue
	/**
	 * Metodo que procesa un mensaje
	 */
	public void processMessage();
}
