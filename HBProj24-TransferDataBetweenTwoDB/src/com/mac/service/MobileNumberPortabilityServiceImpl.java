package com.mac.service;

import com.mac.dao.MobileNumberPortabilityDAO;
import com.mac.dao.MobileNumberPortabilityFactory;

public class MobileNumberPortabilityServiceImpl implements MobileNumberPortabilityService {

	@Override
	public String performMNP(long mobNo) {
		MobileNumberPortabilityDAO dao = null;
		boolean flag = false;
		//get DAO
		dao = MobileNumberPortabilityFactory.getInstance();
		//use DAO
		flag = dao.transfer(mobNo);
		if(flag)
			return "Mobile Number Transffered Successfully";
		else
			return "Mobile Number is not Transffered --->Contact JIO / Airtel Office";
	}
}
