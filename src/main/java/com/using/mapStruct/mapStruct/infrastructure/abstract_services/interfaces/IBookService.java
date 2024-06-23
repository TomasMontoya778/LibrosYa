package com.using.mapStruct.mapStruct.infrastructure.abstract_services.interfaces;

import com.using.mapStruct.mapStruct.api.DTOS.request.BookRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.BookResponse;

public interface IBookService extends CrudService <BookRequest,BookResponse, String>{

}
