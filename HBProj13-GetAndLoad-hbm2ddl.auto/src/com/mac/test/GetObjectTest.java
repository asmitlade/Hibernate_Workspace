package com.mac.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mac.entity.InsurancePolicy;

public class GetObjectTest {
	public static void main(String[] args) {

		SessionFactory factory = null;
		Session ses = null;
		Configuration cfg = null;
		InsurancePolicy policy = null;
		boolean flag = false;
		
		//bootstrap hibernate
		cfg = new Configuration();
		//locate cfg file
		cfg.configure("/com/mac/cfgs/hibernate.cfg.xml");
		//build SessionFactory
		factory = cfg.buildSessionFactory();
		//open Session 
		ses = factory.openSession();
		try {
			policy = ses.get(InsurancePolicy.class, 1004);
			if(policy != null)
				System.out.println("Policy Id ::: "+policy.getPolicyId()+"\nPolicy Name ::: "+policy.getPolicyName()+"\nTenure ::: "+policy.getTenure()+"\nCompany ::: "+policy.getCompany()+"\nInitial Amount ::: "+policy.getInitialAmt());
				flag = true;
		}
		catch(Exception e) {
			flag= false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				System.out.println("Object found");
			}
			else {
				System.out.println("Object not found");
			}
			ses.close();
			factory.close();
		}
	}
}