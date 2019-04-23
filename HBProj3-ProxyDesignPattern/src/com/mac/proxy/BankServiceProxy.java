package com.mac.proxy;

import com.mac.command.BankService;

public class BankServiceProxy implements BankService {

	@Override
	public String withdraw(int accNo, int amt) {
		if(amt >200000)
			return "Get Approval from RBI to withdraw more than 2,00,000 amount";
		else
			return "Withdraw amount :::"+amt+"from Account :::"+accNo;
	}
}
