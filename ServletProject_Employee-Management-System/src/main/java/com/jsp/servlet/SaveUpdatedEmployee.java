package com.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
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

@WebServlet("/SaveUpdatedEmployee")
public class SaveUpdatedEmployee extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		String employeeName = req.getParameter("employeeName");
		String employeeEmail = req.getParameter("employeeEmail");
		String employeeAddress = req.getParameter("employeeAddress");
		double employeeSalary = Double.parseDouble(req.getParameter("employeeSalary"));
		
		Session session = EmployeeUtility.getSession();
		Transaction transaction = session.beginTransaction();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaUpdate<Employee> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Employee.class);
		Root<Employee> root = criteriaUpdate.from(Employee.class);
		criteriaUpdate.set("employeeName", employeeName);
		criteriaUpdate.set("employeeEmail", employeeEmail);
		criteriaUpdate.set("employeeAddress", employeeAddress);
		criteriaUpdate.set("employeeSalary", employeeSalary);
		criteriaUpdate.where(criteriaBuilder.equal(root.get("employeeId"), employeeId));
		session.createQuery(criteriaUpdate).executeUpdate();
		
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
