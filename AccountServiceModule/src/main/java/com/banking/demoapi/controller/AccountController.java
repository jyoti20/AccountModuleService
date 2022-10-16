package com.banking.demoapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demoapi.entity.Account;
import com.banking.demoapi.service.AccountService;

@RestController
public class AccountController {

	AccountService  accService;
	
	public AccountController(AccountService accService) {
        this.accService = accService;
    }
	
		
	/**
	 * getAccountDetails
	* Get Account Details for a given account number
	*/
	@GetMapping("/getAccount/{accountNumber}")
	public ResponseEntity<Account> getAccountDetails(@PathVariable String accountNumber)
	{
		Account account =  accService.getAccountStatement(accountNumber);
		try {
			if(null != account)
			{
 				return new ResponseEntity<Account>(account,HttpStatus.OK);
			}
			
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	@PostMapping("/save/account")
	public ResponseEntity<Account> save(@RequestBody Account account)
	{
		try {
			return new ResponseEntity<>(accService.save(account), HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getAccounts")
	public ResponseEntity<List<Account>> getAllAccounts()
	{
		List<Account> list =  accService.findAll();
		try {
			if(list.size() == 0 || list.isEmpty())
			{
				return new ResponseEntity<List<Account>>(list,HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Account>>(list,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<List<Account>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	

	

		
	

	
	
	
	
}
