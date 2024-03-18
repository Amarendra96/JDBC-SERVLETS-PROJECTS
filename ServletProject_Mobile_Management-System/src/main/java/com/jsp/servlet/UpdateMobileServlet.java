package com.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateMobile")
public class UpdateMobileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		final String URL ="jdbc:mysql://localhost:3306?user=root&password=tiger";
		final String QUERY="select *from grooming_mobile_database.mobile where mobileId="+mobileId;
		Connection connection=null;
		Statement statement=null;


		try {
			Class.forName("com.mysql.cj.jdbc.driver");

			connection  = DriverManager.getConnection(URL);
			statement=connection.createStatement();

			ResultSet resultSet = statement.executeQuery(QUERY);
			req.setAttribute("resultSet", resultSet);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateMobile.jsp");
			requestDispatcher.forward(req, resp);


		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection !=null  ) {
				try {
					statement.close();
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

