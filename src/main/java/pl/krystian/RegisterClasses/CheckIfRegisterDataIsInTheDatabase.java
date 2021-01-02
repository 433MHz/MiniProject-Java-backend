package pl.krystian.RegisterClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckIfRegisterDataIsInTheDatabase {
	
	@Autowired
	private MessageToReturnToClient message;
	
	@Autowired
	private UserDAO userDAO;
	
	public boolean check(LoginAndPasswordFromClient userData) {
		return userDAO.checkIfLoginExist(userData);
	}
}
