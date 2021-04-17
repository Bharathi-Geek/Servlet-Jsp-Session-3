package ola.com.booking.service;

import java.util.List;

import ola.com.booking.dao.RouteDao;
import ola.com.booking.dao.RouteDaoImpl;
import ola.com.booking.model.Route;
import ola.com.booking.service.RouteService;

public class RouteServiceImpl implements RouteService{

	RouteDao routeDao = new RouteDaoImpl();
	
	public List<Route> getRoutes() {
		return routeDao.getRoutes();
	}

}
