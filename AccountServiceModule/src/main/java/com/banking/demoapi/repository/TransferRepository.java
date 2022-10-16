package com.banking.demoapi.repository;

import java.util.List;
import java.util.UUID;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.banking.demoapi.entity.TransferEntity;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, UUID> {

	List<TransferEntity> findByFromAccountEquals(String fromAccount);

	@Lock(LockModeType.OPTIMISTIC)
    @Override
    TransferEntity save(TransferEntity entity);
}
