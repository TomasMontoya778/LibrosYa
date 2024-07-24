package com.using.mapStruct.mapStruct.api.DTOS.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    @Size(min = 0, max = 20, message = "The Status exceeds the numbers of characters")
    @NotBlank(message = "Status is required")
    private String status;
    @NotNull(message = "Reservation Date is required")
    private LocalDate reservationDate;
    @NotBlank(message = "Book ID is required")
    private String book;
    
}
