package com.cybage.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.PrimeUser;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;


public class VisitorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDao = new UserDaoImpl();

	private UserService userService = new UserServiceImpl(userDao);

	public static final Logger log =  LogManager.getLogger(VisitorController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		
		if (path.equals("/")) {
			try {
				List<Category> categoryList = userService.findCategory();
				request.setAttribute("categoryList", categoryList);

				request.getRequestDispatcher("list").forward(request, response);

			} catch (Exception e) {
				log.error("exception occurred... " + e.getLocalizedMessage());
			}
		}
//---------------------------------------category list-----------------------------------------------------	
		if (path.equals("/list")) {
			try {
				List<Category> categoryList = userService.findCategory();
				request.setAttribute("categoryList", categoryList);

				request.getRequestDispatcher("/index.jsp").forward(request, response);

			} catch (Exception e) {
				log.error("exception occurred... " + e.getLocalizedMessage());
			}
		}
//---------------------------------------search-----------------------------------------------------		
		if(path.equals("/search")) {
			String search_string = request.getParameter("search");
			List<Category> categoryList = new ArrayList<Category>();
			List<Course> courseList = new ArrayList<Course>();
			try {
				categoryList = userService.searchByCategory(search_string);
				courseList = userService.searchByCourse(search_string);
				log.debug("Category : " +categoryList);
				log.debug("Course : "+courseList);
			} catch (SQLException e) {
				log.error("exception occurred... " + e.getLocalizedMessage());
			}
			request.setAttribute("categoryList",categoryList);	
			request.setAttribute("courseList", courseList);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
//---------------------------------------registration-----------------------------------------------------
		if (path.equals("/registration")) {
			String fullName = request.getParameter("fullName");
			String username = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			String securityQuestion = request.getParameter("security1");
			String securityAnswer = request.getParameter("securityAnswer");
			String isPrime = request.getParameter("primeUser");
			log.debug("Prime User" +isPrime);
			Boolean isUserPrime = false;
			if(isPrime.equals("true"))
			{
				isUserPrime=true;
			}
			PrimeUser user = new PrimeUser(fullName, username, password,securityQuestion,securityAnswer,isUserPrime);
			
			try {
				int success = userService.registerUser(user);
				if(success==1)
					response.sendRedirect(request.getContextPath()+"/VisitorController/list");

			} catch (Exception e) {
				log.error("exception occurred... " + e.getLocalizedMessage());
			}
		}
		
//---------------------------------------course-----------------------------------------------------		
		if (path.equals("/course")) {
			int cat_id = (Integer.parseInt(request.getParameter("id")));
			System.out.println(cat_id);
			try {
				List<Course> courses = userService.findCourses(cat_id);
				request.setAttribute("courseList", courses);
				request.getRequestDispatcher("/index.jsp").forward(request, response);

			} catch (Exception e) {
				log.error("exception occurred... " + e.getLocalizedMessage());
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
