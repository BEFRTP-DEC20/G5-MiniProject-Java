package com.cybage.controller;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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

import com.cybage.model.CurrentVideo;
import com.cybage.model.EnrolledCourse;
import com.cybage.model.SubCourse;

import com.cybage.service.UserServiceImpl;

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
				List<Course> enrolledList = userService.findEnrolledCourses(userName).stream().sorted((o1, o2) -> (o1.getCourseName().compareTo(o2.getCourseName()))).collect(Collectors.toList());
				List<Course> completedList = userService.findCompletedCourse(userName).stream().sorted((o1, o2) -> (o1.getCourseName().compareTo(o2.getCourseName()))).collect(Collectors.toList());
				List<Category> categories = userService.findCategory();
				enrolledList.removeAll(completedList);
				boolean isPrime  = userService.isPrime(userName);
				request.setAttribute("categoryList", categories);
				request.setAttribute("enrolledList", enrolledList);
				request.setAttribute("completedList", completedList);
				request.setAttribute("isPrime", isPrime);
				request.getRequestDispatcher("/user/UserHome.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}

		if (path.equals("/search")) {
			String userName = request.getRemoteUser();
			String search_string = request.getParameter("search");
			boolean isPrime = userService.isPrime(userName);
			System.out.println(search_string);
			if (search_string == null) {
				request.setAttribute("isPrime", isPrime);
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
				request.setAttribute("isPrime", isPrime);

				request.getRequestDispatcher("/user/UserHome.jsp").forward(request, response);
			}
		}

//-------------------------------------Course--------------------------------------------

		if (path.equals("/course")) {
			System.out.println("inside course method....");
			int cat_id = (Integer.parseInt(request.getParameter("id")));
			String userName = request.getRemoteUser();
			System.out.println(cat_id);
			try {
				List<Course> courses = userService.findCourses(cat_id);
				List<Course> enrolledList = userService.findEnrolledCoursesByCategory(userName,cat_id);
				List<Course> completedList = userService.findCompletedCourse(userName).stream().sorted((o1, o2) -> (o1.getCourseName().compareTo(o2.getCourseName()))).collect(Collectors.toList());
				boolean isPrime = userService.isPrime(userName);
				courses.removeAll(enrolledList);
				enrolledList.removeAll(completedList);
				request.setAttribute("courseList", courses);
				request.setAttribute("enrolledList", enrolledList);
				request.setAttribute("isPrime",isPrime);
				request.setAttribute("completedList", completedList);
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
				subcourses = userService.findSubCourse(courseid);

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
		// ------------------------------user
		// profile----------------------------------------
		if (path.equals("/profileDisplay")) {
			try {
				String userName = request.getRemoteUser();
				System.out.println("in profile display");

				PrimeUser user = userService.displayProfile(userName);
				if (user == null) {
					throw new UserException("could not find user");
				}
				request.setAttribute("user", user);
				System.out.println(user.isIs_prime_user());
				request.setAttribute("isPrime", user.isIs_prime_user());
				System.out.println(user);
				request.getRequestDispatcher("/user/user-profile.jsp").forward(request, response);
			}

			catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}

		if (path.equals("/enroll-course")) {
			int courseId = Integer.parseInt(request.getParameter("id"));
			String userName = request.getRemoteUser();

			int userId = userService.findUserId(userName);
			Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

			String purchaseDate = sdf.format(dt);
			int coursePrice = Integer.parseInt(request.getParameter("price"));

			EnrolledCourse enrolledCourse = new EnrolledCourse(courseId, userId, coursePrice, purchaseDate);
			try {
				int success = userService.enroll(enrolledCourse);

				response.sendRedirect(
						request.getContextPath() + "/UserController/start-course?id=" + courseId + "&vid=0");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (path.equals("/get-certificate")) {
			System.out.println("Into get certifcate method");
			int courseid = Integer.parseInt(request.getParameter("id"));
			System.out.println("course id:" + courseid);

			String username = request.getRemoteUser();
			System.out.println("username :" + username);

			List<String> certificateData = null;

			// 1. update data in enrolled user set course_completed as 1.
			int status = 0;
			try {
				status = userService.updateCourseCompleteStatus(courseid, username);

				// 2. fetch user full_name, category_name and course_name,
				certificateData = userService.gererateCertificate(username, courseid);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("Status:" + status);

			for (String data : certificateData) {
				System.out.println(data);
			}
			request.setAttribute("full_name", certificateData.get(0));
			request.setAttribute("category_name", certificateData.get(1));
			request.setAttribute("course_name", certificateData.get(2));

			System.out.println("in usercontroller:" + certificateData.get(0));
			System.out.println("in usercontroller:" + certificateData.get(1));
			System.out.println("in usercontroller:" + certificateData.get(2));

			if (status > 0) {
				request.getRequestDispatcher("/user/certificate.jsp").forward(request, response);
			} else {
				// show error page
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

//---------------------------Update Profile---------------------------------------------------
		if (path.equals("/updateProfile")) {
			try {
				PrimeUser user = new PrimeUser();
				user.setFullName(request.getParameter("fullName"));
				user.setUserName(request.getRemoteUser());
				user.setPassword(request.getParameter("oldPassword").toString());

				if ((request.getParameter("newPassword").toString()).equals("")) {
					System.out.println(user.getPassword());

				} else {
					System.out.println("new password updated");
					user.setPassword(request.getParameter("newPassword"));
				}
				System.out.println(user.getFullName());
				System.out.println(user.getUserName());
				System.out.println(user.getPassword());
				System.out.println(request.getParameter("primeUser"));
				if (request.getParameter("primeUser").equals("true")) {
					user.setIs_prime_user(true);
				} else {
					user.setIs_prime_user(false);

				}
				userService.updateProfile(user);
				request.getRequestDispatcher("/UserController/list").forward(request, response);
			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
	}

}
