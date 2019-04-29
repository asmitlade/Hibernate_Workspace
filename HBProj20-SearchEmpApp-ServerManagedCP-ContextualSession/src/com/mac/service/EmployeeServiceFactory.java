package com.mac.service;

public class EmployeeServiceFactory {

	public static EmployeeService getInstance() {
		return new EmployeeServiceImpl();
	}
}
