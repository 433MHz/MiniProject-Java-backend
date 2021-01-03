package pl.krystian.RegisterClasses;

import org.springframework.beans.factory.annotation.Autowired;


abstract class CheckData {
	
	@Autowired
	DatabaseRegister database;
	
	boolean isLoginTooLong(String login) {
		if(login.length() > 64) return true;
		else return false;
	}
	
	boolean isLoginTooShort(String login) {
		if(login.length() < 8) return true;
		else return false;
	}
	
	boolean isPasswordTooLong(String password) {
		if(password.length() > 64) return true;
		else return false;
	}
	
	boolean isPasswordTooShort(String password){
		if(password.length() < 8) return true;
		else return false;
	}
	
	boolean arePasswordsSame(String password, String repeatedPassword) {
		if(password.equals(repeatedPassword)) return true;
		else return false;
	}
	
	boolean isLoginInDatabase(String login) {
		return database.isLoginOccupied(login);
	}

}
