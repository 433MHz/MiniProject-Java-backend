package pl.krystian.RegisterClasses;

public class MessageForClient {
	
	private String message;
	private boolean succes;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSucces() {
		return succes;
	}
	public void setSucces(boolean succes) {
		this.succes = succes;
	}
}
