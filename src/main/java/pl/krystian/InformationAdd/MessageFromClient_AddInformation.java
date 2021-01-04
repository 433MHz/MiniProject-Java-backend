package pl.krystian.InformationAdd;

import org.springframework.stereotype.Component;

@Component
public class MessageFromClient_AddInformation {
	private String login;
	private String password;
	private String title;
	private String content;
	private String date;
	private String hour;
	
	
	
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getDate() {
		return date;
	}
	public String getHour() {
		return hour;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
}
