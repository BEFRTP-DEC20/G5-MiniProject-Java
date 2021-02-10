package com.cybage.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.util.DbUtil;

public class UserDaoImpl implements UserDao {
	
	
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

	//-----------------search category-----------------------------------------------------------
		public List<Category> searchByCategory(String searchString) throws SQLException {
			Connection connection = DbUtil.getCon();
			String sql = "select * from category where category_name LIKE ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + searchString + "%");
			ResultSet rs = ps.executeQuery();       //throw an exception if result set is less then 0
			List<Category> categoryList = new ArrayList<Category>();
		
			while(rs.next()) {
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
			ResultSet rs = ps.executeQuery();     //throw an exception if result set is less then 0
			List<Course> courseList = new ArrayList<Course>();
		
			while(rs.next()) {
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
		public int registerUser(User registerUser)  throws SQLException  {
			Connection connection = DbUtil.getCon();
			String sql = "insert into user(full_name, user_name, user_password, user_role, user_security_question, user_security_answer)"+"values( ? , ? , ? , ?, ? , ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			registerUser.setUserId((int)Math.random());
//			ps.setInt(1, registerUser.getUserId());
			ps.setString(1, registerUser.getFullName());
			ps.setString(2, registerUser.getUserName());
			ps.setString(3, registerUser.getPassword());
			ps.setString(4, "user");
			System.out.println(registerUser);
			ps.setString(5, registerUser.getUserSecurityQuestion());
			ps.setString(6, registerUser.getUserSecurityAnswer());
			  return ps.executeUpdate();     //throw an exception if result set is less then 0
			
		
		
			
		}

		public List<Course> findCourses(int categoryId) throws Exception {
			Connection con = DbUtil.getCon();

			String sql = "select course_id,course_name,course_price,course_duration,course_author,course_description,image_url,total_sub_course from course where category_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,categoryId);
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
//---------------------Find User ID by UserName----------------------------------
		public int findUserId(String userName)
		{
			int user_id = 0;
			try {
				Connection con = DbUtil.getCon();
				String sql2 = "select user_id from user where user_name = ?";
				PreparedStatement ps;
				ps = con.prepareStatement(sql2);
				ps.setString(1,userName);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					user_id=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			ps.setInt(1,userId);
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


}
