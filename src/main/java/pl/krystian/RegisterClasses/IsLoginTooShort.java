package pl.krystian.RegisterClasses;

import org.springframework.stereotype.Component;

@Component
class IsLoginTooShort {

	boolean check(String login) {
		if(login.length() < 8) return true;
		else return false;
	}
}
