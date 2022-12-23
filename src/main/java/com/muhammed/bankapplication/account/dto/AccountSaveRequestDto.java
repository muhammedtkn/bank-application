package com.muhammed.bankapplication.account.dto;

import com.muhammed.bankapplication.account.enums.AccountType;
import com.muhammed.bankapplication.account.enums.CurrencyType;
import lombok.Data;

@Data
public class AccountSaveRequestDto {

    private CurrencyType currencyType;
    private AccountType accountType;
}
