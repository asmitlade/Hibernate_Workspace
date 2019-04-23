package com.mac.command;

public class BankServiceImpl implements BankService {

	@Override
	public String withdraw(int accNo, int amt) {
		return "Withdraw amount :::"+amt+"from Account :::"+accNo;
	}
}
