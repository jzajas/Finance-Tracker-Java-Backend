package com.jzajas.financeTracker.service.contract;

import com.jzajas.financeTracker.dto.input.UserRegistrationDTO;
import com.jzajas.financeTracker.dto.output.UserOutputDTO;
import com.jzajas.financeTracker.entity.User;

public interface UserService {

    void createUser(UserRegistrationDTO dto);

    UserOutputDTO getUser(Long id);

    void updateUser();

    void deleteUser();

}
