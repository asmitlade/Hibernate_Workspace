package com.mac.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.ProgProjID;
import com.mac.entity.ProgrammerProjectInfo;
import com.mac.util.HibernateUtil;

public class CompositeIDInsertTest {

	public static void main(String[] args) {
		Session ses=null;
		ProgProjID id=null,idVal=null;
		ProgrammerProjectInfo info=null;
		Transaction tx=null;
		boolean flag=false;
		 //get Session
		ses=HibernateUtil.getSession();
		//prepre Entity class object
		id=new ProgProjID();
		id.setProgId(1014); id.setProjId(154);
		info=new ProgrammerProjectInfo();
		info.setId(id); info.setProgName("Asmit Lade"); info.setProjName("Netflix");
		try {
			tx=ses.beginTransaction();
			   idVal=(ProgProjID) ses.save(info);
			   System.out.println("Generated Id value::"+idVal);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved with composite Id");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
