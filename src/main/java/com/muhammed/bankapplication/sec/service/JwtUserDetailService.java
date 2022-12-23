package com.muhammed.bankapplication.sec.service;

import com.muhammed.bankapplication.customer.entity.Customer;
import com.muhammed.bankapplication.customer.sevice.CustomerEntityService;
import com.muhammed.bankapplication.general.exceptions.BusinessException;
import com.muhammed.bankapplication.sec.errormessage.SecurityErrorMessage;
import com.muhammed.bankapplication.sec.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

    private final CustomerEntityService customerEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!StringUtils.hasText(username)){
            throw new BusinessException(SecurityErrorMessage.USERNAME_CANNOT_BE_NULL);
        }

        Long identityNo;
        try {
            identityNo = Long.valueOf(username);
        } catch (NumberFormatException e){
            throw new BusinessException(SecurityErrorMessage.USERNAME_MUST_BE_NUMBER);
        }

        Customer customer = customerEntityService.findByIdentityNo(identityNo);

        if (customer == null){
            throw new BusinessException(SecurityErrorMessage.INVALID_USERNAME_AND_PASSWORD);
        }

        return JwtUserDetails.create(customer);
    }

    public UserDetails loadUserByCustomerId(Long id){

        Customer customer = customerEntityService.findByIdWithControl(id);

        return JwtUserDetails.create(customer);
    }
}
