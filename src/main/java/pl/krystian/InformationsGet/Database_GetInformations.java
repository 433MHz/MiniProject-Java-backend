package pl.krystian.InformationsGet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.krystian.Database.Database;
import pl.krystian.InformationAdd.MessageFromClient_AddInformation;

@Component
class Database_GetInformations extends Database {
	
	@Autowired
	private MessageFromClient_AddInformation message;
	
	public ArrayList<MessageFromClient_AddInformation> getInformations() {
		ArrayList<MessageFromClient_AddInformation> list = new ArrayList<>();
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);

			String query = "select * from content";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				message = new MessageFromClient_AddInformation();
				message.setLogin(rs.getString("login"));
				message.setTitle(rs.getString("title"));
				message.setContent(rs.getString("content"));
				message.setDate(rs.getString("date"));
				message.setHour(rs.getString("time"));
				list.add(message);
			}
			
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
