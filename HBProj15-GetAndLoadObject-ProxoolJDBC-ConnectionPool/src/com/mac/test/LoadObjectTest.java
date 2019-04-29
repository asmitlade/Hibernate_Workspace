package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.Customer;
import com.mac.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses = null;
		Customer customer = null;
		Transaction tx = null;
		boolean flag = false;
		ses = HibernateUtil.getSession();
		customer = new Customer();
		try {
			//open session 
			//begin transaction
			tx = ses.beginTransaction();
			customer = ses.load(Customer.class, 1002);
			System.out.println("Customer Id ::"+customer.getCustId()+"\nCustomer Name ::"+customer.getCustName()+"\nAddress ::"+customer.getAddress()+"\nMobile Number ::"+customer.getMobNo());
			flag = true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object found");
			}
			else {
				tx.rollback();
				System.out.println("Object Not found");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
