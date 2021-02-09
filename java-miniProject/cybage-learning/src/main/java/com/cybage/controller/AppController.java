
package com.cybage.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "admin", "user"}))
public class AppController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.isUserInRole("admin")) {
			request.getRequestDispatcher("/admin/admin-home.jsp").forward(request, response);
		}
		if (request.isUserInRole("user")) {
			request.getRequestDispatcher("UserController/list").forward(request, response);
		}
	}
}