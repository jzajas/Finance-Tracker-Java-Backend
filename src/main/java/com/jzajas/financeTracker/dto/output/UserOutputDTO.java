package com.jzajas.financeTracker.dto.output;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class UserOutputDTO {

    private String username;

    private String email;

    private LocalDate createdAt;
}
