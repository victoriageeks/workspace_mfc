package Patterns;

import Messages.InterfaceMessage;

public interface Observer {
	
    void update(String name, ActorListener action, InterfaceMessage message);

}
