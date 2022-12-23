package com.muhammed.bankapplication.account.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class AccountMoneyActivityDto {

    private Long accountId;
    private BigDecimal amount;
}
