package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<Category> findCategory() throws Exception{
		return userDao.findCategory();
	}

	public List<Category> searchByCategory(String searchString) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		
		return userDao.searchByCategory(searchString);
				
	}

	public List<Course> searchByCourse(String searchString) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		
		return userDao.searchByCourse(searchString);
	}


	public int registerUser(User registerUser) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		return userDao.registerUser(registerUser);
	}

	public List<Course> findCourses(int categoryId) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.findCourses(categoryId);
	}

	
}
