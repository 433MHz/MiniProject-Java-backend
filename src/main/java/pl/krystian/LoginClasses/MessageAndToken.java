package pl.krystian.LoginClasses;

import org.springframework.stereotype.Component;

@Component
public class MessageAndToken {
	private String message;
	private boolean success;	
	
	public String getMessage() {
		return message;
	}
	public boolean isSuccess() {
		return success;
	}
	void setMessage(String message) {
		this.message = message;
	}
	void setSuccess(boolean success) {
		this.success = success;
	}
	void setAll(String message, boolean success) {
		this.message = message;
		this.success = success;
	}
}
