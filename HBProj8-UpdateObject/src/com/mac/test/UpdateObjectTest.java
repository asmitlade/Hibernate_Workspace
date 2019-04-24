package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.BankAccount;
import com.mac.utility.HibernateUtil;

public class UpdateObjectTest {

	public static void main(String[] args) {

		Session ses = null;
		BankAccount bank = null;
		Transaction tx = null;
		boolean flag = false;
		ses = HibernateUtil.getSession();
		bank = ses.get(BankAccount.class, 1001);
		if(bank!=null) {
			try {
				tx = ses.beginTransaction();
				bank.setHolderName("asmit");
				bank.setBalance(1000000);
				bank.setType("current");
				ses.update(bank);
				flag = true;
			}
			catch(Exception e) {
				flag = false;
				e.printStackTrace();
			}
			finally {
				if(flag) {
					tx.commit();
					System.out.println("Record are updated");
				}
				else {
					tx.rollback();
					System.out.println("Record not updated");
				}
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}//finally
		}
		else {
			System.out.println("Object Not found and Update");
		}
	}//main
}//class
