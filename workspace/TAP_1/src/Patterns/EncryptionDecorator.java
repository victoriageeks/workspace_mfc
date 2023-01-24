package Patterns;

import Actores.*;
import Messages.*;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class EncryptionDecorator extends DecoratorActor {
	
	private static int contador = 0;
	
	public EncryptionDecorator(ActorInstance actor){
		super(actor);
	}
	
	@Override
	public void sendToQueue(ActorInstance sender, InterfaceMessage message) {
		message.setMessage(CaesarCipher.encryptData(message.getMessage(), 1));
		if (contador == 1) {
			message.setMessage(CaesarCipher.encryptData(message.getMessage(), 1));
		}
		System.out.println("Mensaje encriptado: " + message.getMessage());
		if (contador == 1) {
			message.setMessage(CaesarCipher.decryptData(message.getMessage(), 1));
		}
		message.setMessage(CaesarCipher.decryptData(message.getMessage(), 1).replaceAll("z", " "));
		
		if (actor instanceof DecoratorActor) {
			contador++;
		}
		else {
			contador = 0;
		}
		
		actor.sendToQueue(sender, message);
	}
}
