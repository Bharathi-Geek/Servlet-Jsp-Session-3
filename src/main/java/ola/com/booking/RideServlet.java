package ola.com.booking;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ola.com.booking.model.Ride;
import ola.com.booking.service.RideService;
import ola.com.booking.service.RideServiceImpl;

@WebServlet("/ride")
public class RideServlet extends HttpServlet{
	
private static final Long SerailVersionUID = 1L;
RideService service=new RideServiceImpl();
	
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	System.out.println("ENTER INTO RIDE SERVLET");
	HttpSession session=req.getSession();
		int userId = (Integer) session.getAttribute("userId");
		System.out.println("THE USERID FROM SESSION IS one :"+userId);
		System.out.println("THE USERID FROM SESSION IS:"+session.getAttribute("userId"));
	if(req.getParameter("action").equalsIgnoreCase("book")) {
		System.out.println("ENTER INTO RIDE SERVLET method if");
		String routes = req.getParameter("Book");
		System.out.println("THE ROUTE IS:"+routes);
		String route = routes.replaceAll("Book","");
		System.out.println("THE ROUTE IS:"+route);
		int routeId = Integer.valueOf(route);
		System.out.println("THE ROUTEID IS:"+routeId);
		session.setAttribute("routeId", routeId);
		res.setContentType("text/html;charset=UTF-8");
		Ride ride = new Ride();
		ride.setUserId(userId);
		ride.setRouteId(routeId);
		service.saveRide(ride);
		req.setAttribute("rideDetails", service.getRideSuccessDetails(userId,routeId));
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/ridedetails.jsp");
		rd.forward(req, res);

		//ride.setDate(LocalDate.now());
		
	}
}

}
