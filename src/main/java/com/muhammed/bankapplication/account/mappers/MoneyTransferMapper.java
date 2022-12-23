package com.muhammed.bankapplication.account.mappers;

import com.muhammed.bankapplication.account.dto.MoneyTransferDto;
import com.muhammed.bankapplication.account.dto.MoneyTransferSaveRequestDto;
import com.muhammed.bankapplication.account.entity.MoneyTransfer;
import org.mapstruct.factory.Mappers;

public interface MoneyTransferMapper {

    MoneyTransferMapper INTANCE=Mappers.getMapper(MoneyTransferMapper.class);

    MoneyTransfer convertToMoneyTransfer(MoneyTransferSaveRequestDto saveRequestDto);
    MoneyTransferDto convertToMoneyTransferDto(MoneyTransfer moneyTransfer);
}
