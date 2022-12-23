package com.muhammed.bankapplication.account.dto;

import com.muhammed.bankapplication.account.enums.MoneyTransferType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MoneyTransferDto {

    private Long id;
    private Long accountIdFrom;
    private Long accountIdTo;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private String description;
    private MoneyTransferType moneyTransferType;
}
