package pl.krystian.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Component;

import pl.krystian.RegisterClasses.DataFromClient;

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
	
	public boolean addUser(DataFromClient data) {
		try {
			Class.forName(driver);  
			Connection con=DriverManager.getConnection(url,username,password);  
			
			String query = "insert into users (login , password) values (?,?)";
			PreparedStatement stmt=con.prepareStatement(query);  
			stmt.setString(1, data.getLogin());
			stmt.setString(2, data.getPassword());
			int value = stmt.executeUpdate();
			con.close(); 
			
			if(value > 0) return true;
			
			}catch(Exception e){ System.out.println(e);}  
		return false;
	}
}

