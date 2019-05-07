package com.mac.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mac.entity.MobileCustomer;
import com.mac.utility.MysqlHibernateUtil;
import com.mac.utility.OracleHibernateUtil;

public class MobileNumberPortabilityImpl implements MobileNumberPortabilityDAO {

	@Override
	public boolean transfer(long mobNo) {
		Session oraSes = null, mysqlSes = null;
		MobileCustomer customer = null;
		boolean oraFlag = false, mysqlFlag = false, finalResultFlag = false;
		Transaction oraTx = null, mysqlTx = null;
		//get Oracle Session
		oraSes = OracleHibernateUtil.getSession();
		//get Mysql Session
		mysqlSes = MysqlHibernateUtil.getSession();
		//get Object from oracle
		customer = oraSes.get(MobileCustomer.class, mobNo);
		//store object into mysql
		try {
			//begin Transaction
			mysqlTx = mysqlSes.beginTransaction();
			customer.setStatus("active");
			mysqlSes.save(customer);
			mysqlFlag = true;
			oraTx = oraSes.beginTransaction();
			oraSes.delete(customer);
			oraFlag = true;
		}
		
		catch(Exception e) {
			mysqlFlag = false;
			oraFlag =false;
			e.printStackTrace();
		}
		finally {
			try {
				if(oraFlag == false || mysqlFlag == false) {
					oraTx.rollback();
					mysqlTx.rollback();
					System.out.println("MNP Failed");
					finalResultFlag = false;
				}
				else {
					oraTx.commit();
					mysqlTx.commit();
					System.out.println("MNP succeded");
					finalResultFlag = true;
				}
			}
			catch(Exception e) {
				finalResultFlag = false;
				e.printStackTrace();
			}
		}
		return finalResultFlag;
	}
}
