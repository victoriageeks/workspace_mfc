package Patterns;

import Messages.*;

public interface Publisher {
	 
	void subscrib(Observer observer);
	 
	void unsubscrib(Observer observer);
	 
	void notifySubscrib(ActorListener actions, InterfaceMessage message);
}
