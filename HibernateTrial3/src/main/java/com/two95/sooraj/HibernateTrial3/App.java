package com.two95.sooraj.HibernateTrial3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		UserDetails user = new UserDetails();

		user.setUserName("user 1");
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVehicleName("Bus");
		user.getVehicles().add(vehicle1);
		user.getVehicles().add(vehicle2);
		user.getVehicles().add(vehicle3);
		vehicle1.setUser(user);
		vehicle2.setUser(user);
		vehicle3.setUser(user);

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(vehicle3);
		session.getTransaction().commit();
		session.close();

	}
}
