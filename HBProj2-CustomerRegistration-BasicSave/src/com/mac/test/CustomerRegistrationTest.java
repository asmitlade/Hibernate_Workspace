package com.mac.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mac.entity.Customer;

public class CustomerRegistrationTest {

	public static void main(String[] args) {

		//bootstrap hibernate
		Configuration cfg = new Configuration();
		//locate the cfg file and mapping file to cfg 
		cfg = cfg.configure("/com/mac/cfgs/hibernate.cfg.xml");
		//create SessionFactory object
		SessionFactory factory = cfg.buildSessionFactory();
		//get session object
		Session ses = factory.openSession();
		//create domain class object
		Customer customer = new Customer();
		customer.setCustNo(1113);
		customer.setCustName("mac");
		customer.setAddress("hyd");
		customer.setMobNo(7782289635l);
		// Transaction
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			ses.save(customer);
			System.out.println("Customer Registered Succeded");
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Customer Registration Failed");
		}
		//close ses object
		ses.close();
		//close factory object
		factory.close();
	}//main
}//class
