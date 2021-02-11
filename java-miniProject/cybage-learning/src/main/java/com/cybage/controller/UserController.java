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
import com.cybage.exception.UserException;
import com.cybage.service.UserService;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.PrimeUser;
import com.cybage.model.RegularUser;
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
		
//-------------------------------------Course--------------------------------------------
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
		if(path.equals("/profileDisplay")) {
			try {
				String userName= request.getRemoteUser();
				System.out.println("in profile display");
				User user = userService.displayProfile(userName);
				System.out.println(user);
				if(user == null) {
					throw new UserException("could not find user");
				}
				request.setAttribute("user", user);
				System.out.println("Attribute set: "+user);
				request.getRequestDispatcher("/user/user-profile.jsp").forward(request, response);	
			}
			
			catch(Exception e) {
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
	
			
//------------------------------user profile----------------------------------------
			if(path.equals("/profileDisplay")) {
				try {
					String userName= request.getRemoteUser();
					System.out.println("in profile display");
					
					PrimeUser user = userService.displayProfile(userName);
					if(user == null) {
						throw new UserException("could not find user");
					}
					request.setAttribute("user", user);
					System.out.println(user.isIs_prime_user());
					request.setAttribute("isPrime",user.isIs_prime_user());
					System.out.println(user);
					request.getRequestDispatcher("/user/user-profile.jsp").forward(request, response);	
				}
				
				catch(Exception e) {
					System.out.println("error occurred: " + e.getMessage());
				}
			}
			
			
		
//---------------------------Update Profile---------------------------------------------------
		if(path.equals("/updateProfile"))
		{
			try {
				PrimeUser user = new PrimeUser();
				user.setFullName(request.getParameter("fullName"));
				user.setUserName(request.getRemoteUser());
				user.setPassword("old password: "+request.getParameter("newPassword"));
				
				if((request.getParameter("newPassword")).equals("null"))
				{
					System.out.println(user.getPassword());
					
				}
				else
				{
					System.out.println("new password updated");
					user.setPassword(request.getParameter("newPassword"));
				}
				System.out.println(user.getFullName());
				System.out.println(user.getUserName());
				System.out.println(user.getPassword());
				System.out.println(request.getParameter("primeUser"));
				if(request.getParameter("primeUser").equals("true"))
				{
					user.setIs_prime_user(true);
				}
				else
				{
					user.setIs_prime_user(false);
					
				}
				userService.updateProfile(user);
				request.getRequestDispatcher("/list").forward(request, response);
			}catch(Exception e)
			{
				System.out.println("error occurred: " + e.getMessage());
			}
		}
	}



}
