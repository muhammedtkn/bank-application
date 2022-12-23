package com.muhammed.bankapplication.account.dao;

import com.muhammed.bankapplication.account.entity.MoneyTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyTransferDao extends JpaRepository<MoneyTransfer, Long> {

}
