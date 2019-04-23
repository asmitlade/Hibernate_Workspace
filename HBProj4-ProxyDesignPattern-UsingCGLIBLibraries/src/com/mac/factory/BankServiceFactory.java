package com.mac.factory;

import com.mac.command.BankService;
import com.mac.command.BankServiceImpl;
import com.mac.helper.ProxyHelper;

import net.sf.cglib.proxy.Enhancer;

public class BankServiceFactory {

	public static BankService getInstance(boolean RBIMonitoring) {
		BankService service = null;
		if(RBIMonitoring)
			service = (BankService) Enhancer.create(BankServiceImpl.class, new ProxyHelper());
		else
			service = new BankServiceImpl();
		return service;
	}
}
