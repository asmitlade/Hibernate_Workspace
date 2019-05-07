package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.Customer;
import com.mac.utility.HibernateUtil;

public class SaveObjectClusterTest {

	public static void main(String[] args) {
		Session ses = null;
		Customer customer = null,customer1=null;
		Transaction tx = null;
		int idVal = 0, idVal1=0;
		boolean flag = false;
		ses = HibernateUtil.getSession();
		customer = new Customer();
		customer.setCustId(9898);
		customer.setCustName("asmit Lade");
		customer.setAddress("hyd");
		customer.setMobNo(8989989898l);
		customer1 = new Customer();
		customer1.setCustId(9898);
		customer1.setCustName("asmit Lade");
		customer1.setAddress("hyd");
		customer1.setMobNo(8989989898l);
		
		try {
			//open session 
			//begin transaction
			tx = ses.beginTransaction();
			idVal = (int) ses.save(customer);
			idVal1 = (int) ses.save(customer1);
			System.out.println("Customer Id generate ::"+idVal+"  "+idVal1);
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
