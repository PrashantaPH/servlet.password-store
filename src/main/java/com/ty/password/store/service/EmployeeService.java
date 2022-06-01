package com.ty.password.store.service;

import com.ty.password.store.dao.EmployeeDao;
import com.ty.password.store.dto.Employee;

public class EmployeeService {

	EmployeeDao dao = new EmployeeDao();

	public Employee saveEmployee(Employee employee) {
		
		return dao.saveEmployee(employee);
	}
}
