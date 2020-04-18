package com.pawan.mvc.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private static SessionFactory sf=null;
	
	static {
		sf=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory sessionFactory() {
		return sf;
	}
}
