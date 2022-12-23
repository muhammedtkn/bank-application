package com.muhammed.bankapplication.account.dto;

import com.muhammed.bankapplication.account.enums.MoneyTransferType;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class MoneyTransferSaveRequestDto {

    private Long accountIdFrom;
    private Long accountIdTo;
    private BigDecimal amount;
    private String description;
    private MoneyTransferType moneyTransferType;
}
