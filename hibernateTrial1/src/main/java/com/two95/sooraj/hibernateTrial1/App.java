package com.two95.sooraj.hibernateTrial1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select new map(Id, userName)from UserDetails ");
		List<Map<Integer,String>> user = (List<Map<Integer, String>>) query.list();
		Map<String,String> map=new HashMap<String, String>();
		session.getTransaction().commit();
		session.close();
		
		for(Map<Integer, String> maps: user){
			for(String key: maps.values()){
				System.out.println(key);
			}
		}
//		for (Map<String, String> maps : user) {
//		    for (Entry<String, String> entry : maps.entrySet()) {
//		        String key = entry.getKey();
//		        Object value = entry.getValue();
//		        System.out.println( value+"--");
//		    }
//		}

	}
}
