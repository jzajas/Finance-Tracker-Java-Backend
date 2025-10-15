package com.jzajas.financeTracker.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDTO {

    private String username;

    private String email;

    private String password;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
