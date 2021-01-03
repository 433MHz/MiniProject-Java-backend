package pl.krystian.LoginClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserToken{

	@Autowired
	DatabaseLogin database;
	
	@Autowired
	MessageAndToken message;
	
	@Autowired
	Token setToken;
	
	public MessageAndToken get(DataFromClientForLogin data){
		
		String login = data.getLogin();
		String passwordFromUser = data.getPassword();
		String passwordInDatabase = database.getPassword(data.getLogin());
		
		if(database.isLoginOccupied(login)) {
			if(passwordFromUser.equals(passwordInDatabase)) {
				System.out.println(setToken.generate());
			}
		}
		else message.setMessage("Login is not registered");
		
		return null;
	}
}
