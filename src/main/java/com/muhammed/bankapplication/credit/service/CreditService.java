package com.muhammed.bankapplication.credit.service;

import com.muhammed.bankapplication.credit.loan.CreditCalculater;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditService {

    public BigDecimal loanCalculator(BigDecimal requestedLoan, Long installments) {

        CreditCalculater.loanCalculator(requestedLoan,installments);

        return CreditCalculater.loanCalculator(requestedLoan,installments);

    }
}
