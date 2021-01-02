package pl.krystian.RegisterClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckIfRegisterDataIsCorrect {
	
	@Autowired
	private MessageToReturnToClient message;
	
	public MessageToReturnToClient check(LoginAndPasswordFromClient loginAndPasswordFromClient) {
		String login = loginAndPasswordFromClient.getLogin();
		String password = loginAndPasswordFromClient.getPassword();
		String repeatedPassword = loginAndPasswordFromClient.getRepeatedPassword();
		
		if(login.length() < 8  || password.length() < 8) {
			message.setAll(false, "Login and password need to be longer than 8 digits");
		}
		else {
			if(login.length() > 64  || password.length() > 64) {
				message.setAll(false, "Login and password can't be longer than 64 digits");
			}
			else {
				if(password.equals(repeatedPassword)) {
					message.setAll(true, "User added succesfully");
				}
				else {
					message.setAll(false, "Passwords are not same");
				}
			}
		}
		
		return message;
	}

}
