package com.using.mapStruct.mapStruct.api.DTOS.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.using.mapStruct.mapStruct.api.DTOS.response.LoanResponse;
import com.using.mapStruct.mapStruct.domain.entities.Loan;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {
    LoanMapper loanMapper = Mappers.getMapper(LoanMapper.class);

    @InheritInverseConfiguration
    @Mapping(source = "user", target = "userResponse")
    @Mapping(source = "book", target = "bookResponse")
    LoanResponse entityToResponse (Loan loan);

    
}
