package com.using.mapStruct.mapStruct.infrastructure.abstract_services.interfaces;

import com.using.mapStruct.mapStruct.api.DTOS.request.UserRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, String> {

}
