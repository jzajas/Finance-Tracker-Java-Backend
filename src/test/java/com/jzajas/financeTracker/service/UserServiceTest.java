package com.jzajas.financeTracker.service;


import com.jzajas.financeTracker.UtilCreationMethods;
import com.jzajas.financeTracker.dto.input.UserRegistrationDTO;
import com.jzajas.financeTracker.dto.output.UserOutputDTO;
import com.jzajas.financeTracker.entity.User;
import com.jzajas.financeTracker.exceptions.EmailAlreadyExistsException;
import com.jzajas.financeTracker.exceptions.UsernameAlreadyExistsException;
import com.jzajas.financeTracker.mapper.UserMapper;
import com.jzajas.financeTracker.repository.UserRepository;
import com.jzajas.financeTracker.service.contract.UserService;
import com.jzajas.financeTracker.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;

import static com.jzajas.financeTracker.UtilCreationMethods.createDefaultUser;
import static com.jzajas.financeTracker.UtilCreationMethods.createDefaultUserOutputDTO;
import static com.jzajas.financeTracker.UtilCreationMethods.createDefaultUserRegistrationDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper mapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void whenCreateUserCalled_WithValidDTO_UserIsCreated() {
        UserRegistrationDTO inputDto = createDefaultUserRegistrationDTO();
        UserOutputDTO outputDto = createDefaultUserOutputDTO();
        User user = createDefaultUser();

        when(mapper.userDtoToUser(inputDto)).thenReturn(user);
        when(mapper.userToUserDTO(user)).thenReturn(outputDto);

        UserOutputDTO createdUser = userService.createUser(inputDto);

        assertEquals(createdUser, outputDto);
    }

    @Test
    public void whenCreateUserCalled_WithRepeatedUsernameValue_AppropriateExceptionIsCalled() {
        UserRegistrationDTO inputDto = createDefaultUserRegistrationDTO();

        when(userRepository.existsByUsername(anyString())).thenThrow(UsernameAlreadyExistsException.class);

        assertThrows(UsernameAlreadyExistsException.class, () -> userService.createUser(inputDto));
    }

    @Test
    public void whenCreateUserCalled_WithRepeatedEmailValue_AppropriateExceptionIsCalled() {
        UserRegistrationDTO inputDto = createDefaultUserRegistrationDTO();

        when(userRepository.existsByEmail(anyString())).thenThrow(EmailAlreadyExistsException.class);

        assertThrows(EmailAlreadyExistsException.class, () -> userService.createUser(inputDto));
    }
}
