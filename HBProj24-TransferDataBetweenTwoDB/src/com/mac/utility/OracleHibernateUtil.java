package com.mac.utility;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OracleHibernateUtil {
	private static SessionFactory factory;
	static {
		try {
			Configuration cfg = null;
			//bootstrap hibernate
			cfg = new Configuration();
			//locate cfg and mapping xml file
			cfg.configure("/com/mac/cfgs/hibernate-oracle.cfg.xml");
			//create SessionFactory object
			factory = cfg.buildSessionFactory();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	
	public static Session getSession() {
		Session ses = null;
		if(factory!=null)
			ses = factory.openSession();
		return ses;
	}
	
	public static void closeSesion(Session ses) {
		if(ses!=null)
			ses.close();
	}
	
	public static void closeSessionFactory() {
		if(factory!= null)
			factory.close();
	}
}
