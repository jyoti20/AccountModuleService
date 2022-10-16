package com.banking.demoapi.validationexception;

public class TransferFailedException extends Exception {

	public TransferFailedException(String msg){
	      super(msg);
	   }
}
