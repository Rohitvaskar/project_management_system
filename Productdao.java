package com.Project.projectms.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Project.projectms.model.Product;
import com.Project.projectms.util.Hibernate_con;

public class Productdao {
	Scanner sc = new Scanner(System.in);

	public void saveProduct(Product product) {
		Transaction transaction = null;
		try (Session session = Hibernate_con.getsessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public void deleteProduct(long id) {
		Transaction transaction = null;
		try (Session session = Hibernate_con.getsessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Product product = session.load(Product.class, id);
			session.delete(product);
			transaction.commit();
		} catch (Exception e) {

			if (transaction != null) {
				System.out.println("id not found......." + e.getMessage());

			}
		}

	}

	public void updateproduct() {
		long n;
		Transaction transaction = null;

		try (Session session = Hibernate_con.getsessionFactory().openSession();) {
			transaction = session.beginTransaction();

			System.out.println("Enter product ID to update: ");
			n = sc.nextInt();

			// Retrieve the entity from the database
			Product onlineShopping = session.get(Product.class, n);

			if (onlineShopping != null) {

				int choice;

				System.out.println("enter how many row you want to update:-");
				n = sc.nextInt();
				for (int i = 1; i <= n; i++) {

					System.out.println("1) name\n2) brand\n3) cate\n4) price\n5) qun");

					System.out.println("enter column no:-");
					choice = sc.nextInt();

					switch (choice) {
					case 1: {
						System.out.println("Enter new name: ");
						onlineShopping.setP_name(sc.next());
						break;
					}
					case 2: {
						System.out.println("Enter new brand: ");
						onlineShopping.setP_brand(sc.next());
						break;
					}
					case 3: {
						System.out.println("Enter new category: ");
						onlineShopping.setP_category(sc.next());
						break;
					}
					case 4: {
						System.out.println("Enter new price: ");
						onlineShopping.setP_price(sc.nextInt());
						break;
					}
					case 5: {
						System.out.println("Enter new quantity: ");
						onlineShopping.setP_quantity(sc.nextInt());
						break;
					}

					default: {
						System.out.println("invalid row....");
					}

					}

					// Save the updated entity back to the database
					session.update(onlineShopping);
					System.out.println("Data updated successfully.");
					transaction.commit();
				}
			}

			else {

				System.out.println("Product not found with ID: " + n);
			}

		} catch (Exception e) {
			if (transaction != null) {
				System.out.println(e.getMessage());
			}

		}

	}

}
