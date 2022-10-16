package com.banking.demoapi.validationexception;

public class NegativeBalanceException extends Exception {

	public NegativeBalanceException(String msg){
	      super(msg);
	   }

}
