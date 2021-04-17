package ola.com.booking.service;

import ola.com.booking.dao.UserDao;
import ola.com.booking.dao.UserDaoImpl;
import ola.com.booking.helper.UserHelper;
import ola.com.booking.model.User;
import ola.com.booking.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao userDao;

	public void saveUser(User user) {
		System.out.println("ENTER INTO SERVICE IMPL");
		userDao = new UserDaoImpl();
		userDao.saveUser(user);
		//user.setId(UserHelper.getIncrement());
		//userDao.saveUser(user);	
	}

	public int validateUser(String username, String password) {
		return userDao.validateUser(username, password);
	}
}
