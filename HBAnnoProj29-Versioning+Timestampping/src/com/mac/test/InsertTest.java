package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.BankAccount;
import com.mac.utility.HibernateUtil;

public class InsertTest {

	public static void main(String[] args) {

		Session ses = null;
		BankAccount bank = null;
		Transaction tx = null;
		int idVal = 0;
		boolean flag = false;
		//get session object
		ses = HibernateUtil.getSession();
		try {
			//create BankAccount object
			bank = new BankAccount();
			bank.setAccNo(9999);
			bank.setHolderName("mac");
			bank.setBalance(5656000);
			bank.setType("Saving");
			//begin Transaction
			tx = ses.beginTransaction();
			idVal = (int) ses.save(bank);
			System.out.println("Generate Account Number :::"+idVal);
			flag = true;
		}
		catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object are Saved");
			}
			else {
				tx.rollback();
				System.out.println("Object are not saved");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
