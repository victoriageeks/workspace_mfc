package Messages;

public class AddInsultMessage implements InterfaceMessage{
	
	String message;
	
	public AddInsultMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
