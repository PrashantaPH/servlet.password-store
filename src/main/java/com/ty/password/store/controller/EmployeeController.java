package com.ty.password.store.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.password.store.dto.Employee;
import com.ty.password.store.service.EmployeeService;

public class EmployeeController extends HttpServlet {

	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter printWriter = resp.getWriter();

		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		String gender=req.getParameter("gender");
		String role=req.getParameter("role");
		
		Employee employee = new Employee();

		employee.setName(name);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setGender(gender);
		employee.setRole(role);

		EmployeeService service = new EmployeeService();
		service.saveEmployee(employee);

		if (employee != null) {
			printWriter.write("<html><body>");
			printWriter.write("<h1>Name : " + employee.getName() + "</h1>");
			printWriter.write("<h1>Phone : " + employee.getPhone() + "</h1>");
			printWriter.write("<h1>Address : " + employee.getAddress() + "</h1>");
			printWriter.write("<h1>Gender : " + employee.getGender() + "</h1>");
			printWriter.write("<h1>Role : " + employee.getRole() + "</h1>");
			printWriter.write("</html></body>");
		} else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>No Record In The Table </h1>");
			printWriter.write("</html></body>");
		}

	}
}
