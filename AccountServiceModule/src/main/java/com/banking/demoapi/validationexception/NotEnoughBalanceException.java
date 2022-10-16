package com.banking.demoapi.validationexception;

public class NotEnoughBalanceException extends Exception {

	public NotEnoughBalanceException(String msg){
	      super(msg);
	   }
}
