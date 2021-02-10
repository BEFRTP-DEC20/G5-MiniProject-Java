package com.cybage.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.service.UserService;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.service.UserServiceImpl;
import com.mysql.cj.Session;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"user"}))
public class UserController extends HttpServlet {
	
	private UserDao userDao = new UserDaoImpl();

	private UserService userService = new UserServiceImpl(userDao);

	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getPathInfo();

		if (path.equals("/list")) {
			try {

				String userName = request.getRemoteUser();
				List<Course> enrolledList = userService.findEnrolledCourses(userName);
				List<Category> categories = userService.findCategory();
				request.setAttribute("categoryList", categories);
				request.setAttribute("enrolledList",enrolledList);
				request.getRequestDispatcher("/user/UserHome.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
		
		if(path.equals("/search")) {
			String search_string = request.getParameter("search");
		System.out.println(search_string);
			if(search_string == null)
			{
				request.getRequestDispatcher("/list").forward(request, response);
			}
			else {
			List<Category> categoryList = new ArrayList<Category>();
			List<Course> courseList = new ArrayList<Course>();
			try {
				categoryList = userService.searchByCategory(search_string);
				courseList = userService.searchByCourse(search_string);
				System.out.println(categoryList);
				System.out.println(courseList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("categoryList",categoryList);	
			request.setAttribute("courseList", courseList);
			
			request.getRequestDispatcher("/user/UserHome.jsp").forward(request, response);
			}
		}
		//---------------------------------------registration-----------------------------------------------------
		if (path.equals("/registration")) {
			String fullName = request.getParameter("fullName");
			String username = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			String securityQuestion = request.getParameter("security1");
			String securityAnswer = request.getParameter("securityAnswer");

			User user = new User(fullName, username, password,securityQuestion,securityAnswer);
			
			try {
				int success = userService.registerUser(user);
				if(success==1)
					response.sendRedirect("index.jsp");

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
		
//		---------------------------Course----------------------
		if (path.equals("/course")) {
			System.out.println("inside course method....");
			int cat_id = (Integer.parseInt(request.getParameter("id")));
			System.out.println(cat_id);
			try {
				List<Course> courses = userService.findCourses(cat_id);
				request.setAttribute("courseList", courses);

				request.getRequestDispatcher("/user/user-courses.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
		}
		
	
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

	String path = request.getPathInfo();
//-------------------------------------------display category and course list-------------------------------------------
	if (path.equals("/list")) {
		try {
			List<Category> categories = userService.findCategory();
			request.setAttribute("categoryList", categories);

			request.getRequestDispatcher("/user/UserHome.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("error occurred: " + e.getMessage());
		}
	}
	if(path.equals("/search")) {
		String search_string = request.getParameter("search");
		List<Category> categoryList = new ArrayList<Category>();
		List<Course> courseList = new ArrayList<Course>();
		try {
			categoryList = userService.searchByCategory(search_string);
			courseList = userService.searchByCourse(search_string);
			System.out.println(categoryList);
			System.out.println(courseList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("categoryList",categoryList);	
		request.setAttribute("courseList", courseList);
		
		request.getRequestDispatcher("/user/UserHome.jsp").forward(request, response);
	}

	if (path.equals("/open")) {
		try {
			

			request.getRequestDispatcher("/footer.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("error occurred: " + e.getMessage());
		}
	}
	//---------------------------------------user registration-----------------------------------------------------
			if (path.equals("/registration")) {
				String fullName = request.getParameter("fullName");
				String username = request.getParameter("userName");
				String password = request.getParameter("userPassword");
				String securityQuestion = request.getParameter("security1");
				String securityAnswer = request.getParameter("securityAnswer");

				User user = new User(fullName, username, password,securityQuestion,securityAnswer);
				
				try {
					int success = userService.registerUser(user);
					if(success==1)
						response.sendRedirect("/index.jsp");

				} catch (Exception e) {
					System.out.println("error occurred: " + e.getMessage());
				}
			}

			
//------------------------------user profile----------------------------------------
			if(path.equals("/profile")) {
				try {

					String fullName = request.getParameter("fullName");
					String userName = request.getParameter("userName");
					String password = request.getParameter("password");

				}catch(Exception e) {
					System.out.println("error occurred: " + e.getMessage());
				}
			}
			}



}
