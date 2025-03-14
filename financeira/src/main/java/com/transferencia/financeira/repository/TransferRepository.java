package com.transferencia.financeira.repository;

import com.transferencia.financeira.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {


    Transfer save(Transfer transfer);

    List<Transfer> findByUserId(Long userId);
}
