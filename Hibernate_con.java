package com.Project.projectms.util;

import java.util.Properties;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.Project.projectms.model.Product;

public class Hibernate_con {
	private static SessionFactory sessionFactory;

	public static SessionFactory getsessionFactory() {
		if (sessionFactory == null) {
			try {

				Configuration configuration = new Configuration();

				Properties setting = new Properties();
				setting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				setting.put(Environment.URL, "jdbc:mysql://localhost:3306/rohitt?useSSL=false");
				setting.put(Environment.USER, "root");
				setting.put(Environment.PASS, "root");
				setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				setting.put(Environment.SHOW_SQL, "true");
				setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				setting.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(setting);
				configuration.addAnnotatedClass(Product.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return sessionFactory;
	}

}
