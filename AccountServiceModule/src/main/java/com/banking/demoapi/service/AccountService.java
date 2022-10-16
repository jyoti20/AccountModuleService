package com.banking.demoapi.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.demoapi.entity.Account;
import com.banking.demoapi.repository.AccountRepository;

@Service
public class AccountService {
	
	
	@Autowired
	AccountRepository accountRepo;
	
	/**AccountStatement
	* Get Account Details for a given account number
	*/
	public Account getAccountStatement(String accountNumber)
	{
		Optional<Account> account = accountRepo.findByAccountNumberEquals(accountNumber);
		
		if(account.isPresent())
			return account.get();
		
		
			return null;
	}

	/**UpdateBalance
	* Update given balance for the provided account
	*/
	public Account updateBalance(Account account, BigDecimal newBalance) {
		
		account.setCurrentBalance(newBalance);
		return accountRepo.save(account);
		
	}

	/**save
	* Persist provided account
	*/
	public Account save(Account account1) {
		UUID uuid=UUID.randomUUID(); 
		account1.setAccountId(uuid);
		return accountRepo.save(account1);
	}

	public List<Account> findAll() {
		return accountRepo.findAll();
	}

	


}
