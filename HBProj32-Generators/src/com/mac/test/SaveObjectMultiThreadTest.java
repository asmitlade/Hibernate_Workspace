package com.mac.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SaveObjectMultiThreadTest {

	public static void main(String[] args) {
		RequestThread rt =  null;
		RequestThread rt1 =  null;
		Configuration cfg = null;
		SessionFactory factory = null;	
		// bootstrap hibernate
		cfg = new Configuration();
		//locate cfg xml file
		cfg.configure("com/mac/cfgs/hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		rt = new RequestThread(factory);
		rt1 = new RequestThread(factory);
		rt.start();
		rt1.start();
	}//main
}//class
