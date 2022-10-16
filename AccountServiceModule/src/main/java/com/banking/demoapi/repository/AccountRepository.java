package com.banking.demoapi.repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.demoapi.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

	Optional<Account> findByAccountNumberEquals(String accountNumber);
	
	@Lock(LockModeType.OPTIMISTIC)
    @Override
    Account save(Account entity);
	
	@Modifying
	@Query("update Account set  current_balance=?2 where account_number=?3")
	public void updateBalance(String account_number, BigDecimal current_balance);
}
