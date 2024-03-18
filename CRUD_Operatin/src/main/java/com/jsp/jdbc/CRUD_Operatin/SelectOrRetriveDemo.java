package com.jsp.jdbc.CRUD_Operatin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectOrRetriveDemo {

	// for Find All the data from database
	//	public static void main(String[] args) {
	//		
	//		try {
	//			Class.forName("com.mysql.cj.jdbc.Driver");
	//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","tiger");
	//			PreparedStatement ps = connection.prepareStatement("select * from student ");
	//			ResultSet rs = ps.executeQuery();
	//			
	//			while (rs.next()) {
	//				int sId = rs.getInt("sId");
	//				System.out.println("sID="+sId);
	//				String sName = rs.getString("sName");
	//				System.out.println("SName="+sName);
	//				
	//				String sEmail = rs.getString("sEmail");
	//				System.out.println("sEmail="+sEmail);
	//				
	//				String sAddress = rs.getString("sAddress");
	//				System.out.println("sAddress="+sAddress);
	//				System.out.println("=======================================");
	//				
	//			}
	//		} catch (ClassNotFoundException|SQLException e) {
	//			e.printStackTrace();
	//		}
	//	}


	//  for Find specific data from database
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("The student details according to sId: ");
		System.out.println("Enter the sID:");
		int sId = scanner.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","tiger");
			PreparedStatement ps = connection.prepareStatement("select * from student where sId=? ");
			ps.setInt(1, sId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("The Student details:");
				
				int sId1 = rs.getInt("sId");
				System.out.println("sID="+sId1);
				
				String sName = rs.getString("sName");
				System.out.println("SName="+sName);

				String sEmail = rs.getString("sEmail");
				System.out.println("sEmail="+sEmail);

				String sAddress = rs.getString("sAddress");
				System.out.println("sAddress="+sAddress);
				
				System.out.println("=======================================");
			}
			ps.close();
			connection.close();
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
















}
