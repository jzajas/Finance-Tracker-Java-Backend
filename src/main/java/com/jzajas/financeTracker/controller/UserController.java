package com.jzajas.financeTracker.controller;

import com.jzajas.financeTracker.dto.input.UserRegistrationDTO;
import com.jzajas.financeTracker.dto.output.UserOutputDTO;
import com.jzajas.financeTracker.entity.User;
import com.jzajas.financeTracker.service.contract.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserRegistrationDTO dto) {
        userService.createUser(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<UserOutputDTO> getUserById(Long id) {
        UserOutputDTO user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
