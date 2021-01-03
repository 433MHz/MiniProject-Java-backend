package pl.krystian.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Component;

@Component
public class Database {
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/backendSite";
	private final String username = "root";
	private final String password = "";
	
	public boolean isLoginOccupied(String login) {
		try {
		Class.forName(driver);  
		Connection con=DriverManager.getConnection(url,username,password);  
		
		String query = "select * from users where login = ?";
		PreparedStatement stmt=con.prepareStatement(query);  
		stmt.setString(1, login);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			return true;
		}
		
		
		con.close();  
		}
		catch(Exception e){ System.out.println(e);}  
		return false;
	}
}

