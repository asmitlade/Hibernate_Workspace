package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.domain.MNCustomer;
import com.mac.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {

		Session ses= null;
		MNCustomer customer = null;
		Transaction tx = null;
		int idVal = 0;
		boolean flag = false;
		customer = new MNCustomer();
		ses = HibernateUtil.getSession();
		try {
			//begin Transaction
			tx = ses.beginTransaction();
			//set value to customer object
			customer.setCustId(2222);
			customer.setCustName("asmit");
			customer.setMobileNo(9082289635l);
			customer.setCallerTune("pilla ra");
			idVal = (int) ses.save(customer);
			System.out.println("Generate id value :::"+idVal);
			flag = true;
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
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
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
