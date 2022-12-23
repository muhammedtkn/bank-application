package com.muhammed.bankapplication.credit.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreditPaymentDto {

    private Long id;
    private Long creditId;
    private Long installmentId;
    private BigDecimal amount;
    private LocalDate date;
}
