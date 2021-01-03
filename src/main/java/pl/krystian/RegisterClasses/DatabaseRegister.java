package pl.krystian.RegisterClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Component;

import pl.krystian.Database.Database;

@Component
class DatabaseRegister extends Database {
	
	
	boolean addUser(DataFromClientForRegister data) {
		
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
