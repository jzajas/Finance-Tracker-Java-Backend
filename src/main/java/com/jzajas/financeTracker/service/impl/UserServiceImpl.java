package com.jzajas.financeTracker.service.impl;

import com.jzajas.financeTracker.dto.input.UserRegistrationDTO;
import com.jzajas.financeTracker.dto.output.UserOutputDTO;
import com.jzajas.financeTracker.entity.User;
import com.jzajas.financeTracker.mapper.UserMapper;
import com.jzajas.financeTracker.repository.UserRepository;
import com.jzajas.financeTracker.service.contract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final String USER_NOT_FOUND_MESSAGE = "User with id: %d not found";

    UserRepository userRepository;
    UserMapper mapper;


    @Override
    public void createUser(UserRegistrationDTO dto) {
        User user = mapper.userDtoToUser(dto);
        user.setCreatedAt(LocalDate.now());
        userRepository.save(user);
    }

//    TODO implement exception
    @Override
    public UserOutputDTO getUser(Long id) {
        User foundUSer = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(USER_NOT_FOUND_MESSAGE, id)));
        return mapper.userToUserDTO(foundUSer);

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
