package pl.krystian.LoginClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import pl.krystian.Database.Database;

@Component
class DatabaseLogin extends Database {
	

	public String getPassword(String data) {
		try {
			Class.forName(driver);  
			Connection con=DriverManager.getConnection(url,username,password);  
			
			String query = "select password from users where login = ?";
			PreparedStatement stmt=con.prepareStatement(query);  
			stmt.setString(1, data);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String rMessage = rs.getString("password");
				return rMessage;
			}
			con.close(); 
			}catch(Exception e){ System.out.println(e);}  
		return null;
	}
}
