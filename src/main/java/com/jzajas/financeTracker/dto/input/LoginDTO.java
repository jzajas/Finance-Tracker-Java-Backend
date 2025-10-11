package com.jzajas.financeTracker.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class LoginDTO {

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password is too short")
    private String password;

    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
