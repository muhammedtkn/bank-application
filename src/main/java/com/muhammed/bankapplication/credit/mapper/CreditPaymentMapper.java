package com.muhammed.bankapplication.credit.mapper;

import com.muhammed.bankapplication.credit.dto.CreditPaymentDto;
import com.muhammed.bankapplication.credit.entity.CreditPayment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditPaymentMapper {


    CreditPaymentMapper INSTANCE= Mappers.getMapper(CreditPaymentMapper.class);

    CreditPayment convertToCreditPayment(CreditPaymentDto creditPaymentDto);

    CreditPaymentDto convertToCreditPaymentDto(CreditPayment creditPayment);
}
