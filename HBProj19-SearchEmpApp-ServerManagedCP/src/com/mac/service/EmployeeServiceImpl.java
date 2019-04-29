package com.mac.service;

import com.mac.dao.EmployeeDAO;
import com.mac.dao.EmployeeDAOFactory;
import com.mac.dto.EmployeeDTO;
import com.mac.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO empDAO;
	
	public EmployeeServiceImpl() {
		empDAO = EmployeeDAOFactory.getInstance();
	}

	@Override
	public EmployeeDTO searchEmployee(int eno) {

		EmployeeDTO empDTO = null;
		Employee emp = null;
		emp = empDAO.findEmployee(eno);
		//convert emp to dto
		empDTO = new EmployeeDTO();
		empDTO.setEno(emp.getEno());
		empDTO.setEmpName(emp.getEmpName());
		empDTO.setDesg(emp.getDesg());
		empDTO.setSalary(emp.getSalary());
		return empDTO;
	}

}
