package pl.krystian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.InformationAdd.AddInformation;
import pl.krystian.InformationAdd.MessageFromClient_AddInformation;
import pl.krystian.InformationAdd.MessageFromServer_AddInformation;
import pl.krystian.InformationsGet.GetInformations;
import pl.krystian.RegisterClasses.AddUserToDatabase;
import pl.krystian.RegisterClasses.DataFromClientForRegister;
import pl.krystian.RegisterClasses.MessageForClientFromRegister;

@RestController
public class RegisterRepository {
	
	@Autowired
	AddUserToDatabase addUser;
		
	@Autowired
	AddInformation addInformation;
	
	@Autowired
	GetInformations getInfo;
	
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
	
	@CrossOrigin
	@GetMapping("getInformations")
	public ArrayList<MessageFromClient_AddInformation> getInformations(){
		return getInfo.get();
	}
}
