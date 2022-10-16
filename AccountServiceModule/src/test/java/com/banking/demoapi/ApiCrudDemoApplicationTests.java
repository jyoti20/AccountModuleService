package com.banking.demoapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.banking.demoapi.entity.Account;
import com.banking.demoapi.model.TransferRequest;
import com.banking.demoapi.service.AccountService;
import com.banking.demoapi.service.MoneyTransferService;
import com.banking.demoapi.service.TransferService;


@RunWith(SpringRunner.class)
@DataJpaTest
class ApiCrudDemoApplicationTests {
	

	 @TestConfiguration
	    static class AccountServiceTestContextConfiguration {
	        @Bean
	        public AccountService accountServiceTest() {
	            return new AccountService();

	        }
	    }
	 
	 @TestConfiguration
	    static class MoneyTransferServiceTestContextConfiguration {
	        @Bean
	        public MoneyTransferService moneyTransferServiceServiceTest() {
	            return new MoneyTransferService();

	        }
	    }
	 
	 @TestConfiguration
	    static class TransferServiceTestContextConfiguration {
	        @Bean
	        public TransferService transferServiceServiceTest() {
	            return new TransferService();

	        }
	    }
	 
	 @Autowired
	 private AccountService accountService;
	 
	 @Autowired
		MoneyTransferService  moneyTransferService;
	 
	 @Autowired
		TransferService  transferService;
	 
	 
	 @Test
	    public void moneyTransferAccount() {
		 
		 Account account1 = new Account();
		 
		 account1.setAccountNumber("2002");
		 account1.setCurrentBalance(new BigDecimal(2000));
		    accountService.save(account1);
	        
		 System.out.println(account1.getAccountNumber() + ".. craeted");
	        Account account2 = new Account();
	       
	        account2.setAccountNumber("2480052");
	        account2.setCurrentBalance(new BigDecimal(5000));
		        accountService.save(account2);
	        
	        TransferRequest transferRequest = new TransferRequest();
	        
	        transferRequest.setFromAccount(null);
	        transferRequest.setFromAccount(null);
	        transferRequest.setTransactionAmount(new BigDecimal(500));
	        
	        moneyTransferService.processTransaction(transferRequest);
	       
//	        System.out.println(account1.getAccountNumber() + ".. transfered from ");
//	       BigDecimal currBalance = accountService.getAccountStatement(account1.getAccountNumber()).getCurrentBalance();
//	       System.out.println(currBalance + ".. currBalance ");
//	        assertEquals(currBalance, new BigDecimal(1500));
	        
	        System.out.println(account1.getAccountNumber() + ".. transfered from ");
		       BigDecimal addedBalance = accountService.getAccountStatement(account2.getAccountNumber()).getCurrentBalance();
		       System.out.println(addedBalance + ".. addedBalance ");
		        assertEquals(addedBalance, new BigDecimal(5500));
	 }
	 
	 
}
