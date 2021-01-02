package pl.krystian.RegisterClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserToDatabase {
	
	@Autowired
	private MessageToReturnToClient messageToReturnToClient;
	
	@Autowired
	private CheckIfRegisterDataIsCorrect checkIfRegisterDataIsCorrect;
	
	@Autowired
	private CheckIfRegisterDataIsInTheDatabase checkIfRegisterDataIsInTheDatabase;
	
	@Autowired
	UserDAO userDAO;
	
	public MessageToReturnToClient add(LoginAndPasswordFromClient informations){
		messageToReturnToClient = checkIfRegisterDataIsCorrect.check(informations);
		
		if(messageToReturnToClient.isType()) {
			
			if(checkIfRegisterDataIsInTheDatabase.check(informations)) {messageToReturnToClient.setAll(false, "Login is actually in database");}
			
			else {
				
				if(userDAO.addUser(informations)) {}
				
				else {messageToReturnToClient.setAll(false, "Error while connecting with database");}
			}
		}
		else {}
		
		return messageToReturnToClient;
	}

}
