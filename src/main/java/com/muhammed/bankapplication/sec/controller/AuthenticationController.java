package com.muhammed.bankapplication.sec.controller;

import com.muhammed.bankapplication.customer.dto.CustomerDto;
import com.muhammed.bankapplication.customer.dto.CustomerSaveRequest;
import com.muhammed.bankapplication.general.response.GeneralRestResponse;
import com.muhammed.bankapplication.sec.dto.LoginRequestDto;
import com.muhammed.bankapplication.sec.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto) {

        String token = authenticationService.login(loginRequestDto);

        return ResponseEntity.ok(GeneralRestResponse.of(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody CustomerSaveRequest customerSaveRequestDto) {

        CustomerDto customerDto = authenticationService.register(customerSaveRequestDto);

        return ResponseEntity.ok(GeneralRestResponse.of(customerDto));
    }
}
