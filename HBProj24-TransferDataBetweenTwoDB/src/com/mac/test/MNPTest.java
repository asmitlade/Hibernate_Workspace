package com.mac.test;

import com.mac.service.MobileNumberPortabilityService;
import com.mac.service.MobileNumberPortabilityServiceFactory;
import com.mac.utility.MysqlHibernateUtil;
import com.mac.utility.OracleHibernateUtil;

public class MNPTest {

	public static void main(String[] args) {
		MobileNumberPortabilityService service = null;
		//get service class object
		service = MobileNumberPortabilityServiceFactory.getInstance();
		// use service
		System.out.println(service.performMNP(7777777777l));
		//close factories
		OracleHibernateUtil.closeSessionFactory();
		MysqlHibernateUtil.closeSessionFactory();
	}
}
