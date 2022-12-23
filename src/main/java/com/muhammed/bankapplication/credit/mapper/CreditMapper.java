package com.muhammed.bankapplication.credit.mapper;

import com.muhammed.bankapplication.credit.dto.CreditDto;
import com.muhammed.bankapplication.credit.entity.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditMapper {


    CreditMapper INSTANCE = Mappers.getMapper(CreditMapper.class);

    Credit convertToCredit(CreditDto creditDto);

    CreditDto converToCreditDto(Credit credit);
}
