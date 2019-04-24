package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.Customer;
import com.mac.utility.HibernateUtil;

public class DeleteObjectTest {

	public static void main(String[] args) {
		Session ses = null;
		Customer customer = null;
		Transaction tx = null;
		boolean flag = false;
		ses = HibernateUtil.getSession();
		customer = ses.get(Customer.class, 1001);
		if(customer!=null) {
			try {
				//open session 
				//begin transaction
				tx = ses.beginTransaction();
				ses.delete(customer);
				flag = true;
			}
		
			catch(Exception e) {
				e.printStackTrace();
				flag = false;
			}
			finally {
				if(flag) {
					tx.commit();
					System.out.println("Object found and deleted");
				}
				else {
					tx.rollback();
					System.out.println("Object Not found");
				}
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}//finally
		}//if
		else {
			System.out.println("Object Not Deleted");
		}
	}//main
}//class
