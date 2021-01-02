package pl.krystian.RegisterClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserToDatabase {
	
	@Autowired
	private MessageToReturnToClient messageToReturnToClient;
	
	@Autowired
	private CheckIfRegisterDataIsCorrect checkIfRegisterDataIsCorrect;
	
	public MessageToReturnToClient add(LoginAndPasswordFromClient informations){
		checkIfRegisterDataIsCorrect.
		
	}

}
