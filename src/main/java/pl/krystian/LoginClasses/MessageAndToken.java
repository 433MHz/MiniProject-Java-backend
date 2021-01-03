package pl.krystian.LoginClasses;

import org.springframework.stereotype.Component;

@Component
public class MessageAndToken {
	private String message;
	private boolean success = false;
	private String token;
	
	
	public String getMessage() {
		return message;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getToken() {
		return token;
	}
	void setMessage(String message) {
		this.message = message;
	}
	void setSuccess(boolean success) {
		this.success = success;
	}
	void setToken(String token) {
		this.token = token;
	}
	void setAll(String message, boolean success, String token) {
		this.message = message;
		this.success = success;
		this.token = token;
	}
}
