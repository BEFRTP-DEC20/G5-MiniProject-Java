package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;

/**
 * Servlet implementation class RegularController
 */
public class VisitorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDao = new UserDaoImpl();

	private UserService userService = new UserServiceImpl(userDao);

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		String path = request.getPathInfo();

		if (path.equals("/list")) {
			try {
				List<Category> categoryList = userService.findCategory();
				request.setAttribute("categoryList", categoryList);

				request.getRequestDispatcher("/index.jsp").forward(request, response);

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
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
		//---------------------------------------registration-----------------------------------------------------
		if (path.equals("/registration")) {
			User registerUser = new User();
			String fullName = request.getParameter("fullName");
			String username = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			String securityQuestion = request.getParameter("security1");
			String securityAnswer = request.getParameter("securityAnswer");

			User user = new User(fullName, username, password,securityQuestion,securityAnswer);
			
			try {
				int success = userService.registerUser(user);
				response.sendRedirect("index.jsp");

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		String path = request.getPathInfo();

		if (path.equals("/list")) {
			try {
				List<Category> categoryList = userService.findCategory();
				request.setAttribute("categoryList", categoryList);

				request.getRequestDispatcher("/index.jsp").forward(request, response);

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
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
		//---------------------------------------registration-----------------------------------------------------
		if (path.equals("/registration")) {
			User registerUser = new User();
			String fullName = request.getParameter("fullName");
			String username = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			String securityQuestion = request.getParameter("security1");
			String securityAnswer = request.getParameter("securityAnswer");

			User user = new User(fullName, username, password,securityQuestion,securityAnswer);
			
			try {
				int success = userService.registerUser(user);
				response.sendRedirect(request.getContextPath()+"/index.jsp");

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
	
	}

}