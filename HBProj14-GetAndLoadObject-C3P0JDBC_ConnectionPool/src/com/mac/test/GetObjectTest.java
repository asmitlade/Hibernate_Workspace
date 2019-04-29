package com.mac.test;

import org.hibernate.Session;

import com.mac.entity.InsurancePolicy;
import com.mac.utility.HibernateUtil;

public class GetObjectTest {
	public static void main(String[] args) {
		Session ses = null;
		InsurancePolicy policy = null;
		ses = HibernateUtil.getSession();
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
			HibernateUtil.closeSesion(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
