package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private HibernateUtil() {
		
	}

	private static final SessionFactory sessionFactory;
	static {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();

		} catch (Throwable th) {
			System.err.println("Initial Session Factory creation failed");
			throw new ExceptionInInitializerError(th);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
