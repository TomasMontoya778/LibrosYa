package com.using.mapStruct.mapStruct.api.DTOS.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {
    @NotBlank(message = "Loan Date is required (MM/DD/YYYY)")
    private LocalDate loan_Date;
    @NotBlank(message = "Return is required")
    private LocalDate return_date;
    @Size(min = 0, max = 20, message = "The status exceeds the numbers of characters")
    @NotBlank(message = "Status is required")
    private String status;
    @NotBlank(message = "Book ID is required")
    private String book_id;
    @NotBlank(message = "User ID is required")
    private String user_id;
}
