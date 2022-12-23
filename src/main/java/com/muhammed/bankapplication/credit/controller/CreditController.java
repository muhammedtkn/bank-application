package com.muhammed.bankapplication.credit.controller;

import com.muhammed.bankapplication.credit.service.CreditService;
import com.muhammed.bankapplication.general.response.GeneralRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/credits")
public class CreditController {

    private final CreditService creditService;

    @GetMapping("/loanCalculator/{requestedLoan}/{installments}")
    public ResponseEntity loanCalculator(@PathVariable BigDecimal requestedLoan, @PathVariable Long installments){

        BigDecimal loanCalculator=creditService.loanCalculator(requestedLoan,installments);

        return ResponseEntity.ok(GeneralRestResponse.of(loanCalculator));
    }



}