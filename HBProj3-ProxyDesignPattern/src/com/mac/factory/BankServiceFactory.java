package com.mac.factory;

import com.mac.command.BankService;
import com.mac.command.BankServiceImpl;
import com.mac.proxy.BankServiceProxy;

public class BankServiceFactory {

	public static BankService getInstance(boolean RBIMonitoring) {
		BankService service = null;
		if(RBIMonitoring)
			service = new BankServiceProxy();
		else
			service = new BankServiceImpl();
		return service;
	}
}
