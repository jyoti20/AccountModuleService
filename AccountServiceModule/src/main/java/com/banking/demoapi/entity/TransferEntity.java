package com.banking.demoapi.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;


@Table(name="Transfer_Track")
@Entity
public class TransferEntity {
		
	@Id
    private UUID transactionId;
	
	@NonNull
	private String fromAccount;
	
	@NonNull
	private String toAccount;
	
	@NonNull
	private String transferRequestId;

	@NonNull
    private BigDecimal transactionAmount;
	
	@NonNull
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    @CreationTimestamp
    @Column(name="transaction_Date_Time")
    private Date transactionDateTime;

    public UUID getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}



	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Date transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getTransferRequestId() {
		return transferRequestId;
	}

	public void setTransferRequestId(String transferRequestId) {
		this.transferRequestId = transferRequestId;
	}

	
    
    

}
