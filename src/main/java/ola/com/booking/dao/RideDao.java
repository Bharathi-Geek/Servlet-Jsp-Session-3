package ola.com.booking.dao;

import java.util.List;

import ola.com.booking.model.Ride;
import ola.com.booking.model.RideSuccess;

public interface RideDao {
void saveRide(Ride ride);
List<RideSuccess> getRideSuccessDetails(int userId,int routeId);
}
