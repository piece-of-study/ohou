package org.ohou.service;

import org.ohou.dto.UserDto;
import org.ohou.model.User;

public interface UserService {
    User registerUser(UserDto userDto);
    void autoLogin(User user);
}
