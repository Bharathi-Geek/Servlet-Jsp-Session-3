package ola.com.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.UserDao;
import ola.com.booking.model.Route;
import ola.com.booking.model.User;

public class UserDaoImpl implements UserDao {

	Connection conn= ConectionManager.getConnection();
	
	
	public void saveUser(User user) {
		System.out.println("ENTER INTO DAO IMPL");
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into User (email, name, password, phoneNo) values (?,?,?,?)");
			//stmt.setInt(1, user.getuserId());
			stmt.setString(1, user.getEmail());
			stmt.setString(2,user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getPhoneNo());
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public int validateUser(String username, String password) {
		int i=0;
		try {
			System.out.println("username is:"+username);
			System.out.println("password is:"+password);
			PreparedStatement stmt = conn.prepareStatement("SELECT userId FROM User WHERE name=? and password=?");
		    stmt.setString(1, username);
		    stmt.setString(2, password);
		    
		    ResultSet r=stmt.executeQuery();
		    while(r.next()) {
		    		i=r.getInt(1);
		    }
		    	System.out.println("ENTER INTO VALIDUSER DAO IMPL");
		    	System.out.println("The user id after logging successful is:"+i);
		   
		    return i;
		     
		   
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
