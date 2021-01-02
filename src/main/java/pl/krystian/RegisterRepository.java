package pl.krystian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.RegisterClasses.MessageToReturnToClient;
import pl.krystian.RegisterClasses.AddUserToDatabase;
import pl.krystian.RegisterClasses.LoginAndPasswordFromClient;

@RestController
public class RegisterRepository {
	
	@Autowired
	private AddUserToDatabase addUserToDatabase;
	
	@PostMapping("addNewUser")
	public MessageToReturnToClient register(@RequestBody LoginAndPasswordFromClient info) {
		
		System.out.println(info.toString());
		return 	addUserToDatabase.add(info);
	}
}
