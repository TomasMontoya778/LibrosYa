package com.using.mapStruct.mapStruct.api.DTOS.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @Size(min = 0, max = 50, message = "The Username exceeds the numbers of characters")
    @NotBlank(message = "Username is required")
    private String user;

    @Size(min = 0, max = 100, message = "The password exceeds the numbers of characters")
    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Email's required")
    @Email
    @Size(min = 0, max = 40, message = "The email exceeds the number of characters")
    private String email;

    @NotBlank(message = "The Full Name is required")
    @Size(min = 0, max = 100, message = "The Full name exceeds the number of characters")
    private String fullName;

    @Size(min = 0, max = 20, message = "The Role exceeds the numbers of characters")
    @NotBlank(message = "Role is required")
    private String role;
    // private String reservation;
    // private String loan;
}
