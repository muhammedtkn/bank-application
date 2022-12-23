package com.muhammed.bankapplication.credit.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreditInstallmentDto {

    private Long id;
    private Long creditId;
    private String orderNo;
    private BigDecimal monthlyInstallmentAmount;
    private  BigDecimal interestToBePaid;
    private BigDecimal principalToBePaid;
    private  BigDecimal remainingPrincipal;
    private LocalDate dueDate;
}
