package com.mac.test;

import com.mac.command.BankService;
import com.mac.factory.BankServiceFactory;


public class ProxyDPUsingCGLibTest {

	public static void main(String[] args) {
		BankService service = null;
		try {
			service  = BankServiceFactory.getInstance(true);
			System.out.println("service onject class :::"+service.getClass());
			System.out.println(service.withdraw(1234, 300000));
			System.out.println("---------------------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			service  = BankServiceFactory.getInstance(false);
			System.out.println("service onject class :::"+service.getClass());
			System.out.println(service.withdraw(1221, 200000));
			System.out.println("---------------------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			service  = BankServiceFactory.getInstance(false);
			System.out.println("service onject class :::"+service.getClass());
			System.out.println(service.withdraw(5654, 600000));
			System.out.println("---------------------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
