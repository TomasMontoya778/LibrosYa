package com.using.mapStruct.mapStruct.api.DTOS.response;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseToReservation {
    private String id;
    private String fullName;
    private String email;
    private String role;
    private Set<LoanResponseToUser> loanResponseToUsers;
}
