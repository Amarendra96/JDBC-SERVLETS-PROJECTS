package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet("/SaveEmployee")
public class SaveEmployeeServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		String employeeName = req.getParameter("employeeName");
		String employeeEmail = req.getParameter("employeeEmail");
		String employeeAddress = req.getParameter("employeeAddress");
		double employeeSalary = Double.parseDouble(req.getParameter("employeeSalary"));
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setEmployeeEmail(employeeEmail);
		employee.setEmployeeAddress(employeeAddress);
		employee.setEmployeeSalary(employeeSalary);
		
		Session session = EmployeeUtility.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
		
//		resp.getWriter().print("<h1>Employee Saved Successfully</h1>");
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		resp.sendRedirect("index.jsp");
	}
}
