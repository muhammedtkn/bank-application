package com.muhammed.bankapplication.account.dao;

import com.muhammed.bankapplication.account.entity.AccountActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountActivityDao extends JpaRepository<AccountActivity, Long> {

}
