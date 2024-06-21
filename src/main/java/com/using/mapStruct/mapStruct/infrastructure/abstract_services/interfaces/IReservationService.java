package com.using.mapStruct.mapStruct.infrastructure.abstract_services.interfaces;

import com.using.mapStruct.mapStruct.api.DTOS.request.ReservationRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.ReservationResponse;

public interface IReservationService extends CrudService<ReservationResponse, ReservationRequest, String>{

}
