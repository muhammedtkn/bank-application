package com.muhammed.bankapplication.customer.sevice;

import com.muhammed.bankapplication.customer.dao.CustomerDao;
import com.muhammed.bankapplication.customer.dto.CustomerDto;
import com.muhammed.bankapplication.customer.dto.CustomerSaveRequest;
import com.muhammed.bankapplication.customer.dto.CustomerUpdatePasswordDto;
import com.muhammed.bankapplication.customer.entity.Customer;
import com.muhammed.bankapplication.customer.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerEntityService customerEntityService;
    private final PasswordEncoder passwordEncoder;
    private final CustomerDao customerDao;
    private final CustomerPasswordValidator customerPasswordValidator;

    public List<CustomerDto> findAll() {

        List<Customer> customerList = customerEntityService.findAll();
        List<CustomerDto> customerDtoList = CustomerMapper.INSTANCE.convertToCustomerDtoList(customerList);

        return customerDtoList;
    }

    public CustomerDto findById(Long id) {

        Customer customer = customerEntityService.findByIdWithControl(id);

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);

        return  customerDto;
    }

    public CustomerSaveRequest save(CustomerSaveRequest customerSaveRequest) {

        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerSaveRequest);

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer customerSave = customerEntityService.save(customer);

        CustomerSaveRequest toCustomerSaveRequest = CustomerMapper.INSTANCE.converToCustomerSaveRequest(customerSave);

        return toCustomerSaveRequest;
    }

    public void delete(Long id) {

        customerEntityService.delete(id);
    }


    public CustomerDto updatePassword(CustomerUpdatePasswordDto customerUpdatePasswordDto) {
        Long currentCustomerId = customerEntityService.getCurrentCustomerId();

        Customer customer = customerEntityService.findByIdWithControl(currentCustomerId);
        String currentPassword = customer.getPassword();

        customerPasswordValidator.validatorPassword(customerUpdatePasswordDto, currentPassword);

        customer.setPassword(customerUpdatePasswordDto.getNewPassword());
        customer = customerEntityService.save(customer);

        return CustomerMapper.INSTANCE.convertToCustomerDto(customer);
    }
}
