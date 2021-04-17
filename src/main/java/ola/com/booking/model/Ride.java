package ola.com.booking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Ride {


	private int rideId;
	private int userId;
	private int routeId;
	private LocalDate date;
	
	
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
