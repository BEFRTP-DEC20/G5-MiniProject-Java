package com.cybage.controller;

import java.util.*;
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
import com.cybage.model.CurrentVideo;
import com.cybage.model.SubCourse;
import com.cybage.model.User;
import com.cybage.service.UserServiceImpl;
import com.mysql.cj.Session;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "user" }))
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
		System.out.println(path);

//----------------------------HOME USER LIST--------------------------------------
		if (path.equals("/list")) {
			try {

				String userName = request.getRemoteUser();
				List<Course> enrolledList = userService.findEnrolledCourses(userName);
				List<Category> categories = userService.findCategory();
				request.setAttribute("categoryList", categories);
				request.setAttribute("enrolledList", enrolledList);
				request.getRequestDispatcher("/user/UserHome.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}

		if (path.equals("/search")) {
			String search_string = request.getParameter("search");
			System.out.println(search_string);
			if (search_string == null) {
				request.getRequestDispatcher("/list").forward(request, response);
			} else {
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
				request.setAttribute("categoryList", categoryList);
				request.setAttribute("courseList", courseList);

				request.getRequestDispatcher("/user/UserHome.jsp").forward(request, response);
			}
		}
		// ---------------------------------------registration-----------------------------------------------------
		if (path.equals("/registration")) {
			String fullName = request.getParameter("fullName");
			String username = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			String securityQuestion = request.getParameter("security1");
			String securityAnswer = request.getParameter("securityAnswer");

			User user = new User(fullName, username, password, securityQuestion, securityAnswer);

			try {
				int success = userService.registerUser(user);
				if (success == 1)
					response.sendRedirect("index.jsp");

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}

//		---------------------------Course----------------------
		if (path.equals("/course")) {
			System.out.println("inside course method....");
			int cat_id = (Integer.parseInt(request.getParameter("id")));
			String userName = request.getRemoteUser();
			System.out.println(cat_id);
			try {
				List<Course> courses = userService.findCourses(cat_id);
				List<Course> enrolledList = userService.findEnrolledCourses(userName);

				if (courses.removeAll(enrolledList)) {
					System.out.println(courses);
					System.out.println(enrolledList);
				}
				request.setAttribute("courseList", courses);
				request.setAttribute("enrolledList", enrolledList);
				request.getRequestDispatcher("/user/user-courses.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}

		// -----------------------START COURSE------------------------------------------

		if (path.equals("/start-course")) {
			System.out.println("inside start course");
			System.out.println(path.indexOf("/start-course"));
			// int currentVideo = Integer.parseInt(path.substring(14,1));
			int currentVideo = Integer.parseInt(request.getParameter("vid"));

			// int currentVideo =1;
			System.out.println(currentVideo);
			int courseid = Integer.parseInt(request.getParameter("id"));
			String username = request.getRemoteUser();
			List<SubCourse> subcourses = null;
			try {
				subcourses = userService.findSubCourse();

				int current_videoInDb = userService.getCurrentVideo(courseid);
				System.out.println("currentVideo:" + currentVideo);
				System.out.println("From database" + current_videoInDb);

				if (currentVideo == 0) {
					if (current_videoInDb > 0) {
						currentVideo = current_videoInDb;
					} else {
						currentVideo = 1;
					}
				}
				current_videoInDb = currentVideo;
				// now update current_video count in db
				int status = userService.updateCurrentVideo(new CurrentVideo(username, courseid, current_videoInDb));
				System.out.println("status:" + status);
				request.getSession().setAttribute("video_count", subcourses.size());
				request.getSession().setAttribute("current_video", currentVideo);
				// System.out.println("size of subcourses" + subcourses.size());
				if (subcourses.size() == 0) {
					try {
						throw new UserException("No SubCourse found in database...");
					} catch (UserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// System.out.println(subcourses.get(currentVideo-1));

				request.getSession().setAttribute("subcourse_id", subcourses.get(currentVideo - 1).getSubCourseId());
				request.getSession().setAttribute("subcourse_title",
						subcourses.get(currentVideo - 1).getSubCourseName());
				request.getSession().setAttribute("subcourse_desc",
						subcourses.get(currentVideo - 1).getSubCourseDescription());
				request.getSession().setAttribute("subcourse_url", subcourses.get(currentVideo - 1).getVideoUrl());
				request.getSession().setAttribute("course_id", courseid);
				System.out.println("course id passes: " + courseid);
				response.sendRedirect(request.getContextPath() + "/user/start-course.jsp");

			} catch (SQLException e) {
				// log.error("could not get Subcourse: " + e.getMessage());
				System.out.println("Error in Subcourse");
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
		if (path.equals("/search")) {
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
			request.setAttribute("categoryList", categoryList);
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
		// ---------------------------------------user
		// registration-----------------------------------------------------
		if (path.equals("/registration")) {
			String fullName = request.getParameter("fullName");
			String username = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			String securityQuestion = request.getParameter("security1");
			String securityAnswer = request.getParameter("securityAnswer");

			User user = new User(fullName, username, password, securityQuestion, securityAnswer);

			try {
				int success = userService.registerUser(user);
				if (success == 1)
					response.sendRedirect("/index.jsp");

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}

//------------------------------user profile----------------------------------------
		if (path.equals("/profile")) {
			try {

				String fullName = request.getParameter("fullName");
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}

	}

}
