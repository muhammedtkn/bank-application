package com.muhammed.bankapplication.customer.controller;

import com.muhammed.bankapplication.customer.dto.CustomerDto;
import com.muhammed.bankapplication.customer.dto.CustomerSaveRequest;
import com.muhammed.bankapplication.customer.dto.CustomerUpdatePasswordDto;
import com.muhammed.bankapplication.customer.sevice.CustomerService;
import com.muhammed.bankapplication.general.response.GeneralRestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity findAll(){

        List<CustomerDto> customerDtoList = customerService.findAll();

        return ResponseEntity.ok(GeneralRestResponse.of(customerDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        CustomerDto customerDto = customerService.findById(id);

        return ResponseEntity.ok(GeneralRestResponse.of(customerDto ));
    }

    @PostMapping
    public  ResponseEntity save(@Valid @RequestBody CustomerSaveRequest customerSaveRequest){

        CustomerSaveRequest saveRequest = customerService.save(customerSaveRequest);

        return ResponseEntity.ok(GeneralRestResponse.of(saveRequest));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity save(@PathVariable Long id){

        customerService.delete(id);

        return ResponseEntity.ok(GeneralRestResponse.empty());
    }

    public ResponseEntity updatePassword(@Valid @RequestBody CustomerUpdatePasswordDto customerUpdatePasswordDto) {

        CustomerDto customerDto=customerService.updatePassword(customerUpdatePasswordDto);

        return ResponseEntity.ok(GeneralRestResponse.of(customerDto));
    }
}

