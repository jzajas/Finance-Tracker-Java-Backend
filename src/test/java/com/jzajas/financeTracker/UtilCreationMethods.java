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
                "123",
                LocalDate.of(2025, 10, 8)
        );
    }

    public static User createCustomUser(String username, String email) {
        return new User(
                1L,
                username,
                email,
                "123",
                LocalDate.of(2025, 10, 8)
        );
    }

    public static UserRegistrationDTO createDefaultUserRegistrationDTO() {
        return new UserRegistrationDTO(
                "johnny",
                "123",
                "johnny.doe@gmail.com"
        );
    }

    public static UserRegistrationDTO createCustomUserRegistrationDTO(String username, String email) {
        return new UserRegistrationDTO(
                username,
                "123",
                email
        );
    }

    public static UserOutputDTO createDefaultUserOutputDTO() {
        return new UserOutputDTO(
                "johnny",
                "johnny.doe@gmail.com",
                LocalDate.of(2025, 10, 8)
        );
    }

    public static UserOutputDTO createCustomUserOutputDTO(String username, String email) {
        return new UserOutputDTO(
                "johnny",
                "johnny.doe@gmail.com",
                LocalDate.of(2025, 10, 8)
        );
    }


}
