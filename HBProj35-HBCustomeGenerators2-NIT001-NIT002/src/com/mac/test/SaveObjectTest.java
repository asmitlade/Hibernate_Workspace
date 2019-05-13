package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.Customer;
import com.mac.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session ses = null;
		Customer customer = null;
		Transaction tx = null;
		String idVal = null;
		boolean flag = false;
		ses = HibernateUtil.getSession();
		customer = new Customer();
		//customer.setCustId(9898);
		customer.setCustName("mayur");
		customer.setAddress("arjuni");
		customer.setMobNo(5656665655l);
		try {
			//open session 
			//begin transaction
			tx = ses.beginTransaction();
			idVal = (String) ses.save(customer);
			System.out.println("Customer Id generate ::"+idVal);
			flag = true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object are Saved");
			}
			else {
				tx.rollback();
				System.out.println("Object are not Saved");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
