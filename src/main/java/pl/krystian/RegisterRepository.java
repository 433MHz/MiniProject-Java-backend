package pl.krystian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.krystian.RegisterClasses.DataFromClientForRegister;
import pl.krystian.LoginClasses.DataFromClientForLogin;
import pl.krystian.LoginClasses.MessageAndToken;
import pl.krystian.LoginClasses.UserToken;
import pl.krystian.RegisterClasses.AddUserToDatabase;
import pl.krystian.RegisterClasses.MessageForClient;

@RestController
public class RegisterRepository {
	
	@Autowired
	AddUserToDatabase addUser;
	
	@Autowired
	MessageForClient message;
	
	@Autowired
	UserToken userToken;
	
	@CrossOrigin
	@PostMapping("addNewUser")
	public MessageForClient register(@RequestBody DataFromClientForRegister info) {
		
		message = addUser.add(info);
		return message;
	}
	
	@CrossOrigin
	@PostMapping("getUserToken")
	public MessageAndToken login(@RequestBody DataFromClientForLogin info) {
		
		return userToken.get(info);
	}
}
