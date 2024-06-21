package com.using.mapStruct.mapStruct.api.DTOS.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private String id;
    private String status;
    private LocalDate reservationDate;
    private UserResponseToReservation user;
    private BookResponse book;
}
