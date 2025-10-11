package com.jzajas.financeTracker.controller;


import com.jzajas.financeTracker.dto.input.LoginDTO;
import com.jzajas.financeTracker.dto.input.UserRegistrationDTO;
import com.jzajas.financeTracker.dto.output.UserOutputDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @PostMapping("/signup")
    public ResponseEntity<UserOutputDTO> register(@RequestBody @Valid UserRegistrationDTO dto) {
//        TODO implement registration (create enw registration service)
        UserOutputDTO user = new UserOutputDTO();

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> authenticate(@RequestBody @Valid LoginDTO dto) {
//        TODO implement authentication service and jwt service to handle login

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
