package com.mac.dao;

import org.hibernate.Session;

import com.mac.entity.Employee;
import com.mac.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee findEmployee(int eno) {
		Session ses = null;
		Employee emp = null;
		//get session object
		ses = HibernateUtil.getSession();
		//load object
		emp = ses.load(Employee.class, 7902);
		return emp;
	}

}
