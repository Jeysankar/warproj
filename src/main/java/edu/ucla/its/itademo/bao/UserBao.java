package edu.ucla.its.itademo.bao;

import java.util.List;

import edu.ucla.its.itademo.dao.UserDao;
import edu.ucla.its.itademo.util.User;

public class UserBao {

	private UserDao userDao;
	
	/**
	 * @param args
	 */
	public List<User> filterUsersList() {
		return userDao.getUsersList();
	}
	
	public User retrieveUser(User user) {
		return userDao.retrieveUser(user);
	}
	
	
	public void registerUser(User user) {
		userDao.registerUser(user);
	}
	
	public UserDao getDisplayDao() {
		return userDao;
	}

	public void setDisplayDao(UserDao userDao) {
		this.userDao = userDao;
	}
}