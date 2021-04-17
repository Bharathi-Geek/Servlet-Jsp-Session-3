package ola.com.booking.service;

import java.util.List;

import ola.com.booking.dao.RideDao;
import ola.com.booking.dao.RideDaoImpl;
import ola.com.booking.model.Ride;
import ola.com.booking.model.RideSuccess;

public class RideServiceImpl implements RideService{
	RideDao dao=new RideDaoImpl();

	public void saveRide(Ride ride) {
		// TODO Auto-generated method stub
		dao.saveRide(ride);
		
	}

	
	  public List<RideSuccess> getRideSuccessDetails(int userId,int routeId) { 
		  System.out.println("ENTER RIDE SUCCESS SERVICE IMPL");
		  System.out.println("USER ID SERVICE IMPL:"+userId);
		  System.out.println("ROUTE ID SERVICE IMPL:"+routeId);
		  return dao.getRideSuccessDetails(userId,routeId); 
	  }
	 
	

}
