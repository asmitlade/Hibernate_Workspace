package com.mac.dao;

public class MobileNumberPortabilityFactory {

	public static MobileNumberPortabilityDAO getInstance() {
		return new MobileNumberPortabilityImpl();
	}
}
