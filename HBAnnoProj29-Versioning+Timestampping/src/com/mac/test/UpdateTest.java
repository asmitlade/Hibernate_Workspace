package com.mac.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.BankAccount;
import com.mac.utility.HibernateUtil;

public class UpdateTest {

	public static void main(String[] args) {

		Session ses = null;
		BankAccount bank = null;
		Transaction tx = null;
		boolean flag = false;
		//get Session 
		ses = HibernateUtil.getSession();
		//get BankAccount class object
		bank = ses.load(BankAccount.class, 9999);
		if(bank == null) {
			System.out.println("Object not found");
		}
		try {
			tx = ses.beginTransaction();
			bank.setBalance(900000);
			flag = true;
		}
		catch(HibernateException he) {
			flag = false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object Updated for  "+bank.getUpdateCount()+" times and last Update on :::"+bank.getLastUpdate());
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
