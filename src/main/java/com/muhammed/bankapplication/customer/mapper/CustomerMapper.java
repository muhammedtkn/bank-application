package com.muhammed.bankapplication.customer.mapper;

import com.muhammed.bankapplication.customer.dto.CustomerDto;
import com.muhammed.bankapplication.customer.dto.CustomerSaveRequest;
import com.muhammed.bankapplication.customer.dto.CustomerUpdatePasswordDto;
import com.muhammed.bankapplication.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto convertToCustomerDto(Customer customer);
    Customer convertToCustomer(CustomerUpdatePasswordDto customerUpdateRequestDto);
    List<CustomerDto> convertToCustomerDtoList(List<Customer> customerList);
    Customer convertToCustomer(CustomerSaveRequest customerSaveRequest);
    CustomerSaveRequest converToCustomerSaveRequest(Customer customer);



}
