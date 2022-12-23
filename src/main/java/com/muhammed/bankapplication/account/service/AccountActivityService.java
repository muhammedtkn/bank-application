package com.muhammed.bankapplication.account.service;

import com.muhammed.bankapplication.account.dto.AccountMoneyActivityDto;
import com.muhammed.bankapplication.account.entity.Account;
import com.muhammed.bankapplication.account.entity.AccountActivity;
import com.muhammed.bankapplication.account.enums.AccountActivityType;
import com.muhammed.bankapplication.account.errorsMessage.AccountErrorMessage;
import com.muhammed.bankapplication.account.service.entityservice.AccountActivityEntityService;
import com.muhammed.bankapplication.account.service.entityservice.AccountEntityService;
import com.muhammed.bankapplication.general.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AccountActivityService {

    private final AccountEntityService accountEntityService;
    private final AccountActivityEntityService accountActivityEntityService;

    public BigDecimal deposit(AccountMoneyActivityDto accountMoneyActivityDto) {

        AccountActivityType accountActivityType = AccountActivityType.DEPOSIT;
        Long accountId = accountMoneyActivityDto.getAccountId();
        BigDecimal amount = accountMoneyActivityDto.getAmount();

        AccountActivity accountActivity = moneyIn(accountActivityType, accountId, amount);

        return accountActivity.getAmount();
    }

    public BigDecimal withdraw(AccountMoneyActivityDto accountMoneyActivityDto) {

        AccountActivityType withdraw = AccountActivityType.WITHDRAW;
        Long accountId = accountMoneyActivityDto.getAccountId();
        BigDecimal amount = accountMoneyActivityDto.getAmount();

        AccountActivity accountActivity = moneyOut(withdraw, accountId, amount);

        return accountActivity.getAmount();
    }

    public AccountActivity moneyIn(AccountActivityType accountActivityType, Long accountId, BigDecimal amount) {
        Account account = accountEntityService.findByIdWithControl(accountId);
        BigDecimal newBalance = account.getCurrentBalance().add(amount);

        account = updateCurrentBalance(account, newBalance);

        AccountActivity accountActivity = createAccountActivity(amount, account.getId(), newBalance, accountActivityType);
        return accountActivity;
    }

    public AccountActivity moneyOut(AccountActivityType withdraw, Long accountId, BigDecimal amount) {
        Account account = accountEntityService.findByIdWithControl(accountId);
        BigDecimal newBalance = account.getCurrentBalance().subtract(amount);

        validateBalance(newBalance);

        account = updateCurrentBalance(account, newBalance);

        AccountActivity accountActivity = createAccountActivity(amount, account.getId(), newBalance, withdraw);
        return accountActivity;
    }

    private void validateBalance(BigDecimal newBalance) {
        if (newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new BusinessException(AccountErrorMessage.INSUFFICIENT_BALANCE);
        }
    }

    private Account updateCurrentBalance(Account account, BigDecimal newBalance) {
        account.setCurrentBalance(newBalance);
        account = accountEntityService.save(account);
        return account;
    }

    private AccountActivity createAccountActivity(BigDecimal amount, Long accountId, BigDecimal newBalance,
                                                  AccountActivityType accountActivityType) {
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.setAccountActivityType(accountActivityType);
        accountActivity.setAccountId(accountId);
        accountActivity.setAmount(amount);
        accountActivity.setCurrentBalance(newBalance);
        accountActivity.setTransactionDate(LocalDate.now());
        accountActivity = accountActivityEntityService.save(accountActivity);
        return accountActivity;
    }
}
