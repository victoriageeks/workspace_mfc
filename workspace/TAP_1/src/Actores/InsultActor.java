package Actores;

import java.util.LinkedList;
import java.util.Random;

import Messages.Message;

public class InsultActor implements Actor{
	private LinkedList<String> insultList = new LinkedList<>();
	
	public Message getInsultMessage() {
		Message message = new Message(null, null);
		
		int random = (int)(Math.random()*50+1);
		random = random % insultList.size();
		message.setMessage(insultList.get(random));
		
		return message;
	}
	
	public void addInsultMessage(String insult) {
		insultList.add(insult);
		
	}
	
	
	public LinkedList<String> getAllInsultsMessage() {
		return insultList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendToQueue(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processMessage() {
		// TODO Auto-generated method stub
		
	}

}
