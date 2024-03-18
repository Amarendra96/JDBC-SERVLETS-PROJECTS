package com.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		Session session = EmployeeUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaDelete<Employee> criteriaDelete = criteriaBuilder.createCriteriaDelete(Employee.class);
		Root<Employee> root = criteriaDelete.from(Employee.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("employeeId"), employeeId));
		session.createQuery(criteriaDelete).executeUpdate();
		
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		root = criteriaQuery.from(Employee.class);
		Query<Employee> query = session.createQuery(criteriaQuery);
		List<Employee> employeesList = query.getResultList();
		
		transaction.commit();
		session.close();
		
		req.setAttribute("employeesList", employeesList);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayEmployees.jsp");
		requestDispatcher.forward(req, resp);
	}
}
