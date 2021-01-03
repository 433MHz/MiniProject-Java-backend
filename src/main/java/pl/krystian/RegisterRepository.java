package pl.krystian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.RegisterClasses.AddUserToDatabase;
import pl.krystian.RegisterClasses.DataFromClient;
import pl.krystian.RegisterClasses.MessageForClient;

@RestController
public class RegisterRepository {
	
	@Autowired
	AddUserToDatabase addUser;
	
	@Autowired
	MessageForClient message;
	
	@PostMapping("addNewUser")
	public MessageForClient register(@RequestBody DataFromClient info) {
		
		message = addUser.add(info);
		System.out.println(message.getMessage() + " | " + message.isSucces());
		return null;
	}
}
