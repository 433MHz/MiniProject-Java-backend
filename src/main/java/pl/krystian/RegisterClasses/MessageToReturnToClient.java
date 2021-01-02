package pl.krystian.RegisterClasses;

import org.springframework.stereotype.Component;

@Component
public class MessageToReturnToClient {
	private boolean type;
	private String message;
	
	
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MessageToReturnToClient [type=" + type + ", message=" + message + "]";
	}
	
	public void setAll(boolean type, String message) {
		this.type = type;
		this.message = message;
	}
	
	
	
}
