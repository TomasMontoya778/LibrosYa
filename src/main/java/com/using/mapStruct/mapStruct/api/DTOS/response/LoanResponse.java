package com.using.mapStruct.mapStruct.api.DTOS.response;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    private String id;
    private LocalDate loan_Date;
    private LocalDate return_date;
    private String status;
    private UserReponseToLoan userResponse;
    private BookResponse bookResponse;
}
