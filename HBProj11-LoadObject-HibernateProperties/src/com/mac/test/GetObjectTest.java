package com.mac.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mac.entity.InsurancePolicy;

public class GetObjectTest {
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session ses = null;
		InsurancePolicy policy = null;
		Configuration cfg = null;
		//bootstrap hibernate
		cfg = new Configuration();
		//specify mapping file name
		cfg.addFile("src/com/mac/entity/InsurancePolicy.hbm.xml");
		//create SessionFactory object
		factory = cfg.buildSessionFactory();
		ses = factory.openSession();
		try {
			policy = ses.get(InsurancePolicy.class, 1010);
			if(policy!=null)
			System.out.println("Policy Id ::: "+policy.getPolicyId()+"\nPolicy Name ::: "+policy.getPolicyName()+"\nTenure ::: "+policy.getTenure()+"\nCompany ::: "+policy.getCompany()+"\nInitial Amount ::: "+policy.getInitialAmt());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Object not found");
		}
		finally {
			ses.close();
			factory.close();
		}
	}
}
