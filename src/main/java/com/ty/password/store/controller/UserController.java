package com.ty.password.store.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.password.store.dto.User;
import com.ty.password.store.service.UserService;

public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setGender(gender);

		UserService service=new UserService();
		service.saveUser(user);
		PrintWriter printWriter = resp.getWriter();

		/*String htmlCode = "<html><body><h1>User : " + user +
		 "</h1></body></html>";//toString method orerriden thats why
		String htmlCode = "<html><body><h1>Name : " + user.getName() + "</h1></body></html>";
		printWriter.write(htmlCode);

		String htmlCode1 = "<html><body><h1>Email : " + user.getEmail() + "</h1></body></html>";
		printWriter.write(htmlCode1);

		String htmlCode2 = "<html><body><h1>Password : " + user.getPassword() + "</h1></body></html>";
		printWriter.write(htmlCode2);

		String htmlCode3 = "<html><body><h1>Gender : " + user.getGender() + "</h1></body></html>";
		printWriter.write(htmlCode3);   (OR)  */
		
		if(user != null)
		{
			printWriter.write("<html><body>");
			printWriter.write("<h1>Id : " + user.getId() + "</h1>");
			printWriter.write("<h1>Name : " + user.getName() + "</h1>");
			printWriter.write("<h1>Email : " + user.getEmail() + "</h1>");
			printWriter.write("<h1>Password : " + user.getPassword() + "</h1>");
			printWriter.write("<h1>Gender : " + user.getGender() + "</h1>");
			printWriter.write("</html></body>");
		}
		else
		{
			printWriter.write("<html><body>");
			printWriter.write("<h1>no data</h1>");
			printWriter.write("</html></body>");
			
		}
		
	}

}
