package com.two95.sooraj.HibernateTrial2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();

		user1.setUserName("userA");
		UserDetails user2 = new UserDetails();

		user2.setUserName("userB");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		
		
		session.getTransaction().commit();
		session.close();

	}
}
