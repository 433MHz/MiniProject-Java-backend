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
	Token token;
	
	public MessageAndToken get(DataFromClientForLogin data){
		
		String login = data.getLogin();
		String passwordFromUser = data.getPassword();
		String passwordInDatabase = database.getPassword(data.getLogin());
		
		if(database.isLoginOccupied(login)) {
			if(passwordFromUser.equals(passwordInDatabase)) {
				String generatedToken = token.generate();
				database.updateToken(generatedToken, login);
				message.setAll("Logged in", true, generatedToken);
			}
			else message.setAll("Incorrect password", false, null);
		}
		else message.setAll("Login is not registered", false, null);;
		
		return message;
	}
}
