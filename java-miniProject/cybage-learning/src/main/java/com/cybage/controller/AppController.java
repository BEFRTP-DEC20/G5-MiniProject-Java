
package com.cybage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "admin", "user"}))
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final Logger log =  LogManager.getLogger(AppController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.isUserInRole("admin")) {
			log.debug("entering adminController");
			request.getRequestDispatcher("AdminController/listCategory").forward(request, response);
		}
		if (request.isUserInRole("user")) {
			log.debug("entering userController");
			request.getRequestDispatcher("UserController/list").forward(request, response);
		}
	}
}