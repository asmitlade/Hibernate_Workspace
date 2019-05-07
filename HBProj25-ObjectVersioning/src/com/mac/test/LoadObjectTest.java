package com.mac.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.domain.MNCustomer;
import com.mac.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {

		Session ses = null;
		MNCustomer customer = null;
		Transaction tx = null;
		boolean flag = false;
		//get Session object
		ses = HibernateUtil.getSession();
		customer = ses.get(MNCustomer.class, 1);
		if(customer == null) {
			System.out.println("Object Not Found");
			return;
		}
		try {
			tx = ses.beginTransaction();
			customer.setCallerTune("Mr. Perfect");
			flag = true;
		}
		catch(HibernateException he) {
			flag = false;
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object Updated for  "+customer.getTuneChangeCount()+" times");
			}
			else {
				tx.rollback();
				System.out.println("Object Not Updated");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
