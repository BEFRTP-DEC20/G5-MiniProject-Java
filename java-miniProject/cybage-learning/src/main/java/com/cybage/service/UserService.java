package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;

import com.cybage.model.PrimeUser;

import com.cybage.model.CurrentVideo;
import com.cybage.model.EnrolledCourse;
import com.cybage.model.SubCourse;


public interface UserService {
	
	public List<Category> findCategory() throws Exception;
	public List<Category> searchByCategory(String searchString) throws SQLException;
	public List<Course> searchByCourse(String searchString) throws SQLException;
	public int registerUser(PrimeUser registerUser) throws SQLException;
	public List<Course> findCourses(int categoryId) throws Exception;
	public List<Course> findEnrolledCourses(String userName) throws SQLException;

	public PrimeUser displayProfile(String userName)throws SQLException;
	public int updateProfile(PrimeUser user) throws SQLException;

	public List<SubCourse> findSubCourse(int courseid) throws SQLException;
	public int getCurrentVideo(int courseid) throws SQLException;
	public int updateCurrentVideo(CurrentVideo currentVideo) throws SQLException;
	public List<Course> findEnrolledCoursesByCategory(String userName, int cat_id) throws SQLException;
	public boolean isPrime(String userName);
	public int enroll(EnrolledCourse ec) throws SQLException;
	public int findUserId(String userName);

	public int updateCourseCompleteStatus(int courseid, String username) throws SQLException;
	public List<String> gererateCertificate(String username, int courseid) throws SQLException;
	public List<Course> findCompletedCourse(String userName) throws SQLException;

}
