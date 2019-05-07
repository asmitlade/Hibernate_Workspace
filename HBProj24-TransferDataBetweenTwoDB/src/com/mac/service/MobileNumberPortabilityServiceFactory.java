package com.mac.service;

public class MobileNumberPortabilityServiceFactory {

	public static MobileNumberPortabilityService getInstance() {
		return new MobileNumberPortabilityServiceImpl();
	}
}
