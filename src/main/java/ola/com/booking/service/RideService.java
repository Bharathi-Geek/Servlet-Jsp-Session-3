package ola.com.booking.service;

import java.util.List;

import ola.com.booking.model.Ride;
import ola.com.booking.model.RideSuccess;

public interface RideService {

	public void saveRide(Ride ride);
	public List<RideSuccess> getRideSuccessDetails(int userId,int routeId);
		
}
