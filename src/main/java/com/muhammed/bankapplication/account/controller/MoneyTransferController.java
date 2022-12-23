package com.muhammed.bankapplication.account.controller;

import com.muhammed.bankapplication.account.dto.MoneyTransferDto;
import com.muhammed.bankapplication.account.dto.MoneyTransferSaveRequestDto;
import com.muhammed.bankapplication.account.service.MoneyTransferService;
import com.muhammed.bankapplication.general.response.GeneralRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/money-transfers")
@RequiredArgsConstructor
public class MoneyTransferController {

    private final MoneyTransferService moneyTransferService;

    @PostMapping
    public ResponseEntity transferMoney(@RequestBody MoneyTransferSaveRequestDto moneyTransferSaveRequestDto) {

        MoneyTransferDto moneyTransferDto = moneyTransferService.transferMoney(moneyTransferSaveRequestDto);

        return ResponseEntity.ok(GeneralRestResponse.of(moneyTransferDto));

    }
    }