package com.muhammed.bankapplication.account.service;

import com.muhammed.bankapplication.account.dto.MoneyTransferDto;
import com.muhammed.bankapplication.account.dto.MoneyTransferSaveRequestDto;
import com.muhammed.bankapplication.account.entity.MoneyTransfer;
import com.muhammed.bankapplication.account.enums.AccountActivityType;
import com.muhammed.bankapplication.account.mappers.MoneyTransferMapper;
import com.muhammed.bankapplication.account.service.entityservice.MoneyTransferEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MoneyTransferService {

    private final AccountActivityService accountActivityService;
    private final MoneyTransferEntityService moneyTransferEntityService;

    public MoneyTransferDto transferMoney(MoneyTransferSaveRequestDto moneyTransferSaveRequestDto) {

        BigDecimal amount = moneyTransferSaveRequestDto.getAmount();

        accountActivityService.moneyOut(AccountActivityType.SEND, moneyTransferSaveRequestDto.getAccountIdFrom(), amount);
        accountActivityService.moneyIn(AccountActivityType.GET, moneyTransferSaveRequestDto.getAccountIdTo(), amount);

        MoneyTransfer moneyTransfer = MoneyTransferMapper.INTANCE.convertToMoneyTransfer(moneyTransferSaveRequestDto);
        moneyTransfer.setTransactionDate(LocalDateTime.now());

        moneyTransfer = moneyTransferEntityService.save(moneyTransfer);

        MoneyTransferDto moneyTransferDto = MoneyTransferMapper.INTANCE.convertToMoneyTransferDto(moneyTransfer);

        return moneyTransferDto;
    }
}
