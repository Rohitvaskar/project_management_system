package com.Project.projectms;

import java.util.Scanner;

import com.Project.projectms.dao.Productdao;
import com.Project.projectms.model.Product;

/**
 * Hello world!
 *
 */
public class App {
	static int price, qun, id, n, choice;
	static String name, category, brand;
	static char repeat;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		do {

			System.out.println(" *****************operations****************");
			System.out.println("1.userinput\n2:updatetable\n3:deletetable");
			System.out.println("\n\nwhich opration you want to perform");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("----------------------------------------------------------------");
				userinput();
				break;

			case 2:
				updatetable();
				break;

			case 3:
				deletetable();
				break;
			default:
				System.out.println(" please enter valid input");
				break;
			}

			System.out.println("do you want to repeat the opration:- ");
			repeat=sc.next().charAt(0);
			
		} while (repeat=='y'||  repeat=='Y');
	}

	public static void userinput() {

		System.out.println("how many row you want to add:");
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {

			System.out.println("enter product name:");
			name = sc.next();

			System.out.println("enter product category:");
			category = sc.next();

			System.out.println("enter product brand:");
			brand = sc.next();

			System.out.println("enter product price");

			price = sc.nextInt();

			System.out.println("enter product quatity");
			qun = sc.nextInt();

			Productdao productdao = new Productdao();

			Product product = new Product(name, category, price, brand, qun);
			productdao.saveProduct(product);

		}

	}

	public static void updatetable() {

		Productdao productdao = new Productdao();

		productdao.updateproduct();

	}

	public static void deletetable() {
		Productdao productdao = new Productdao();

		System.out.println("enter id which you want to delete:- ");
		id = sc.nextInt();
		productdao.deleteProduct(id);
	}
}
