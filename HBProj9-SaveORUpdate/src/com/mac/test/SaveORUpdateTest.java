package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.BrandFactory;
import com.mac.utility.HibernateUtil;

public class SaveORUpdateTest {

	public static void main(String[] args) {
		Session ses = null;
		BrandFactory factory = null;
		Transaction tx = null;
		boolean flag = false;
		ses = HibernateUtil.getSession();
		factory = new BrandFactory();
		factory.setCustMobileNo(9082289635l);
		factory.setCustName("mac");
		factory.setCustAddrs("sakoli");
		factory.setRewardPoints(26);
		try {
			tx = ses.beginTransaction();
			ses.saveOrUpdate(factory);
			flag = true;
		}
		catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved and update");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved or update ");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
