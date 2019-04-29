package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.BrandFactory;
import com.mac.utility.HibernateUtil;

public class MergeTest2 {

	public static void main(String[] args) {
		Session ses = null;
		BrandFactory factory = null,factory1=null,factory2=null;
		Transaction tx = null;
		boolean flag = false;
		ses = HibernateUtil.getSession();
		try {
			tx = ses.beginTransaction();
			factory = new BrandFactory();
			factory.setCustMobileNo(9082289635l);
			factory.setCustName("asmit");
			factory.setCustAddrs("sakoli");
			factory.setRewardPoints(23);
			ses.save(factory);
			System.out.println("Before Merge :::"+factory);

			factory1 = new BrandFactory();
			factory1.setCustMobileNo(9082289635l);
			factory1.setCustName("mukesh");
			factory1.setCustAddrs("korba");
			factory1.setRewardPoints(700);
			factory2 = (BrandFactory) ses.merge(factory1);
			System.out.println("After Merge :::"+factory2);
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
