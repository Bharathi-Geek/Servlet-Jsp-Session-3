package ola.com.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ola.com.booking.ConectionManager;
import ola.com.booking.model.Ride;
import ola.com.booking.model.RideSuccess;
import ola.com.booking.model.User;

public class RideDaoImpl implements RideDao{

	Connection conn = ConectionManager.getConnection();
	
	public void saveRide(Ride ride) {
		System.out.println("ENTER INTO RIDE DAO IMPL");
			try {
				PreparedStatement stmt = conn.prepareStatement("insert into ride (userId,routeId,date) values(?,?,?)");
				stmt.setInt(1, ride.getUserId());
				stmt.setInt(2, ride.getRouteId());
				stmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				stmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	  public List<RideSuccess> getRideSuccessDetails(int userId,int routeId) {
		  System.out.println("ENTER RIDE SUCCESS DAO IMPL");
		  System.out.println("USER ID IS:"+userId);
		  System.out.println("ROUTE ID IS:"+routeId);
		  List<RideSuccess> rideSuccess = new ArrayList<RideSuccess>();
		  
		  try {
			PreparedStatement ps = conn.prepareStatement("select name,source,destination,duration,date "
+ "from user,route,ride where user.userId="+userId+ " and "
			+ "ride.userId="+userId+ " and route.routeId="+routeId+ " and ride.routeId="+routeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RideSuccess ride = new RideSuccess();
				ride.setUsername(rs.getString(1));
				ride.setSource(rs.getString(2));
				ride.setDestination(rs.getString(3));
				ride.setDuration(rs.getDouble(4));
				ride.setDate(rs.getDate(5));
				rideSuccess.add(ride);
			}
			System.out.println("THE SIZE OF THE LIST IS:"+rideSuccess.size());
			return rideSuccess;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  return null;
	  
	  
	  }
	 
	

}
