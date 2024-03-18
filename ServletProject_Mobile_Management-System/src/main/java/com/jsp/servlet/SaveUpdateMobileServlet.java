package com.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveUpdateMobile")
public class SaveUpdateMobileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		String mobileModel = req.getParameter("mobileModel");
		String mobileBrand = req.getParameter("mobileBrand");
		double mobilePrice = Double.parseDouble(req.getParameter("mobilePrice"));

		final String URL ="jdbc:mysql://localhost:3306?user=root&password=tiger";
		final String QUERY="update grooming_mobile_database.mobile set mobileModel=?,mobileBrand=?,mobilePrice=? where mobileId="+mobileId;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection  = DriverManager.getConnection(URL);
			PreparedStatement prepareStatement = connection.prepareStatement(QUERY);
			
			preparedStatement.setString(1,mobileModel);
			preparedStatement.setString(2,mobileBrand);
			preparedStatement.setDouble(3,mobilePrice);
			
			int result = preparedStatement.executeUpdate();
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from grooming_mobile_database.mobile");
			req.setAttribute("resultSet", resultSet);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayAllMobiles.jsp");
			requestDispatcher.forward(req, resp);




		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection!=null  ) {
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