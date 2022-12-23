package com.muhammed.bankapplication.account.mappers;

import com.muhammed.bankapplication.account.dto.AccountDto;
import com.muhammed.bankapplication.account.dto.AccountSaveRequestDto;
import com.muhammed.bankapplication.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountMapper INSTANCE=Mappers.getMapper(AccountMapper.class);

    Account convertToAccount(AccountSaveRequestDto accountSaveRequestDto);
    AccountDto converToAccountDto(Account account);
    Account convertToAccount(AccountDto accountDto);

    List<AccountDto> convertToAccountDtoList(List<Account> accountList);
}
