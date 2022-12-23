package com.muhammed.bankapplication.account.service;

import com.muhammed.bankapplication.account.dto.AccountDto;
import com.muhammed.bankapplication.account.dto.AccountSaveRequestDto;
import com.muhammed.bankapplication.account.entity.Account;
import com.muhammed.bankapplication.account.errorsMessage.AccountErrorMessage;
import com.muhammed.bankapplication.account.mappers.AccountMapper;
import com.muhammed.bankapplication.account.service.entityservice.AccountEntityService;
import com.muhammed.bankapplication.account.utils.GeneratedNewIban;
import com.muhammed.bankapplication.general.enums.Status;
import com.muhammed.bankapplication.general.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

        private final AccountEntityService accountEntityService;
        public AccountDto saveAccount(AccountSaveRequestDto accountSaveRequestDto) {

            String newIban = generateNewIban();

            Long currentCustomerId = accountEntityService.getCurrentCustomerId();

            Account account = AccountMapper.INSTANCE.convertToAccount(accountSaveRequestDto);
            account.setIbanNo(newIban);
            account.setCurrentBalance(BigDecimal.ZERO);
            account.setStatus(Status.ACTIVE);
            account.setCustomerId(currentCustomerId);
            account = accountEntityService.save(account);

            AccountDto accountDto = AccountMapper.INSTANCE.convertToAccountDto(account);

            return accountDto;

        }
        private String generateNewIban() {

            String ibanNumbers = GeneratedNewIban.getRandomNumberAsString(26);

            return "TR" + ibanNumbers;
        }

        public List<AccountDto> findAllAccountByCustomerId() {

        Long currentCustomerId = accountEntityService.getCurrentCustomerId();

        List<Account> accountList = accountEntityService.findAllByCustomerId(currentCustomerId);

        List<AccountDto> accountDtoList = AccountMapper.INSTANCE.convertToAccountDtoList(accountList);

        return accountDtoList;

    }

    public AccountDto findAccountById(Long id) {

        Account account = accountEntityService.findByIdWithControl(id);

        AccountDto accountDto = AccountMapper.INSTANCE.converToAccountDto(account);

        return accountDto;
    }

    public void deactivateAccount(Long id) {

        Account account = accountEntityService.findByIdWithControl(id);

        if (Status.PASSIVE.equals(account.getStatus())){
            throw new BusinessException(AccountErrorMessage.ACCOUNT_ALREADY_PASSIVE);
        }

        account.setStatus(Status.PASSIVE);
        account.setCancelDate(new Date());
        accountEntityService.save(account);
    }

 }

