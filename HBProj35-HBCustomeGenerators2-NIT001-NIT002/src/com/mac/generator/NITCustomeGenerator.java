package com.mac.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class NITCustomeGenerator implements IdentifierGenerator {

	private static final String GET_SEQ_VAL = "SELECT NIT_SEQ.NEXTVAL FROM DUAL";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int val = 0;
		try {
			// get Connection object
			con = session.connection();
			// create PreparedStatement object
			ps = con.prepareStatement(GET_SEQ_VAL);
			// excute Query
			rs = ps.executeQuery();
			if(rs.next()) {
				val = rs.getInt(1);
			}
			// process the result
			if (val <= 9)
				return "NIT00" + val;
			else if (val <= 99)
				return "NIT0" + val;
			else
				return "NIT" + val;
		} catch (SQLException se) {
			se.printStackTrace();
			return "could not generate id value";
		} catch (Exception e) {
			e.printStackTrace();
			return "could not generate id value";
		} finally {
			try {
				if (rs != null)
					rs.close();

			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} // finally
	}// method
}// class
