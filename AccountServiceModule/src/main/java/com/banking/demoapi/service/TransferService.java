package com.banking.demoapi.service;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.demoapi.entity.TransferEntity;
import com.banking.demoapi.repository.TransferRepository;

@Service
public class TransferService {
	
	@Autowired
	TransferRepository transferRepo;
	
	
	
	TransferEntity createTransfer(String fromAccount, String toAccount, BigDecimal transactionAmount, String transferRequestId, String status)
	{
		
		TransferEntity transferEntity = new TransferEntity();
		transferEntity.setFromAccount(fromAccount);
		transferEntity.setToAccount(toAccount);
		transferEntity.setTransactionAmount(transactionAmount);
		transferEntity.setTransferRequestId(transferRequestId);
		transferEntity.setStatus(status);
		
		UUID uuid=UUID.randomUUID(); 
		transferEntity.setTransactionId(uuid);
		transferEntity = transferRepo.save(transferEntity);
		return transferEntity;
		
	}
}
