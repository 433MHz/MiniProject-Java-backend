package pl.krystian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.InformationAdd.AddInformation;
import pl.krystian.InformationAdd.MessageFromClient_AddInformation;
import pl.krystian.InformationAdd.MessageFromServer_AddInformation;
import pl.krystian.RegisterClasses.AddUserToDatabase;
import pl.krystian.RegisterClasses.DataFromClientForRegister;
import pl.krystian.RegisterClasses.MessageForClientFromRegister;

@RestController
public class RegisterRepository {
	
	@Autowired
	AddUserToDatabase addUser;
		
	@Autowired
	AddInformation addInformation;
	
	
	@CrossOrigin
	@PostMapping("addNewUser")
	public MessageForClientFromRegister register(@RequestBody DataFromClientForRegister info) {
		return addUser.add(info);
	}
	
	@CrossOrigin
	@PostMapping("sendInformation")
	public MessageFromServer_AddInformation addInformation(@RequestBody MessageFromClient_AddInformation message) {
		return addInformation.add(message);
	}
}
