package com.banking.demoapi.model;

import java.math.BigDecimal;

import org.springframework.lang.NonNull;



public class AccountDTO {
	
	@NonNull
	String accountNumber;

	@NonNull
    BigDecimal currentBalance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

}
