package com.using.mapStruct.mapStruct.api.DTOS.response;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String fullNameMapped;
    private String emailMapped;
    private String roleMapped;
    private Set<ReservationResponseToUser> reservationResponseToUsers;
    private Set<LoanResponseToUser> loanResponseToUsers;
}
