package com.using.mapStruct.mapStruct.api.DTOS.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseFull {
    private String id;
    private String user;
    private String fullName;
    private String email;
    private String role;
    private List<ReservationResponseToUser> reservation;
    private List<LoanResponseToUser> loan;
}
