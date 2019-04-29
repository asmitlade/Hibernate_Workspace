package com.mac.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mac.dto.EmployeeDTO;
import com.mac.service.EmployeeService;
import com.mac.service.EmployeeServiceFactory;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	private EmployeeService service;
   	
	public void init() throws ServletException {

		service = EmployeeServiceFactory.getInstance();
   	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = null;
		int eno = 0;
		EmployeeDTO empDTO = null;
		RequestDispatcher rd = null;
		res.setContentType("text/html");
		pw = res.getWriter();
		eno = Integer.parseInt(req.getParameter("eno"));
		empDTO = service.searchEmployee(eno);
		req.setAttribute("empData", empDTO);
		rd = req.getRequestDispatcher("/result.jsp");
		rd.forward(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
