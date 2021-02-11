package com.cybage.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.SubCourse;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;

class AdminDaoImplTest {

	private AdminDao adminDao = new AdminDaoImpl();
	private AdminService adminService = new AdminServiceImpl(adminDao);

	/*-----------------------Test Cases for category.---------------------------------------*/
	@Test
	void testAddCategory() throws SQLException {
		int addCount = adminService.addCategory(new Category("nikita", "hskdf"));
		assertEquals(1, addCount);
	}

	@Test
	void testUpdateCategory() throws SQLException {
		Category category = new Category(67, "neha", "njsncw");
		int updateCount = adminService.updateCategory(category);
		assertEquals(1, updateCount);
	}

	@Test
	void testListCategory() throws SQLException {
		List<Category> category = adminService.listCategory();
		assertEquals(9, category.size());
	}

	@Test
	void testDeleteCategory() throws SQLException {
		int deleteCount = adminService.deleteCategory(67);
		assertEquals(1, deleteCount);
	}

	/*-----------------------Test Cases for course.---------------------------------------*/

	@Test
	void testAddCourse() throws SQLException {
		int addCount = adminService.addCourse(new Course("nikita", "calvin", "sjbjs", "sfbsj", 56, 987, 5, 68));
		assertEquals(1, addCount);
	}

	@Test
	void testUpdateCourse() throws SQLException {
		Course course = new Course(24, "harish", "makjd", "chemistry", "bfjs", 67, 4, 4);
		int updateCount = adminService.updateCourse(course);
		assertEquals(1, updateCount);
	}

	@Test
	void testDeleteCourse() throws SQLException {
		int deleteCount = adminService.deleteCourse(24);
		assertEquals(1, deleteCount);
	}

	@Test
	void testListCourse() throws SQLException {
		List<Course> course = adminService.listCourse(68);
		assertEquals(2, course.size());
	}

	/*-----------------------Test Cases for sub-course.---------------------------------------*/
	@Test
	void testAddSubCourse() throws SQLException {
		int addCount = adminService.addSubCourse(new SubCourse(3, 25, "neeraj", "hgh", "sjbjs", 5));
		assertEquals(1, addCount);
	}

	@Test
	void testUpdateSubCourse() throws SQLException {
		SubCourse subCourse = new SubCourse(1, 25, 25, "neeraj1", "hgh", "sjbjs", 6);
		int updateCount = adminService.updateSubCourse(subCourse);
		assertEquals(1, updateCount);
	}

	@Test
	void testDeleteSubCourse() throws SQLException {
		int deleteCount = adminService.deleteSubCourse(1);
		assertEquals(1, deleteCount);
	}

	@Test
	void testListSubCourse() throws SQLException {
		List<SubCourse> course = adminService.listSubCourse(25);
		assertEquals(1, course.size());
	}
}
