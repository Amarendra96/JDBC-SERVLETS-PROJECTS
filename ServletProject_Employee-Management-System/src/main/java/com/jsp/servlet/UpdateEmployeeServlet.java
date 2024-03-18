package com.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

@WebServlet("/UpdateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		
		Session session = EmployeeUtility.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("employeeId"), employeeId));
		Query<Employee> query = session.createQuery(criteriaQuery);
		List<Employee> employee = query.getResultList();
		
		req.setAttribute("employee", employee);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateEmployee.jsp");
		requestDispatcher.forward(req, resp);
	}

}
