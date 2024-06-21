package com.using.mapStruct.mapStruct.infrastructure.abstract_services.interfaces;

import com.using.mapStruct.mapStruct.api.DTOS.request.LoanRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.LoanResponse;

public interface ILoanService extends CrudService<LoanResponse, LoanRequest, String>{

}
