package com.jzajas.financeTracker.mapper;

import com.jzajas.financeTracker.dto.input.UserRegistrationDTO;
import com.jzajas.financeTracker.dto.output.UserOutputDTO;
import com.jzajas.financeTracker.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    UserOutputDTO userToUserDTO(User user);

    User userDtoToUser(UserRegistrationDTO dto);
}
