package com.cybage.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.CurrentVideo;
import com.cybage.model.EnrolledCourse;
import com.cybage.model.PrimeUser;
import com.cybage.model.SubCourse;
import com.cybage.model.User;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;

class UserDaoImplTest {

	private UserDao userDao = new UserDaoImpl();
	private UserService userService = new UserServiceImpl(userDao);

	@Test
	void testFindCategory() throws Exception {
		List<Category> category = userService.findCategory();
		assertEquals(11, category.size());
	}

	@Test
	void testSearchByCategory() throws SQLException {
		List<Category> category = userService.searchByCategory("development");
		assertEquals(0, category.size());
	}

	@Test
	void testSearchByCourse() throws SQLException {
		List<Course> category = userService.searchByCourse("development");
		assertEquals(0, category.size());
	}

//	@Test
//	void testRegisterUser() {
//		int isRegistered = userService.registerUser(new PrimeUser("Neeraj Nehra", "neerajn", "pass", "q", "a"));
//	}

	@Test
	void testFindCourses() throws Exception {
		List<Course> course = userService.findCourses(68);
		assertEquals(4, course.size());
	}

	@Test
	void testFindUserId() {
		int addCount = userService.findUserId("");
		assertEquals(0, addCount);
	}

	@Test
	void testFindEnrolledCourses() throws SQLException {
		List<Course> course = userService.findEnrolledCourses("");
		assertEquals(0, course.size());
	}

//	@Test
//	void testDisplayProfile() throws SQLException {
//		PrimeUser ps = userService.displayProfile("neerajn");
//		assertEquals("neerajn",ps.getUserName());
//	}

//	@Test
//	void testUpdateProfile() throws SQLException {
//		int isUpdate = userService.updateProfile(new PrimeUser("Neeraj Nehra", "neerajn", "password", "q", "a",true));
//		assertEquals(1, isUpdate);
//	}

//	@Test
//	void testIsPrime() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testFindSubCourse() throws SQLException {
		List<SubCourse> subCourse = userService.findSubCourse(25);
		assertEquals(1, subCourse.size());
	}

	@Test
	void testGetCurrentVideo() throws SQLException {
		int videoSeq = userService.getCurrentVideo(25);
		assertEquals(3, videoSeq);
	}

	@Test
	void testUpdateCurrentVideo() throws SQLException {
		int isUpdate = userService.updateCurrentVideo(new CurrentVideo("neerajn", 25, 3));
		assertEquals(1, isUpdate);
	}

	@Test
	void testFindEnrolledCoursesByCategory() throws SQLException {
		List<Course> ec = userService.findEnrolledCoursesByCategory("neerajn", 72);
		assertEquals(0, ec.size());
	}

//	@Test
//	void testEnroll() throws SQLException {
//		int isEnrolled = userService.enroll(new EnrolledCourse(27, 1, 1200, "2012-12-02"));
//		assertEquals(1, isEnrolled);
//	}

	@Test
	void testUpdateCourseCompleteStatus() throws SQLException {
		int isComplete = userService.updateCourseCompleteStatus(25, "neerajn");
		assertEquals(1, isComplete);
	}


}
