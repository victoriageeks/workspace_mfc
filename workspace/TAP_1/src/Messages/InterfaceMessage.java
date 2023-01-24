package Messages;

import Actores.ActorInstance;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public interface InterfaceMessage {
	
	/**
	 * Setter de sender
	 * @param sender
	 */
	public void setSender(ActorInstance sender);
	
	/**
	 * Getter de sender
	 * @return - actor
	 */
	public ActorInstance getSender();
	
	/**
	 * Hetter de message
	 * @return - message
	 */
	public String getMessage();
	
	/**
	 * Setter de message
	 * @param message
	 */
	public void setMessage(String message);
}
