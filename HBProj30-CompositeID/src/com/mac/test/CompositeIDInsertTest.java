package com.mac.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.ProgProjID;
import com.mac.entity.ProgrammerProjectInfo;
import com.mac.util.HibernateUtil;

public class CompositeIDInsertTest {

	public static void main(String[] args) {

		Session ses= null;
		ProgProjID id = null;
		ProgrammerProjectInfo ppi = null;
		Transaction tx = null;
		//int idVal = 0;
		boolean flag = false;
		//create ProjProgID class object
		id = new ProgProjID();
		//create ProgrammerProjectInfo class object
		ppi = new ProgrammerProjectInfo();
		//get Session object
		ses = HibernateUtil.getSession();
		try {
			
			//set value to ProgProjID 
			id.setProgId(1212);
			id.setProjId(777);
			//set value to ProgrammerProjectInfo object
			ppi.setId(id);
			ppi.setProgName("Asmit Lade");
			ppi.setProjName("netflix");
			ppi.setSalary(900000);
			//begin Transaction
			tx = ses.beginTransaction();
			ses.save(ppi);
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
