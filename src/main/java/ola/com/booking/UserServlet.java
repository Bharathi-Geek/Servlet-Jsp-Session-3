package ola.com.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ola.com.booking.model.User;
import ola.com.booking.service.UserService;
import ola.com.booking.service.UserServiceImpl;

@WebServlet("/users")
public class UserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("action").equals("register")) {
			System.out.println("ENTER INTO USER SERVLET");
			User user = new User();
			user.setName(req.getParameter("name"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setPhoneNo(req.getParameter("phoneNo"));
			
			userService.saveUser(user);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
	        rd.forward(req, resp);
		}
		
		if(req.getParameter("action").equals("login")) {
			int isExist = userService.validateUser(req.getParameter("username"), req.getParameter("password"));
			System.out.println("THE ISEXIST IS:"+isExist);
			//instead of boolean get user object
			resp.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = resp.getWriter();
	        
			if(isExist!=0) {//user obj null or not
				RequestDispatcher rd = req.getRequestDispatcher("routes");
				HttpSession session = req.getSession();
				session.setAttribute("userId", isExist);
				System.out.println("THE SESSION USER ID IN LOGIN:"+session.getAttribute("userId"));
				//send userId also
	            rd.forward(req, resp);
			}
			else {
				out.println("<font color='red'><b>You have entered incorrect password</b></font>");
	            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.html");
	            rd.include(req, resp);
			}
		}
		
		
		
	}

	
}
