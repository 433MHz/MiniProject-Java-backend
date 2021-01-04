package pl.krystian.InformationsGet;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.krystian.InformationAdd.MessageFromClient_AddInformation;

@Component
public class GetInformations {

	@Autowired
	private Database_GetInformations database;
	
	public ArrayList<MessageFromClient_AddInformation> get(){
		
		return database.getInformations();
	}
}
