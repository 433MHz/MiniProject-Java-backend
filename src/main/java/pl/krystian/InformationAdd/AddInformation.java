package pl.krystian.InformationAdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddInformation {

	@Autowired
	MessageFromServer_AddInformation fromServer;

	@Autowired
	Database_AddInformation database;
	
	@Autowired
	GetTime getTime;

	public MessageFromServer_AddInformation add(MessageFromClient_AddInformation fromClient) {
		String login = fromClient.getLogin();
		String password = fromClient.getPassword();
		String title = fromClient.getTitle();
		String content = fromClient.getContent();
		int option;
		
		System.out.println(title);

		if (!database.isLoginOccupied(login))
			option = 1;
		else if (!database.isLoginAndPasswordValid(login, password))
			option = 2;
		else if (title == null || title.isEmpty())
			option = 3;
		else if (title.length() > 30)
			option = 4;
		else if (content == null || content.isEmpty())
			option = 5;
		else if (content.length() > 500)
			option = 6;
		else
			option = 7;

		String message;
		boolean success;

		switch (option) {
		case 1:
			message = "This login is not registered";
			success = false;
			break;
		case 2:
			message = "Password is not valid";
			success = false;
			break;
		case 3:
			message = "Title can't be empty";
			success = false;
			break;
		case 4:
			message = "Title can't be larger than 30 digits";
			success = false;
			break;
		case 5:
			message = "Content can't be empty";
			success = false;
			break;
		case 6:
			message = "Content can't be larger than 500 digits";
			success = false;
			break;
		case 7:
			message = "Added succesfully";
			success = true;
			database.addInformation(getTime.get(fromClient));
			break;
		default:
			message = "Error";
			success = false;
		}

		fromServer.setMessage(message);
		fromServer.setSuccess(success);
		return fromServer;
	}

}
