package pl.krystian.RegisterClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserToDatabase extends CheckData{
	
	@Autowired
	MessageForClientFromRegister messageForClient;
	
	public MessageForClientFromRegister add(DataFromClientForRegister data) {
		String login = data.getLogin();
		String password = data.getPassword();
		String repeatedPassword = data.getRepeatedPassword();
		
		int option = 0;
		
		if(isLoginTooShort(login)) option = 1;
		else if(isLoginTooLong(login)) option = 2;
		else if(isPasswordTooShort(password)) option = 3;
		else if(isPasswordTooLong(password)) option = 4;
		else if(!arePasswordsSame(password, repeatedPassword)) option = 5;
		else if(isLoginInDatabase(login)) option = 6;
		else if(database.addUser(data)) option = 7;
		
		
		
		switch (option) {
		case 1:
			messageForClient.setAll("Login need to be longer than 8 digits", false);
			break;
		case 2:
			messageForClient.setAll("Login need to be lesser than 64 digits", false);
			break;
		case 3:
			messageForClient.setAll("Password need to be longer than 8 digits", false);
			break;
		case 4:
			messageForClient.setAll("Password need to be lesser than 64 digits", false);
			break;
		case 5:
			messageForClient.setAll("Passwords are not same", false);
			break;
		case 6:
			messageForClient.setAll("This login is occupied", false);
			break;
		case 7:
			messageForClient.setAll("User register success", true);
			break;
			
		default:
			break;
		}
		
		return messageForClient;
	}

}
