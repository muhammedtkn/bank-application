package com.muhammed.bankapplication.credit.mapper;

import com.muhammed.bankapplication.credit.dto.CreditInstallmentDto;
import com.muhammed.bankapplication.credit.entity.CreditInstallment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditInstallmentMapper {


    CreditInstallmentMapper INSTANCE = Mappers.getMapper(CreditInstallmentMapper.class);

    CreditInstallment converToCreditInstallment(CreditInstallmentDto creditInstallmentDto);

    CreditInstallmentDto converToCreditInstallmentDto(CreditInstallment creditInstallment);

}
