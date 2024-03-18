package com.jsp.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeUtility {
	
	public static Session getSession() {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

}
