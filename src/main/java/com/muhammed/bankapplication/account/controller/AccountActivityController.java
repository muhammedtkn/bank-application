package com.muhammed.bankapplication.account.controller;

import com.muhammed.bankapplication.account.dto.AccountMoneyActivityDto;
import com.muhammed.bankapplication.account.service.AccountActivityService;
import com.muhammed.bankapplication.general.response.GeneralRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/account-activities")
@RequiredArgsConstructor
public class AccountActivityController {

    private final AccountActivityService accountActivityService;

    @PostMapping("/deposit")
    public ResponseEntity deposit(@RequestBody AccountMoneyActivityDto accountMoneyActivityDto){

        BigDecimal currentBalance = accountActivityService.deposit(accountMoneyActivityDto);

        return ResponseEntity.ok(GeneralRestResponse.of(currentBalance));
    }

    @PostMapping("/withdraw")
    public ResponseEntity withdraw(@RequestBody AccountMoneyActivityDto accountMoneyActivityDto){

        BigDecimal currentBalance = accountActivityService.withdraw(accountMoneyActivityDto);

        return ResponseEntity.ok(GeneralRestResponse.of(currentBalance));
    }
}
