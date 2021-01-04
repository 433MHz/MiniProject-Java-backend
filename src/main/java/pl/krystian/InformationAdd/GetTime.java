package pl.krystian.InformationAdd;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
class GetTime {
	
	public MessageFromClient_AddInformation get(MessageFromClient_AddInformation message) {
		
		SimpleDateFormat formatterDay = new SimpleDateFormat("dd/MM/yyyy");  
		SimpleDateFormat formatterHour = new SimpleDateFormat("HH:mm");  
		
	    Date date = new Date();  
	    
	    message.setDate(formatterDay.format(date));
	    message.setHour(formatterHour.format(date));
	    
	    return message;
	}

}