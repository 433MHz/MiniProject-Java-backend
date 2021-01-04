package pl.krystian.InformationAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import pl.krystian.Database.Database;

@Component
class Database_AddInformation extends Database {

	public boolean isLoginAndPasswordValid(String UserLogin, String UserPassword) {
		String DbPassword = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);

			String query = "select * from users where login = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, UserLogin);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				DbPassword = rs.getString("password");
			}
			con.close();

			if (DbPassword.equals(UserPassword))
				return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public void addInformation(MessageFromClient_AddInformation message) {
		String login = message.getLogin();
		String title = message.getTitle();
		String content = message.getContent();
		String date = message.getDate();
		String hour = message.getHour();

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);

			String query = "insert into content (login, title, content, date, time) values (?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, login);
			stmt.setString(2, title);
			stmt.setString(3, content);
			stmt.setString(4, date);
			stmt.setString(5, hour);

			stmt.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
