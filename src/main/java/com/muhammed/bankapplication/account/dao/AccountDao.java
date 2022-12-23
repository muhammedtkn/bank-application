package com.muhammed.bankapplication.account.dao;

import com.muhammed.bankapplication.account.entity.Account;
import com.muhammed.bankapplication.general.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDao extends JpaRepository<Account, Long> {

    List<Account> findAllByCustomerIdAndStatus(Long customerId, Status status);
}