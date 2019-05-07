package com.mac.test;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.mac.entity.StockInfo;
import com.mac.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {

		Session ses= null;
		StockInfo info = null;
		Transaction tx = null;
		int idVal = 0;
		boolean flag = false;
		info = new StockInfo();
		ses = HibernateUtil.getSession();
		try {
			//begin Transaction
			tx = ses.beginTransaction();
			//set value to customer object
			info.setStockId(2222);
			info.setStockName("mac");
			info.setCompany("magic");
			info.setPrice(12345);
			idVal = (int) ses.save(info);
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
