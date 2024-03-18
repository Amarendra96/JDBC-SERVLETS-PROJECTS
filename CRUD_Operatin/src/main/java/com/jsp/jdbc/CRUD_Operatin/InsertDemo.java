package com.jsp.jdbc.CRUD_Operatin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDemo {

	//	public static void main(String[] args) {
	//		//User Values
	//		int sId=2;
	//		String sName="Harsh";
	//		String sEmail="Harsh@123";
	//		String sAddress="Bihar";
	//
	//		try {
	//			Class.forName("com.mysql.cj.jdbc.Driver");
	//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root","tiger");
	//			PreparedStatement ps = connection.prepareStatement("insert into student values('"+sId+"','"+sName+"','"+sEmail+"','"+sAddress+"')");
	//			int i = ps.executeUpdate();
	//			if (i>0) {
	//				System.out.println("sucessfully inserted");
	//
	//			} else {
	//				System.out.println("Failed");
	//			}
	//
	//		} catch (ClassNotFoundException | SQLException e) {
	//			e.printStackTrace();
	//		}
	//
	//	}
	//second method
	//	public static void main(String[] args) {
	//		int sId=3;
	//		String sName="Ankita";
	//		String sEmail="Harshanki@123";
	//		String sAddress="WBengal";
	//		try {
	//			Class.forName("com.mysql.cj.jdbc.Driver");
	//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","tiger");
	//			PreparedStatement prepareStatement = connection.prepareStatement("insert into student values(?,?,?,?)");
	//			prepareStatement.setInt(1, sId);
	//			prepareStatement.setString(2, sName);
	//			prepareStatement.setString(3, sEmail);
	//			prepareStatement.setString(4, sAddress);
	//			int i = prepareStatement.executeUpdate();
	//			if (i>0) {
	//				System.out.println("sucessefully inserted");
	//			} else {
	//				System.out.println("Fail");
	//			}
	//
	//
	//		} catch (ClassNotFoundException |SQLException e) {
	//			e.printStackTrace();
	//		}                                                                                             
	//	}

	//using scanner class
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","tiger");
				PreparedStatement ps = connection.prepareStatement("insert into jdbc_db.student values(?,?,?,?)");
				System.out.println("Enter the student details");
				System.out.println("Enter studentID: ");
				ps.setInt(1, scanner.nextInt());
				System.out.println("Enter StudentName:");
				ps.setString(2, scanner.next());
				System.out.println("Enter StudentEmail:");
				ps.setString(3, scanner.next());
				System.out.println("Enter StudentAddress:");
				ps.setString(4, scanner.next());
				int i = ps.executeUpdate();
				if (i>0) {
					System.out.println("Sucessfully inserted");
				} else {
					System.out.println("failed");
				}
				ps.close();
				connection.close();
			} catch (ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
	 }
	
	//using properties file
	
	}






