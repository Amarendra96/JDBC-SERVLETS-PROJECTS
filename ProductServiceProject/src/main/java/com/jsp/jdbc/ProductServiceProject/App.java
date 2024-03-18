package com.jsp.jdbc.ProductServiceProject;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{


	public static void main( String[] args )
	{
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Choose one of the options\n1. Add Product\n2. Find Product By ID\n3. Update Product Price By ID\n4. Delete Product By ID\n5. Find Product By Name\n6. Find All Products\n7. Find All Products Between Prices\n8. Exit");
			int option = scanner.nextInt();

			switch (option) {
			case 1: ProductService.addProduct();
					break;
			case 2: ProductService.findProductById();
					break;
			case 3: ProductService.updateProductPriceById();
					break;
			case 4: ProductService.deleteProductById();
					break;
			case 5: ProductService.findProductByName();
					break;
			case 6: ProductService.findAllProducts();
					break;
			case 7: ProductService.findAllProductsBetweenPrices();
			break;
			case 8: System.out.println("Thank you");
					scanner.close();
					return;
			default:
				System.out.println("Please enter valid option");
			}
			System.out.println("==========================");
		}
	}


}


