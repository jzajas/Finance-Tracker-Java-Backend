package com.jzajas.financeTracker.service.impl;

import com.jzajas.financeTracker.dto.input.UserRegistrationDTO;
import com.jzajas.financeTracker.dto.output.UserOutputDTO;
import com.jzajas.financeTracker.entity.User;
import com.jzajas.financeTracker.exceptions.EmailAlreadyExistsException;
import com.jzajas.financeTracker.exceptions.InvalidPasswordException;
import com.jzajas.financeTracker.exceptions.UserNotFoundException;
import com.jzajas.financeTracker.exceptions.UsernameAlreadyExistsException;
import com.jzajas.financeTracker.mapper.UserMapper;
import com.jzajas.financeTracker.repository.UserRepository;
import com.jzajas.financeTracker.service.contract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String INCORRECT_PASSWORD_MESSAGE = "Password needs to contain at least one digit and be 7 characters long";
    private static final int MINIMAL_PASSWORD_LENGTH = 7;
    private final String USER_NOT_FOUND_MESSAGE = "User with id: %d not found";
    private final String ALREADY_EXISTS_MESSAGE = "already exists";

    private UserRepository userRepository;
    private UserMapper mapper;


    @Override
    public UserOutputDTO createUser(UserRegistrationDTO dto) {
        String password = dto.getPassword();
        validateRegistrationCredentials(dto.getUsername(), dto.getEmail(), password);

        User user = mapper.userDtoToUser(dto);
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());

        byte[] hashedPassword = hashPassword(password);

//        try {
//            hashedPassword = hashPassword(password);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }

        user.setPassword(hashedPassword.toString());
        userRepository.save(user);

        return mapper.userToUserDTO(user);
    }

    @Override
    public UserOutputDTO getUser(Long id) {
        User foundUSer = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, id)));

        return mapper.userToUserDTO(foundUSer);

    }

    @Override
    public UserOutputDTO updateUser(Long id, UserRegistrationDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow( () -> new UserNotFoundException(USER_NOT_FOUND_MESSAGE));

        User updatedUser = userUpdateMapping(user, dto);

        return mapper.userToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private void  validateRegistrationCredentials(String username, String email, String password) {
        if(userRepository.existsByUsername(username)) throw new UsernameAlreadyExistsException(username + ALREADY_EXISTS_MESSAGE);
        if(userRepository.existsByEmail(email)) throw new EmailAlreadyExistsException(email + ALREADY_EXISTS_MESSAGE);
        if (password.length() < MINIMAL_PASSWORD_LENGTH) throw new InvalidPasswordException(INCORRECT_PASSWORD_MESSAGE);

        Pattern pattern = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();
        if(!matchFound) throw new InvalidPasswordException(INCORRECT_PASSWORD_MESSAGE);
    }


//    TODO change algorithm from SHA-512 to BCrypt using Spring Security
    private byte[] hashPassword(String password) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);

            return md.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    private User userUpdateMapping(User user, UserRegistrationDTO dto) {
        byte[] hashedPassword = hashPassword(dto.getPassword());

        return new User(
                user.getId(),
                dto.getUsername(),
                dto.getEmail(),
                hashedPassword.toString(),
                user.getCreatedAt(),
                LocalDate.now()
        );
    }
}
