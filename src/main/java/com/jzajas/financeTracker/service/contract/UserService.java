package com.jzajas.financeTracker.service.contract;

import com.jzajas.financeTracker.dto.input.UserRegistrationDTO;
import com.jzajas.financeTracker.dto.output.UserOutputDTO;

public interface UserService {

    UserOutputDTO createUser(UserRegistrationDTO dto);

    UserOutputDTO getUser(Long id);

    void updateUser();

    void deleteUser();

}
