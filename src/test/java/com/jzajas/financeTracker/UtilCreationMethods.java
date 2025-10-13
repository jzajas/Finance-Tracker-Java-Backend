package com.jzajas.financeTracker;

import com.jzajas.financeTracker.dto.input.UserRegistrationDTO;
import com.jzajas.financeTracker.dto.output.UserOutputDTO;
import com.jzajas.financeTracker.entity.User;

import java.time.LocalDate;

public class UtilCreationMethods {


    public static User createDefaultUser() {
        return new User(
                1L,
                "johnny",
                "johnny.doe@gmail.com",
                "password1",
                LocalDate.of(2025, 10, 8),
                LocalDate.of(2025, 10, 8)
        );
    }

    public static User createCustomUser(String password) {
        return new User(
                1L,
                "johnny",
                "johnny.doe@gmail.com",
                password,
                LocalDate.of(2025, 10, 8),
                LocalDate.of(2025, 10, 8)
        );
    }

    public static UserRegistrationDTO createDefaultUserRegistrationDTO() {
        return new UserRegistrationDTO(
                "johnny",
                "password1",
                "johnny.doe@gmail.com"
        );
    }

    public static UserRegistrationDTO createCustomUserRegistrationDTO(String password) {
        return new UserRegistrationDTO(
                "johnny",
                password,
                "johnny.doe@gmail.com"
        );
    }

    public static UserOutputDTO createDefaultUserOutputDTO() {
        return new UserOutputDTO(
                "johnny",
                "johnny.doe@gmail.com",
                "password1",
                LocalDate.of(2025, 10, 8)
        );
    }

    public static UserOutputDTO createCustomUserOutputDTO(String password) {
        return new UserOutputDTO(
                "johnny",
                "johnny.doe@gmail.com",
                password,
                LocalDate.of(2025, 10, 8)
        );
    }
}
