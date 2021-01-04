package pl.krystian.InformationAdd;

import org.springframework.stereotype.Component;

@Component
public class MessageFromServer_AddInformation {
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
}
