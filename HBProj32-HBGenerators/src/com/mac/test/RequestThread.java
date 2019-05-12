package com.mac.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mac.entity.Customer;

public class RequestThread extends Thread {

	private SessionFactory factory;
	
	public RequestThread(SessionFactory factory){
		this.factory = factory;
	}
	@Override
	public void run() {
		Session ses = null;
		Customer customer = null;
		Transaction tx = null;
		int idVal = 0;
		boolean flag = false;
		//create Customer class object
		customer = new Customer();
		//set the values
		customer.setCustId(9898);
		customer.setCustName("asmit Lade");
		customer.setAddress("hyd");
		customer.setMobNo(8989989898l);
		
		try {
			//open session 
			ses = factory.openSession();
			//begin transaction
			tx = ses.beginTransaction();
			idVal = (int) ses.save(customer);
			System.out.println("Customer Id generate ::"+idVal);
			flag = true;
			System.out.println("Thread are Sleeping....");
			Thread.sleep(40000);
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
			ses.close();
			factory.close();
		}//finally
	}
}
