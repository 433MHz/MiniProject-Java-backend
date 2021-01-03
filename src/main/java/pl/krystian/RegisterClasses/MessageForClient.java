package pl.krystian.RegisterClasses;

import org.springframework.stereotype.Component;

@Component
public class MessageForClient {
	
	private String message;
	private boolean succes;
	
	public String getMessage() {
		return message;
	}
	void setMessage(String message) {
		this.message = message;
	}
	public boolean isSucces() {
		return succes;
	}
	void setSucces(boolean succes) {
		this.succes = succes;
	}
	void setAll(String message, boolean succes) {
		this.message = message;
		this.succes = succes;
	}
	
}
