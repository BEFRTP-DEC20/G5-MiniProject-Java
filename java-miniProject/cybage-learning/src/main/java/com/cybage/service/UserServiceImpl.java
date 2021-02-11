package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.model.Category;
import com.cybage.model.Course;

import com.cybage.model.PrimeUser;

import com.cybage.model.CurrentVideo;
import com.cybage.model.EnrolledCourse;
import com.cybage.model.SubCourse;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<Category> findCategory() throws Exception {
		return userDao.findCategory();
	}

	public List<Category> searchByCategory(String searchString) throws SQLException {

		return userDao.searchByCategory(searchString);

	}

	public List<Course> searchByCourse(String searchString) throws SQLException {

		return userDao.searchByCourse(searchString);
	}

	public int registerUser(PrimeUser registerUser) throws SQLException {

		return userDao.registerUser(registerUser);
	}

	public List<Course> findCourses(int categoryId) throws Exception {

		return userDao.findCourses(categoryId);
	}

	public List<Course> findEnrolledCourses(String userName) throws SQLException {

		return userDao.findEnrolledCourses(userName);
	}

	public PrimeUser displayProfile(String userName) throws SQLException {

		return userDao.displayProfile(userName);
	}

	public int updateProfile(PrimeUser user) throws SQLException {

		return userDao.updateProfile(user);
	}

	public List<SubCourse> findSubCourse(int userid) throws SQLException {
		
		return userDao.findSubCourse(userid);
	}

	public int getCurrentVideo(int courseid) throws SQLException {
		
		return userDao.getCurrentVideo(courseid);
	}

	public int updateCurrentVideo(CurrentVideo currentVideo) throws SQLException {
	
		return userDao.updateCurrentVideo(currentVideo);
	}

	public List<Course> findEnrolledCoursesByCategory(String userName, int cat_id) throws SQLException {
	
		return userDao.findEnrolledCoursesByCategory(userName, cat_id);
	}

	public boolean isPrime(String userName) {
	
		return userDao.isPrime(userName);
	}

	public int enroll(EnrolledCourse ec) throws SQLException {
	
		return userDao.enroll(ec);
	}

	public int findUserId(String userName) {
	
		return userDao.findUserId(userName);
	}

	public int updateCourseCompleteStatus(int courseid, String username) throws SQLException {
	
		return userDao.updateCourseCompleteStatus(courseid, username);
	}

	public List<String> gererateCertificate(String username, int courseid) throws SQLException {
	
		return userDao.gererateCertificate(courseid, username);
	}

	@Override
	public List<Course> findCompletedCourse(String userName) throws SQLException {
	
		return userDao.findCompletedCourse(userName);
	}

}
