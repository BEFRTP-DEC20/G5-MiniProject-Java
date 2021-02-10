package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.util.DbUtil;


public class AdminDaoImpl implements AdminDao{
	public int addCategory(Category category) throws SQLException {
		String sql = "insert into category(category_name, image_url) values(?, ?)";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,category.getCategoryName());
		ps.setString(2,category.getImageUrl());
		return ps.executeUpdate();
	}

	public Category getCategoryById(int catId) throws SQLException {
		String sql = "select * from category where category_id = ?";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, catId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Category category = new Category();
		category.setCategoryId(rs.getInt(1));
		category.setCategoryName(rs.getString(2));
		category.setImageUrl(rs.getString(3));
		return category;
	}
	
	public List<Category> listCategory() throws SQLException{
		
		String sql = "select category_id, category_name, image_url from category";
		Connection con = DbUtil.getCon();
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
	
	public int deleteCategory(int catId) throws SQLException {
		String sql = "delete from category where category_id = ?";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, catId);
		return ps.executeUpdate();
	}
	
	public int updateCategory(Category category) throws SQLException{
		String sql = "update category set category_name = ? , image_url = ? where category_id = ?";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category.getCategoryName());
		ps.setString(2, category.getImageUrl());
		ps.setInt(3, category.getCategoryId());
		return ps.executeUpdate();
	}
	
	public List<Course> listCourse(int categoryId) throws SQLException{
		String sql = "select course_id, course_name, course_price, course_duration, course_author, course_description, image_url from course where category_id = ?";
		Connection con = DbUtil.getCon();
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
			course.setCategoryId(categoryId);
			courses.add(course);
		}
		return courses;
	}
	
	public int addCourse(Course course) throws SQLException{
		String sql = "insert into course(course_name, course_price, course_duration, course_author, course_description, total_sub_course, image_url, category_id) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,course.getCourseName());
		ps.setInt(2,course.getCoursePrice());
		ps.setInt(3,course.getCourseDuration());
		ps.setString(4,course.getCourseAuthor());
		ps.setString(5,course.getCourseDescription());
		ps.setInt(6,course.getTotalSubCourse());
		ps.setString(7,course.getImageUrl());
		ps.setInt(8,course.getCategoryId());
		return ps.executeUpdate();
	}
	
	public int updateCourse(Course course) throws SQLException{
		String sql = "update course set course_name = ? , course_price = ?, course_duration = ?, course_author = ?, course_description = ?, total_sub_course = ?, image_url = ? where course_id = ?";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,course.getCourseName());
		ps.setInt(2,course.getCoursePrice());
		ps.setInt(3,course.getCourseDuration());
		ps.setString(4,course.getCourseAuthor());
		ps.setString(5,course.getCourseDescription());
		ps.setInt(6,course.getTotalSubCourse());
		ps.setString(7,course.getImageUrl());
		ps.setInt(8, course.getCourseId());
		return ps.executeUpdate();
	}
	
	public int deleteCourse(int courseId) throws SQLException{
		String sql = "delete from course where course_id = ?";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseId);
		return ps.executeUpdate();
	}
}
