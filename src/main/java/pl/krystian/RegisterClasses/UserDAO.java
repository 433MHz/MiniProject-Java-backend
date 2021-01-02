package pl.krystian.RegisterClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	
	private final String url = "jdbc:mysql://localhost:3306/sonoo";
	private final String login = "root";
	private final String password = "";
	private final String driver = "com.mysql.jdbc.cj.Driver";
	
	
	public boolean addUser(LoginAndPasswordFromClient data) {
	try{  
		Class.forName(driver);  
		Connection con=DriverManager.getConnection(  
		url,login,password);  
		
		String query = "insert into users values login = ? password = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, data.getLogin());
		stmt.setString(2, data.getPassword());
		stmt.executeUpdate();
		
		con.close();  
		
		return true;
		}catch(Exception e){ System.out.println(e);}  
	
	return false;
	}
	
	public boolean checkIfLoginExist(LoginAndPasswordFromClient data) {
		try{  
			Class.forName(driver);  
			Connection con=DriverManager.getConnection(  
			url,login,password);  
			
			String query = "select * from users where login = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, data.getLogin());
			ResultSet resultSet = stmt.executeQuery();
			
			con.close();  

			while(resultSet.next()) {
				return true;
			}
						
			return false;
			}catch(Exception e){ System.out.println(e);}  
		
		return false;
		}
}
