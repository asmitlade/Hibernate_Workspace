package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.Employee;
import com.mac.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		 Session ses=null;
		 Employee emp=null;
		 Transaction tx=null;
		 boolean flag=false;
		 int idVal = 0;
		 try {
			 
			 //Open Session
			 ses=HibernateUtil.getSession();
			 //create Entity class obj with Data
			 emp=new Employee();
			 emp.setEno(1008); emp.setEname("asmit");
			 emp.setDesg("CLERK"); emp.setSalary(700000);
			 //begin Transaction
			 tx=ses.beginTransaction();
			 //save object
			 idVal = (int) ses.save(emp);
			 System.out.println("Generated id value :::"+idVal);
			 flag=true;
		 }//try
		 catch(Exception e) {
			 flag=false;
			 e.printStackTrace();
		 }
		 finally {
			 //perform Tx Mgmt
			 if(flag) {
				 tx.commit();
				 System.out.println("Object is saved");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object is rolleback");
			 }
			 //close HB ses,SessionFactory objs
			 HibernateUtil.closeSession(ses);
			 HibernateUtil.closeSessionFactory();
		 }//finally 
	}//main
}//class
