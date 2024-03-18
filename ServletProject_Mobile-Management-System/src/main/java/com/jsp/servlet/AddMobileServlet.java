package com.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMobileServlet")
public class AddMobileServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		String mobileModel = req.getParameter("mobileModel");
		String mobileBrand = req.getParameter("mobileBrand");
		double mobilePrice = Double.parseDouble(req.getParameter("mobilePrice"));
		
		final String URL = "jdbc:mysql://localhost:3306?user=root&password=tiger";
		final String QUERY = "insert into grooming_mobile_database.mobile values (?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL);
			preparedStatement = connection.prepareStatement(QUERY);
			
			preparedStatement.setInt(1, mobileId);
			preparedStatement.setString(2, mobileModel);
			preparedStatement.setString(3, mobileBrand);
			preparedStatement.setDouble(4, mobilePrice);
			
			int result = preparedStatement.executeUpdate();
			
			resp.sendRedirect("index.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
