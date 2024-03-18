package com.jsp.jdbc.CRUD_Operatin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the sId which one you wants to delete");
		int sId = scanner.nextInt();






		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "tiger");
			PreparedStatement ps = connection.prepareStatement("delete from student where sId=?");
			ps.setInt(1, sId);
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println("sucessfully deleted");
			} else {
				System.out.println("failed");

			}
			connection.close();
		} catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		}

	}

}

