package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class DivideServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req ,ServletResponse res)throws ServletException,IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		res.getWriter().print("<h1> " + num1 + " / " + num2 + " = " +(num1/num2) + "</h1>");

	}

}
