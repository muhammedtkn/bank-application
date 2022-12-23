package com.muhammed.bankapplication.account.controller;

import com.muhammed.bankapplication.account.dto.AccountDto;
import com.muhammed.bankapplication.account.dto.AccountSaveRequestDto;
import com.muhammed.bankapplication.account.service.AccountService;
import com.muhammed.bankapplication.general.response.GeneralRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity save(@RequestBody AccountSaveRequestDto accountSaveRequestDto){

        AccountDto accountDto = accountService.saveAccount(accountSaveRequestDto);

        return ResponseEntity.ok(GeneralRestResponse.of(accountDto));
    }

    @GetMapping
    public ResponseEntity findAll(){

        List<AccountDto> accountDtoList =  accountService.findAllAccountByCustomerId();

        return ResponseEntity.ok(GeneralRestResponse.of(accountDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralRestResponse<AccountDto>> findById(@PathVariable Long id){

        AccountDto accountDto = accountService.findAccountById(id);

        return ResponseEntity.ok(GeneralRestResponse.of(accountDto));
    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity deactivate(@PathVariable Long id){

        accountService.deactivateAccount(id);

        return ResponseEntity.ok(GeneralRestResponse.empty());
    }
}
