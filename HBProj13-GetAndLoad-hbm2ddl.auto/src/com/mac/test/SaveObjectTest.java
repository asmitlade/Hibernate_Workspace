package com.mac.test;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mac.entity.InsurancePolicy;

public class SaveObjectTest {
	public static void main(String[] args) {

		SessionFactory factory = null;
		Session ses = null;
		Configuration cfg = null;
		InsurancePolicy policy = null;
		boolean flag = false;
		Transaction tx = null;
		//bootstrap hibernate
		cfg = new Configuration();
		//locate cfg file
		cfg.configure("/com/mac/cfgs/hibernate.cfg.xml");
		//build SessionFactory
		factory = cfg.buildSessionFactory();
		//open Session 
		ses = factory.openSession();
		//create InsurancePolicy class object
		policy = new InsurancePolicy();
		policy.setPolicyId(1004);
		policy.setPolicyName("asmit");
		policy.setTenure(45);
		policy.setCompany("magic");
		policy.setInitialAmt(34500);
		try {
			tx = ses.beginTransaction();
			ses.save(policy);
			flag = true;
		}
		catch(Exception e) {
			flag= false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object found");
			}
			else {
				tx.rollback();
				System.out.println("Object not found");
			}
			ses.close();
			factory.close();
		}
	}
}