package com.muhammed.bankapplication.sec.service;

import com.muhammed.bankapplication.customer.dto.CustomerDto;
import com.muhammed.bankapplication.customer.dto.CustomerSaveRequest;
import com.muhammed.bankapplication.customer.sevice.CustomerService;
import com.muhammed.bankapplication.sec.dto.LoginRequestDto;
import com.muhammed.bankapplication.sec.security.JwtTokenGenerator;
import com.muhammed.bankapplication.sec.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final CustomerService customerService;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final AuthenticationManager authenticationManager;

    public CustomerDto register(CustomerSaveRequest customerSaveRequestDto) {

        return customerService.save(customerSaveRequestDto);
    }

    public String login(LoginRequestDto loginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequestDto.getIdentityNo().toString(), loginRequestDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        return getBearerToken(token);
    }

    public Long getCurrentCustomerId(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JwtUserDetails jwtUserDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof JwtUserDetails){
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        }

        Long customerId = null;
        if (jwtUserDetails != null){
            customerId = jwtUserDetails.getId();
        }

        return customerId;
    }

    private String getBearerToken(String token) {
        return EnumJwtConstant.BEARER.getText() + token;
    }


}
