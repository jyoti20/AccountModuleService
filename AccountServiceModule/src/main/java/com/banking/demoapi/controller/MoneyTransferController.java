package com.banking.demoapi.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demoapi.model.TransferRequest;
import com.banking.demoapi.service.MoneyTransferService;

@RestController
public class MoneyTransferController {

	MoneyTransferService  moneyTransferService;

		
	public MoneyTransferController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }
	
	/**
	 * InitiateAmountTranser given transactionAmount from source:fromAccount to the distination:toAccount
	* Update appropriate balances 
	* Create Transfer statement 
	*/
	@PostMapping("/initiateAmountTranser")
	public ResponseEntity<String> initiateAmountTransfer(@RequestBody TransferRequest transferRequest)
	{
		boolean status = false;
	   try {
		   try {
			   
		       status = moneyTransferService.processTransaction(transferRequest);
		       String msg = "";
			   if(status)
			   {
			     msg = "transaction successful : response " + status;
			     	return  new ResponseEntity<String>(msg,HttpStatus.OK);
			   }
			   else
				   return  new ResponseEntity<String>(msg,HttpStatus.EXPECTATION_FAILED);
		   }
		   catch(Exception e)
		   {
			   String msg = "transaction unsuccessful : response " + status + " : "+ e.getMessage();
				return  new ResponseEntity<String>(msg,HttpStatus.EXPECTATION_FAILED);
		   }
		   
			  
	   }
	   catch(Exception e){
		   
		   String msg = "transaction unsuccessful : response " + status + " cause :" +e.getMessage();
			return  new ResponseEntity<String>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
		   
	   }
		
	}
	
}
