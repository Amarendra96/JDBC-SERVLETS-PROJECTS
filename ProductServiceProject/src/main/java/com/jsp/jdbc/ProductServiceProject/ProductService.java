package com.jsp.jdbc.ProductServiceProject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {
	public static Connection getConnection() {
		final String URL = "jdbc:mysql://localhost:3306?user=root&password=tiger";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		if (connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void addProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product ID, Product Name, Product Brand, Product Price");
		int productId = scanner.nextInt();
		String productName = scanner.next();
		String productBrand = scanner.next();
		double productPrice = scanner.nextDouble();

		final String QUERY = "insert into grooming_database.product values (?, ?, ?, ?)";
		Connection connection = ProductService.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, productId);
			preparedStatement.setString(2, productName);
			preparedStatement.setString(3, productBrand);
			preparedStatement.setDouble(4, productPrice);
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("Product details successfully saved");
			} else {
				System.out.println("Product details not saved");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductService.closeConnection(connection);
		scanner.close();
	}

	public static void findProductById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product ID");
		int productId = scanner.nextInt();
		final String QUERY = "select * from grooming_database.product where productId = ?";
		Connection connection = ProductService.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("Product ID: " + resultSet.getInt("productId"));
				System.out.println("Product Name: " + resultSet.getString("productName"));
				System.out.println("Product Brand: " + resultSet.getString("productBrand"));
				System.out.println("Product Price: " + resultSet.getDouble("productPrice"));
			} else {
				System.out.println("No Product is available with ID: " + productId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductService.closeConnection(connection);
		scanner.close();
	}

	public static void updateProductPriceById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product ID");
		int productId = scanner.nextInt();
		System.out.println("Enter Product Price");
		double productPrice = scanner.nextDouble();
		final String QUERY = "update grooming_database.product set productPrice = ? where productId = ?";
		Connection connection = ProductService.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setDouble(1, productPrice);
			preparedStatement.setInt(2, productId);
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("Product has been successfully updated");
			} else {
				System.out.println("Product is not updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductService.closeConnection(connection);
		scanner.close();
	}

	public static void deleteProductById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product ID");
		int productId = scanner.nextInt();
		final String QUERY = "delete from grooming_database.product where productId = ?";
		Connection connection = ProductService.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setDouble(1, productId);
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("Product has been successfully deleted");
			} else {
				System.out.println("Product is not deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductService.closeConnection(connection);
		scanner.close();
	}

	public static void findProductByName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product Name");
		String productName = scanner.next();
		final String QUERY = "select * from grooming_database.product where productName = ?";
		Connection connection = ProductService.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, productName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("Product ID: " + resultSet.getInt("productId"));
				System.out.println("Product Name: " + resultSet.getString("productName"));
				System.out.println("Product Brand: " + resultSet.getString("productBrand"));
				System.out.println("Product Price: " + resultSet.getDouble("productPrice"));
			} else {
				System.out.println("No Product is available with Name: " + productName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductService.closeConnection(connection);
		scanner.close();
	}

	public static void findAllProducts() {
		final String QUERY = "select * from grooming_database.product";
		Connection connection = ProductService.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				System.out.println("No products available");
				return;
			}
			do {
				System.out.println("==========================");
				System.out.println("Product ID: " + resultSet.getInt("productId"));
				System.out.println("Product Name: " + resultSet.getString("productName"));
				System.out.println("Product Brand: " + resultSet.getString("productBrand"));
				System.out.println("Product Price: " + resultSet.getDouble("productPrice"));
			} while (resultSet.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductService.closeConnection(connection);	
	}

	public static void findAllProductsBetweenPrices() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the range of Product Price");
		int productPrice1 = scanner.nextInt();
		int productPrice2 = scanner.nextInt();
		final String QUERY = "select * from grooming_database.product where productPrice between ? and ?";
		Connection connection = ProductService.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, productPrice1);
			preparedStatement.setInt(2, productPrice2);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				System.out.println("No products available");
				return;
			}
			do {
				System.out.println("==========================");
				System.out.println("Product ID: " + resultSet.getInt("productId"));
				System.out.println("Product Name: " + resultSet.getString("productName"));
				System.out.println("Product Brand: " + resultSet.getString("productBrand"));
				System.out.println("Product Price: " + resultSet.getDouble("productPrice"));
			} while (resultSet.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductService.closeConnection(connection);
		scanner.close();
	}



}

