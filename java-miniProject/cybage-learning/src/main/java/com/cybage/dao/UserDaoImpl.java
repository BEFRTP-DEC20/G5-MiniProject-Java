package com.cybage.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import com.cybage.model.Category;
import com.cybage.model.Course;

import com.cybage.model.PrimeUser;

import com.cybage.model.CurrentVideo;
import com.cybage.model.EnrolledCourse;
import com.cybage.model.SubCourse;


import com.cybage.util.DbUtil;

public class UserDaoImpl implements UserDao {

//----------------------------display category-----------------------------------------	

	public List<Category> findCategory() throws Exception {
		Connection con = DbUtil.getCon();

		String sql = "select category_id, category_name, image_url from category";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Category> categories = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setCategoryId(rs.getInt(1));
			category.setCategoryName(rs.getString(2));
			category.setImageUrl(rs.getString(3));

			categories.add(category);
		}
		return categories;
	}

//------------------------------search category----------------------------------------

	public List<Category> searchByCategory(String searchString) throws SQLException {

		Connection connection = DbUtil.getCon();
		String sql = "select * from category where category_name LIKE ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "%" + searchString + "%");
		ResultSet rs = ps.executeQuery(); // throw an exception if result set is less then 0
		List<Category> categoryList = new ArrayList<Category>();

		while (rs.next()) {
			Category category = new Category();
			category.setCategoryId(rs.getInt(1));
			category.setCategoryName(rs.getString(2));
			category.setImageUrl(rs.getString(3));
			categoryList.add(category);
		}
		return categoryList;

	}

//-----------------------------search course--------------------------------------------------------

	public List<Course> searchByCourse(String searchString) throws SQLException {
		Connection connection = DbUtil.getCon();
		String sql = "select * from course where course_name LIKE ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "%" + searchString + "%");
		ResultSet rs = ps.executeQuery(); // throw an exception if result set is less then 0
		List<Course> courseList = new ArrayList<Course>();

		while (rs.next()) {
			Course course = new Course();
			course.setCourseId(rs.getInt(1));
			course.setCourseName(rs.getString(2));
			course.setCoursePrice(rs.getInt(3));
			course.setCourseDuration(rs.getInt(4));
			course.setCourseAuthor(rs.getString(5));
			course.setCourseDescription(rs.getString(6));
			course.setImageUrl(rs.getString(7));

			courseList.add(course);
		}
		return courseList;
	}

//-----------------------------User Registration--------------------------------

	public int registerUser(PrimeUser registerUser) throws SQLException {
		Connection connection = DbUtil.getCon();
		String sql = "insert into user(full_name, user_name, user_password, user_role, user_security_question, user_security_answer, is_prime_user)"
				+ "values( ? , ? , ? , ?, ? , ? , ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		registerUser.setUserId((int) Math.random());

		ps.setString(1, registerUser.getFullName());
		ps.setString(2, registerUser.getUserName());
		ps.setString(3, registerUser.getPassword());
		ps.setString(4, "user");
		System.out.println(registerUser);
		ps.setString(5, registerUser.getUserSecurityQuestion());
		ps.setString(6, registerUser.getUserSecurityAnswer());

		ps.setBoolean(7, registerUser.isIs_prime_user());
		return ps.executeUpdate(); // throw an exception if result set is less then 0

	}

//-------------------------------FIND ALL COURSES----------------------------------------------
	public List<Course> findCourses(int categoryId) throws Exception {
		Connection con = DbUtil.getCon();

		String sql = "select course_id,course_name,course_price,course_duration,course_author,course_description,image_url,total_sub_course from course where category_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, categoryId);
		ResultSet rs = ps.executeQuery();

		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setCourseId(rs.getInt(1));
			course.setCourseName(rs.getString(2));
			course.setCoursePrice(rs.getInt(3));
			course.setCourseDuration(rs.getInt(4));
			course.setCourseAuthor(rs.getString(5));
			course.setCourseDescription(rs.getString(6));
			course.setImageUrl(rs.getString(7));
			course.setTotalSubCourse(rs.getInt(8));

			courses.add(course);
		}
		return courses;
	}

//---------------------------Find User ID by UserName----------------------------------
	public int findUserId(String userName) {
		int user_id = 0;
		try {
			Connection con = DbUtil.getCon();
			String sql2 = "select user_id from user where user_name = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql2);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user_id = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user_id;
	}

//---------------------------ENROLLED COURSES--------------------------------------------
	public List<Course> findEnrolledCourses(String userName) throws SQLException {
		Connection con = DbUtil.getCon();
		int userId = findUserId(userName);
		String sql = "select * from course left join enrolled_course on course.course_id = enrolled_course.course_id where user_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();

		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setCourseId(rs.getInt(1));
			course.setCourseName(rs.getString(2));
			course.setCoursePrice(rs.getInt(3));
			course.setCourseDuration(rs.getInt(4));
			course.setCourseAuthor(rs.getString(5));
			course.setCourseDescription(rs.getString(6));
			course.setImageUrl(rs.getString(7));
			course.setTotalSubCourse(rs.getInt(8));

			courses.add(course);
		}
		return courses;
	}
//----------------------------------display profile------------------------------------

	public PrimeUser displayProfile(String userName) throws SQLException {
		Connection con = DbUtil.getCon();
		String sql = "select * from user where user_name = ?";
		PreparedStatement ps;
		ps = con.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		PrimeUser user = new PrimeUser();
		while (rs.next()) {
			user.setUserId(rs.getInt(1));
			user.setFullName(rs.getString(2));
			user.setUserName(rs.getString(3));
			System.out.println(rs.getString(4));
			user.setPassword(rs.getString(4));
			user.setRole(rs.getString(5));
			System.out.println(rs.getString(5));
			user.setUserSecurityQuestion(rs.getString(6));
			System.out.println(rs.getString(6));
			user.setUserSecurityAnswer(rs.getString(7));
			System.out.println(rs.getString(7));
			user.setIs_prime_user(rs.getBoolean(8));
			System.out.println(rs.getBoolean(8));
		}
		System.out.println(user);
		return user;
	}

	// ----------------------------------Update
	// profile------------------------------------

	public int updateProfile(PrimeUser user) throws SQLException {
		Connection con = DbUtil.getCon();
		System.out.println(user.getUserName());
		String sql2 = "update user set full_name=?,user_password=? , is_prime_user=? where user_name = ?";
		PreparedStatement ps;
		ps = con.prepareStatement(sql2);
		ps.setString(1, user.getFullName());

		ps.setString(2, user.getPassword());
		ps.setBoolean(3, user.isIs_prime_user());
		ps.setString(4, user.getUserName());
		return ps.executeUpdate();

	}

	public boolean isPrime(String userName) {
		boolean user_prime = false;
		try {
			Connection con = DbUtil.getCon();
			String sql2 = "select is_prime_user from user where user_name = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql2);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user_prime = rs.getBoolean(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user_prime;

	}

	public List<SubCourse> findSubCourse(int courseid) throws SQLException {
		Connection con = DbUtil.getCon();

		String sql = "select sub_course_id, sub_course_name, sub_course_duration, sub_course_description, video_url, video_sequence, course_id from sub_course where course_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseid);
		ResultSet rs = ps.executeQuery();

		List<SubCourse> subCourses = new ArrayList<SubCourse>();
		while (rs.next()) {
			SubCourse subCourse = new SubCourse();

			subCourse.setSubCourseId(rs.getInt(1));
			subCourse.setSubCourseName(rs.getString(2));
			subCourse.setSubCourseDuration(rs.getInt(3));
			subCourse.setSubCourseDescription(rs.getString(4));
			subCourse.setVideoUrl(rs.getString(5));
			subCourse.setVideoSequence(rs.getInt(6));
			subCourse.setCourseId(rs.getInt(7));

			subCourses.add(subCourse);

		}
		return subCourses;
	}

	public int getCurrentVideo(int courseid) throws SQLException {
		Connection con = DbUtil.getCon();

		String sql = "select current_video from enrolled_course where course_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public int updateCurrentVideo(CurrentVideo currentVideo) throws SQLException {
		String sql = "update enrolled_course set current_video = ? where user_id = ? and course_id = ? ";

		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, currentVideo.getCurrentVideoInDb());
		ps.setInt(2, findUserId(currentVideo.getUsername()));
		ps.setInt(3, currentVideo.getCourseId());
		System.out.println("in dao" + currentVideo.getCurrentVideoInDb());
		return ps.executeUpdate();

	}

	public List<Course> findEnrolledCoursesByCategory(String userName, int cat_id) throws SQLException {
		Connection con = DbUtil.getCon();
		int userId = findUserId(userName);
		String sql = "select * from course left join enrolled_course on course.course_id = enrolled_course.course_id where user_id = ? and category_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, cat_id);
		ResultSet rs = ps.executeQuery();

		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setCourseId(rs.getInt(1));
			course.setCourseName(rs.getString(2));
			course.setCoursePrice(rs.getInt(3));
			course.setCourseDuration(rs.getInt(4));
			course.setCourseAuthor(rs.getString(5));
			course.setCourseDescription(rs.getString(6));
			course.setImageUrl(rs.getString(7));
			course.setTotalSubCourse(rs.getInt(8));

			courses.add(course);
		}
		return courses;
	}

//--------------------------------------Enroll Course--------------------------------------------
	public int enroll(EnrolledCourse ec) throws SQLException {
		Connection con = DbUtil.getCon();
		String sql = "insert into enrolled_course values(? , ? , ? , ? , ? , ? , ? , ? )";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ec.getEnrollmentId());
		ps.setString(2, ec.getPurchaseDate());
		ps.setInt(3, ec.getCoursePrice());
		ps.setInt(4, ec.getCurrentVideo());
		ps.setBoolean(5, ec.isCourseComplete());
		ps.setInt(6, ec.getCourseId());
		ps.setInt(7, ec.getUserId());
		ps.setString(8, ec.getCertificateUrl());

		return ps.executeUpdate();
	}

	public int updateCourseCompleteStatus(int courseid, String username) throws SQLException {
		String sql = "update enrolled_course set course_complete = 1 where user_id = ? and course_id = ? ";

		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, findUserId(username));
		ps.setInt(2, courseid);
		return ps.executeUpdate();
	}

	public List<String> gererateCertificate(int courseid, String username) throws SQLException {
		String sqlFullName = "select full_name from user where user_id = ?";

		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sqlFullName);
		ps.setInt(1, findUserId(username));
		ResultSet rs = ps.executeQuery();
		rs.next();
		String fullName = rs.getString(1);

		String sqlCourseDetails = "select course_name, category_name from course INNER JOIN category On category.category_id = course.category_id INNER JOIN enrolled_course ON course.course_id = enrolled_course.course_id where enrolled_course.course_complete =1 and enrolled_course.user_id = ? and enrolled_course.course_id = ?";

		ps = con.prepareStatement(sqlCourseDetails);
		ps.setInt(1, findUserId(username));
		ps.setInt(2, courseid);
		ResultSet rs1 = ps.executeQuery();
		rs1.next();
		String courseName = rs1.getString(1);
		String categoryName = rs1.getString(2);

		ps.close();
		return Arrays.asList(fullName, categoryName, courseName);
	}

}
