package com.ty.password.store.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.password.store.dto.User;
import com.ty.password.store.service.UserService;

public class ValidateUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserService service = new UserService();

		User user = service.validateUser(email, password);

		PrintWriter printWriter = resp.getWriter();

		if (user != null) {
			printWriter.write("<html><body>");
			printWriter.write("<h1> " + user.getName() + " : User Found....! </h1>");
			printWriter.write("</html></body>");
		} else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>User Not  Found....! </h1>");
			printWriter.write("</html></body>");

		}
	}
}
