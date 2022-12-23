package com.muhammed.bankapplication.account.dto;

import com.muhammed.bankapplication.account.enums.AccountType;
import com.muhammed.bankapplication.account.enums.CurrencyType;
import com.muhammed.bankapplication.general.enums.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountDto {

    private Long id;
    private Long customerId;
    private String ibanNo;
    private BigDecimal currentBalance;
    private CurrencyType currencyType;
    private AccountType accountType;
    private Status status;
    private LocalDateTime cancelDate;
}
